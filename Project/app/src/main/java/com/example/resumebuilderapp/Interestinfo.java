package com.example.resumebuilderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Interestinfo extends AppCompatActivity {
    private EditText interest1,interest2,interest3;
    private Button save;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reff;

    interest_info intfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interestinfo);
        interest1=(EditText)findViewById(R.id.Interest1et);
        interest2=(EditText)findViewById(R.id.interest2et);
        interest3=(EditText)findViewById(R.id.interest3et);
        save=(Button)findViewById(R.id.save1btn);
        intfo=new interest_info();
        firebaseAuth=FirebaseAuth.getInstance();
        reff= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res=validate(new EditText[]{interest1,interest2,interest3});
                if(res==false){
                    Toast.makeText(Interestinfo.this,"Please fill all details",Toast.LENGTH_LONG).show();
                }
                else {
                    intfo.setInterest1(interest1.getText().toString().trim());
                    intfo.setInterest2(interest2.getText().toString().trim());
                    intfo.setInterest3(interest3.getText().toString().trim());

                    reff.child("interestinfo").setValue(intfo);
                    Toast.makeText(Interestinfo.this, "Saved Details", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Interestinfo.this, SecondActivity.class));
                    Toast.makeText(Interestinfo.this, "Enter Achievements Details", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
    private boolean validate(EditText[] fields){
        for(int i = 0; i < fields.length; i++){
            EditText currentField = fields[i];
            if(currentField.getText().toString().length() <= 0){
                return false;
            }
        }
        return true;
    }

}
