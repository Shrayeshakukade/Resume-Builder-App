package com.example.resumebuilderapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Template1 extends AppCompatActivity {

    private DatabaseReference reff,reff1,reff2,reff3,reff4,reff5,reff6,reff7;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private WebView webView;
    PrintDocumentAdapter adapter;
    private String nme,add1,add2,add3,eml,phno,skil1,skil2,skil3,com,from,role,to,int1,int2,int3;
    private String cg,course,insti,yearop,t1,t2,des1,des2,du1,du2,dob,lang,nation,a1,a2,sname,hname,smks,hmks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template1);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        webView=(WebView)findViewById(R.id.webview);
        reff=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("basic_details");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nme=dataSnapshot.child("name").getValue().toString();
                add1=dataSnapshot.child("add1").getValue().toString();
                add2=dataSnapshot.child("add2").getValue().toString();
                add3=dataSnapshot.child("add3").getValue().toString();
                eml=dataSnapshot.child("email").getValue().toString();
                phno=dataSnapshot.child("mobno").getValue().toString();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        reff1=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("Skill_info");
        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               skil1=dataSnapshot.child("skill1").getValue().toString();
                skil2=dataSnapshot.child("skill2").getValue().toString();
                skil3=dataSnapshot.child("skill3").getValue().toString();
           }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        reff2=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("experienceinfo");
        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                com=dataSnapshot.child("company").getValue().toString();
                from=dataSnapshot.child("from").getValue().toString();
                role=dataSnapshot.child("role").getValue().toString();
                to=dataSnapshot.child("to").getValue().toString();
           }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        reff7=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("interestinfo");
        reff7.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int1=dataSnapshot.child("interest1").getValue().toString();
                int2=dataSnapshot.child("interest2").getValue().toString();
                int3=dataSnapshot.child("interest3").getValue().toString();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        reff6=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("Achievements");
        reff6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                a1=dataSnapshot.child("acheive1").getValue().toString();
                a2=dataSnapshot.child("acheive2").getValue().toString();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
        reff4=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("projectinfo");
        reff4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                t1=dataSnapshot.child("title1").getValue().toString();
                t2 =dataSnapshot.child("title2").getValue().toString();
                des1=dataSnapshot.child("description1").getValue().toString();
                des2=dataSnapshot.child("description2").getValue().toString();
                du1=dataSnapshot.child("duration1").getValue().toString();
                du2=dataSnapshot.child("duration2").getValue().toString();
                code();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reff3=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("educationinfo");
        reff3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                sname=dataSnapshot.child("scname").getValue().toString();
                hname=dataSnapshot.child("hscname").getValue().toString();
                smks=dataSnapshot.child("scmks").getValue().toString();
                hmks=dataSnapshot.child("hscmks").getValue().toString();
                cg=dataSnapshot.child("cgpa").getValue().toString();
                course =dataSnapshot.child("course").getValue().toString();
                insti=dataSnapshot.child("institute").getValue().toString();
                yearop=dataSnapshot.child("yop").getValue().toString();
                code();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        reff5=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("personalinfo");
        reff5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dob=dataSnapshot.child("dob").getValue().toString();
                lang =dataSnapshot.child("lang").getValue().toString();
                nation=dataSnapshot.child("nation").getValue().toString();
                code();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void createpdf(View view){

        Context context=Template1.this;
        PrintManager printManager=(PrintManager)Template1.this.getSystemService(context.PRINT_SERVICE);
        PrintDocumentAdapter printDocumentAdapter=null;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            adapter=webView.createPrintDocumentAdapter();
        }
        String Jobname=getString(R.string.app_name)+"Document";
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){
            PrintJob printJob=printManager.print(Jobname,adapter,new PrintAttributes.Builder().build());
        }
    }
    public void code()
    {
        String html="<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>resume2</title>\n" +
                "  <link rel=\"stylesheet\" type=\"text/css\" href=\"file:android_asset/resume2.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<div id=\"sideright\">\n" +
                "  <h2  id=\"name\"align=\"center\">"+nme+"</h2>\n" +
                "  <br>\n" +
                "  <br>\n" +
                "  <h3>BASIC DETAILS</h3>\n" +
                "  <h4 id=\"add1\" id=\"add2\" id=\"add3\"><img src=\"loc.png\">"+add1+","+add2+","+add3+"</h4>\n" +
                "  <h4 id=\"email\"><img src=\"file:android_asset/mail.png\">"+eml+"</h4>\n" +
                "  <h4 id=\"phno\"><img src=\"file:android_asset/phonecall.png\">  phn no:"+phno+"</h4>\n" +
                "  <h3><img src=\"file:android_asset/user.png\">  PERSONAL PROFILE</h3>\n" +
                "  <!--personal details here -->\n" +
                "  <h4 id=\"dob\">Date of birth:"+dob+"</h4>\n" +
                "  <h4 id=\"lang\">Known languages:"+lang+"</h4></h4>\n" +
                "  <h4 id=\"nation\">Nationality:"+nation+"</h4>\n" +
                "  <h3><img src=\"file:android_asset/tools.png\">  TECHNICAL SKILLS</h3>\n" +
                "  <h4 id=\"skil1\">"+skil1+"</h4>\n" +
                "  <h4 id=\"skil1\">"+skil2+"</h4>\n" +
                "  <h4 id=\"skil1\">"+skil3+"</h4>\n" +
                "\n" +
                "  <h3><img src=\"file:android_asset/thumbsup1.png\">  INTERESTS</h3>\n" +
                "  <h4 id=\"inte1\">"+int1+"</h4>\n" +
                "  <h4  id=\"inte1\">"+int2+"</h4>\n" +
                "  <h4  id=\"inte1\">"+int3+"</h4>\n" +
                "  </h4>\n" +
                "</div>\n" +
                "<div id=\"header\">\n" +
                "  <h3><img src=\"file:android_asset/education.png\">  EDUCATION</h3>\n" +
                "  <!--education details here -->\n" +
                "  <h4><u>Graduation Details</u></h4>\n" +
                "  <h4 id=\"course\">Course:"+course+"</h4>\n" +
                "  <h4 id=\"insti\">Institute Name:"+insti+"</h4>\n" +
                "  <h4 id=\"cgp\">Cgpa:"+cg+"</h4>\n" +
                "  <h4 id=\"yop\">Year of Passing:"+yearop+"</h4>\n" +
                "\n" +
                "  <h4><u>HSC details</u></h4>\n" +
                "  <h4 id=\"hscname\">College Name:"+hname+"</h4>\n" +
                "  <h4 id=\"hscmks\">Percentage:"+hmks+"%"+"</h4>\n" +
                "\n" +
                "  <h4><u>SSC Details</u></h4>\n" +
                "  <h4 id=\"sscname\">School Name:"+sname+"</h4>\n" +
                "  <h4 id=\"sscmks\">Percentage:"+smks+"%"+"</h4>\n" +
                "\n" +
                "  <h3><img src=\"file:android_asset/experience.png\">  EXPERIENCE</h3>\n" +
                "  <h4 id=\"role\">Role:"+role+"</h4>\n" +
                "  <h4 id=\"company\">Company Name:"+com+"</h4>\n" +
                "  <h4 id=\"duration\">Duration:from "+from+" to "+to+"</h4>\n" +
                "\n" +
                "  <h3><img src=\"file:android_asset/trophy.png\">  AWARDS AND ACHIEVEMENTS</h3>\n" +
                "  <h4 id=\"ach1\">"+a1+"</h4>\n" +
                "  <h4 id=\"ach2\">"+a2+"</h4>\n" +
                "  <h3><img src=\"file:android_asset/projects.png\">  PROJECTS</h3>\n" +
                "  <!--projects details here -->\n" +
                "  <h4 id=\"t1\">Project Title:"+t1+"</h4>\n" +
                "  <h4 id=\"des1\">Title Description:"+des1+"</h4></h4>\n" +
                "  <h4 id=\"du1\">Duration:"+du1+"</h4>\n" +
                "\n" +
                "  <h4 id=\"t2\">Project Title:"+t2+"</h4>\n" +
                "  <h4 id=\"des2\">Title Description:"+des2+"</h4></h4>\n" +
                "  <h4 id=\"du2\">Duration:"+du2+"</h4>\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        webView.loadDataWithBaseURL(null,html,"text/html","utf-8",null);



    }



}
