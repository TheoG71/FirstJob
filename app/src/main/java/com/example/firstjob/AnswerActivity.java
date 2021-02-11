package com.example.firstjob;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.firstjob.adapters.AnswerItemAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        ArrayList tmp = new ArrayList();


        try {
            tmp = getArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



        //ArrayList 2D
        ArrayList<ArrayList<String>> sectionList = new ArrayList();

        ArrayList<String> title = new ArrayList();
        title.add((String) tmp.get(3));

        //title.add("Web developper");
        //title.add("Projet manager");
        //title.add("Marketing manager");

        ArrayList<String> content = new ArrayList();
        //content.add("content number 1 let's add some text to make a way better looking render on our beautiful application");
        //content.add("content number 2 let's add some text to make a way better looking render on our beautiful application, but a lil' different so we have some diversity");
        //content.add("content number 3 let's add some shit to this announce displayer, it looks stunning !");

        ArrayList<String> hired = new ArrayList();
        //hired.add("true");
        //hired.add("refused");
        //hired.add("refused2");

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

    private ArrayList getArray() throws FileNotFoundException {
        String filename = "myfile.txt";


        ArrayList load = new ArrayList();


        FileInputStream fis = null;
        try {
            fis = openFileInput(filename);
            InputStreamReader ist = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(ist);
            StringBuilder sb = new StringBuilder();
            String text;



            while ((text = br.readLine()) != null){

                //sb.append(text).append("\n");
                load.add(text);

            }
            Log.e("aller ", sb.toString());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return load;

    }
}
