package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_D = (Button) findViewById(R.id.btn_details);
        Button btn_A = (Button) findViewById(R.id.btn_answer);

        btn_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityDetails();
            }
        });


        btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAnswer();
            }
        });

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.category);
        //create a list of items for the spinner.
        String[] items = new String[]{"Agriculture", "Soutien scolaire", "Aide senior", "Magasin", "", "Baby sitter", "Serveur", "Pet sitter"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

    }

    private void openActivityDetails(){
        Intent intent = new Intent(this,details.class);
        startActivity(intent);
    }

    private void openActivityAnswer(){
        Intent intent = new Intent(this,answer.class);
        startActivity(intent);
    }

}