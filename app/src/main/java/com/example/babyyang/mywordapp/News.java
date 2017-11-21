package com.example.babyyang.mywordapp;

/**
 * Created by BabyYang on 2017/11/20.
 */

public class News {
    private String listNews1;
    private String listNews2;
    public News(String new1,String new2) {
        this.listNews1 = new1;
        this.listNews2 = new2;
    }
    public String getListNews1(){
        return listNews1;
    }
    public String getListNews2(){
        return listNews2;
    }
    public void setDetail(String detail){
        this.listNews2 = detail;
    }
    public void setTitle(String news){
        this.listNews1 = news;
    }
    public News() {
        this.listNews1 = null;
        this.listNews2 = null;
    }
}
