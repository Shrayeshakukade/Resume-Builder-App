package com.example.resumebuilderapp;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TemplatePage extends AppCompatActivity implements View.OnClickListener{

    private Button Temp1,Temp2,Temp3,Temp4,Temp5,Temp6,Temp7,Temp8;
    private TextView Choose;
    private DatabaseReference rootRef,r1;
    private  FirebaseDatabase firebaseDatabase;
    private  FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_page);
        firebaseAuth= FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();

        Temp1 = (Button)findViewById(R.id.btn1);
        Temp2 = (Button)findViewById(R.id.btn2);
        Temp3 = (Button)findViewById(R.id.btn3);
        Temp4 = (Button)findViewById(R.id.btn4);
        Temp5 = (Button)findViewById(R.id.btn5);
        Temp6 = (Button)findViewById(R.id.btn6);
        Temp7 = (Button)findViewById(R.id.btn7);
        Temp8 = (Button)findViewById(R.id.btn8);

        Temp1.setOnClickListener(this);
        Temp2.setOnClickListener(this);
        Temp3.setOnClickListener(this);
        Temp4.setOnClickListener(this);
        Temp5.setOnClickListener(this);
        Temp6.setOnClickListener(this);
        Temp7.setOnClickListener(this);
        Temp8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn1:
              rootRef= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
                rootRef.child("experienceinfo");
                rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue() == null) {
                            Toast.makeText(TemplatePage.this,"This template is only for exprienced one",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent2 = new Intent(TemplatePage.this, Template1.class);
                            startActivity(intent2);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


                break;
           case R.id.btn2:
               rootRef= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
               rootRef.child("experienceinfo");
               rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                   @Override
                   public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                       if (dataSnapshot.getValue() == null) {
                           Toast.makeText(TemplatePage.this,"This template is only for exprienced one",Toast.LENGTH_SHORT).show();
                       }
                       else {
                           Intent intent2 = new Intent(TemplatePage.this, Template2.class);
                           startActivity(intent2);
                       }
                   }
                   @Override
                   public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
               break;
            case R.id.btn3:
                rootRef= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
                rootRef.child("experienceinfo");
                rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue() == null) {
                            Toast.makeText(TemplatePage.this,"This template is only for exprienced one",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent3 = new Intent(TemplatePage.this, Template3.class);
                            startActivity(intent3);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;
            case R.id.btn4:
                rootRef= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
                rootRef.child("experienceinfo");
                rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue() == null) {
                            Toast.makeText(TemplatePage.this,"This template is only for exprienced one",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent4 = new Intent(TemplatePage.this, Template4.class);
                            startActivity(intent4);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case R.id.btn5:
                rootRef= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
                rootRef.child("experienceinfo");
                rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue() == null) {
                            Toast.makeText(TemplatePage.this,"This template is only for exprienced one",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent5 = new Intent(TemplatePage.this, Template5.class);
                            startActivity(intent5);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
            case R.id.btn6:
                rootRef= FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
                rootRef.child("experienceinfo");
                rootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if (dataSnapshot.getValue() == null) {
                            Toast.makeText(TemplatePage.this,"This template is only for exprienced one",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Intent intent6 = new Intent(TemplatePage.this, Template6.class);
                            startActivity(intent6);
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                break;
            case R.id.btn7:
                r1 = FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
                r1.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        if (snapshot.hasChild("fresherinfo")) {
                            Intent intent7 = new Intent(TemplatePage.this, Template7.class);
                            startActivity(intent7);

                        }else{
                            Toast.makeText(TemplatePage.this,"This template is only for fresher ",Toast.LENGTH_SHORT).show();

                            // does not exist
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                break;
          case R.id.btn8:
              r1 = FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid());
             r1.addListenerForSingleValueEvent(new ValueEventListener() {
                  @Override
                  public void onDataChange(DataSnapshot snapshot) {
                      if (snapshot.hasChild("fresherinfo")) {
                          Intent intent8 = new Intent(TemplatePage.this, Template8.class);
                          startActivity(intent8);
                          // it exists!
                      }else{
                          Toast.makeText(TemplatePage.this,"This template is only for fresher ",Toast.LENGTH_SHORT).show();

                          // does not exist
                      }
                  }

                  @Override
                  public void onCancelled(@NonNull DatabaseError databaseError) {

                  }
              });

              break;
            default:
                Toast.makeText(this, "Not going anywhere !!!", Toast.LENGTH_LONG).show();
                break;
        }
    }

}
