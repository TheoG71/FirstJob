package com.example.firstjob;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.firstjob.adapters.AnswerItemAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnswerActivity extends AppCompatActivity {
// Voici un commentaire pour pouvoir push

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);


        getArray();

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

        ArrayList<String> hired = new ArrayList();
        hired.add("true");
        hired.add("false");
        hired.add("false");

        sectionList.add(title);
        sectionList.add(content);
        sectionList.add(hired);

        //List of items
        List<AnswerItem> answerItemList = new ArrayList<>();

        for (int i = 0; i < sectionList.size(); i++) {
            if (sectionList.get(2).get(i).equals("true")){
                answerItemList.add(new AnswerItem(sectionList.get(0).get(i), sectionList.get(1).get(i), sectionList.get(2).get(i), "Accepted"));
            }else{
                answerItemList.add(new AnswerItem(sectionList.get(0).get(i), sectionList.get(1).get(i), sectionList.get(2).get(i), "Declined"));
            }
        }

        //get list view
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new AnswerItemAdapter(this, answerItemList));
    }

    private ArrayList getArray() {
        ArrayList load = new ArrayList();

        try {
            File myObj = new File("");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Log.e("info :", data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        return load;

    }
}
