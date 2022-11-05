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

public class Educationinfo extends AppCompatActivity {
    private EditText course,cgpa,year,institute;
    private EditText scname,hscname,scmks,hscmks;
    private Button save;
    private DatabaseReference reff;
    private FirebaseAuth firebaseAuth;
    education_info ei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educationinfo);
        course=(EditText)findViewById(R.id.courseet);
        cgpa=(EditText)findViewById(R.id.cgpaet);
        year=(EditText)findViewById(R.id.Yopet);
        institute=(EditText)findViewById(R.id.instituteet);
        scname=(EditText)findViewById(R.id.schoolet);
       hscname=(EditText)findViewById(R.id.hscnme);
        hscmks=(EditText)findViewById(R.id.hscmks);
        scmks=(EditText)findViewById(R.id.mkset);
        save=(Button)findViewById(R.id.save_button);
        ei=new education_info();
        firebaseAuth=FirebaseAuth.getInstance();
        reff= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean res=validate(new EditText[]{course,cgpa,year,institute,scname,hscname,scmks,scmks});
                if(res==false){

                    Toast.makeText(Educationinfo.this,"Please fill all details",Toast.LENGTH_LONG).show();
                }
                else {
                    ei.setScname(scname.getText().toString().trim());
                    ei.setScmks(scmks.getText().toString().trim());
                    ei.setHscname(hscname.getText().toString().trim());
                    ei.setHscmks(hscmks.getText().toString().trim());
                    ei.setCourse(course.getText().toString().trim());
                    ei.setCgpa(cgpa.getText().toString().trim());
                    ei.setYop(year.getText().toString().trim());
                    ei.setInstitute(institute.getText().toString().trim());

                    reff.child("educationinfo").setValue(ei);
                    Toast.makeText(Educationinfo.this, "Saved Details", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Educationinfo.this, SecondActivity.class));
                    Toast.makeText(Educationinfo.this, "Enter Experience Details", Toast.LENGTH_LONG).show();
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

