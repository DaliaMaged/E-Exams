package com.example.e_exams.professor;

import android.os.Bundle;

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

        View rootView = inflater.inflate(R.layout.fragment_templets_fragment, container, false);
        createExam =rootView.findViewById(R.id.createBtn);
//        rvMCQ =rootView.findViewById(R.id.rv_mcq);
//        rvTrueNFalse =rootView.findViewById(R.id.rv_trueNfalse);
        textView =rootView.findViewById(R.id.textView);
        textView3 =rootView.findViewById(R.id.textView3);
      List <trueAndfalses> items=new ArrayList<>();

        RecyclerView recyclerViewTF=(RecyclerView) rootView.findViewById(R.id.rv_trueNfalse);
        trueAndfalses tf1=new trueAndfalses("question one ", "first answ","second answ");

        questionTFAdapter questionTFAdapter=new questionTFAdapter(tf1);

        recyclerViewTF.setAdapter(questionTFAdapter);
//        recyclerViewTF.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        recyclerViewTF.setLayoutManager(new LinearLayoutManager(Objects.requireNonNull(getActivity()).getBaseContext()));
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getActivity().getBaseContext());

//        recyclerViewTF.setLayoutManager(layoutManager);
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity().getBaseContext());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);



        mcqS mcq1 = new mcqS("eddd","edddd","eddd","three","four");

        RecyclerView recyclerViewMcq=(RecyclerView) rootView.findViewById(R.id.rv_mcq);
        questionMCQAdapter questionAdapterMcq=new questionMCQAdapter(mcq1);
        recyclerViewMcq.setAdapter(questionAdapterMcq);





    return rootView;

    }
}