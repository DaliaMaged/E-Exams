package com.example.e_exams;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Lifecycle;

public class login_Adapter extends FragmentPagerAdapter {
private Context context;
private int totalTabs;

    public login_Adapter(@NonNull FragmentManager fm, Context context,int totalTabs) {
        super(fm);
        this.context=context;
        this.totalTabs=totalTabs;
    }

//    private String tabTitles[] = new String[]{"Login", "Sign up"};
//
//
//
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return tabTitles[position];
//    }
  public int getCount(){
      return totalTabs;
}
  public Fragment getItem(int position){
      switch (position){
          case 0:
              login_tabFragment login_tabFragment = new login_tabFragment();
              return login_tabFragment;
          case 1:
               signUp_tabFragment signUp_tabFragment=new signUp_tabFragment();
               return signUp_tabFragment;

      }
      return null;
  }

}
