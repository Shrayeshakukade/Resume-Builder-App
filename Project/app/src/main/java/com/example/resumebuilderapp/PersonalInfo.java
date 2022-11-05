package com.example.resumebuilderapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PersonalInfo extends AppCompatActivity {


   private EditText status,lang,nation;
   private EditText dob;
   private Button save;
    private DatabaseReference reff;
    private FirebaseAuth firebaseAuth;
    personal_info pi;
    private Calendar myCalendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        dob=(EditText)findViewById(R.id.dobet);
        lang=(EditText)findViewById(R.id.languageet);
        nation=(EditText)findViewById(R.id.nationalityet);
        save=(Button)findViewById(R.id.btn_save);
        pi=new personal_info();
        firebaseAuth=FirebaseAuth.getInstance();
        reff= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());

        final DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                String myFormat = "dd/MM/yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                dob.setText(sdf.format(myCalendar.getTime()));
            }
        };



        dob.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               new DatePickerDialog(PersonalInfo.this, datePickerListener, myCalendar
                       .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                       myCalendar.get(Calendar.DAY_OF_MONTH)).show();


           }
       });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res=validate(new EditText[]{lang,nation});
                if(res==false){
                    Toast.makeText(PersonalInfo.this,"Please fill all details",Toast.LENGTH_LONG).show();
                }
                else {
                    pi.setDob(dob.getText().toString().trim());
                    pi.setLang(lang.getText().toString().trim());
                    pi.setNation(nation.getText().toString().trim());
                    reff.child("personalinfo").setValue(pi);
                    Toast.makeText(PersonalInfo.this, "Saved Details", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(PersonalInfo.this, SecondActivity.class));
                    Toast.makeText(PersonalInfo.this, "Enter Education Details", Toast.LENGTH_LONG).show();
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
