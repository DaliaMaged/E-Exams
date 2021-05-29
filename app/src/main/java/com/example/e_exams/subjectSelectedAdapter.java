package com.example.e_exams;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class subjectSelectedAdapter extends RecyclerView.Adapter<subjectSelectedAdapter.ViewHolder> {
    View view;
    Context context;
    ArrayList<String>arrayList;
    subjectSelectedListener subjectSelectedListener;
    ArrayList<String>arrayList_0 =new ArrayList<>();
    DatabaseReference  mDatabase;
    FirebaseAuth mAuth;

    private Context mContext;
    private Callback callback;
    String type,uid,age,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10,
            subject11,subject12,subject13,subject14,subject15,subject16,subject17, year1, year2, year3, year4,subjectList;
    EditText email, pass,name;
    private String Name , Email,password;


    User user=new User(Name,Email,password,type,uid,age,subject1,subject2,subject3,subject4,subject5,subject6,subject7,subject8,subject9,subject10,
            subject11,subject12,subject13,subject14,subject15,subject16,subject17,year1,year2,year3,year4,subjectList);

    public subjectSelectedAdapter( Context context,ArrayList<String>arrayList, subjectSelectedListener subjectSelectedListener,String uid) {
        this.context=context;
        this.arrayList=arrayList;
        this.subjectSelectedListener=subjectSelectedListener;
        this.uid=uid;
    }

    public View getView() {
        return view;
    }

    @NonNull
    @Override
    public subjectSelectedAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.rv_layout,parent,false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull subjectSelectedAdapter.ViewHolder holder, int position) {
        if(arrayList !=null && arrayList.size()>0){
            holder.checkBox.setText(arrayList.get(position));
            holder.checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(holder.checkBox.isChecked()){
                      boolean item= arrayList_0.add(arrayList.get(position));
            System.out.println("item is Checked"+arrayList.get(position));


                    }else {
                        arrayList_0.remove(arrayList.get(position));
                    }

                    System.out.println("narl"+uid);

                    subjectSelectedListener.onSubjectChanged(arrayList_0);
                    user.setSubjects(arrayList_0);
                    System.out.println(arrayList_0);

              //      mDatabase.child(id).setValue(user);

                }
            });

        }

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox= itemView.findViewById(R.id.checkbox);
        }
    }
}
