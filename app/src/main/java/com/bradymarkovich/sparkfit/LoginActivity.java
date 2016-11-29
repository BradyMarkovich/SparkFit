package com.bradymarkovich.sparkfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = (EditText) findViewById(R.id.username_TxtField);
        final EditText pword = (EditText) findViewById(R.id.pass_TxtField);
        final Button login = (Button) findViewById(R.id.login_Button);
        final TextView registerlink = (TextView) findViewById(R.id.register_TextView);

        //Go to register activity if register link is clicked
        registerlink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerInt = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerInt);

            }

        });


    }
}
