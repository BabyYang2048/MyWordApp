package com.example.babyyang.mywordapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by BabyYang on 2017/11/20.
 */

public class NewsAdapter extends ArrayAdapter<News> {
    private int resourceId;
    public NewsAdapter(Context context, int textViewResourceId, List<News> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        News news = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView word1 = (TextView)view.findViewById(R.id.listNews1);
        word1.setText(news.getListNews1());
        return view;
    }
}
