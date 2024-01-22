package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class After_Login extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    TextView UserName;
    public  static int spl=6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);
      //  UserName=findViewById(R.id.user_after);
      //  Intent intent=getIntent();
      //  String value=  intent.getStringExtra("key");
      //  UserName.setText(value);
        lottieAnimationView=findViewById(R.id.lottie2);
        lottieAnimationView.animate().translationY(1600).setDuration(2000).setStartDelay(4000);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(After_Login.this,Login.class);
                startActivity(intent);
                finish();
            }
        },spl);


    }
}