package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;

public class answer extends AppCompatActivity {
// Voici un commentaire pour pouvoir push

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        ArrayList<ArrayList<String>> sectionList = new ArrayList();

        ArrayList<String> title = new ArrayList();
        title.add("Web developper");
        title.add("Projet manager");
        title.add("Marketing manager");

        ArrayList<String> content = new ArrayList();
        content.add("content1");
        content.add("content2");
        content.add("content3");

        sectionList.add(title);
        sectionList.add(content);

        TextView myTitleView = (TextView) findViewById(R.id.title);
        TextView myContentView = (TextView) findViewById(R.id.content);

        int listSize = sectionList.size() + 1;

        for (int i = 0; i < listSize; i++) {
            myTitleView.append(sectionList.get(0).get(i));
            myContentView.append(sectionList.get(1).get(i));
            myTitleView.append("\n");
            myContentView.append("\n");
        }
    }
}
