package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.firstjob.adapters.AnswerItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnswerActivity extends AppCompatActivity {
// Voici un commentaire pour pouvoir push

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        //List of items
        List<AnswerItem> answerItemList = new ArrayList<>();
        answerItemList.add(new AnswerItem("titre1", "content1"));
        answerItemList.add(new AnswerItem("titre2", "content2"));
        answerItemList.add(new AnswerItem("titre3", "content3"));

        //get list view
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new AnswerItemAdapter(this, answerItemList));
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_answer);
//
//        ArrayList<ArrayList<String>> sectionList = new ArrayList();
//
//        ArrayList<String> title = new ArrayList();
//        title.add("Web developper");
//        title.add("Projet manager");
//        title.add("Marketing manager");
//
//        ArrayList<String> content = new ArrayList();
//        content.add("content1");
//        content.add("content2");
//        content.add("content3");
//
//        sectionList.add(title);
//        sectionList.add(content);
//
//        TextView myTitleView = (TextView) findViewById(R.id.title);
//        TextView myContentView = (TextView) findViewById(R.id.content);
//
//        int listSize = sectionList.size() + 1;
//
//        for (int i = 0; i < listSize; i++) {
//            myTitleView.append(sectionList.get(0).get(i));
//            myContentView.append(sectionList.get(1).get(i));
//            myTitleView.append("\n");
//            myContentView.append("\n");
//        }
//    }
}
