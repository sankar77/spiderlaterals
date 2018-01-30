package com.example.dell.helloworld;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c = this;
        Button btt=(Button)findViewById(R.id.bn);
        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hey", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getPackageManager();
                i = managerclock.getLaunchIntentForPackage("com.example.dell.fragments");
                i.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(i);
            }
        });

        Button button = (Button) findViewById(R.id.b);
        final EditText text = (EditText) findViewById(R.id.a);
        //final String Answer;
        final TextView tv = (TextView) findViewById(R.id.t);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String Answer=" ";
                tv.setText(text.getText().toString());

            }
        });
        View someView = findViewById(R.id.activity_main);
        View view = someView.getRootView();
        view.setBackgroundColor(0xfff00000);
        final EditText tx = (EditText) findViewById(R.id.a1);
        final EditText tc = (EditText) findViewById(R.id.a2);
        Button bt = (Button) findViewById(R.id.button2);
        //Button b=(Button) findViewById(R.id.bt4);
        final TextView tvi = (TextView) findViewById(R.id.tview);
        /*bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tvi.setText(tx.getInteger().toString());
            Integer n1=Integer.parseInt(tx.getText().toString());
            Integer n2=Integer.parseInt(tc.getText().toString());
            Integer n3=n1+n2;
            tvi.setText(n3.toString());
                //Intent i=new Intent();
            }

        });*/
        Button btn = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tx.getText().toString().isEmpty() || tc.getText().toString().isEmpty()) {
                    Snackbar.make(view, "Please Input valid values", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {

                    Integer n1 = Integer.parseInt(tx.getText().toString());
                    Integer n2 = Integer.parseInt(tc.getText().toString());
                    Integer n3 = n1 + n2;
                    tvi.setText(n3.toString());
                    View someView1 = findViewById(R.id.activity_main);
                    View view1 = someView1.getRootView();
                    view1.setBackgroundColor(0xff000000);
                    Intent i = new Intent(c, Main2Activity.class);
                    i.putExtra("res", tvi.getText());
                    startActivity(i);
                }
            }
        });
        Button b = (Button) findViewById(R.id.bt4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tx.getText().toString().isEmpty()||tc.getText().toString().isEmpty()){
                    Snackbar.make(view, "Please Input valid values", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                else{
                Integer n1 = Integer.parseInt(tx.getText().toString());
                Integer n2 = Integer.parseInt(tc.getText().toString());


                    Integer n3 = n1 - n2;
                    tvi.setText(n3.toString());
                    Intent i = new Intent(c, Main2Activity.class);
                    i.putExtra("res", tvi.getText());
                    startActivity(i);
                }
            }
        });
        Button bn=(Button) findViewById(R.id.gb);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View someView = findViewById(R.id.activity_main);
                View view2 = someView.getRootView();
                view2.setBackgroundColor(0xfff00000);
            }
        });
    }


}


