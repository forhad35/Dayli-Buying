package com.example.recycler_view_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recycler_view_demo.DataBase.db;

public class MainActivity2 extends AppCompatActivity {
    EditText disc, amount, date;
    String dis, amounts, dates;
    CurrentDate currentDate;

    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );

        addBtn = findViewById( R.id.addbtn );
        disc = findViewById( R.id.add_disc );
        amount = findViewById( R.id.add_amount );
        date = findViewById( R.id.add_date );
        currentDate = new CurrentDate();
        date.setText( currentDate.formatedDate() );
        db dbm = new db( this );
        addBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dis = disc.getText().toString();
                amounts = amount.getText().toString();
                dates = date.getText().toString();
                if ( !dis.isEmpty() && !amounts.isEmpty() && !dates.isEmpty() ) {
                    boolean b = dbm.addData( dis, amounts, dates );
                    if ( b ) {
                        Toast.makeText( MainActivity2.this, "Data inserted", Toast.LENGTH_SHORT ).show();

                    } else {
                        Toast.makeText( MainActivity2.this, "data not inserted", Toast.LENGTH_SHORT ).show();

                    }
                } else {
                    Toast.makeText( MainActivity2.this, "Input Data First", Toast.LENGTH_SHORT ).show();

                }
            }
        } );


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity( new Intent( MainActivity2.this, MainActivity.class ) );
    }
}