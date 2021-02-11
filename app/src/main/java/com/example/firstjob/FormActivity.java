package com.example.firstjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

public class FormActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button btn = (Button) findViewById(R.id.btn_send);
        EditText name = (EditText) findViewById(R.id.name);
        EditText first_name = (EditText) findViewById(R.id.first_name);
        EditText age = (EditText) findViewById(R.id.age);
        EditText location = (EditText) findViewById(R.id.location);
        EditText email = (EditText) findViewById(R.id.email);
        EditText phone = (EditText) findViewById(R.id.phone);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(name.getText())) {
                    name.setError("Name is required!");
                }
                if (TextUtils.isEmpty(first_name.getText())) {
                    first_name.setError("First name is required!");
                }
                if (TextUtils.isEmpty(age.getText())) {
                    age.setError("Age is required!");
                }
                if (TextUtils.isEmpty(location.getText())) {
                    location.setError("Location is required!");
                }
                if (TextUtils.isEmpty(email.getText())) {
                    email.setError("Email is required!");
                }
                if (TextUtils.isEmpty(phone.getText())) {
                    phone.setError("Phone is required!");
                } else {
                    try {
                        closeActivity();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void closeActivity() throws IOException {

        save(getArrayFromDetails());
        finish();

    }

    private ArrayList getArrayFromDetails() {

        ArrayList<String> reception = getIntent().getStringArrayListExtra("details");
        reception.add(String.valueOf(getRandom()));

        return reception;

    }


    private void save(ArrayList<String> reception) {
        String filename = "myfile.txt";
        String coup = "\n";
        FileOutputStream outputStream;
        Log.e("Taille de recpetion", String.valueOf(reception.size()));

        try {
            outputStream = openFileOutput(filename, Context.MODE_APPEND);

            for (int i = 0; reception.size() > i ; i++) {
                outputStream.write(reception.get(i).getBytes());
                outputStream.write(coup.getBytes());

            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }


    private boolean getRandom(){
        Random randomNumber = new Random();
        boolean randomBoolean = randomNumber.nextBoolean();
        return randomBoolean;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}