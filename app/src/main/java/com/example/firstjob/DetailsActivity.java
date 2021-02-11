package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    String date;
    String company;
    String location;
    String title;
    String description;

    ListView mListView;

    private ArrayList<String> details  = new ArrayList();
    {

        details.add(date);
        details.add(company);
        details.add(location);
        details.add(title);
        details.add(description);
        Log.e("Coucou",details.toString());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ArrayList<String> reception = getIntent().getStringArrayListExtra("info");
        mListView = (ListView) findViewById(R.id.listView);

        date = reception.get(0);
        company = reception.get(1);
        location = reception.get(2);
        title = reception.get(3);
        description = reception.get(4);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(DetailsActivity.this,android.R.layout.simple_list_item_1, android.R.id.text1, details);
        mListView.setAdapter(adapter);

        Button btn = (Button) findViewById(R.id.btn_post);
        //test test test //

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(); }
        });


    }



    private void openActivity(){
        Intent intent = new Intent(this, FormActivity.class);
        intent.putStringArrayListExtra("details",new ArrayList<>(details));
        startActivity(intent);
    }

}