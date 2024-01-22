package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;
    Button Register;
    Button Show;
    Button Reset;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.edit_user);
        password = findViewById(R.id.edit_password);
        login = findViewById(R.id.button);
        DatabaseSqlite sqlite = new DatabaseSqlite(this);
        Intent intent = getIntent();
        intent.getStringExtra("keeey");
        username.setText(intent.getStringExtra("keeey"));
        Intent intent1 = getIntent();
        intent1.getStringExtra("keey");
        username.setText(intent.getStringExtra("keey"));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = username.getText().toString();
                String Password = password.getText().toString();
                if (Name.equalsIgnoreCase("") || Password.equalsIgnoreCase("")) {
                    Toast.makeText(Login.this, "Please Enter all fields ", Toast.LENGTH_LONG).show();
                } else {
                    String Result = sqlite.Check(Name, Password);
                    if (Result.equals("Found")) {
                        Intent intent = new Intent(Login.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (Result.equals("Not Found")) {
                        Toast.makeText(Login.this, "Password or Username is Worng", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        Register = findViewById(R.id.btn_menu);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });
        Reset = findViewById(R.id.btn_reset);
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent  intent = new Intent(Login.this,Check_Username.class);
             intent.putExtra("key_Reset",username.getText().toString());
             startActivity(intent);
                finish();
            }
        });

    }

}
