package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Check_Username extends AppCompatActivity {
EditText CheckUsername;
Button Check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseSqlite sqlite = new DatabaseSqlite(this);
        setContentView(R.layout.activity_check_username);
        CheckUsername=findViewById(R.id.edit_user_check);
        Check=findViewById(R.id.btn_check);
        Intent intent = getIntent();
        intent.getStringExtra("key_Reset");
        CheckUsername.setText( intent.getStringExtra("key_Reset"));
        Check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = CheckUsername.getText().toString();
                String Result = sqlite.Check_Username(Username);

                if (Result.equalsIgnoreCase("Found"))
                {
                    Toast.makeText(Check_Username.this, "Your Username is already existing ", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Check_Username.this,Reset_Password.class);
                    intent.putExtra("CheckUsername",Username);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(Check_Username.this, "This Username is not available , You have to Regiser", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Check_Username.this,Register.class);
                    startActivity(intent);
                }
            }
        });
    }
}