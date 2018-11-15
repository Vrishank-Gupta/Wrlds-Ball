package com.example.vrishankgupta.boilerplate;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
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
    FancyButton fancyButton,counter;
    static public String name = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_bounce);
        tv = findViewById(R.id.forceValue);

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


        if(BeforeBounce.count >=5)
        {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(this);
            }
            builder.setTitle("Login")
                    .setMessage("You Need to login to continue playing! Login Now?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // continue with delete

                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

        tv.setText("Normal Force:- "+force+"N");
        Log.d("After", "onCreate: " + force);


    }
}
