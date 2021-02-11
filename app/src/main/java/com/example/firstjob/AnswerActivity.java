package com.example.firstjob;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
        ArrayList<String> content = new ArrayList();
        ArrayList<String> hired = new ArrayList();

        int j = 0;

        Log.e("taille ", String.valueOf(tmp.size()));


        for (int i = 3; i < tmp.size(); i+=6){
            Log.e("i ", String.valueOf(i));
            title.add((String) tmp.get(i));
            Log.e("title ", String.valueOf(tmp.get(i)));
        }

        for (int i = 4; i < tmp.size(); i+=6){
            Log.e("i ", String.valueOf(i));
            content.add(((String) tmp.get(i)).substring(0,20));
            Log.e("content ", String.valueOf(tmp.get(i)));
        }

        for (int i = 5; i < tmp.size(); i+=6){
            Log.e("i ", String.valueOf(i));
            hired.add((String) tmp.get(i));
            Log.e("hired ", String.valueOf(tmp.get(i)));
            j++;
        }

        sectionList.add(title);
        sectionList.add(content);
        sectionList.add(hired);

        //List of items
        List<AnswerItem> answerItemList = new ArrayList<>();

        for (int i = 0; i < j; i++) {
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
