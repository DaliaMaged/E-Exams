package com.example.e_exams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.e_exams.student.homeActivityStudent;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class signStudent extends AppCompatActivity {

    EditText StudentID;
    LinearLayout fristLevelLayout,secondLevelLayout,thirdLevelLayout,fourthLevelLayout;
    RadioButton levelOne,leveltwo,levelthree,levelfour;
    RadioGroup selectLevel;
    Button NextButton;
    String type,uid,age,subject1,subject2,subject3,subject4
            ,subject5,subject6,subject7,subject8,subject9,subject10,
            subject11,subject12,subject13,subject14,subject15,subject16,subject17, year1, year2, year3, year4,subjectList;
    EditText email;
    EditText pass;
    EditText name;
    CheckBox checkAL,checkDS,checkDB,checkIS,checkCN,checkDSc,checkSE,checkDA,checkFS,checkIP,checkNS,checkHC,checkCL,checkDC,checkCS,checkOR,checkOS;
    private DatabaseReference  mDatabase;
    FirebaseAuth mAuth;
    int i;
    private String Name , Email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_student);
        StudentID = findViewById(R.id.studenId);
        fristLevelLayout = findViewById(R.id.fristLevelLayout);
        secondLevelLayout = findViewById(R.id.secondLevelLayout);
        thirdLevelLayout = findViewById(R.id.thirdLevelLayout);
        fourthLevelLayout = findViewById(R.id.fourthLevelLayout);
        levelOne = findViewById(R.id.levelOne);
        leveltwo = findViewById(R.id.leveltwo);
        levelthree = findViewById(R.id.levelthree);
        levelfour = findViewById(R.id.levelfour);
        selectLevel = findViewById(R.id.selectLevel);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        name=findViewById(R.id.name);
        //checkBoxsID
        checkAL=findViewById(R.id.checkAL);checkDC=findViewById(R.id.checkDC);
        checkDS=findViewById(R.id.checkDS);checkCS=findViewById(R.id.checkCS);
        checkDB=findViewById(R.id.checkDB);checkOR=findViewById(R.id.checkOR);
        checkIS=findViewById(R.id.checkIS);checkOS=findViewById(R.id.checkOS);
        checkCN=findViewById(R.id.checkCN);checkDSc=findViewById(R.id.checkDSc);
        checkSE=findViewById(R.id.checkSE);checkDA=findViewById(R.id.checkDA);
        checkFS=findViewById(R.id.checkFS);checkIP=findViewById(R.id.checkIP);
        checkNS=findViewById(R.id.checkNS);checkHC=findViewById(R.id.checkHC);
        checkCL=findViewById(R.id.checkCL);


        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("USERS").push();
        User user=new User(Name,Email,password,type,uid,age,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10,
                subject11,subject12,subject13,subject14,subject15,subject16,subject17,year1,year2,year3,year4,subjectList);


        //checkbox for subject
        String Algorithms="Algorithms";
         String DataStructuree="Data Structure";String  DataBase="Data Base";
        String  informationsystem="Information system"; String datascience="Data Science";
        String ComputerNetwork ="Computer Network"; String softwareengineering="Software Engineering";
        String ImageProcessing="Image Processing";String datasanalysis="Data Analysis";
        String fundamentalsoftware="Fundamental Software";String networksecurity="Network Security";
        String DigitalCircuits="Digital Circuits";String historyofcomputer="History Of Computer";
        String computerlow="Computer Low";
        String cyberSecurity="cyber Security";String operatingResearch="operating Research";
        String operatingSystem="operating System";
        // radiobutton for year
        String firstyear="First year";
        String secondyear="second year";
        String thirdyear="third year";
        String forthyear="forth year";

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                  //  i=(int)snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        levelOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                    fristLevelLayout.setVisibility(View.VISIBLE);
                    secondLevelLayout.setVisibility(View.GONE);
                    thirdLevelLayout.setVisibility(View.GONE);
                    fourthLevelLayout.setVisibility(View.GONE);

                    user.setYear1(firstyear);
                }
            }
        });
        leveltwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
            fristLevelLayout.setVisibility(View.GONE);
            secondLevelLayout.setVisibility(View.VISIBLE);
            thirdLevelLayout.setVisibility(View.GONE);
            fourthLevelLayout.setVisibility(View.GONE);

                    user.setYear2(secondyear);
                }
            }
        });
        levelthree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
            fristLevelLayout.setVisibility(View.GONE);
            secondLevelLayout.setVisibility(View.GONE);
            thirdLevelLayout.setVisibility(View.VISIBLE);
            fourthLevelLayout.setVisibility(View.GONE);

                    user.setYear3(thirdyear);
                }
            }
        });
        levelfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((RadioButton) v).isChecked();
                if (checked){
                                fristLevelLayout.setVisibility(View.GONE);
            secondLevelLayout.setVisibility(View.GONE);
            thirdLevelLayout.setVisibility(View.GONE);
            fourthLevelLayout.setVisibility(View.VISIBLE);

                    user.setYear4(forthyear);
                }
            }
        });
        NextButton=findViewById(R.id.NextButton);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(signStudent.this, homeActivityStudent.class);
                startActivity(intent);
                //if student select subject it wii save in firebase
                if (checkAL.isChecked()){ user.setSubject1(Algorithms);
                mDatabase.setValue(user);}
                if (checkDS.isChecked()){ user.setSubject2(DataStructuree);
                    mDatabase.setValue(user);}
                if (checkCN.isChecked()){ user.setSubject3(ComputerNetwork);
                    mDatabase.setValue(user);}
                if (checkDB.isChecked()){ user.setSubject4( DataBase);
                    mDatabase.setValue(user);}
                if (checkIS.isChecked()){ user.setSubject5(informationsystem);
                    mDatabase.setValue(user);}
                if (checkCL.isChecked()){ user.setSubject6(computerlow);
                    mDatabase.setValue(user);}
                if (checkDC.isChecked()){ user.setSubject7(datascience);
                    mDatabase.setValue(user);}
                if (checkOR.isChecked()){ user.setSubject8(operatingResearch);
                    mDatabase.setValue(user);}
                if (checkSE.isChecked()){ user.setSubject9(softwareengineering);
                    mDatabase.setValue(user);}
                if (checkDA.isChecked()){ user.setSubject10(datasanalysis);
                    mDatabase.setValue(user);}
                if (checkFS.isChecked()){ user.setSubject11(fundamentalsoftware);
                    mDatabase.setValue(user);}
                if (checkIP.isChecked()){ user.setSubject12( ImageProcessing);
                    mDatabase.setValue(user);}
                if (checkNS.isChecked()){ user.setSubject13(networksecurity);
                    mDatabase.setValue(user);}
                if (checkHC.isChecked()){ user.setSubject14(historyofcomputer);
                    mDatabase.setValue(user);}
                if (checkOS.isChecked()){ user.setSubject15(operatingSystem);
                    mDatabase.setValue(user);}
                if (checkDS.isChecked()){ user.setSubject16(DigitalCircuits);
                    mDatabase.setValue(user);}
                if (checkCS.isChecked()){ user.setSubject17(cyberSecurity);
                    mDatabase.setValue(user);}
            }

        });


    }



}