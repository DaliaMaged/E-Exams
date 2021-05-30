package com.example.e_exams.professor;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.e_exams.professor.models.mcqS;
import com.example.e_exams.professor.models.trueAndfalses;
import com.example.e_exams.professor.adapter.questionTFAdapter;
import com.example.e_exams.professor.adapter.questionMCQAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.e_exams.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class templets_fragment extends Fragment {

Button createExam;
RecyclerView rvMCQ,rvTrueNFalse;
TextView textView,textView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_temp_items, container, false);

    return rootView;

    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createExam =getView().findViewById(R.id.createBtn);
        textView =getView().findViewById(R.id.textView);
        textView3 =getView().findViewById(R.id.textView3);
        Bundle bundle=this.getArguments();
        String data=bundle.getString("key");
        String data2=bundle.getString("keyy");
        textView.setText("True and falses Q"+data);
        textView3.setText("Mcq Q"+data2);

        List<trueAndfalses> items=new ArrayList<>();
        RecyclerView recyclerViewTF =getView().findViewById(R.id.rv_trueNfalse);
//        trueAndfalses tf1=new trueAndfalses("Question one", "True","False");
//        items.add(tf1);
//        trueAndfalses tf2=new trueAndfalses("Question one", "True","False");
//        items.add(tf2);
//        trueAndfalses tf3=new trueAndfalses("Question one", "True","False");
//        items.add(tf3);
        for (int i = 1; i <= Integer.parseInt(data) ; i++) {
            items.add(new trueAndfalses("Question "+i, "True", "False" ));
        }
        questionTFAdapter questionTFAdapter=new questionTFAdapter(items);
        recyclerViewTF.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewTF.setAdapter(questionTFAdapter);

        List<mcqS> items2=new ArrayList<>();
        RecyclerView recyclerViewMCQ =getView().findViewById(R.id.rv_mcq);
        for (int i = 1; i <= Integer.parseInt(data2) ; i++) {
            items2.add(new mcqS("Question "+i, "one", "two" ,"three","four"));
        }
//        mcqS mcq1=new mcqS("Question 1 ", "one ","two","three","four");
//        items2.add(mcq1);
//        mcqS mcq2=new mcqS("Question 1 ", "one ","two","three","four");
//        items2.add(mcq2);
        questionMCQAdapter questionMCQAdapter=new questionMCQAdapter(items2);
        recyclerViewMCQ.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMCQ.setAdapter(questionMCQAdapter);


    }
}