package com.example.storagetechniques;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button LoginBtn;
    EditText passEdit, userEdit;
    String adminPass ="123";
    String adminUser ="SaraH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginBtn = findViewById(R.id.login_btn);
        passEdit = findViewById(R.id.password_edit);
        userEdit = findViewById(R.id.username_edit);

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Password and Username Validity

                String user = userEdit.getText().toString();
                String pass = passEdit.getText().toString();
                if (user == ""){
                    Toast.makeText(MainActivity.this, "Username cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (pass == ""){
                    Toast.makeText(MainActivity.this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if (user != adminUser){
                    Toast.makeText(MainActivity.this, "Username is incorrect", Toast.LENGTH_SHORT).show();
                }
                else if (pass != adminPass){
                    Toast.makeText(MainActivity.this, "Password is incorrect", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent i= new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(i);
                }

            }
        });
    }
}