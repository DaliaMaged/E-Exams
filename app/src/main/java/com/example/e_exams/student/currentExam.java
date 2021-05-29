package com.example.e_exams.student;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.e_exams.R;


public class currentExam extends Fragment {
    RecyclerView recyclerView;
    numberQuestionAdapterSt adapterQst;
    String qNumber[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
    Button btnNext;
    Dialog mDialog;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public currentExam() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment currentExam.
     */
    // TODO: Rename and change types and number of parameters
    public static currentExam newInstance(String param1, String param2) {
        currentExam fragment = new currentExam();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Rootview=inflater.inflate(R.layout.fragment_current_exam,container,false);
        recyclerView=Rootview.findViewById(R.id.recycleDesign);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getBaseContext(),LinearLayoutManager.HORIZONTAL,false));
        //
        adapterQst=new numberQuestionAdapterSt(getActivity().getBaseContext(),qNumber);

        recyclerView.setAdapter(adapterQst);
        btnNext=Rootview.findViewById(R.id.btnNext);
        mDialog=new Dialog(getActivity().getBaseContext());
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.setContentView(R.layout.popup);
                mDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            }
        });

        return Rootview;
    }
}