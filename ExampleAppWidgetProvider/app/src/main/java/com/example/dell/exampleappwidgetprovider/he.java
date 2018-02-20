package com.example.dell.exampleappwidgetprovider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class he extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendBroadcast(new Intent(Intent.ACTION_MAIN).addCategory(Intent.CATEGORY_HOME));
        setContentView(R.layout.activity_he);
    }
}
