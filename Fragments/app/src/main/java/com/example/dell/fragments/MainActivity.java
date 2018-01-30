package com.example.dell.fragments;

//import android.support.v4.app.Fragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.Snackbar;

import com.example.dell.fragments.dummy.DummyContent;

import layout.EMERALD;
import layout.FirstFragment;
import layout.MenuFragment;
import layout.RUBY;
import layout.SecondFragment;

//import layout.FirstFragment;
//import layout.SecondFragment;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener,RUBY.OnFragmentInteractionListener, EMERALD.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
if(findViewById(R.id.frameLayout)!=null) {
    if (savedInstanceState != null)
        return;

    ItemFragment firstfrag = new ItemFragment();
    firstfrag.setArguments(getIntent().getExtras());
    getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, firstfrag).commit();
}
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){Button bt1=(Button)findViewById(R.id.b1);
        Button bt2=(Button)findViewById(R.id.b2);
        Button bt3=(Button)findViewById(R.id.b3);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"First Fragment",Snackbar.LENGTH_LONG
                ).setAction("action",null).show();
                loadFrag(new FirstFragment());
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Second Fragment",Snackbar.LENGTH_LONG
                ).setAction("action",null).show();
                loadFrag(new SecondFragment());
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getPackageManager();
                i = managerclock.getLaunchIntentForPackage("com.example.dell.helloworld");
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
                //KeyEvent keyCode = new KeyEvent();
                //Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
                //Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                //Intent i;
                //PackageManager manager = getPackageManager();
                //try {
                  //  i = manager.getLaunchIntentForPackage("com.example.dell.helloworld.MainActivity");
                    //if (i == null)
                      //  throw new PackageManager.NameNotFoundException();
                    //i.addCategory(Intent.CATEGORY_LAUNCHER);
                    //startActivity(i);
                //} catch (PackageManager.NameNotFoundException e) {

                //}
                //Intent inent = new Intent("com.example.dell.helloworld.ANOTHER_ACTIVITY");

                //startActivity(inent);
            }
        });
        }}

private void loadFrag(Fragment fragment){
    FragmentManager fmag= getFragmentManager();
    FragmentTransaction ftra=fmag.beginTransaction();
    ftra.replace(R.id.frameLayout,fragment);
    //Uri location = Uri.parse("geo:37.422219,-122.08364?z=14"); // z param is zoom level
    //Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);


    ftra.commit();
}

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        RUBY rb=RUBY.newInstance(item.names,item.details);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,rb).addToBackStack(null).commit();

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
