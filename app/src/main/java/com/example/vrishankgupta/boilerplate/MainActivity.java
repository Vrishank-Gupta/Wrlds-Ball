package com.example.vrishankgupta.boilerplate;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
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

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{
                        Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE
                },
                1);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    start();
                } else {
                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    void start()
    {
        a = new Ball(this);
        Button btn = findViewById(R.id.butn);


        a.setOnConnectionStateChangedListener(new Ball.OnConnectionStateChangedListener() {
            @Override
            public void onConnectionStateChanged(int i, String s) {
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a.scanForDevices();
                        Log.d("Conn", "onClick: "+a.getConnectionState());
                        Log.d("Devices", "onCreate: " + a.getDeviceList());


                    }
                });
            }
        });

        a.setOnBounceListener(new Ball.OnBounceListener() {
            @Override
            public void onBounce(int i, float v) {
                Toast.makeText(a, "Bouncing", Toast.LENGTH_LONG).show();
            }
        });
    }
}
