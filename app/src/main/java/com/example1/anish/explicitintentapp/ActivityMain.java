package com.example1.anish.explicitintentapp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class ActivityMain extends AppCompatActivity {

    TextView t1;
    EditText et1;
    Button b1,b2;
    final int ACTIVITY_3 = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        t1 = findViewById(R.id.t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().toString().isEmpty()){
                    Toast.makeText(ActivityMain.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    String name = et1.getText().toString().trim();
                    //we create the object of the intent to switch over the  activity
                    Intent  intent = new Intent(  ActivityMain.this,com.example1.anish.explicitintentapp.Activity2.class);
                        intent.putExtra( "name",name);
                        // here we create a key and its value to be accesssed on the other activities so we use the putExtra() func
                    startActivity(intent);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        Intent intent  =  new Intent(ActivityMain.this,com.example1.anish.explicitintentapp.Activity3.class);
                        startActivityForResult(intent,ACTIVITY_3);// we need to passs an integer to uniquely identify the activity 3
                // the above fucnc is used because the result is being returned to the mainActivity.
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //say we are having many activities that return to the same main activity then to identify which acivity is returning we need the unique code
        if(requestCode== ACTIVITY_3){
            if(resultCode== RESULT_OK){
                t1.setText(data.getStringExtra("surname"));
            }
            if(resultCode==RESULT_CANCELED){
                t1.setText("No data received");
            }

        }
    }
}
