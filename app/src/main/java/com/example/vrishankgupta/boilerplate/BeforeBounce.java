package com.example.vrishankgupta.boilerplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.wrlds.sdk.Ball;

public class BeforeBounce extends AppCompatActivity {
    static int count = 0;

    Ball a;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before);
        img = findViewById(R.id.img);
        a=MainActivity.a;

        Ball.BounceType type = new Ball.BounceType();


        a.setOnShakeListener(new Ball.OnShakeListener() {
            @Override
            public void onShake(float v) {
                Toast.makeText(a, "Shaken"  + v, Toast.LENGTH_SHORT).show();
            }
        });
        a.setOnBounceListener(new Ball.OnBounceListener() {
            @Override
            public void onBounce(int i, float v) {
                Log.d("BounceType", Ball.BounceType.HARD + "");
                String str = String.valueOf(v);
                if(v > 10)
                {
                    count++;
                    startActivity(new Intent(BeforeBounce.this,AfterBounce.class).putExtra("force",str).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                    finish();
                }
            }
        });

    }


}
