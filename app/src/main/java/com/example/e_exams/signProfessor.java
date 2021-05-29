package com.example.e_exams;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_exams.professor.homeActivityProfesor;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class signProfessor extends AppCompatActivity implements subjectSelectedListener{
    RecyclerView recycleSubject;
    Button selected_button;
    subjectSelectedAdapter adapter;
    String type,uid,age,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10,
            subject11,subject12,subject13,subject14,subject15,subject16,subject17, year1, year2, year3, year4,subjectList;
    EditText email;
    EditText pass;
    EditText name;
    DatabaseReference  mDatabase;
    FirebaseAuth mAuth;


    int i;
    private String Name , Email,password;

    User user;
    String subject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_professor);
        recycleSubject=findViewById(R.id.recycleSubject);
        selected_button=findViewById(R.id.selected_button);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        name=findViewById(R.id.name);

        //firebase

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("USERS");
        User user=new User(Name,Email,password,type,uid,age,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10,
                subject11,subject12,subject13,subject14,subject15,subject16,subject17,year1,year2,year3,year4,subjectList);
Bundle extras =getIntent().getExtras();
uid =extras.getString("zuid");
System.out.println("fuid"+uid);
        selected_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(signProfessor.this, homeActivityProfesor.class);
                startActivity(intent);

        //        user.setSubjects(arraysubject);
System.out.println("zezp"+adapter.arrayList_0);

mDatabase.child(uid).child("Courses").setValue(adapter.arrayList_0);
            }
        });
        SetRecylerView();
    }


    private ArrayList<String> getsebjectselected(){
        ArrayList<String> arraySubject= new ArrayList<>();
        arraySubject.add("Algorithms");
        arraySubject.add("Data Structure");arraySubject.add("Software Engineering");arraySubject.add("Data Analysis");
        arraySubject.add("Computer Network");arraySubject.add("Network Security");arraySubject.add("History Of Computer");
        arraySubject.add("Image Processing");arraySubject.add("Computer Low");arraySubject.add( "Fundamental of Software");
        arraySubject.add("Data Base");arraySubject.add("Cyber Security");arraySubject.add("Operating Research");
        arraySubject.add("Digital Circuits");arraySubject.add("Operating System");

        return arraySubject;

    }

    private void SetRecylerView() {
        recycleSubject.setLayoutManager(new LinearLayoutManager(this));
        adapter=new subjectSelectedAdapter(this,getsebjectselected(),this,uid);
        System.out.println("theuid"+uid);
        recycleSubject.setAdapter(adapter);
    }
    @Override
    public void onSubjectChanged(ArrayList<String> arrayList) {

    }
}