package com.example.babyyang.mywordapp;

import android.os.Handler;
import android.os.Message;
import android.util.Xml;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by BabyYang on 2017/11/20.
 */

public class NewsInfo {

    private ListView listNews;
    public Message message;
    public ArrayList<News> newList = new ArrayList<>();
    private NewsAdapter adapter = null;

    public NewsInfo(ListView listNews,NewsAdapter adapter,ArrayList<News> list){
        this.listNews = listNews;
        this.adapter = adapter;
        this.newList = list;
    }



    final Handler handler = new Handler(){
        @Override
        public void handleMessage(Message age){
            switch ((message.what)){
                case 1:
                    listNews.setAdapter(adapter);
                    break;
                default:
                    break;
            }
        }
    };

    public void getNewsInfo()
    {
        Thread thread = new Thread(){
            @Override
            public void run() {
                String path = "http://47.93.99.95:8080/news_en.xml";
                try {
                    URL url = new URL(path);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    if(conn.getResponseCode() == 200)
                    {
                        InputStream is = conn.getInputStream();
                        parseXmlInfo(is);
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public void parseXmlInfo(InputStream is)
    {
        XmlPullParser xParser = Xml.newPullParser();
        try {
            xParser.setInput(is, "utf-8");
            int eventType = xParser.getEventType();
            News news = null;
            while(eventType != XmlPullParser.END_DOCUMENT)
            {
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if("newslist".equals(xParser.getName())) {
                            newList = new ArrayList<News>();
                        }
                        else if ("news".equals(xParser.getName())) {
                            news = new News();
                        }
                        else if ("detail".equals(xParser.getName())) {
                            String detail = xParser.nextText();
                            news.setDetail(detail);
                        }
                        else if ("title".equals(xParser.getName())) {
                            String title = xParser.nextText();
                            news.setTitle(title);
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if("news".equals(xParser.getName()))
                        {
                            adapter.add(news);
                        }
                        break;
                }
                eventType = xParser.next();
            }


            message = new Message();
            message.what = 1;
            handler.sendMessage(message);
            //打印
            for (News n : newList) {
                System.out.println(n.toString());
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
