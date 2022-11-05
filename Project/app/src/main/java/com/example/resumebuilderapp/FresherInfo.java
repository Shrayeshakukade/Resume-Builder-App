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

public class FresherInfo extends AppCompatActivity {
    private EditText company,from,to,role;
    private Button save;
    private DatabaseReference reff;
    private FirebaseAuth firebaseAuth;
    experience_info exi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresher_info);
        company=(EditText)findViewById(R.id.workplace1et);
        from=(EditText)findViewById(R.id.doj1et);
        to=(EditText)findViewById(R.id.to1et);
        role=(EditText)findViewById(R.id.role1et);
        save=(Button)findViewById(R.id.save1btn);
        exi=new experience_info();
        firebaseAuth=FirebaseAuth.getInstance();
        reff= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res=validate(new EditText[]{company,from,to,role});
                if(res==false){
                    Toast.makeText(FresherInfo.this,"Please fill all details",Toast.LENGTH_LONG).show();
                }
                else {
                    exi.setCompany(company.getText().toString().trim());
                    exi.setFrom(from.getText().toString().trim());
                    exi.setTo(to.getText().toString().trim());
                    exi.setRole(role.getText().toString().trim());

                    reff.child("fresherinfo").setValue(exi);
                    Toast.makeText(FresherInfo.this, "Saved Details", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(FresherInfo.this, SecondActivity.class));
                    Toast.makeText(FresherInfo.this, "Enter Project Details", Toast.LENGTH_LONG).show();
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
