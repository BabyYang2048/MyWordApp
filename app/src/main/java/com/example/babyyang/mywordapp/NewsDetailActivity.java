package com.example.babyyang.mywordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by BabyYang on 2017/11/20.
 */

public class NewsDetailActivity extends AppCompatActivity {
    private Button wordBut;
    private Button changeBut;
    private Button newsBut;
    private String title;
    private String detail;
    private TextView tv_title;
    private TextView tv_detail;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newslist_detail);
        tv_detail = (TextView)findViewById(R.id.newsDetail);
        tv_title = (TextView)findViewById(R.id.newsTitle);
        Intent intent = getIntent();
        title = intent.getStringExtra("newsTitle");
        detail = intent.getStringExtra("newsDetail");
        tv_title.setText(title);
        tv_detail.setText(detail);
        tv_detail.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
