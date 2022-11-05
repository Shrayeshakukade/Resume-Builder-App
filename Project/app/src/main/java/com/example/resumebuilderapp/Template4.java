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

public class Template4 extends AppCompatActivity {

    private DatabaseReference reff,reff1,reff2,reff7,reff3,reff4,reff5,reff6;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private WebView webView;
    PrintDocumentAdapter adapter;
    private String nme,add1,add2,add3,eml,phno,skil1,skil2,skil3,com,from,role,to,sname,hname,smks,hmks;;
    private String cg,course,insti,yearop,t1,t2,des1,des2,du1,du2,dob,lang,nation,a1,a2,int1,int2,int3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template4);

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
        reff7=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("Achievements");
        reff7.addValueEventListener(new ValueEventListener() {
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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        reff6=FirebaseDatabase.getInstance().getReference(firebaseAuth.getUid()).child("interestinfo");
        reff6.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                int1=dataSnapshot.child("interest1").getValue().toString();
                int2=dataSnapshot.child("interest2").getValue().toString();
                int3=dataSnapshot.child("interest3").getValue().toString();
                code();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });



    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void createpdf(View view){
        Context context=Template4.this;
        PrintManager printManager=(PrintManager)Template4.this.getSystemService(context.PRINT_SERVICE);
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
                "\t<title></title>\n" +
                "\t<link rel=\"stylesheet\" type=\"text/css\" href=\"file:android_asset/Layout2.css\"\n" +
                "</head>\n" +
                "\n" +
                "  <div class=\"container\">\n" +
                "    <div class=\"row\">\n" +
                "      <div class=\"col-md-10 col-md-offset-1\">\n" +
                "        <div class=\"title text-center\">\n" +
                "          <h1 id=\"name\">"+nme+"</h1>\n" +
                "          <h3 id=\"phone\">"+phno+"</h3>\n" +
                "          <h4 id=\"email\"><a href=\"email\">"+eml+"</a></h4>\n" +
                "          <hr />\n" +
                "          <ul class=\"list-inline\">\n" +
                "             </ul>\n" +
                "        </div>\n" +
                "        \n" +
                "\t\t\n" +
                "        <!-- Education section-->\n" +
                "        <div class=\"work-experience\">\n" +
                "          <h2 class=\"text-center\">Education</h2>\n" +
                "          <p id=\"course\" id=\"year\" id=\"inst\">I completed my "+course+" in the year "+yearop+" at institute  "+insti+" with cgpa  "+cg+"</p>\n" +
                "          <p id=\"hscmks\" id=\"hscn\">I secured  "+hmks+"% in 12th and was the part of  "+hname+" </p>\n" +
                "          <p id=\"schooln\" id=\"sscmks\">I was in  "+sname+" and scored  "+smks+"% in 10th.   \n" +
                "              </div>\n" +
                "                    \n" +
                "        <!-- summary section -->\n" +
                "        <div class=\"work-experience\">\n" +
                "          <h2 class=\"text-center\">Skills</h2>\n" +
                "\t\t  <div class=\"row experience-title\">\n" +
                "            <div class=\"col-md-9\">\n" +
                "        <p id=\"s1\">"+skil1+"</p>\n" +
                "          <p id=\"s2\">"+skil2+"</p>\n" +
                "\t\t  <p id=\"s3\">"+skil3+"</p>\n" +
                "            </div>\n" +
                "            </div>\n" +
                "\t\t\t</div>\t\t\t\n" +
                "\t\t\t</div>\n" +
                "        \n" +
                "        \n" +
                "        <!-- work experience section -->\n" +
                "        <div class=\"work-experience\">\n" +
                "          <h2 class=\"text-center\">Work Experience</h2>\n" +
                "          <div class=\"row experience-title\">\n" +
                "            <div class=\"col-md-9\">\n" +
                "           <p>   <font size=\"3\" id=\"role\">Role:"+role+"</font></p> \n" +
                "\t\t\t <p> <font size=\"3\" id=\"comn\">Company name:"+com+"</font></p>\n" +
                "                         <p> <font size=\"3\"id=\"dura\">Duration:from "+from+" to "+to+"</font></p>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "           </div>\n" +
                "          </div>\n" +
                "          </div>\n" +
                "      </div>\n" +
                "\n" +
                "\t<div class=\"work-experience\">\n" +
                "          <h2 class=\"text-center\">Projects</h2>\n" +
                "          <div class=\"row experience-title\">\n" +
                "            <div class=\"col-md-9\">\n" +
                "                 \n" +
                "              \t\t <p>  <font size=\"3\" id=\"pt1\">Project Title:"+t1+"</font> </p>\n" +
                "\t\t\t <p> <font size=\"3\" id=\"pdes1\">description:"+des1+"</font> </p>\n" +
                "\t\t\t  <p><font size=\"3\" id=\"pdur1\">duration:"+du1+"</font> </p>\n" +
                "      <br>        \n" +
                " \t\t\t <p><font size=\"3\"id=\"pt2\">Project Title:"+t2+"</font> </p>\n" +
                "\t\t\t  <p><font size=\"3\" id=\"pdes2\">description:"+des2+"</font></p>\n" +
                "\t\t\t <p><font size=\"3\" id=\"pdur2\">duration:"+du2+"</font> </p>\n" +
                "               \n" +
                "              </div>\n" +
                "            </div>\n" +
                "           </div>\n" +
                "        \n" +
                "\t  <!-- Interest section-->\n" +
                "        <div class=\"work-experience\">\n" +
                "          <h2 class=\"text-center\">Interest</h2>\n" +
                "          <p id=\"inte1\">"+int1+"</p>\n" +
                "          <p id=\"inte2\">"+int2+"</p>\n" +
                "\t\t  <p  id=\"inte3\">"+int3+"</p>\n" +
                "            </div>\n" +
                "\n" +
                "    </div>\n" +
                "\t <!-- Achievement section -->\n" +
                "        <div class=\"work-experience\">\n" +
                "          <h2 class=\"text-center\">Achievements</h2>\n" +
                "          <div class=\"row experience-title\">\n" +
                "            <div class=\"col-md-9\">\n" +
                "             <p> <font size=\"3\" id=\"ach1\">"+a1+"</font></p> \n" +
                "             <p> <font size=\"3\" id=\"ach2\">"+a2+"</font></p>\n" +
                "              </div>\n" +
                "            </div>\n" +
                "           </div>\n" +
                "          </div>\n" +
                "          </div>\n" +
                "      </div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n ";
        webView.loadDataWithBaseURL(null,html,"text/html","utf-8",null);



    }



}
