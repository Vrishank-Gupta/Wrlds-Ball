package com.example.vrishankgupta.boilerplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.wrlds.sdk.Ball;

public class ActionActivity extends AppCompatActivity {

    Ball a;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        a=MainActivity.a;

        a.setOnBounceListener(new Ball.OnBounceListener() {
            @Override
            public void onBounce(int i, float v) {
                img.setImageResource(R.drawable.after);
            }
        });

    }


}
