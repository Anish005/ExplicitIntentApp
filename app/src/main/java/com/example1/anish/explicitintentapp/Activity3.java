package com.example1.anish.explicitintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
public class Activity3 extends AppCompatActivity {

    EditText e3;
    Button b3,b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        e3 = findViewById(R.id.e3);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e3.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this, "Please enter your surname", Toast.LENGTH_SHORT).show();
                }
                else{
                    String surname = e3.getText().toString().trim();
                    Intent intent =  new Intent();
                    intent.putExtra("surname",surname);
                    //we can directly assign the part that we have assigned it to the variable surname
                    //we need not have to start another activity
                    setResult(RESULT_OK,intent );
                    Activity3.this.finish();//this will destroy the activity after being called
                }

            }
        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });

    }
}
