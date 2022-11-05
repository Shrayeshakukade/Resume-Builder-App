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

public class Achievementinfo extends AppCompatActivity {
    private  EditText acheive1,acheive2;
    private Button save;
    private DatabaseReference reff;
    private FirebaseAuth firebaseAuth;
    acheive_info ai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievementinfo);
        acheive1=(EditText)findViewById(R.id.at1et);
        acheive2=(EditText)findViewById(R.id.at1et2);
        save=(Button)findViewById(R.id.save1btn);
        firebaseAuth=FirebaseAuth.getInstance();
        ai=new acheive_info();
        reff= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res = validate(new EditText[]{acheive1,acheive2});
                if (res == false) {
                    Toast.makeText(Achievementinfo.this, "Please fill atleast one skill", Toast.LENGTH_LONG).show();
                } else {
                    ai.setAcheive1(acheive1.getText().toString().trim());
                    ai.setAcheive2(acheive2.getText().toString().trim());
                    reff.child("Achievements").setValue(ai);
                    Toast.makeText(Achievementinfo.this, "Saved Details", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Achievementinfo.this, SecondActivity.class));
                    Toast.makeText(Achievementinfo.this, "You can generate Resume now!!", Toast.LENGTH_LONG).show();
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


