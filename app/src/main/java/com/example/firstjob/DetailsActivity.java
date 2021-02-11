package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ListView mListView;

    private ArrayList<String> Job_Title = new ArrayList();
    private ArrayList<String> Company = new ArrayList();
    private ArrayList<String> Country_State = new ArrayList();
    private ArrayList<String> Job_Description = new ArrayList();{
        Job_Description.add("lalalalalala");
    }
    private ArrayList<String> Requirements = new ArrayList();
    private ArrayList<String> Date_Of_Publication = new ArrayList();

    private ArrayList<ArrayList<String>> details  = new ArrayList();

    {

        details.add(Job_Title);
        details.add(Company);
        details.add(Country_State);
        details.add(Job_Description);
        details.add(Requirements);
        details.add(Date_Of_Publication);
        System.out.println(details);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        mListView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<ArrayList<String>> adapter = new ArrayAdapter<ArrayList<String>>(DetailsActivity.this,android.R.layout.simple_list_item_1, android.R.id.text1, details);
        mListView.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.btn_post);
        //test test test //

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });


    }


    private void openActivity(){
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }

}