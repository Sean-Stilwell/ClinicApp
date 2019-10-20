package com.example.projetfinaleseg2505;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "Account.db";
    public static final String TABLE_NAME = "Account_table";
    public static final String ID = "ID";
    public static final String LOGIN = "LOGIN";
    public static final String PASSWORD = "PASSWORD";
    public static final String TYPE = "TYPE";
    public static final String NAME = "NAME";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, LOGIN TEXT, PASSWORD TEXT, TYPE TEXT, NAME TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String id, String password, String type, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID,id);
        contentValues.put(PASSWORD,password);
        contentValues.put(TYPE,type);
        contentValues.put(NAME, name);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }
}
