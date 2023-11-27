package com.example.recycler_view_demo;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.recycler_view_demo.DataBase.db;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    RecyclerView recycler;
    ArrayList<Record> arrayList;
    FloatingActionButton flotBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        flotBtn = findViewById( R.id.ftbtn );
        arrayList = new ArrayList<Record>();
        fetchMyData();
        flotBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity( new Intent( MainActivity.this, MainActivity2.class ) );
                    finish();
                } catch (Exception e) {
                    Log.d( "TAG", "onClick:" + e );
                }

            }
        } );
    }

    public void fetchMyData() {
        Cursor cursor = new db( this ).dataRead();

        while (cursor.moveToNext()) {
            Record record = new Record( cursor.getString( 1 ), cursor.getString( 2 ) + " TK", cursor.getString( 3 ) );
            arrayList.add( record );
        }
        recycler = (RecyclerView) findViewById( R.id.recView );
        recycler.setLayoutManager( new LinearLayoutManager( this ) );
        try {
            RecordAdapter recordAdapter = new RecordAdapter( arrayList );
            recycler.setAdapter( recordAdapter );
        } catch (Exception e) {
            Log.d( "TAG", "onCreate: errs" );
        }
    }
}
