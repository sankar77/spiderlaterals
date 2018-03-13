package com.example.sankar.recyclerviewexample.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nagarajan on 15-06-2016.
 */
public class DBhelper extends SQLiteOpenHelper {
    static String name="MYDB.db";
    static int version=1;
    public DBhelper(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("Create Table details(name TEXT,age TEXT,mobno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             if(newVersion>oldVersion)
                 onCreate(db);
    }

public boolean insetRecord (String name,String age,String mobno){

    ContentValues values=new ContentValues();
    values.put("name",name);
    values.put("age",age);
    values.put("mobno",mobno);
    SQLiteDatabase db=this.getWritableDatabase();
    long ack=db.insert("details",null,values);
    return ack>0;
}

    public Cursor getInsertRecord(){
        SQLiteDatabase db=this.getReadableDatabase();
        String query="select * from details ";
        Cursor c=db.rawQuery(query, null);
        return  c;
    }

    public void deleteRecord(String name){
        SQLiteDatabase db=this.getWritableDatabase();
        String query="delete from details where name='"+name+"'";
        db.execSQL(query);
    }
public Cursor getparticularname(String name){
    SQLiteDatabase db=this.getReadableDatabase();
    String query="select * from details where name='"+name+"'";
    return db.rawQuery(query,null);

}
}