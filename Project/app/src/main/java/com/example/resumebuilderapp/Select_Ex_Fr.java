package com.example.resumebuilderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Select_Ex_Fr extends AppCompatActivity {
    private Button Experirnced,Fresher;
    private TextView TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select__ex__fr);
        Experirnced = (Button)findViewById(R.id.btnExp);
        Fresher = (Button)findViewById(R.id.btnFresher);


        Experirnced.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Select_Ex_Fr.this,Experienceinfo.class);
                startActivity(intent1);
            }
        });

        Fresher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Select_Ex_Fr.this,FresherInfo.class);
            startActivity(intent2);
            }
        });
    }
}
