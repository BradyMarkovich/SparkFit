package com.bradymarkovich.sparkfit;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final String pwordFinal = "";
        final EditText fname = (EditText) findViewById(R.id.firstName_TxtField);
        final EditText lname = (EditText) findViewById(R.id.lastName_TxtField);
        final EditText email = (EditText) findViewById(R.id.email_TxtField);
        final EditText pword = (EditText) findViewById(R.id.password_TxtField);
        final EditText pwordv = (EditText) findViewById(R.id.passwordVerify_TxtField);
        final Button register = (Button) findViewById(R.id.register_Button);



        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final String fn = fname.getText().toString();
                final String ln = lname.getText().toString();
                final String mail = email.getText().toString();
                final String pass = pword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response)
                    {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean succ = jsonResponse.getBoolean("success");
                            if (succ)
                            {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Register failed").setNegativeButton("Retry", null).create().show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(fn, ln, mail, pass, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }


        });


    }
}
