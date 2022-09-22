package com.example.storagetechniques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    Handler handler;
    public static final String USER_KEY = "user";
    public static final String PASS_KEY = "pass";
    public static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                try {
                    // Get Shared Preferences while splash is loading so as to decide where to intent

                    // Get the app context (the place we want to get the preferences to), then get the preferences
                    sharedPreferences = getApplicationContext().getSharedPreferences("AuthPref", Context.MODE_PRIVATE);

                    // Read if we have sharedPref
                    String storedUser = sharedPreferences.getString(SplashActivity.USER_KEY, null);
                    String storedPass = sharedPreferences.getString(SplashActivity.PASS_KEY, null);

                    if (storedPass.isEmpty() || storedUser.isEmpty()){

                        Intent i= new Intent(SplashActivity.this, MainActivity.class);
                        startActivity(i);
                    }
                    else{
                        Intent i2= new Intent(SplashActivity.this, MainActivity2.class);
                        startActivity(i2);
                    }

                } catch (Exception e){
                    // Getting Shared Preferences Failed (ie. the file "AuthPref" is not created yet)
                    Intent i3= new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(i3);
                }

            }
        }, 5000);
    }


}