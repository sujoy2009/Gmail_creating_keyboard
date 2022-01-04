package com.example.customphonekeyboard;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.DataOutputStream;
import java.io.IOException;

public class autobot_background extends Service {

    private static final int delay = 3000;
    private static final int mindelay = 300;
    Process process;
    DataOutputStream os;

    final class TheThread  implements Runnable{
        int  serviceID;
        TheThread(int serviceID){
            this.serviceID = serviceID;
        }

        @Override
        public void run() {

            try{
                process = Runtime.getRuntime().exec("su");
                os = new DataOutputStream(process.getOutputStream());


                for(int i=0;i<1000000;i++){
//                    Thread.sleep(delay);
//                    All_Clear();

                    Thread.sleep(3500);
                    wifi_off();
                    Thread.sleep(1000);
                    DeviceIdCHanger();
                    Thread.sleep(delay);
                    ChamelPhon();
                    Thread.sleep(delay);
                    Ghost_Phone();
                    Thread.sleep(delay);
                    wifi_on();
                    Thread.sleep(5000);

                    Play_Service_Clear();
                    Thread.sleep(delay);
                    Thread.sleep(25000);


                    Google_Account_Create();
                    Thread.sleep(2000);



                    Play_Service_Clear_for_good_skip();
                    Thread.sleep(3000);


                    Google_Account_Create2();

                    Thread.sleep(3000);
                    Play_Service_Clear_for_good_skip();
                    Thread.sleep(2000);
                    Google_Account_Create2();
                    Thread.sleep(5000);




                    wifi_off_2nd();


                    Thread.sleep(delay);


                    Google_Account_Delete_all();
                    Thread.sleep(5000);

                }

                os.writeBytes("exit\n");
                os.flush();
                os.close();
                Thread.sleep(delay);

                try {
                    process.waitFor();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (IOException | InterruptedException e){
                e.printStackTrace();
            }
            stopSelf(this.serviceID);

        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new TheThread(startId));
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        process.destroy();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



    public void Google_Account_Delete(){
        try{
            String cmd = "/system/bin/pm clear com.android.settings\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);

            //setting
            cmd = "/system/bin/am start -a android.settings.SETTINGS\n";
            os.writeBytes(cmd);
            Thread.sleep(5000);
            //swipe
            cmd = "/system/bin/input swipe 261 795 261 581 60\n";
            os.writeBytes(cmd);
            Thread.sleep(400);
            cmd = "/system/bin/input swipe 261 795 261 581 60\n";
            os.writeBytes(cmd);
            Thread.sleep(400);

            cmd = "/system/bin/input swipe 254 331 269 850 400\n";
            os.writeBytes(cmd);
            Thread.sleep(300);



            //account
            cmd = "/system/bin/input tap 234 564\n";
            os.writeBytes(cmd);
            Thread.sleep(500);


            //open google

            //home
            /*
            cmd = "/system/bin/input keyevent KEYCODE_HOME\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);
            cmd = "/system/bin/input tap 62 93\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

             */
            //google_touch
            cmd = "/system/bin/input tap 339 173\n";
            os.writeBytes(cmd);
            Thread.sleep(500);
            //touch on the mail

            cmd = "/system/bin/input tap 242 196\n";
            os.writeBytes(cmd);
            Thread.sleep(500);


            //...
            cmd = "/system/bin/input tap 450 84\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            //remove
            cmd = "/system/bin/input tap 295 148\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            //remove popup
            cmd = "/system/bin/input tap 304 542\n";
            os.writeBytes(cmd);
            Thread.sleep(500);




        }catch (IOException | InterruptedException e){}
    }
    public void Google_Account_Delete_all(){
        try{

            String cmd = "/system/bin/pm clear com.android.settings\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);

            //setting
            cmd = "/system/bin/am start -a android.settings.SETTINGS\n";
            os.writeBytes(cmd);
            Thread.sleep(5000);
            //swipe
            cmd = "/system/bin/input swipe 261 795 261 581 60\n";
            os.writeBytes(cmd);
            Thread.sleep(400);
            cmd = "/system/bin/input swipe 261 795 261 581 60\n";
            os.writeBytes(cmd);
            Thread.sleep(400);

            cmd = "/system/bin/input swipe 254 331 269 850 400\n";
            os.writeBytes(cmd);
            Thread.sleep(300);



            //account
            cmd = "/system/bin/input tap 234 564\n";
            os.writeBytes(cmd);
            Thread.sleep(500);


            //open google

            //home
            /*
            cmd = "/system/bin/input keyevent KEYCODE_HOME\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);
            cmd = "/system/bin/input tap 62 93\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

             */
            //google_touch
            cmd = "/system/bin/input tap 339 173\n";
            os.writeBytes(cmd);
            Thread.sleep(500);
            //touch on the mail

            cmd = "/system/bin/input tap 242 196\n";
            os.writeBytes(cmd);
            Thread.sleep(500);


            //...
            cmd = "/system/bin/input tap 450 84\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            //remove
            cmd = "/system/bin/input tap 295 148\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            //remove popup
            cmd = "/system/bin/input tap 304 542\n";
            os.writeBytes(cmd);
            Thread.sleep(500);
            //touch on the mail 2

            cmd = "/system/bin/input tap 242 196\n";
            os.writeBytes(cmd);
            Thread.sleep(500);


            //...
            cmd = "/system/bin/input tap 450 84\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            //remove
            cmd = "/system/bin/input tap 295 148\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            //remove popup
            cmd = "/system/bin/input tap 304 542\n";
            os.writeBytes(cmd);
            Thread.sleep(500);
            //touch on the mail 3

            cmd = "/system/bin/input tap 242 196\n";
            os.writeBytes(cmd);
            Thread.sleep(500);


            //...
            cmd = "/system/bin/input tap 450 84\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            //remove
            cmd = "/system/bin/input tap 295 148\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            //remove popup
            cmd = "/system/bin/input tap 304 542\n";
            os.writeBytes(cmd);
            Thread.sleep(500);

            cmd = "/system/bin/am force-stop com.rungetel.ghostphone\n";
            os.writeBytes(cmd);
            Thread.sleep(delay);

        }catch (IOException | InterruptedException e){}
    }

    public  void Google_Account_Create(){
        try{

            String cmd = "/system/bin/pm clear com.android.settings\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);

            cmd = "/system/bin/am start -a android.settings.ADD_ACCOUNT_SETTINGS\n";
            os.writeBytes(cmd);
            Thread.sleep(6000);

            //google
            cmd = "/system/bin/input tap 248 246\n";
            os.writeBytes(cmd);
            Thread.sleep(50000);
            //create acc
            cmd = "/system/bin/input tap 113 704\n";
            os.writeBytes(cmd);
            Thread.sleep(delay);
            //for myself
            cmd = "/system/bin/input tap 120 484\n";
            os.writeBytes(cmd);
            Thread.sleep(5000);
            //first last name
            cmd = "/system/bin/input tap 251 442\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);

            cmd = "/system/bin/input tap 78 716\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 250 567\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 173 720\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            //next
            cmd = "/system/bin/input tap 163 794\n";
            os.writeBytes(cmd);
            Thread.sleep(17000);
            //month
            cmd = "/system/bin/input tap 89 408\n";
            os.writeBytes(cmd);
            Thread.sleep(700);

            cmd = "/system/bin/input tap 251 288\n";
            os.writeBytes(cmd);
            Thread.sleep(700);
            //day
            cmd = "/system/bin/input tap 242 403\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 235 707\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            //year
            cmd = "/system/bin/input tap 376 412\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 344 718\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

//            gender
            cmd = "/system/bin/input tap 222 510\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 292 407\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            //web next
            cmd = "/system/bin/input tap 388 715\n";
            os.writeBytes(cmd);
            Thread.sleep(25000);

//            gmail_addr
            cmd = "/system/bin/input tap 61 638\n";
            os.writeBytes(cmd);
            Thread.sleep(4000);

            cmd = "/system/bin/input tap 420 707\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 136 826\n";
            os.writeBytes(cmd);
            Thread.sleep(10000);
//            password
            cmd = "/system/bin/input tap 186 491\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 63 804\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);

            cmd = "/system/bin/input tap 153 846\n";
            os.writeBytes(cmd);
            Thread.sleep(15000);

            //phone_num
            cmd = "/system/bin/input tap 273 501\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            //send
            cmd = "/system/bin/input tap 336 833\n";
            os.writeBytes(cmd);
            Thread.sleep(300);


            //empty
            cmd = "/system/bin/input tap 247 610\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            //skip_button
            cmd = "/system/bin/input tap 73 834\n";
            os.writeBytes(cmd);
            Thread.sleep(170);

            //skip again
            cmd = "/system/bin/input tap 73 790\n";
            os.writeBytes(cmd);
            Thread.sleep(15000);

            //next
            cmd = "/system/bin/input tap 376 700\n";
            os.writeBytes(cmd);
            Thread.sleep(15000);

            //swipe down
            cmd = "/system/bin/input swipe 261 795 261 581 50\n";
            os.writeBytes(cmd);
            Thread.sleep(100);
            cmd = "/system/bin/input swipe 261 795 261 581 50\n";
            os.writeBytes(cmd);
            Thread.sleep(100);
            cmd = "/system/bin/input swipe 261 795 261 581 50\n";
            os.writeBytes(cmd);
            Thread.sleep(100);

            //i_agree
            cmd = "/system/bin/input tap 368 698\n";
            os.writeBytes(cmd);
            Thread.sleep(40000);

            //drive_backup_off
            cmd = "/system/bin/input swipe 269 638 243 295 500\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            cmd = "/system/bin/input tap 392 402\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            cmd = "/system/bin/input swipe 269 638 243 295 500\n";
            os.writeBytes(cmd);
            Thread.sleep(300);


            //accept
            cmd = "/system/bin/input tap 397 812\n";
            os.writeBytes(cmd);
            Thread.sleep(300);



        }catch (IOException | InterruptedException e){}
    }
    public  void Google_Account_Create2(){
        try{

            String cmd = "/system/bin/pm clear com.android.settings\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);

            cmd = "/system/bin/am start -a android.settings.ADD_ACCOUNT_SETTINGS\n";
            os.writeBytes(cmd);
            Thread.sleep(6000);

            //google
            cmd = "/system/bin/input tap 248 246\n";
            os.writeBytes(cmd);
            Thread.sleep(50000);
            //create acc
            cmd = "/system/bin/input tap 113 704\n";
            os.writeBytes(cmd);
            Thread.sleep(delay);
            //for myself
            cmd = "/system/bin/input tap 104 569\n";
            os.writeBytes(cmd);
            Thread.sleep(5000);
            //first last name
            cmd = "/system/bin/input tap 251 442\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);

            cmd = "/system/bin/input tap 78 716\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 250 567\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 173 720\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            //next
            cmd = "/system/bin/input tap 163 794\n";
            os.writeBytes(cmd);
            Thread.sleep(15000);
            //month
            cmd = "/system/bin/input tap 89 408\n";
            os.writeBytes(cmd);
            Thread.sleep(700);

            cmd = "/system/bin/input tap 251 288\n";
            os.writeBytes(cmd);
            Thread.sleep(700);
            //day
            cmd = "/system/bin/input tap 242 403\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 235 707\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            //year
            cmd = "/system/bin/input tap 376 412\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 344 718\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

//            gender
            cmd = "/system/bin/input tap 222 510\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 292 407\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            //web next
            cmd = "/system/bin/input tap 388 715\n";
            os.writeBytes(cmd);
            Thread.sleep(20000);

//            gmail_addr
            cmd = "/system/bin/input tap 61 638\n";
            os.writeBytes(cmd);
            Thread.sleep(4000);

            cmd = "/system/bin/input tap 420 707\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 136 826\n";
            os.writeBytes(cmd);
            Thread.sleep(10000);
//            password
            cmd = "/system/bin/input tap 186 491\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            cmd = "/system/bin/input tap 63 804\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);

            cmd = "/system/bin/input tap 153 846\n";
            os.writeBytes(cmd);
            Thread.sleep(15000);

            //phone_num
            cmd = "/system/bin/input tap 273 501\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            //send
            cmd = "/system/bin/input tap 336 833\n";
            os.writeBytes(cmd);
            Thread.sleep(300);


            //empty
            cmd = "/system/bin/input tap 247 610\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            //skip_button
            cmd = "/system/bin/input tap 73 834\n";
            os.writeBytes(cmd);
            Thread.sleep(170);
            //skip again
            cmd = "/system/bin/input tap 73 790\n";
            os.writeBytes(cmd);
            Thread.sleep(15000);

            //next
            cmd = "/system/bin/input tap 376 700\n";
            os.writeBytes(cmd);
            Thread.sleep(15000);

            //swipe down
            cmd = "/system/bin/input swipe 261 795 261 581 50\n";
            os.writeBytes(cmd);
            Thread.sleep(100);
            cmd = "/system/bin/input swipe 261 795 261 581 50\n";
            os.writeBytes(cmd);
            Thread.sleep(100);
            cmd = "/system/bin/input swipe 261 795 261 581 50\n";
            os.writeBytes(cmd);
            Thread.sleep(100);

            //i_agree
            cmd = "/system/bin/input tap 368 698\n";
            os.writeBytes(cmd);
            Thread.sleep(30000);

            //drive_backup_off
            /*
            cmd = "/system/bin/input swipe 269 638 243 295 500\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            cmd = "/system/bin/input tap 392 402\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            cmd = "/system/bin/input swipe 269 638 243 295 500\n";
            os.writeBytes(cmd);
            Thread.sleep(300);




            //accept
            cmd = "/system/bin/input tap 397 812\n";
            os.writeBytes(cmd);


            Thread.sleep(300);
            */




        }catch (IOException | InterruptedException e){}
    }




    public void wifi_off_2nd(){
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        wifiManager.setWifiEnabled(true);
        wifiManager.setWifiEnabled(false);

    }
    public void wifi_off(){

        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        wifiManager.setWifiEnabled(true);
        wifiManager.setWifiEnabled(false);

    }
    public void wifi_on(){
        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        wifiManager.setWifiEnabled(true);
    }

    public void Play_Service_Clear(){
        try{
            Thread.sleep(1000);

            String cmd = "/system/bin/input keyevent KEYCODE_HOME\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);


            cmd = "/system/bin/input tap 419 98\n";
            os.writeBytes(cmd);
            Thread.sleep(4000);

            cmd = "/system/bin/input tap 334 788\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);

            cmd = "/system/bin/input tap 396 546\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);
        }
        catch (IOException | InterruptedException e){}
    }
    public void Play_Service_Clear_for_good_skip(){
        try{

            Thread.sleep(1000);


           String cmd = "/system/bin/input tap 419 98\n";
            os.writeBytes(cmd);
            Thread.sleep(4000);

            cmd = "/system/bin/input tap 334 788\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);

            cmd = "/system/bin/input tap 396 546\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);
        }
        catch (IOException | InterruptedException e){}
    }

    public  void Ghost_Phone(){
        try {
            String cmd = "/system/bin/monkey -p com.rungetel.ghostphone 1\n";
            os.writeBytes(cmd);
            Thread.sleep(5000);

//            gfs ID
            cmd = "/system/bin/input tap 343 183\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);
            //+ first click
            cmd = "/system/bin/input tap 406 646\n";
            os.writeBytes(cmd);
            Thread.sleep(300);
            //+ second click
            cmd = "/system/bin/input tap 396 724\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);
            //SHUFFLE first click
            cmd = "/system/bin/input tap 216 648\n";
            os.writeBytes(cmd);
            Thread.sleep(300);

            //SHUFFLE SECOND click
            cmd = "/system/bin/input tap 218 740\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);

            cmd = "/system/bin/input tap 316 663\n";
            os.writeBytes(cmd);
            Thread.sleep(500);



            cmd = "/system/bin/input tap 379 518\n";
            os.writeBytes(cmd);
            Thread.sleep(10000);

//            mac change
            cmd = "/system/bin/input tap 242 182\n";
            os.writeBytes(cmd);
            Thread.sleep(1500);

            cmd = "/system/bin/input tap 397 392\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);

            cmd = "/system/bin/input tap 227 388\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);

            cmd = "/system/bin/input tap 309 393\n";
            os.writeBytes(cmd);
            Thread.sleep(2000);

            cmd = "/system/bin/input tap 385 510\n";
            os.writeBytes(cmd);
            Thread.sleep(22000);

            cmd = "/system/bin/am force-stop com.rungetel.ghostphone\n";
            os.writeBytes(cmd);
            Thread.sleep(delay);

        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }




    }


    public void ChamelPhon(){

        try {
            String cmd = "/system/bin/am force-stop com.cryptotel.chamelephon\n";
            os.writeBytes(cmd);
            Thread.sleep(delay);


            cmd = "/system/bin/monkey -p com.cryptotel.chamelephon 1\n";
            os.writeBytes(cmd);
            Thread.sleep(4000);

            cmd = "/system/bin/input tap 282 557\n";
            os.writeBytes(cmd);
            Thread.sleep(700);

            cmd = "/system/bin/input tap 262 636\n";
            os.writeBytes(cmd);
            Thread.sleep(700);

            cmd = "/system/bin/input tap 177 490\n";
            os.writeBytes(cmd);
            Thread.sleep(1000);


        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

    }



    public void DeviceIdCHanger(){


        try {
            Thread.sleep(5000);
        String cmd = "/system/bin/monkey -p com.makeinfo.androididchanger 1\n";
        os.writeBytes(cmd);
        Thread.sleep(9000);



        cmd = "/system/bin/input tap 377 452\n";
        os.writeBytes(cmd);
        Thread.sleep(500);


        cmd = "/system/bin/input tap 157 751\n";
        os.writeBytes(cmd);
        Thread.sleep(500);


        cmd = "/system/bin/am force-stop com.makeinfo.androididchanger\n";
        os.writeBytes(cmd);

        Thread.sleep(300);


        }catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

    }

    public void All_Clear(){
        try{
            String cmd = "/system/bin/pm clear com.android.settings\n";
            os.writeBytes(cmd);
            Thread.sleep(200);
            cmd = "/system/bin/pm clear com.makeinfo.androididchanger\n";
            os.writeBytes(cmd);
            Thread.sleep(200);
            cmd = "/system/bin/pm clear com.cryptotel.chamelephon\n";
            os.writeBytes(cmd);
            Thread.sleep(200);
            cmd = "/system/bin/pm clear com.rungetel.ghostphone\n";
            os.writeBytes(cmd);
            Thread.sleep(200);
            cmd = "/system/bin/pm clear com.android.settings\n";
            os.writeBytes(cmd);
            Thread.sleep(200);
        }
        catch (IOException | InterruptedException e){}
    }



//    adb shell monkey -p com.makeinfo.androididchanger 1
//adb shell monkey -p com.cryptotel.chamelephon 1
//adb shell am force-stop com.cryptotel.chamelephon

//    adb shell su -c 'svc wifi enable/disable'
    //am start -a android.settings.ADD_ACCOUNT_SETTINGS


    //scroll
//            adb shell input swipe 262 660 270 290 300


}
