package com.bradymarkovich.sparkfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fname = (EditText) findViewById(R.id.firstName_TxtField);
        final EditText lname = (EditText) findViewById(R.id.lastName_TxtField);
        final EditText email = (EditText) findViewById(R.id.email_TxtField);
        final EditText pword = (EditText) findViewById(R.id.password_TxtField);
        final EditText pwordv = (EditText) findViewById(R.id.passwordVerify_TxtField);
        final Button register = (Button) findViewById(R.id.register_Button);


    }
}
