package com.example.customphonekeyboard;

import android.content.SharedPreferences;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {

    private KeyboardView keyboardView;
    private Keyboard keyboard;
    DatabaseHelper myDb;

    private boolean caps = false;
    //for data sending
    private File filePath = new File(Environment.getExternalStorageDirectory() + "/Gmailcreated.xls");
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final int lindex = 1;
    public static final String lpin = "fff";
    public static final String SHARED_PREFS_for_pin = "sharedPrefsforpin";
    int indeexx=1;
    int emty=0;
    HSSFSheet sheet;
    HSSFWorkbook workbook;
    //keyboard data
    String name;
    String surname;
    String pass;
    String mail;
    String gettedpin;
   // String code2="";
    int cn=1;
    HSSFSheet sheettt;
    HSSFWorkbook workbook2;
    File filePath2;


    @Override
    /** Grabs the keyboard view and adds the layout to it */
    public View onCreateInputView() {
        keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        keyboard = new Keyboard(this, R.xml.keys_layout);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int primaryCode) {

    }



    @Override
    public void onRelease(int primaryCode) {

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onKey(int primaryCode, int[] keyCodes) {
        SharedPreferences sharedPreferencesnew = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        emty = sharedPreferencesnew.getInt("lindex", +1);
        if(emty==1||emty==0){
            workbook = new HSSFWorkbook();
            //invoking creatSheet() method and passing the name of the sheet to be created
            sheet = workbook.createSheet("January");
            cn=0;
            HSSFRow rowhead = sheet.createRow((short) 0);
//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method
            rowhead.createCell(0).setCellValue("GMail");
            rowhead.createCell(4).setCellValue("Passward");
        }




        //playSound(4);
        InputConnection inputConnection = getCurrentInputConnection();
        if (inputConnection != null) {
            switch(primaryCode) {
                case Keyboard.KEYCODE_DELETE :
                    CharSequence selectedText = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1, 0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                case Keyboard.KEYCODE_SHIFT:
                    caps = !caps;
                    keyboard.setShifted(caps);
                    keyboardView.invalidateAllKeys();
                    break;
                case Keyboard.KEYCODE_DONE:
                    inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));

                    break;
                default :
                    char code = (char) primaryCode;
                   String code2="";
                    if(primaryCode==22){
                        //if singleton is needed
                        /*
                       String single_pin= MySingletonClass.getInstance().getStringValue();

                        SharedPreferences sharedPreferencesformypin = getSharedPreferences(SHARED_PREFS_for_pin, MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferencesformypin.edit();


                        editor.putString("allpin", single_pin);
                        Toast.makeText(getApplicationContext(),"setted"+single_pin,Toast.LENGTH_LONG).show();
                        // Toast.makeText(getApplicationContext().this, "setted"+pin, Toast.LENGTH_SHORT).show();



                        editor.apply();

                         */

                    }
                    if(primaryCode==115){

                        String[] strArray3 = {"Estela","Kendall","Cherry","Prince","Franchesca","Aaron","Shanice","Benton","Marcelene","Denis","Mitzi","Theo","Charlott","Dino","Cyndi","Gregory","Sharla","Kieth",
                                "Ethelyn","Valentine","Adrienne","Kirk","Tonisha","Les","Tammera","Leslie","Fallon","Eldridge","Kathryne","Edmund","Jennine","Erich","Shaunda","Fredrick","Neta","Jermaine","Ginger","Kurtis","Patsy","Leland","Rebecka","Anderson","Marva","Vincenzo","Starr","Grant","Ling","Daron","Krysten","Douglas","Khalilah","Ramiro","Janette","Jonah","Alane","Lanny","Joelle","Jayson","Alyssa","Victor","Kanisha","Eldon","Tamika","Gus","Tresa","Columbus","Eusebia","Jay","Marisol","Melvin","Deandrea","Huey","Dean","Michaele","Reyes","Charles","Denis","Margy","Mckinley",
                                "Candance","Earl","Nobuko","Tory","Devora","Brooks","Delilah","Evan","Lorinda","Tobias","Laurel","Booker","Elmira","Dominick","Vince","Bari","Lonny","Yasuko","Rich","Gussie","Harvey"
                        ,"Clark","Porsha","Antonia","Kisha","Benito","Georgine","Noel","Ariana","Roscoe","Juli","Andreas","Jesusa",
                                "Carrol","Toby","Rodney","Pa","Deandre","Ruby","Josef","Lakita","Luciano","Kalyn","Anton","Gertude","Kristopher","Georgina","Gil","Sharita","Claud","Xuan","Winston","Chi","Bryan","Shoshana","Elliot","Keena","Ernie","Eustolia","Antony","Angella","Winford","Zonia","Matt","Nickie","Elroy","Johnette","Mohammed","Leisa","Granville","Dorris","Whitney","Ronald","Garret","Cecille","Julius","My","Brain","Robbyn","Dean","Niki","Damon","Jackqueline","Leonard","Jenae","Chase","Nola","Mckinley","Clarita","Colin","Rosita","Delmar","Twana","Bruno","Brittanie","Gerard","Un","Edwardo","Janetta","Carmen","Kathryne","Rodolfo","Tammy","Willy","Pei","Milan","Gilda","Brant","Shannon","Tyson","Carry","Kelley","Sona","Norbert","Rosalee","sujoy",
                                "Emmitt","Byron","Gerardo","Jamison","Arlie","Leon","Gerardo","Terrell","Palmer","Oswaldo","Alphonse","Tyree","Johnathon","Maxwell","Bernardo","Roger","Nolan","Elvis","Moises","Raymon","Wilton","Lenny","Kraig","Donald","Malik","Jeff","Bret","Odis","Gino","Owen","Dong","Jess","Nicky","Rubin","Isreal","Lowell","Bradly","Gerald","Bret","Charlie","Gerardo","Francesco","Sam","Lucius","Rickie","James","Sonny","Justin","Dane","Lucien","Lindsay","Tad","Donnell","Billie","Jerold","Reggie","Taylor","Marcos","Shirley","Abel","Elvin","Foster","Graham","Jae","Lon","Gerardo","Sterling","Mariano","Nicholas","Josef","Brendan","Nathanial","Merrill","Cyril","Daniel","Ronald","Emilio","Ismael","Angelo","Roosevelt","Hank","Berry","Jude","Florencio",
                                "Chad","Markus","Olin","Franklin","Orval","Deandre","Santo","Zane","Trinidad","Sal","Collin","Milan","Florencio","Byron","Roland","Ahmad","Jerrold","Fidel","Everette","Ernesto","Donnell","Mohammad","Eli","Jame","Claudio","Frederick","Issac","Dexter","Alberto","Emmitt","Jamey","Oren","Terrell","Gerardo","Ike","Isaias","Elliott","Howard","Jay","Luigi","Allan","Jere","Dallas","Adrian","Blake","Neville","Merlin","Walter","Elisha","Wes","Alonzo","Robert","Ali","Reuben","Von","Stacey","Jimmie","Israel","Andreas","Mario","Ashley","Britt","Chauncey","Doug","Marcos","Gaylord","Jeffry","Moses","Juan","Theo","Keneth","Wm","Jared","Dominick","Carol","Ali","Loyd","Antone","Alva","Irvin","Russ","Felipe","Mose","Luciano","Rick","Paul","Ned","Tad",
                                "Trey","Lauren","Carol","Derek","Coy","Olin","Tyson","Michel","Russ","Gerardo","Alfredo","Elvis","Shane","Sammy","Darren","Noble","Nickolas","Robin","Boyd","Michal","Dominick","Burton","Valentine","Arron","Hubert","Rudolph","Elton","Nicolas","Mohammad","Jonah","Gerardo","Stanford","Milton","Antony","Kelly","Seth","Granville","Timmy","Colin","Jefferson","Luke","Marcus","Ronald","Thanh","Demetrius","Reid","Art","Tracey","Laurence","Chase","Lino","Karl","Vern","Jamie","Val","Miguel","Reinaldo","Jess","Galen","Harlan","Humberto","Heriberto","Jewell","Mitch","Elmo","Murray","Patricia","Sumana","Jess",
                                "Hilton","Jimmie","Royal","Emile","Alden","Jeromy","Christopher","Issac","Merrill","Avery","Antwan","Rick","Darrell","RickRoyal","Robby","Darrin","Lawerence",".","Jang","Matthew","Carroll","..","Sutcliffe","Alphonso","Ulysses","Mac","Theo","Timothy","Jarred","Hank","Mason","Titus","Dominic","Rico","Benedict","Ali","Danny","Horace","Earl","Hipolito","Jimmie","Royce","Randy","Ernest","Roger","Bernard","Billie","Andreas","Buford","Bradford","Bud","Kurt","Sanford","Sam","Leland","Ramon","Logan","Leonardo","Cliff","Ivory","Scottie","Shaun","Nicky","Charley","Ezra","Genaro","Dalton","Bruce","Mariano","Marcel","Jerrod","Arlie","Kim","Romeo","Christopher","Houston","Wilfredo","Cesar","Carson","Emil","Bud","Robby","Adan","Federico","Jerold",
                                "Dennis","Lewis","Caleb","Joseph","Yong","Art","Emil","Gino","Shaun","Truman","Hilario","Jamison","Troy","George","Ollie","Raymon","Jewel","Miquel","Ariel","Donnie","Vito","Elisha","Chad","Abram","Guy","Clark","Grant","Boyce","Arnulfo","Jerome","Ron","Shannon","Eugenio","Shaun","Lucien","Gilberto","Berry","Michale","Ulysses","Edward","Lucas","Tyron","Basil","Elliot","Nigel","Michel","Cedrick","Lindsay","Andrew","Hal","Osvaldo","Bernie","Clinton","Bo","Marshall","Miguel","Ron","Major","Florencio","Elwood","Granville","Gordon","Barney","Mitchel","Darin","Robby","Monroe","Damon","Felton","Keneth","Marshall","Elbert","Colton","Porter","Reginald","Benny","Shane","Dario","Kent","Carlton","Karl","Sergio","Joe","Scottie","Todd","Walton","Teddy"
                                ,"Napoleon","Jay","Pete","Edwardo","Vincenzo","Kendrick","Man","Ashley","Ned","Delmer","Jacques","Noah","Ira","Carey","Maxwell","Don","Sal","Burt","Kelly","Brant","Quincy","Monroe","Lupe","Ben","Clinton","Marlon","William","Jonathan","Noe","Devon","Freddie","Michel","Jessie","Danilo","Dan","Jeremiah","Dane","Dewey","Lionel","Calvin","Rickie","Edmond","Roscoe","Dana","Freddy","Waldo","Darell","Bryan","Julio","Palmer","Jody","Victor","Benedict","Sylvester","Jude","Sean","Waldo","Isaac","Toby","Hunter","Bryon","Von","Sang","Russell","Modesto","Erick","Len","Chas","Terence","Beau","Oren","Alejandro","Tobias","Aron","Louie","Stanton","Johnathon","Ismael","Graham","Everette","Robby","Dong","Wesley","Adam","Errol","Zachery","Arlen","Rocky","Sylvester",
                                "Sung","Raymon","Mohammad","Dong","Johnny","Hollis","Edward","Lacy","Mel","Roderick","Korey"
                        };

                        int min = 0;
                        int max = 670;
                        int b = (int)(Math.random()*(max-min+1)+min);
                         name=  strArray3[b];
                         if(name.length()<4){
                              b = (int)(Math.random()*(max-min+1)+min);
                             name=  strArray3[b];


                         }
                        int minv= 0;
                        int maxv = 7;
                        int bv = (int)(Math.random()*(maxv-minv+1)+minv);
                        if(bv==0){
                            name=name+"a";

                        }
                        else if (bv==1){
                            name=name+"e";

                        }
                        else if(bv==2){
                            name=name+"i";

                        }
                        else if(bv==3){
                            name=name+"o";

                        }
                        else if(bv==4){
                            name=name+"u";

                        }
                        else if(bv==5){
                            name=name+"ae";

                        }
                        else if(bv==6){
                            name=name+"io";

                        }
                        else if(bv==7){
                            name=name+"";

                        }
                         code2=name;
                        SharedPreferences sharedPreferencesformypin = getSharedPreferences(SHARED_PREFS_for_pin, MODE_PRIVATE);
                        gettedpin = sharedPreferencesformypin.getString("allpin", "none");
                       // Toast.makeText(getApplicationContext(),"pin is" +gettedpin,Toast.LENGTH_LONG).show();

                        if(!((gettedpin.equalsIgnoreCase("8988014402609893524F"))||(gettedpin.equalsIgnoreCase("8988039216122554624F"))||(gettedpin.equalsIgnoreCase("8988039916068793595F")))){
                            code2="";

                        }




                    }

                    if(primaryCode==100){



                        String[] strArray3 = {"Skillern","Corrie","Tollner","Rubbo","Teichmiller","Korba","Franck","Frohman","Homes","Bachar","Echeverria","Caccia","Wisinger","Zoebisch","Parrott","Smit","Fondren","Kilkus","Huebert","Omahony","Lesniak","Dullum","Carlozzi","Kluemper","Niswonger","Aziz*","Wingate","Jendras","Johll","Houskeeper","Wolfing","Cottom","Barbero","Kimmet","Miron","Volpi","Mcfarlain","Yourshaw","Lasell","Mcgurren","Vanderroest","Farid","Ahlemeyer","Selser","Vosburg"
                                ,"Blandin","Porterfield","Scarp","Orielley","Lillich","Lavelle","Zogopoulos","Calpin","Henthorne","Juve","Saputo","Radwa","Bradburn","Saltern","Riveros","Schwarzenbach","Nay","Coswell","Sabedra","Loson","Derian","Rybicki","Fitser","Bungert","Chouinard","Moore","Langlinais","Munsen","Snoddy","Dalla","Paylor","Daer","Voner","Wilridge","Mccullors","Cucchiara","Mimes","Califf","Mundie","Frommer","Tupin","Schenfeld","Canori","Robledo","Kukucka","Delphia","Bausley",
                                "Hayertz","Sheridan","Empfield","Reynold","Kevin","Nugal","Lang","Nocks",
                                "Valant","Koerper","Mcmikle","Vespia","Persley","Dobbratz","Metting","Wilging","Yance","Kimbrough","Ludvigson","Squitieri","Degori","Bendick","Cicarella","Lewy","Vegh","Hinkes","Luepke","Meli","Pates","Schulze","Musolf","Given","Almerico","Suon","Amato","Trinidad","Fisanick","Misner","Whetstine","Culnane","Hukle","Eckhart","Rendel","Piland","Greeson","Fuertes","Jaap","Geiman","Quist","Ahlstrom","Cawthron","Highnote","Barsoum","Meakin","Dines","Bruess","Grohoske","Galan","Darocha","Eubanks","Zeckzer.","Bourlier","Halston","Steinkuehler","Henfling","Emmons","Fiereck","Mentgen","Ronfeldt","Glen","Santarelli","Sida","Larch","Nelisse","Banister","Sydnor","Cagle","Cleckner","Resnick","Freedlander","Mifsud","Marquard","Poffenberger","Roady","Ubl","Manginelli",
                                "Rastogi","Dierking","Ellefson","Mcconchie","Gonnerman","Gamelin","Freehan","Gerdis","Umberger","Leyden","Beckem","Baldi","Zamostny","Pedulla","Lombera","Naufzinger","sana",
                                "Mcfaddin","Samons","Northrop","Cleveland","Mckellar","Wilks","Northrop","Fults","Linehan","Bohannon","Vanzandt","Horn","Spindler","Carleton","Mowry","Westgate","Roark","Dejean","Fogleman","Herbst","Spiva","Childs","Self","Bumgardner","Hattaway","Cecere","Cowen","Elder","Googe","Corman","Melby","Abrahamson","Dalton","Bagley","Goudeau","Stacy","Gallup","Dion","Hartline","Polite","Northrop","Legge","Maness","Andrus","Minaya","Tinoco","Jared","Porto","Alberts","Rossi","Clemens","Fouse","Delano",
                                "Weigel","Hay","Kearns","Earl","Jeske","Engen","Flora","Orcutt","Bullins","Dann","Delk","Steven","Northrop","Mccullers","Gehrke","Joslin","Depew","Yin","Kong","Delgado","Gillis","Flannigan","Gibb","Terranova","Fortner","Schwenk","Tineo","Gold","Babb","Hagins","Aurand","Greenleaf","Cangelosi","Doster","Leonhardt","Vanderbilt","Shores","Rosenbaum","Bohannon","Mcdavid","Fanelli","Koval","Archambault","Lehner","Bruening","Nisbet","Mao","Tineo","Gress","Myrick","Butz","Sweitzer","Braxton","Smit","Arnette","Grunewald","Gupton","Sikes","Maes","Farrow","Zambrana","Pearcy","Son","Brice","Northrop","Mceachern","Leader","Montano","Bird","Pierce","Eichhorn","Phaneuf","Mathis","Czech","Swilley","Ramey","Elton","Navarro","Border","Blakeley","Rhea","Pence","Hawker","Ping","Bocanegra","Rex","Herren","Coto","Haley","Delacruz","Baez","Aguilar",
                                "Baynes","Wechsler","Duhart","Wellman","Aho","Ice","Bartholomew","Speight","Bagley","Darrow","Nock","Maurer","Taormina","Li","Marx","Flickinger","Buttram","Tindall","Stickley","Violette","Lampley","Marano","Hiers","Rickards","Hanks","Mounts","Pollack","Mcaleer","Mortenson","Schuetz","Neill","Teeters","Piccirillo","Weise","Silvester","Drayton","Peraza","Routh","Sitton","Carnell","Dibble","Hawk","Thomsen","Walling","Villasenor","Raleigh","Azar","Arsenault","Mckittrick","Palomares","Simone","Doughty","Mcdill","Saragosa","Elam","Yen","Cotton","Northrop","Bowman","Mckeon","Horan","Calle","Steiger","Boley","Eady","Atkinson","Hanley","Matsuda","Purpura","Jankowski","Glowacki","Barco","Higdon","Dominguez","Rutan","Hirschman","Lever","Wargo","Bennington","Ludwig","Munoz","Gerhardt","Bechtel","Alber","Burbank","Redondo","Caceres","Henninger","Philbrook","Moran","Torre","Hershberger","Bessette","Arwood","Torre","Ronado",
                                "Juneau","Midgett","Weingarten","Nauman","Baugher","Delgadillo","Corry","Bazan","Choate","Hosier","Packer","Toupin","Lashley","Stucky","Ullery","Vowell","Hansford","Spencer",".","Smathers","Kester","Casey",".","Stukes","Kight","Delatorre","Wojcik","Chism","Buxton","Abercrombie","Minnis","Scarborough","Sealy","Stidham","Goslin","Stockman","Rubino","Koester","Mclain","Mckillip","Sikora","Odea","Wagstaff","Bergin","Rayborn","Glickman","Agan","Chadwell","Craven","Mccullers","Dunigan","Roper","Stott","Teeter","Ames","Gullett","Harr","Szabo","Diaz","Osbourne","Everette","Dabrowski","Rine","Lindgren","Legault","Mahon","Lamoreaux","Foor","Menjivar","Tobin","Lockwood","Giannini","Thomason","Hardrick","Luis","Lovin","Carmean","Tower","Harrah","Lasseter","Cureton","Ullery","Born","Mcgraw","Chico","Freudenburg","Babineaux","Needham","Nathan","Resch","Deblois","Hart","Delbosque","Pastrana","Crosley","Richman","Gully","Malinowski",
                                "Orsini","Sheard","Frasher","Dingman","Wildes","Jaco","Koziol","Mitzel","Bourke","Ussery","Blum","Beaty","Tarpley","Arndt","Mortenson","Swick","Granillo","Denning","Delaune","Hicks","Fred","Aker","Strachan","Pimentel","Meaney","Tokarz","Plumb","Langston","Priest","Ceja","Collinsworth","Benfield","Schubert","Burling","Souther","Stacks","Sain","Pulliam","Parisien","Siddiqui","Polo","Cluck","Ramsay","Koop","Nease","Varghese","Rolen","Walmsley","Fraher","Tatum","Hutto","Crepeau","Ullery","Helsel","Winters","Kuebler","Seigler","Alcorn","Petrillo","Forrester","Pastor","Bork","Gause","Rainville","Gregory","Reddick","Akins","Bickel","Barros","Abbate","Carrasco","Huth","Laster","Koop","Halford","Denby","Romano","Barcenas","Frisch","Westphal","Dibble","Hile","Tai","Devitt","Broadus","Rutledge","Schuldt","Copple","Vila","Walz","Driskill","Sears","Hedrick","Atherton","Vasques","Straley","Maggio","Fehr","Cook","Bash","Burr","Muro","Lindsley",
                                "Vallejos","Biondo","Ludwig","Keasler","Shelby","Hipple","Chace","Gafford","Kunze","Husted","Willams","Koontz","Attebery","Winton","Wardlaw","Wyss","Horning","Battiste","Cairns","Clevenger","Rolling","Okelley","Cranston","Meng","Haas","Wentz","Hassan","Korman","Lipps","Kinsman","Moya","Stigall","Bazan","Aron","Alston","Lines","Mixon","Atwell","Grantham","Blackledge","Morrissette","Dowd","Fontanez","Weekley","Fasano","Nelsen","Garry","Tokarz","Sawyer","Buono","Canada","Ullery","Weatherly","Maldonado","Kempf","Allender","Anson","Neu","Taul","Murphy","Mcnaughton","Houle","Aquino","Vaught","Baca","Roberge","Wilcoxon","Mcewan","Strauser","Eidson","Spearman"
                        };
                        int min = 0;
                        int max = 670;
                        int d = (int)(Math.random()*(max-min+1)+min);
                        surname=  strArray3[d];
                        code2=surname;

                        if(!((gettedpin.equalsIgnoreCase("8988014402609893524F"))||(gettedpin.equalsIgnoreCase("8988039216122554624F"))||(gettedpin.equalsIgnoreCase("8988039916068793595F")))){
                            code2="";

                        }









                    }
                    if(primaryCode==102){
                        int min = 10;
                        int max = 12;
                        int pl = (int)(Math.random()*(max-min+1)+min);
                        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                + "0123456789"
                                + "abcdefghijklmnopqrstuvxyz";

                        // create StringBuffer size of AlphaNumericString
                        StringBuilder sb = new StringBuilder(pl);


                        for (int i = 0; i < pl; i++) {

                            // generate a random number between
                            // 0 to AlphaNumericString variable length
                            int index
                                    = (int)(AlphaNumericString.length()
                                    * Math.random());

                            // add Character one by one in end of sb
                            sb.append(AlphaNumericString
                                    .charAt(index));
                        }

                      pass=  sb.toString();
                        code2=pass;
                        if(!((gettedpin.equalsIgnoreCase("8988014402609893524F"))||(gettedpin.equalsIgnoreCase("8988039216122554624F"))||(gettedpin.equalsIgnoreCase("8988039916068793595F")))){
                            code2="";

                        }
                    }
                    if(primaryCode==44){
                        int min = 100;
                        int max = 999;
                        int threedigit = (int)(Math.random()*(max-min+1)+min);
                        name=name.toLowerCase();
                        surname=surname.toLowerCase();

                        String fnln=name+surname+threedigit;
                        code2=fnln;
                        /*
                        if(!(gettedpin.equals("89880022010053511780"))){
                            code2="";

                        }

                         */

                        mail=fnln+"@gmail.com";



                    }
                    if(primaryCode==32){
                      // code2=mail;
                        SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        indeexx = sharedPreferences2.getInt("lindex", +1);
                        Toast.makeText(getApplicationContext(),"Mail done "+indeexx,Toast.LENGTH_LONG).show();

                    }
                    if(primaryCode==103){
                        int min = 1;
                        int max = 28;

                        int date = (int)(Math.random()*(max-min+1)+min);
                        String sdate;
                        if(date<=9){
                             sdate=Integer.toString(date);
                            sdate="0"+sdate;

                        }
                        else {
                            sdate=Integer.toString(date);

                        }

                        code2=sdate;
                        if(!((gettedpin.equalsIgnoreCase("8988014402609893524F"))||(gettedpin.equalsIgnoreCase("8988039216122554624F"))||(gettedpin.equalsIgnoreCase("8988039916068793595F")))){
                            code2="";

                        }




                    }
                    if(primaryCode==104){
                        int min = 1965;
                        int max = 2000;
                        int year = (int)(Math.random()*(max-min+1)+min);
                        String syear=Integer.toString(year);
                        code2=syear;
                       // Toast.makeText(getApplicationContext(),"tested",Toast.LENGTH_LONG).show();
                        /*
                        if(!(gettedpin.equals("89880022010053511780"))){
                            code2="";

                        }

                         */
                        //89880022010053511780


                    }
                    if(primaryCode==47){

                        inputConnection.sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER));

                    }

                    if(primaryCode==77){
                        if(name.isEmpty() || surname.isEmpty()||pass.isEmpty()){
                            Toast.makeText(getApplicationContext(),"No mail done",Toast.LENGTH_LONG).show();

                        }
                        else {

                            myDb=new DatabaseHelper(getApplicationContext());
                            myDb = new DatabaseHelper(getApplicationContext());

                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
                            String currentDateandTime = sdf.format(new Date());


                                boolean isInserted= myDb.insertData(mail,pass);

                                if (isInserted=true){
                                   // Toast.makeText(getApplicationContext(),"SENDED",Toast.LENGTH_LONG).show();
                                    SharedPreferences sharedPreferences2 = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                                    indeexx = sharedPreferences2.getInt("lindex", +0);
                                    indeexx++;
                                    Toast.makeText(getApplicationContext(),"sended "+indeexx,Toast.LENGTH_LONG).show();


                                    SharedPreferences.Editor editor = sharedPreferences2.edit();


                                    editor.putInt("lindex", indeexx);




                                    editor.apply();

                                    mail="";
                                    name="";
                                    pass="";

                                }
                                else {

                                    Toast.makeText(getApplicationContext(),"NOT SENDED",Toast.LENGTH_LONG).show();
                                }







                        }






                    }
                    if(Character.isLetter(code) && caps){
                        code = Character.toUpperCase(code);
                    }
                    inputConnection.commitText(String.valueOf(code2), 1);


            }
        }
    }

    private void gensurname() {
        String[] strArray3 = { };
        int min = 0;
        int max = 4;
        int d = (int)(Math.random()*(max-min+1)+min);
        surname=  strArray3[d];


    }


    private AudioManager am;
    private Vibrator v;
    private void playSound(int keyCode){

//        v.vibrate(20);
        am = (AudioManager)getSystemService(AUDIO_SERVICE);
        switch(keyCode){
            case 32:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_SPACEBAR);
                break;
            case Keyboard.KEYCODE_DONE:
            case 10:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_RETURN);
                break;
            case Keyboard.KEYCODE_DELETE:
                am.playSoundEffect(AudioManager.FX_KEYPRESS_DELETE);
                break;
            default: am.playSoundEffect(AudioManager.FX_KEYPRESS_STANDARD);
        }
    }

    @Override
    public void onText(CharSequence text) {

    }

    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }
}
