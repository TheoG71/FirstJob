package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.method.ScrollingMovementMethod;
import android.util.Log;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {


    String mDate;
    String mCompany;
    String mLocation;
    String mTitle;
    String mDescription;


    private ArrayList<String> details  = new ArrayList();

    {

        details.add(mDate);
        details.add(mCompany);
        details.add(mLocation);
        details.add(mTitle);
        details.add(mDescription);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Reception of the ArrayList info  which is then stored in a new ArrayList called reception.
        ArrayList<String> reception = getIntent().getStringArrayListExtra("info");


        mDate = reception.get(0);
        mCompany = reception.get(1);
        mLocation = reception.get(2);
        mTitle = reception.get(3);
        mDescription = reception.get(4);

        //create TextView
        TextView created_at = (TextView)findViewById(R.id.created_at);
        created_at.setText(String.valueOf(mDate));
        TextView comp = (TextView)findViewById(R.id.comp);
        comp.setText(String.valueOf(mCompany));
        TextView place = (TextView)findViewById(R.id.place);
        place.setText(String.valueOf(mLocation));
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(String.valueOf(mTitle));
        TextView information = (TextView)findViewById(R.id.information);
        mDescription = mDescription.substring(3);
        
        //translate the description into html
        mDescription = mDescription.replaceAll("\\<.*?>", "");
        information.setText(String.valueOf(mDescription));
        information.setMovementMethod(new ScrollingMovementMethod());

        Button btn = (Button) findViewById(R.id.btn_post);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(reception);}
        });


    }

    private void openActivity(ArrayList details){
        //Sending ArrayList to FormActivity by storing it in a new ArrayList
        Intent intent = new Intent(this, FormActivity.class);
        intent.putStringArrayListExtra("details",new ArrayList<>(details));
        startActivity(intent);
    }

}