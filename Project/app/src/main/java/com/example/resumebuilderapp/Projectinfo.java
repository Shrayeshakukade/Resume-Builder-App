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

public class Projectinfo extends AppCompatActivity {
    private EditText title1,title2,description1,description2,duration1,duration2,title3;
     private Button save;
     private FirebaseAuth firebaseAuth;
     private DatabaseReference reff;
     project_info pri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projectinfo);
        title1=(EditText)findViewById(R.id.titleet1);
        description1=(EditText)findViewById(R.id.descriptionet1);
        duration1=(EditText)findViewById(R.id.durationet1);
        title2=(EditText)findViewById(R.id.titleet2);
        description2=(EditText)findViewById(R.id.description2);
        duration2=(EditText)findViewById(R.id.duration2);

        save=(Button)findViewById(R.id.Save_btn);
        pri=new project_info();
        firebaseAuth=FirebaseAuth.getInstance();
        reff= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res=validate(new EditText[]{title1,description1,duration1});
                if(res==false){
                    Toast.makeText(Projectinfo.this,"Please fill all details",Toast.LENGTH_LONG).show();
                }
                else {
                    pri.setTitle1(title1.getText().toString().trim());
                    pri.setDescription1(description1.getText().toString().trim());
                    pri.setDuration1(duration1.getText().toString().trim());
                    pri.setTitle2(title2.getText().toString().trim());
                    pri.setDescription2(description2.getText().toString().trim());
                    pri.setDuration2(duration2.getText().toString().trim());

                    reff.child("projectinfo").setValue(pri);
                    Toast.makeText(Projectinfo.this, "Saved Details", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Projectinfo.this, SecondActivity.class));
                    Toast.makeText(Projectinfo.this, "Enter Skills Details", Toast.LENGTH_LONG).show();
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