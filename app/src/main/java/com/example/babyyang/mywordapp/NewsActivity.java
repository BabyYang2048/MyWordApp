package com.example.babyyang.mywordapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by BabyYang on 2017/11/20.
 */

public class NewsActivity extends AppCompatActivity {
    private Button wordBut;
    private Button changeBut;
    private ListView listNews = null;
    private NewsAdapter adapter = null;
    private ArrayList<News> newsArrayList = new ArrayList<News>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_layout);
        listNews = (ListView)findViewById(R.id.newsList);
        adapter = new NewsAdapter(NewsActivity.this,R.layout.newslist_item,newsArrayList);


        NewsInfo newsInfo = new NewsInfo(listNews,adapter,newsArrayList);
        newsInfo.getNewsInfo();
        listNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News newsone = newsArrayList.get(position);
                Intent intent = new Intent();
                intent.putExtra("newsTitle", newsone.getListNews1());
                intent.putExtra("newsDetail",newsone.getListNews2());
                intent.setClass(NewsActivity.this,NewsDetailActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

    }
}
