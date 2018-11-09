package com.example.vrishankgupta.boilerplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View easySplashScreenView = new EasySplashScreen(Splash.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(3000)
                .withBackgroundResource(android.R.color.white)
                .withFooterText("Copyright 2016")
                .withBackgroundResource(R.drawable.ballimage)
                .withBeforeLogoText("BoilerPlate")
                .create();

        setContentView(easySplashScreenView);

    }
}
