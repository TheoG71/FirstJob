package com.example.firstjob;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstjob.adapters.AnswerItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class AnswerActivity extends AppCompatActivity {
// Voici un commentaire pour pouvoir push

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        //ArrayList 2D
        ArrayList<ArrayList<String>> sectionList = new ArrayList();

        ArrayList<String> title = new ArrayList();
        title.add("Web developper");
        title.add("Projet manager");
        title.add("Marketing manager");

        ArrayList<String> content = new ArrayList();
        content.add("content number 1 let's add some text to make a way better looking render on our beautiful application");
        content.add("content number 2 let's add some text to make a way better looking render on our beautiful application, but a lil' different so we have some diversity");
        content.add("content number 3 let's add some shit to this announce displayer, it looks stunning !");

        sectionList.add(title);
        sectionList.add(content);

        int listSize = sectionList.size() + 1;

        //List of items
        List<AnswerItem> answerItemList = new ArrayList<>();

        for (int i = 0; i < listSize; i++) {
            answerItemList.add(new AnswerItem(sectionList.get(0).get(i), sectionList.get(1).get(i)));
        }

//        answerItemList.add(new AnswerItem("titre1", "content1"));
//        answerItemList.add(new AnswerItem("titre2", "content2"));
//        answerItemList.add(new AnswerItem("titre3", "content3"));

        //get list view
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new AnswerItemAdapter(this, answerItemList));
    }
}
