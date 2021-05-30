package com.example.e_exams.professor;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
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


public class CreateExams extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner subjectsSpinner, levelsSpinner;
    Button nextBtn;
    EditText trueNfalse, mcq;
    CharSequence trueAndfalsesNo;
    Editable mcqNo;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_creat_exams, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        subjectsSpinner = getView().findViewById(R.id.subjects_spinner);
        levelsSpinner = getView().findViewById(R.id.levels_spinner);
        nextBtn = getView().findViewById(R.id.next);
        trueNfalse = getView().findViewById(R.id.edtNoTrueFalse);
        mcq = getView().findViewById(R.id.edtNoMcq);

        levelsSpinner.setOnItemSelectedListener(this);
        subjectsSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.subjects, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity().getBaseContext(), R.array.level, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        subjectsSpinner.setAdapter(adapter);
        levelsSpinner.setAdapter(adapter2);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle=new Bundle();
                bundle.putString("key",mcq.getText().toString());
                bundle.putString("keyy",trueNfalse.getText().toString());


                templets_fragment fragment = new templets_fragment();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_page_prof, fragment).commit();




            }

        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
