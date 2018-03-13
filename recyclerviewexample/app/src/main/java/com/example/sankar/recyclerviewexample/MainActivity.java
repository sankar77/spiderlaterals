package com.example.sankar.recyclerviewexample;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sankar.recyclerviewexample.database.DBhelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DBhelper db;
    EditText nm;
    EditText ag;
    EditText mno;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         nm = (EditText) findViewById(R.id.edtname);
         ag = (EditText) findViewById(R.id.edtage);
         mno = (EditText) findViewById(R.id.edtmobno);
        Button submit = (Button) findViewById(R.id.insert);
        Intent i = new Intent(Intent.ACTION_MAIN);
        PackageManager managerclock = getPackageManager();
        i = managerclock.getLaunchIntentForPackage("com.example.dell.exampleappwidgetprovider");
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        i.putExtra("res",nm.getText().toString());
        startActivity(i);
        db = new DBhelper(this);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean ack = db.insetRecord(nm.getText().toString(), ag.getText().toString(), mno.getText().toString());
                if (ack)
                    Toast.makeText(MainActivity.this, "INSERT SUCCESSFULL", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "INSERT UNSUCCESSFULL", Toast.LENGTH_SHORT).show();
            }
        });
        Button reportbtn=(Button) findViewById(R.id.report);
        reportbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ReportActivity.class);
                startActivity(intent);
            }
        });


    }
}
