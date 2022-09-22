package com.example.storagetechniques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button LoginBtn;
    EditText passEdit, userEdit;
    String adminPass ="123";
    String adminUser ="SaraH";
    CheckBox rememberMeCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginBtn = findViewById(R.id.login_btn);
        passEdit = findViewById(R.id.password_edit);
        userEdit = findViewById(R.id.username_edit);
        rememberMeCheck = findViewById(R.id.rememberme_check);


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Password and Username Validity Check

                String user = userEdit.getText().toString();
                String pass = passEdit.getText().toString();
                if (user.isEmpty()){
                    Toast.makeText(MainActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (pass.isEmpty()){
                    Toast.makeText(MainActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (!user.equals(adminUser)){
                    Toast.makeText(MainActivity.this, "Username is incorrect", Toast.LENGTH_SHORT).show();
                }
                else if (!pass.equals(adminPass)){
                    Toast.makeText(MainActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                    // If the user wants to save username and password (remember me)
                    if (rememberMeCheck.isChecked()){

                        // Get the app context (the place we want to get the preferences to), then get the preferences
                        SplashActivity.sharedPreferences = getApplicationContext().getSharedPreferences("AuthPref", Context.MODE_PRIVATE);
                        // Get an instance of sharedPref editor (SharedPreferences.Editor editor) and use it to edit the sharedPref instance we have (sharedPreferences)
                        SharedPreferences.Editor editor = SplashActivity.sharedPreferences.edit();

                        // Store Shared Preferences
                        editor.putString(SplashActivity.USER_KEY,user);
                        editor.putString(SplashActivity.PASS_KEY,pass);
                        editor.apply();

                    }

                    Intent i= new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }

            }
        });
    }
}