package com.example.fragments;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class Intro extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;

    public  static int spl=6000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        lottieAnimationView=findViewById(R.id.lottie);
        lottieAnimationView.animate().translationY(1600).setDuration(2000).setStartDelay(4000);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intro.this,Login.class);
                startActivity(intent);
                finish();
            }
        },spl);



    }

}