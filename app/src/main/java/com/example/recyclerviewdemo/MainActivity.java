package com.example.recyclerviewdemo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Notification;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    String name[]={"Darsh Somwanshi"," Ranvi Somwanshi","Amit Patil"};
    String contact[]={"98705656446"," 9686656454","9876543210"};
    String img[]={"","",""};
    ImageView imageView=null;
    String permission[]=new String[]{Manifest.permission.CAMERA};
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recycler1);
        CustomAdapter adapter=new CustomAdapter(img,name,contact);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,true));

            imageView=findViewById(R.id.img2);
            if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED)
            {

            }
            else {
                requestPermissions(permission,200);
            }
    }
int code=200;
    public void OpenCamera(View view) {

    Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
       startActivityForResult(intent,code);
       //ActivityResultLauncher i= registerForActivityResult(new ActivityResultContracts.TakePicture());

        }
        @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == code) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            imageView.setImageBitmap(photo);


        }
    }
}