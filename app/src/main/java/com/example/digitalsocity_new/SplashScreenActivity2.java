package com.example.digitalsocity_new;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        getWindow().setStatusBarColor(ContextCompat.getColor(SplashScreenActivity2.this,R.color.white));

        Thread thread = new Thread()
        {
            @Override
            public void run() {

                try {
                    sleep(3000);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally {
                    Intent i= new Intent(SplashScreenActivity2.this,LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };thread.start();
    }
    }
