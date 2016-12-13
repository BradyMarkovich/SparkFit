package com.bradymarkovich.sparkfit;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = (EditText) findViewById(R.id.username_TxtField);
        final EditText pword = (EditText) findViewById(R.id.pass_TxtField);
        final Button login = (Button) findViewById(R.id.login_Button);
        final TextView registerlink = (TextView) findViewById(R.id.register_TextView);

        //Go to Register activity if register link is clicked
        registerlink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent registerInt = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerInt);

            }

        });

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                final String em = email.getText().toString();
                final String pw = pword .getText().toString();

                Response.Listener<String> resListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("Response2", response);

                            JSONObject jsonResponse = new JSONObject(response);
                            Log.d("Response", jsonResponse.toString());

                            boolean succ = jsonResponse.getBoolean("success");

                            if (succ){
                                //if succcessful, switch to UserAreaActivity
                                Intent intent = new Intent(LoginActivity.this, UserAreaActivity.class);
                                Log.d("Email transfer", em);
                                intent.putExtra("emailadd", em);//transfer email address amongst activities


                                LoginActivity.this.startActivity(intent);


                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login failed").setNegativeButton("Retry", null).create().show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                //submit a LoginRequest through LoginRequest.java
                LoginRequest loginRequest = new LoginRequest(em, pw, resListener);
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);

            }

        });


    }
}
