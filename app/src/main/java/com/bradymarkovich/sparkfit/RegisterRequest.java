package com.bradymarkovich.sparkfit;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REQUEST_URL =  "http://159.203.13.37/register.php";
    private Map<String, String> params;

    public RegisterRequest(String fname, String lname, String email, String password, Response.Listener<String> listener){
        super (Method.POST, REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("fname", fname);
        params.put("lname", lname);
        params.put("email", email);
        params.put("password", password);
        Log.d("Values", email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}


