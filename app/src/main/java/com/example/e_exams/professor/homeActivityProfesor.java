package com.example.e_exams.professor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.e_exams.R;
import com.google.android.material.tabs.TabLayout;


public class homeActivityProfesor extends AppCompatActivity {
    TabLayout tabLayout;
   ViewPager2 viewPager2;
   FragmentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_profesor);
        viewPager2=findViewById(R.id.viewpager);
        tabLayout=findViewById(R.id.viewpagertab);

        FragmentManager fm=getSupportFragmentManager();
        adapter=new FragmentAdapter(fm,getLifecycle());
        viewPager2.setAdapter(adapter);


        tabLayout.addTab(tabLayout.newTab().setText("Create Exam"));
        tabLayout.addTab(tabLayout.newTab().setText("Exams"));
        tabLayout.addTab(tabLayout.newTab().setText("Degrees"));


tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager2.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
});
viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
    @Override
    public void onPageSelected(int position) {
        tabLayout.selectTab(tabLayout.getTabAt(position));
    }
});

    }
}