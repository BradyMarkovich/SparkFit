package com.bradymarkovich.sparkfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);

        final EditText email = (EditText) findViewById(R.id.emailVerified);
        final TextView emtest = (TextView) findViewById(R.id.userTestTxtV);
        final EditText lol = (EditText) findViewById(R.id.email_TxtField);


        //transfer data from one activity to another
        emtest.setText(getIntent().getStringExtra("emailadd"));



    }
}
