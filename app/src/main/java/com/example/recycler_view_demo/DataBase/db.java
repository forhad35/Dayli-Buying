package com.example.recycler_view_demo.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;


public class db extends SQLiteOpenHelper {
    SQLiteDatabase db;

    public db(@Nullable Context context) {
        super( context, "DailyExpenses", null, 1 );
        db = this.getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE dailyUsage (id integer primary key autoincrement , Description text, Amount text, Date String)";
        sqLiteDatabase.execSQL( query );

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
    public boolean addData(String details, String amount, String date) {
        ContentValues c = new ContentValues();
        c.put( "Description", details );
        c.put( "amount", amount );
        c.put( "Date", date );
        boolean rr = true;
        try {
            long r = db.insert( "dailyUsage", null, c );
            if ( r == -1 ) {
                rr = false;
            } else {
                rr = true;
            }
        } catch (Exception ee) {
            Log.d( "err", "insertData: " + ee );
        }
        return rr;
    }

    public Cursor dataRead() {
        SQLiteDatabase read = this.getReadableDatabase();
        Cursor cursor= db.rawQuery( "select  * from dailyUsage",null );
        return cursor;
    }
}

