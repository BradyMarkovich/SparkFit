package com.bradymarkovich.sparkfit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.*;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserAreaActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView count;
    boolean run;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        count = (TextView) findViewById(R.id.count);

        //Initialize sensor manager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        run = true;

        //Get the pedometer sensor
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null){
            sensorManager.registerListener((SensorEventListener) this, countSensor, sensorManager.SENSOR_DELAY_UI);
        }
        else
        {
            //error message for user
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onPause(){
        super.onPause();
        run = false;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (run) {
            count.setText(String.valueOf(event.values[0]));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
