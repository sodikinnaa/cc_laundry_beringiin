package com.example.cc_laundry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Move(View view) {
//        Toast toast2=Toast.makeText(this, "Nav's Second Toast ", Toast.LENGTH_SHORT);      //this one doesn't work
//        toast2.show();


        Intent myIntent = new Intent(MainActivity.this, InputActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}