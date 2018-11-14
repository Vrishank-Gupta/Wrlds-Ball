package com.example.vrishankgupta.boilerplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wrlds.sdk.Ball;

import org.w3c.dom.Text;

import mehdi.sakout.fancybuttons.FancyButton;

public class AfterBounce extends AppCompatActivity {

    TextView tv;
    EditText etName;
    FancyButton fancyButton,counter,btnName;
    static public String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_bounce);
        tv = findViewById(R.id.forceValue);
        etName = findViewById(R.id.etName);
        btnName = findViewById(R.id.btnName);
        btnName.setText("Register");
        btnName.setRadius(55);
        btnName.setTextSize(20);
        counter = findViewById(R.id.counter);
        counter.setText("No. of bounces:- " + BeforeBounce.count);
        counter.setRadius(55);
        counter.setTextSize(25);
        fancyButton = findViewById(R.id.fancy);
        fancyButton.setText("Reset");
        fancyButton.setRadius(55);
        fancyButton.setTextSize(30);
        Intent intent = getIntent();
        String force = intent.getStringExtra("force");

        fancyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BeforeBounce.count = 0;
                name = "";
                startActivity(new Intent(AfterBounce.this,BeforeBounce.class));
                finish();
            }
        });

        btnName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etName.getText().toString().equals(null) || etName.getText().toString().equals(""))
                {
                    etName.setError("Empty Field");
                }

                else {
                    counter.setText("No. of bounces by " + etName.getText().toString() + ":- " + BeforeBounce.count);
                    name = etName.getText().toString();
                    counter.setTextSize(25);
                }


            }
        });

        tv.setText("Normal Force:- "+force+"N");
        Log.d("After", "onCreate: " + force);


    }
}
