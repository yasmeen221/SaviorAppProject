package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText editText_username;
    EditText editText_email;
    EditText editText_password;
    EditText editText_confirmpassword;
    Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DatabaseSqlite sqlite = new DatabaseSqlite(this);
        editText_username=(EditText) findViewById(R.id.editText_username);
        editText_email= (EditText)findViewById(R.id.editText_email);
        editText_password=(EditText)findViewById(R.id.editText_password);
        editText_confirmpassword = findViewById(R.id.editText_confirmpassword);
        Register= (Button) findViewById(R.id.btn_register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String User = editText_username.getText().toString();
                String Email = editText_email.getText().toString();
                String Password = editText_password.getText().toString();
                String Confirm_Password = editText_confirmpassword.getText().toString();
                if (User.equalsIgnoreCase("")|| Email.equalsIgnoreCase("") || Password.equalsIgnoreCase("") || Confirm_Password.equalsIgnoreCase(""))
                {
                    Toast.makeText(Register.this, "Please Enter all the fields", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (Password.equalsIgnoreCase(Confirm_Password))
                    {
                        String res = sqlite.Check_Username(User);
                        if (res.equalsIgnoreCase("Found"))
                        {
                            Toast.makeText(Register.this, "This Username is Existing", Toast.LENGTH_LONG).show();
                        }
                        else {
                            String result = sqlite.Insert_Data(User, Email, Password);
                            //   Toast.makeText(Register.this, result, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(Register.this, Login.class);
                            intent.putExtra("keeey", editText_username.getText().toString());
                            startActivity(intent);
                            finish();
                        }
                    }
                    else
                    {
                        Toast.makeText(Register.this,"Password does not match", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}