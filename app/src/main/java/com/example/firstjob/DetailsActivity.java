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

    private ArrayList<String> created_at = new ArrayList();
    private ArrayList<String> Company = new ArrayList();
    private ArrayList<String> location = new ArrayList();
    private ArrayList<String> title = new ArrayList();{
        title.add("lalalalalala");
    }
    private ArrayList<String> description = new ArrayList();

    private ArrayList<ArrayList<String>> details  = new ArrayList();

    {

        details.add(created_at);
        details.add(Company);
        details.add(location);
        details.add(title);
        details.add(description);
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
        ArrayList<String> Re = getIntent().getStringArrayListExtra("info");
        System.out.println(Re);
    }

}