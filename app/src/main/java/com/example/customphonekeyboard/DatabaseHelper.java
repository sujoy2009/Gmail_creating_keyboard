package com.example.customphonekeyboard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String COL_1 = "ID";
    public static final String COL_2 = "MAIL";
    public static final String COL_3 = "PASSWORD";
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Mail_table";
    private Context context;

    public DatabaseHelper(Context context2) {
        super(context2, DATABASE_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        this.context = context2;
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Mail_table (ID INTEGER PRIMARY KEY AUTOINCREMENT,MAIL TEXT,PASSWORD TEXT)");
    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS Mail_table");
    }

    public boolean insertData(String name, String surname) {
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        new Date();
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        if (db.insert(TABLE_NAME, (String) null, contentValues) == -1) {
            return false;
        }
        return true;
    }

    public Cursor getAllData() {
        return getWritableDatabase().rawQuery("select*from Mail_table", (String[]) null);
    }

    public Integer deleteData() {
        return Integer.valueOf(getWritableDatabase().delete(TABLE_NAME, (String) null, (String[]) null));
    }
}
