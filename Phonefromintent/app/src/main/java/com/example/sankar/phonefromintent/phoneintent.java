package com.example.sankar.phonefromintent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class phoneintent extends AppCompatActivity {
   ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneintent);
        final EditText num=(EditText) findViewById(R.id.nm);
        iv=(ImageView) findViewById(R.id.iview);
        Button bn=(Button) findViewById(R.id.btn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+num.getText().toString()));
                if (ActivityCompat.checkSelfPermission(phoneintent.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
        Button came=(Button) findViewById(R.id.cm);
         came.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                 startActivityForResult(intent,0);
             }
         });


    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
       super.onActivityResult(requestCode,resultCode,data);
        Bitmap bp=(Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bp);
    }
}