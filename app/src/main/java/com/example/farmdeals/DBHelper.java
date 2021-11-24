package com.example.farmdeals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table userdetails(User_id Text primary key,Mobile_no Text,Email Text,Address Text,Password Text)");

    }
    @Override
    public void onCreate(SQLiteDatabase myDBFm) {
        myDBFm.execSQL("create Table farmerdetails(Farmer_id Text primary key,F_ph_no Text,F_email Text,F_address Text,f_password Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {
        myDB.execSQL("drop Table if exists userdetails");
        myDB.execSQL("drop Table if exists farmerdetails");

    }
    public boolean insertData(String User_id,String Mobile_no,String Email,String Address,String Password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("User_id",User_id);
        contentValues.put("Mobile_no",Mobile_no);
        contentValues.put("Email",Email);
        contentValues.put("Address",Address);
        contentValues.put("Password",Password);
        long result=myDB.insert("userdetails",null,contentValues);

        if(result==-1){
            return false;
        }
        else
            return true;
    }


    public boolean checkUser_id(String User_id){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor= myDB.rawQuery("select * from userdetails where User_id=?",new String[] {User_id});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkUser_idPassword(String User_id,String Password){
        SQLiteDatabase myDB=this.getWritableDatabase();
        Cursor cursor= myDB.rawQuery("select * from userdetails where User_id=? and Password=?",new String[] {User_id,Password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
}
