package com.example.resumebuilderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.os.Bundle;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText Password;
    private Button Login;
    private  TextView Info,forgotpass;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null){
            finish();
            startActivity(new Intent(MainActivity.this,SecondActivity.class));
        }

        username=(EditText)findViewById(R.id.editText);
        Password=(EditText)findViewById(R.id.editText2);
        Login=(Button)findViewById(R.id.button);
        Info=(TextView)findViewById(R.id.tvinfo);
        forgotpass=(TextView)findViewById(R.id.forgotpas) ;
        Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
            }
        });
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              startActivity(new Intent(MainActivity.this,PasswordActivity.class));
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                    progressDialog.setTitle("Authenticating");
                    progressDialog.setMessage("Please Wait...");
                    progressDialog.show();
                    check(username.getText().toString(), Password.getText().toString());

            }
        });
    }

    private  void check(String name,String pass)
    {
        firebaseAuth.signInWithEmailAndPassword(name, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this,"Login Successfull",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));

                }
                else {

                    Toast.makeText(MainActivity.this,"Login Failed",Toast.LENGTH_SHORT).show();

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
