package com.example.firstjob;

public class AnswerItem {

    //fields
    private String title;
    private String content;

    //constructor
    public AnswerItem(String title, String content){
        this.title = title;
        this.content = content;
    }

    //methods
    public String getTitle(){ return title;}
    public String getContent(){ return content;}
}
