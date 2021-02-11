package com.example.firstjob;

public class AnswerItem {

    //fields
    private String title;
    private String content;
    private String hired;
    private String response;

    //constructor
    public AnswerItem(String title, String content, String hired, String response){
        this.title = title;
        this.content = content;
        this.hired = hired;
        this.response = response;
    }

    //methods
    public String getTitle(){ return title;}
    public String getContent(){ return content;}
    public String getHired(){ return hired;}
    public String getResponse(){ return response;}
}
