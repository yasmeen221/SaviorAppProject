package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Reset_Password extends AppCompatActivity {
EditText Username,NewPassword,ConfirmPassword ;
Button Reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DatabaseSqlite sqlite = new DatabaseSqlite(this);
        setContentView(R.layout.activity_reset_password);
        Username= findViewById(R.id.edit_user_reset);
        NewPassword=findViewById(R.id.edit_newpassword_reset);
        ConfirmPassword=findViewById(R.id.editText_confirmpassword_reset);
        Reset=findViewById(R.id.btn_resetpassord);
        Intent intent = getIntent();
        intent.getStringExtra("CheckUsername");
        Username.setText(intent.getStringExtra("CheckUsername"));
        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username =  Username.getText().toString();
               String newpassword = NewPassword.getText().toString();
               String confirmpassword = ConfirmPassword.getText().toString();
               if (username .equalsIgnoreCase("")||newpassword.equalsIgnoreCase("")||confirmpassword.equalsIgnoreCase(""))
               {
                   Toast.makeText(Reset_Password.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   if (newpassword.equalsIgnoreCase(confirmpassword))
                   {
                       String Result = sqlite.update_Password(username,newpassword);
                       if (Result.equalsIgnoreCase("Done"))
                       {
                           Toast.makeText(Reset_Password.this, "Your Password Reseted", Toast.LENGTH_SHORT).show();
                           Intent intent = new Intent(Reset_Password.this,Login.class);
                           intent.putExtra("keey",username );
                           startActivity(intent);
                       }
                       else
                       {
                           Toast.makeText(Reset_Password.this, "Your Password Not Reseted", Toast.LENGTH_SHORT).show();
                       }
                   }
                   else
                   {
                       Toast.makeText(Reset_Password.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                   }
               }


            }

        });
    };
}