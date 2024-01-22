package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Book extends AppCompatActivity {
    EditText Firstname ,Lastname ,Email,Phone;
    Spinner Number, Date,Time,Reservation;
    Button Book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        DatabaseSqlite databaseSqlite = new DatabaseSqlite(this);
        Firstname=findViewById(R.id.Fname);
        Lastname = findViewById(R.id.Lname);
        Email = findViewById( R.id.email);
        Phone = findViewById(R.id.phone);
        Number = findViewById(R.id.number);
        Date = findViewById(R.id.date);
        Time = findViewById(R.id.time);
        Reservation = findViewById(R.id.reservation);
        Book = findViewById(R.id.update);
        Book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = Firstname.getText().toString();
                String lname = Lastname.getText().toString();
                String email = Email.getText().toString();
                int phone = Integer.parseInt(Phone.getText().toString());
                int number= Integer.parseInt(Number.getSelectedItem().toString());
                String date = Date.getSelectedItem().toString();
                String time = Time.getSelectedItem().toString();
                String reservation = Reservation.getSelectedItem().toString();
                if (fname.equalsIgnoreCase("")||lname.equalsIgnoreCase("")||email.equalsIgnoreCase(""))
                {
                    Toast.makeText(Book.this, "Please write again", Toast.LENGTH_SHORT).show();
                }
                else {

                  String Result = databaseSqlite.book(fname,lname,email,number,date,time,reservation,phone);

                        Toast.makeText(Book.this,Result, Toast.LENGTH_SHORT).show();

                }

            }
        });

    }
}