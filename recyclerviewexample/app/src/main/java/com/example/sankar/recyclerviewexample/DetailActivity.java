package com.example.sankar.recyclerviewexample;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sankar.recyclerviewexample.database.DBhelper;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
      TextView name;
    DBhelper db;
    MyDetailsVo vo;
    String nam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();
        String na= i.getStringExtra("Name");
        db = new DBhelper(this);
        vo = new MyDetailsVo();
        Cursor c = db.getparticularname(na);
        if (c.moveToFirst()) {

            nam = c.getString(c.getColumnIndex("name"));

        }
        name=(TextView) findViewById(R.id.ne);
        name.setText(nam);
        Toast.makeText(DetailActivity.this, nam, Toast.LENGTH_SHORT).show();

        //vo.setName(nam);

    }
}
