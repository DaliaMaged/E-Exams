package com.example.e_exams.student;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.e_exams.professor.CreateExams;
import com.example.e_exams.professor.Degrees;
import com.example.e_exams.professor.Exams;
import com.example.e_exams.student.currentExam;

public class FragmentAdapterSt extends FragmentStateAdapter {
    public FragmentAdapterSt(@NonNull  FragmentManager fragmentManager,  Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new ExamSt();
            case 2:
                return new DegreesSt();
        }
        return new currentExam();

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
