package com.example.e_exams.professor;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.e_exams.R;
import com.example.e_exams.databinding.FragmentCreatExamsBinding;
import com.example.e_exams.forgetPasswordActivity;

import java.util.Objects;


public class CreateExams extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner subjectsSpinner,levelsSpinner;
    Button nextBtn;
    EditText trueNfalse, mcq;
    FragmentCreatExamsBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_creat_exams, container, false);
        subjectsSpinner =rootView.findViewById(R.id.subjects_spinner);
        levelsSpinner =rootView.findViewById(R.id.levels_spinner);
        nextBtn =rootView.findViewById(R.id.next);
        trueNfalse=rootView.findViewById(R.id.edtNoTrueFalse);
        mcq=rootView.findViewById(R.id.edtNoMcq);

        levelsSpinner.setOnItemSelectedListener(this);
        subjectsSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.subjects, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2=ArrayAdapter.createFromResource(getActivity().getBaseContext(),R.array.level, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        subjectsSpinner.setAdapter(adapter);
        levelsSpinner.setAdapter(adapter2);

        binding=FragmentCreatExamsBinding.inflate(getLayoutInflater());

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment temp_items= new temp_items();
                FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,temp_items);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });
        return rootView;
    }
 public void onDestroyView() {

     super.onDestroyView();
     binding=null;
 }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}