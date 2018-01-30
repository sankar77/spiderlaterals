package com.example.dell.helloworld;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TextView v=(TextView) findViewById(R.id.t);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        View view=findViewById(R.id.act);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                //view.setBackgroundResource(R.drawable.);
                //view.setBackgroundColor(0x00000);
                //view.setBackgroundColor(0xfff00000);
                Snackbar.make(view, "hello", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //v.setBackgroundResource(drawable);
                //view.setTextColor(0x00000);
                return false;
            }
        });
        /*View someView = findViewById(R.id.content_main2);
        View view1 = someView.getRootView();
        view1.setBackgroundColor(0xfff00000);
        */
        view.setBackgroundColor(0xfff00000);
        //View someView = findViewById(R.id.content_main2);

        // Find the root view
        //View view = someView.getRootView();

        // Set the color
        //Color c = new Color(getResources().)
        //root.setBackgroundColor(getResources().getColor(R.color.colornew, null));
        //view.setBackgroundColor(0xfff00000);
        Intent i=getIntent();
        String c=i.getStringExtra("res");

        v.setText(c);

        //RelativeLayout li=(RelativeLayout) findViewById(R.id.activity_main);
        //li.setBackgroundColor(Color.parseColor("#ff0231"));
    }

}
