package com.example.customphonekeyboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.customphonekeyboard.MyInputMethodService.SHARED_PREFS_for_pin;

public class MainActivity extends AppCompatActivity {
   // EditText e1;
    Button setup,insertbutton,viewbutton,deletebutton,robotb;
    String pin;
    String allpin;
    String simID;
    DatabaseHelper myDb;
    SQLiteToExcel sqliteToExcel;
    String directory_path = Environment.getExternalStorageDirectory().getPath() + "/";
    public static final String SHARED_PREFS = "sharedPrefs";
    int count;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        count = sharedPreferences2.getInt("lindex", +1);

        myDb=new DatabaseHelper(getApplicationContext());
      //  myDb = new DatabaseHelper(getApplicationContext());
        //e1=(EditText)findViewById(R.id.pinid);
        setup=(Button)findViewById(R.id.setpinbuttonid);
        insertbutton=(Button)findViewById(R.id.insertdataid);
        viewbutton=(Button)findViewById(R.id.veiwid);
        deletebutton=(Button)findViewById(R.id.deletedataid);
        robotb=(Button)findViewById(R.id.robotonid);
        robotb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(new Intent(getApplicationContext(), autobot_background.class));

            }
        });


        setup.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // pin=e1.getText().toString();
                //String single_pin= MySingletonClass.getInstance().getStringValue();
                TelephonyManager tm = (TelephonyManager)
                        getSystemService(Context.TELEPHONY_SERVICE);


                simID = tm.getSimSerialNumber();;
                //Toast.makeText(getApplicationContext(),"sim"+simID,Toast.LENGTH_SHORT).show();

                if((simID.equalsIgnoreCase("8988039916068793595F"))||(simID.equalsIgnoreCase("8988014402609893524F"))||(simID.equalsIgnoreCase("8988039216122554624F"))){
                    SharedPreferences sharedPreferencesformypin = getSharedPreferences(SHARED_PREFS_for_pin, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferencesformypin.edit();


                    editor.putString("allpin", simID);
                    Toast.makeText(getApplicationContext(),"Succesfully Setted",Toast.LENGTH_LONG).show();
                    // Toast.makeText(getApplicationContext().this, "setted"+pin, Toast.LENGTH_SHORT).show();



                    editor.apply();

                    MySingletonClass.getInstance().setString(pin);


                }
                else {
                    Toast.makeText(getApplicationContext(),"Not Setted"+simID,Toast.LENGTH_LONG).show();

                }



            }

        });
        insertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Export SQLite DB as EXCEL FILE
                sqliteToExcel = new SQLiteToExcel(getApplicationContext(), DatabaseHelper.DATABASE_NAME, directory_path);
                sqliteToExcel.exportAllTables("createdmail.xls", new SQLiteToExcel.ExportListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onCompleted(String filePath) {
                       /// Utils.showSnackBar(view, "Successfully Exported");
                         Toast.makeText(MainActivity.this, "Export successful!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "No Export"+e.toString(), Toast.LENGTH_SHORT).show();
                      //  Utils.showSnackBar(view, "Not Exported");
                    }
                });


            }
        });
        viewbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res=myDb.getAllData();
                if(res.getCount()==0){                     //when there is no data show message..error message is depend on  "showMessage"method
                    //show message
                   showMessage("Error","Nothing Found");
                    return;

                }
                StringBuffer buffer=new StringBuffer();

                while(res.moveToNext()){                                               //read and collect data in database in coloum
                    // buffer.append("ID :"+ res.getString(0)+"\n");
                    buffer.append("GMAIL:"+ res.getString(1)+"\n");
                    buffer.append("PASSWARD :"+ res.getString(2)+"\n");

                    //   buffer.append("Date :"+ res.getString(4)+"\n\n");


                }
                //show all data
                showMessage("Data of Database",buffer.toString());

            }
        });
        deletebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Cursor res=myDb.getAllData();
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No mail done", Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    count=0;

                    Integer deleteData = myDb.deleteData();
                    Toast.makeText(MainActivity.this, " DELETED", Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);


                    SharedPreferences.Editor editor = sharedPreferences2.edit();


                    editor.putInt("lindex", count);
                    editor.apply();
                    onStart();

                }






            }
        });




    }

    public void showMessage(String title,String Message){                   //show message method
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
    @Override
    protected void onStart()
    {
        super.onStart();


        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        count = sharedPreferences2.getInt("lindex", +0);
        count=count;
        viewbutton.setText("VIEW"+"("+count+")");
        insertbutton.setText("EXPORT"+"("+count+")");
        deletebutton.setText("Delete"+"("+count+")");

        //Toast.makeText(getApplicationContext(),"Now onStart() calls", Toast.LENGTH_LONG).show(); //onStart Called

    }



}

