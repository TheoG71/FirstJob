package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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