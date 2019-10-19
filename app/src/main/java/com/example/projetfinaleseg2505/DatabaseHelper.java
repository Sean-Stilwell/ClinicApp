package com.example.sqliteapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "Account.db";
    public static final String TABLE_NAME = "Account_table";
    public static final String USERNAME = "Username";
    public static final String PASSWORD = "Password";
    public static final String TYPE = "type";
    public static final String NAME = "NAME";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        db.execSQL("create table "+ TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, LOGIN TEXT, PASSWORD TEXT, TYPE TEXT, NAME TEXT )");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
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
