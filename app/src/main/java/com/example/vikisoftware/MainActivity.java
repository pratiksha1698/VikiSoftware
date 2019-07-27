package com.example.vikisoftware;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ProgrammingAdapter.OnNotekListener {

    //private static final int CAMERA_REQUEST = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView programinglist = (RecyclerView) findViewById(R.id.programinglist);
        programinglist.setLayoutManager(new LinearLayoutManager(this));
        String[] SUBJECT = {"C", "C++", "VB6.0",".NET", "JAVA", "RDBMS", "OPERATING SYSTEM", "ADVANCED JAVA", "BUSINESS MATHAMTICS", "MANAGMENT", "OOPL", "NETWORKING", "HTML", "PHP", "BUSINESS MANAGEMENT"};
        programinglist.setAdapter(new ProgrammingAdapter(SUBJECT,this));
    }
    @Override
    public void onNoteClick(int position) {
        Intent in= new Intent(MainActivity.this,Camera.class);
        startActivity(in);
        /*Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);*/
    }
}

