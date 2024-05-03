package com.prithviraj.contatcsstoringapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDBHelper extends SQLiteOpenHelper {
    private static String DATABASE_NAME = "contactsDB";
    private static int DATABASE_VERSION = 1;
    private static String tableName = "contacts";
    private static String primaryKey = "PRIMARY_KEY";
    private static String userName = "NAME";
    private static String phoneNO = "PHONE_NUMBER";
    private static String emailID = "EMAIL";
    public MyDBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + tableName + " ("
                + primaryKey + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + userName + " TEXT, "
                + phoneNO + " TEXT, "
                + emailID + " TEXT"
                + ")");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS "+tableName);
        onCreate(db);

    }
    public void addContact(String name,String phone,String email)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(userName,name);
        values.put(phoneNO,phone);
        values.put(emailID,email);
        db.insert(tableName,null,values);
    }

    public ArrayList<contact> fetchContact()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+tableName,null);
        ArrayList<contact> contactArrayList = new ArrayList<contact>();
        while (cursor.moveToNext())
        {
            contact c = new contact();
            c.setuName(cursor.getString(1));
            c.setuNumber(cursor.getString(2));
            c.setuEmail(cursor.getString(3));

            contactArrayList.add(c);


        }
        return contactArrayList;
    }
    public void delContact(String phone)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName,phoneNO+ " = ? ", new String[]{phone});
    }
}
