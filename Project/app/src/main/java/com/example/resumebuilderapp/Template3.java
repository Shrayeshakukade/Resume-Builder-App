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

public class Template3 extends AppCompatActivity {

    private DatabaseReference reff,reff1,reff2,reff3,reff4,reff7,reff6;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private WebView webView;
    PrintDocumentAdapter adapter;
    private String nme,add1,add2,add3,eml,phno,skil1,skil2,skil3,com,from,role,to,sname,smks,hname,hmks;
    private String cg,course,yearop,insti,t1,t2,des1,des2,du1,du2,int1,int2,int3,a1,a2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template3);

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
                code();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void createpdf(View view){
        Context context=Template3.this;
        PrintManager printManager=(PrintManager)Template3.this.getSystemService(context.PRINT_SERVICE);
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
                "    <title></title>\n" +
                "\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"file:android_asset/Layout3.css\">\n" +
                "</head>\n" +
                "\n" +
                "<div class=\"wrapper clearfix\">\n" +
                "    <div class=\"left\">\n" +
                "\n" +
                "        <div class=\"name-hero\">\n" +
                "\n" +
                "            <div class=\"me-img\"></div>\n" +
                "\n" +
                "            <div class=\"name-text\">\n" +
                "\n" +
                "                <h1 id = \"name\">"+nme+"</h1>\n" +
                "                <p id = \"Add1\"\"add2\"\"add3\"><em> "+add1+","+"</em>"+add2+","+"<em>"+add3+"</em></p>\n" +
                "                <p id = \"email\">"+eml+"</p>\n" +
                "                <p id= \"phno\">"+phno+"</p>\n" +
                "\n" +
                "            </div>\n" +
                "\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "    <div class=\"right\">\n" +
                "\n" +
                "\n" +
                "        <div class=\"inner\">\n" +
                "            <section>\n" +
                "                <h1>Education</h1>\n" +
                "                <ul class=\"skill-set\">\n" +
                "                    <font size=\"4\">Graduation Details</font><br>\n" +
                "                    <font size=\"3\" id=\"course\" >Course:"+course+"</font><br>\n" +
                "                    <font size=\"3\"  id=\"insti\">Institute Name:"+insti+"</font><br>\n" +
                "                    <font size=\"3\" id=\"cgp\">Cgpa:"+cg+"</font><br>\n" +
                "                    <font size=\"3\" id=\"yop\">Year of Passing:"+yearop+"</font><br>\n" +
                "                    <br>\n" +
                "                    <font size=\"4\">HSC Details</font><br>\n" +
                "                    <font size=\"3\" id=\"hscname\">College Name:"+hname+"</font><br>\n" +
                "                    <font size=\"3\" id=\"hscmks\">Percentage:"+hmks+"%"+"</font><br>\n" +
                "                    <br>\n" +
                "                    <font size=\"4\">SSC Details</font><br>\n" +
                "                    <font size=\"3\" id=\"sscname\">School Name:"+sname+"</font><br>\n" +
                "                    <font size=\"3\" id=\"sscmks\">Percentage:"+smks+"%"+"</font>\n" +
                "\n" +
                "                </ul>\n" +
                "            </section>\n" +
                "\n" +
                "            <section>\n" +
                "                <h1>Experience</h1>\n" +
                "                <font size=\"3\" id=\"role\">Role:"+role+"</font><br>\n" +
                "                <font size=\"3\" id=\"company\">Company Name:"+com+"</font><br>\n" +
                "                <font size=\"3\" id=\"duration\">Duration:from "+from+" to "+to+"</font>\n" +
                "\n" +
                "            </section>\n" +
                "\n" +
                "            <section>\n" +
                "                <h1>Project</h1>\n" +
                "                <font size=\"3\" id=\"pt1\">Project Title:"+t1+"</font><br>\n" +
                "                <font size=\"3\" id=\"pd1\">Project Description:"+des1+"</font><br>\n" +
                "                <font size=\"3\" id=\"pdu1\">Duration:"+du1+"t</font><br>\n" +
                "                <br>\n" +
                "                <font size=\"3\" id=\"pt2\">Project Title:"+t2+"</font><br>\n" +
                "                <font size=\"3\" id=\"pd2\">Project Description:"+des2+"</font><br>\n" +
                "                <font size=\"3\" id=\"pdu2\">Duration:"+du2+"t</font>\n" +
                "\n" +
                "            </section>\n" +
                "\n" +
                "            <section>\n" +
                "                <h1>Technical Skills</h1>\n" +
                "                <ul class=\"skill-set\">\n" +
                "                    <li id=\"skill1\">"+skil1+"</li>\n" +
                "                    <li id=\"skill2\">"+skil2+"</li>\n" +
                "                    <li id=\"skill3\">"+skil3+"</li>\n" +
                "\n" +
                "                </ul>\n" +
                "            </section>\n" +
                "            <section>\n" +
                "                <h1>Personal Interests</h1>\n" +
                "                <ul class=\"skill-set\">\n" +
                "                    <li id=\"int1\">"+int1+"</li>\n" +
                "                    <li id=\"int2\">"+int2+"</li>\n" +
                "                    <li id=\"int3\">"+int3+"</li>\n" +
                "                </ul>\n" +
                "            </section>\n" +
                "            <section>\n" +
                "                <h1>Achievements</h1>\n" +
                "                <ul class=\"skill-set\">\n" +
                "                    <li id=\"Ach1\">"+a1+"</li>\n" +
                "                    <li id=\"Ach2\">"+a2+"</li>\n" +
                "\n" +
                "                </ul>\n" +
                "            </section>\n" +
                "            <section>\n" +
                "                <div class=\"handmade\">\n" +
                "\n" +
                "                    <p id=\"nam\">handmade by <em>"+nme+"</em></p>\n" +
                "                </div>\n" +
                "            </section>\n" +
                "\n" +
                "        </div>\n" +
                "\n" +
                "    </div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>\n";
        webView.loadDataWithBaseURL(null,html,"text/html","utf-8",null);



    }



}
