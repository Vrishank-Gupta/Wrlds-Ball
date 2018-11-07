package com.example.vrishankgupta.boilerplate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wrlds.sdk.Ball;

public class MainActivity extends AppCompatActivity {

    Ball a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        a = new Ball(this);
        Button btn = findViewById(R.id.butn);


        a.setOnConnectionStateChangedListener(new Ball.OnConnectionStateChangedListener() {
            @Override
            public void onConnectionStateChanged(int i, String s) {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a.scanForDevices();

                        Log.d("Devices", "onCreate: " + a.getDeviceList());
                    }
                });
            }
        });

        Toast.makeText(this, a.getDeviceList().toString(), Toast.LENGTH_SHORT).show();
    }
}
