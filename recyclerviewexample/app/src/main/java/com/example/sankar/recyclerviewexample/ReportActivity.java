package com.example.sankar.recyclerviewexample;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sankar.recyclerviewexample.database.DBhelper;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {

    DBhelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        db=new DBhelper(this);
        RecyclerView rlist;
        ArrayList<MyDetailsVo> list = new ArrayList<>();//initialisation
        rlist = (RecyclerView) findViewById(R.id.list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rlist.setLayoutManager(linearLayoutManager);
        Cursor c=db.getInsertRecord();

        if(c.moveToFirst()){
            do{
                MyDetailsVo vo = new MyDetailsVo();
                vo.setName(c.getString(c.getColumnIndex("name")));//setting the data to adapter
                vo.setAge(c.getString(c.getColumnIndex("age")));
                vo.setMobileno(c.getString(c.getColumnIndex("mobno")));
                list.add(vo);

            }while (c.moveToNext());
        }

        CustomAdapter adapter = new CustomAdapter(list,db,ReportActivity.this);//setting the data in adapter to the list
        rlist.setAdapter(adapter);

    }
}
