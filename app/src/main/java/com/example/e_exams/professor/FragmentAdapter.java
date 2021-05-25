package com.example.e_exams.professor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.e_exams.professor.CreateExams;
import com.example.e_exams.professor.Degrees;
import com.example.e_exams.professor.Exams;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull  FragmentManager fragmentManager, @NonNull  Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 1:
                return new Exams();
            case 2:
                return new Degrees();
            case 3:
                return new templets_fragment();

        }
        return new CreateExams();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
