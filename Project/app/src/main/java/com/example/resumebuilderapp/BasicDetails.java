package com.example.resumebuilderapp;

import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class BasicDetails extends AppCompatActivity {
    private EditText name, add1, add2, add3, email, mob;
    private Button save;
    basic_details bd;
    private DatabaseReference reff;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_details);
        name = (EditText) findViewById(R.id.nameet);
        add1 = (EditText) findViewById(R.id.add1et);
        add2 = (EditText) findViewById(R.id.add2et);
        add3 = (EditText) findViewById(R.id.add3et);
        email = (EditText) findViewById(R.id.emailet);
        mob = (EditText) findViewById(R.id.phoneet);
        save = (Button) findViewById(R.id.save_btn);
        bd=new basic_details();
        firebaseAuth=FirebaseAuth.getInstance();
        reff=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String strname = name.getText().toString();
                boolean val1,val2;
                val1 = strname.matches("^[A-Z][a-z]+\\s[A-Z][a-z]+$");
                //Matcher matcher = Pattern.compile("[A-Z][a-z]*").matcher(strname); above is the same
                if(val1==false){
                    name.setError("Enter valid name");
                }
                String mno=mob.getText().toString();
                val2=mno.matches("^((\+){1}91){1}[1-9]{1}[0-9]{9}$");

                String stremail = email.getText().toString();
                boolean val3 = Patterns.EMAIL_ADDRESS.matcher(stremail).matches();
                if(stremail.isEmpty()){
                    email.setError("Email cannot be empty!");
                }else if(val3 == false){
                    email.setError("Enter valid email address!");
                }
                boolean res=validate(new EditText[]{name,add1,add2,add3,email,mob});
                if((res==false)||(val1==false)||(val3==false)){
                    Toast.makeText(BasicDetails.this,"Please fill all  valid details",Toast.LENGTH_LONG).show();
                }
                else {
                    bd.setName(name.getText().toString().trim());
                    bd.setAdd1(add1.getText().toString().trim());
                    bd.setAdd2(add2.getText().toString().trim());
                    bd.setAdd3(add3.getText().toString().trim());
                    bd.setEmail(email.getText().toString().trim());
                    bd.setMobno(mob.getText().toString().trim());
                    reff.child("basic_details").setValue(bd);
                    Toast.makeText(BasicDetails.this, "Saved Details", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(BasicDetails.this, SecondActivity.class));
                    Toast.makeText(BasicDetails.this, "Enter Personal Details", Toast.LENGTH_LONG).show();
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
