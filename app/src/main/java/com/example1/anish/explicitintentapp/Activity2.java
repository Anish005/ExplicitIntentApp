package com.example1.anish.explicitintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

public class Activity2 extends AppCompatActivity {


    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        t2 = findViewById(R.id.t2);
        String name = getIntent().getStringExtra("name");
        t2.setText(name + getString(R.string.activity2));
    }
}
