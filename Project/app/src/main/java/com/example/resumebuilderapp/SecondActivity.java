package com.example.resumebuilderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private  FirebaseAuth firebaseAuth;
    private Button basic_details,personal_info,education_d,experience_d,project_d,interest_d,skills_d,achievement_d,resume;
    private String userid;
    private DatabaseReference rootRef=null;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        firebaseAuth=FirebaseAuth.getInstance();
        userid=firebaseAuth.getCurrentUser().getUid();


        basic_details=(Button)findViewById(R.id.basicd);
        personal_info=(Button)findViewById(R.id.personald);
        education_d=(Button)findViewById(R.id.educationd);
        experience_d=(Button)findViewById(R.id.exp_d);
        project_d=(Button)findViewById(R.id.project_d);
        interest_d=(Button)findViewById(R.id.interest_d);
        skills_d=(Button)findViewById(R.id.skills_d);
        achievement_d=(Button)findViewById(R.id.achievements_d);
        resume=(Button)findViewById(R.id.resume_d);

               basic_details.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondActivity.this,BasicDetails.class));
    }
});
personal_info.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondActivity.this,PersonalInfo.class));
    }
});
education_d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondActivity.this,Educationinfo.class));
    }
});
experience_d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondActivity.this,Select_Ex_Fr.class));
    }
});
project_d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondActivity.this,Projectinfo.class));
    }
});
achievement_d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondActivity.this,Achievementinfo.class));
    }
});
interest_d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondActivity.this,Interestinfo.class));
    }
});
skills_d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SecondActivity.this,Skillinfo.class));
    }
});

if(rootRef==null)
{
    rootRef=FirebaseDatabase.getInstance().getReference();
}
rootRef.child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        count=(int)dataSnapshot.getChildrenCount();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});





        resume.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if (count <8) {
            Toast.makeText(SecondActivity.this, "Please fill all details", Toast.LENGTH_LONG).show();
        } else {
            startActivity(new Intent(SecondActivity.this, TemplatePage.class));
        }
    }
});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logoutMenu: {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(SecondActivity.this,MainActivity.class));

            }
        }
        return super.onOptionsItemSelected(item);
    }
}






