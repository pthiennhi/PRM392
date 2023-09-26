package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.buttonLinearLayout1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.linear_layout_1);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        });
        btn2 = (Button) findViewById(R.id.buttonLinearLayout2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.linear_layout_2);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });
        btn3 = (Button) findViewById(R.id.buttonConstrainLayout1);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.constrain_layout_1);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });
        btn4 = (Button) findViewById(R.id.buttonConstrainLayout2);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.constrain_layout_2);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });
        btn5 = (Button) findViewById(R.id.buttonConstrainLayout3);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.constrain_layout_3);
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            }
        });





    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the back stack
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}