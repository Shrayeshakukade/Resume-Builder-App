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

public class Skillinfo extends AppCompatActivity {
    private EditText skill1,skill2,skill3;
    private Button save;
    skill_info si;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skillinfo);
        skill1=(EditText)findViewById(R.id.skill1et);
        skill2=(EditText)findViewById(R.id.skill2et);
        skill3=(EditText)findViewById(R.id.skill3et);
        save=(Button)findViewById(R.id.save1btn);
        si=new skill_info();
        firebaseAuth=FirebaseAuth.getInstance();
        reff= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res=validate(new EditText[]{skill1});
                if(res==false){
                    Toast.makeText(Skillinfo.this,"Please fill atleast one skill",Toast.LENGTH_LONG).show();
                }
                else {
                    si.setSkill1(skill1.getText().toString().trim());
                    si.setSkill2(skill2.getText().toString().trim());
                    si.setSkill3(skill3.getText().toString().trim());
                    reff.child("Skill_info").setValue(si);
                    Toast.makeText(Skillinfo.this, "Saved Details", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Skillinfo.this, SecondActivity.class));
                    Toast.makeText(Skillinfo.this, "Enter Interests Details", Toast.LENGTH_LONG).show();
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
