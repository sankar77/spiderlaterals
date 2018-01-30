package com.example.dell.tabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.support.design.widget.Snackbar;

import layout.FirstFragment;
import layout.SecondFragment;


public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=(FrameLayout)findViewById(R.id.fl);
        tabLayout=(TabLayout)findViewById(R.id.tl);
        TabLayout.Tab ftab=tabLayout.newTab();
        ftab.setText("First Tab");
        TabLayout.Tab stab=tabLayout.newTab();
        stab.setText("Second Tab");
        tabLayout.addTab(ftab);
        tabLayout.addTab(stab);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fg=null;
                switch(tab.getPosition()){
                    case 0:fg=new FirstFragment();
                            break;
                    case 1:fg=new SecondFragment();
                           break;
                    default:View v=findViewById(R.id.activity_main);
                            Snackbar.make(v,"Select a tab",Snackbar.LENGTH_LONG).setAction("action",null).show();
                }
               FragmentManager fm=getSupportFragmentManager();
                FragmentTransaction ftran=fm.beginTransaction();
                ftran.replace(R.id.fl,fg);
                ftran.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ftran.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
