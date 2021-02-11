package com.example.firstjob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.text.TextUtils;
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

    private static final String FILE_NAME="My_Post_List.txt";


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
                //appel fonc qui ckeck les données un bool true false

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



        FileOutputStream outputStream = openFileOutput(FILE_NAME,MODE_PRIVATE);
        String files="";
        outputStream.write(files.getBytes());
        outputStream.close();
        FileInputStream inputStream =openFileInput(FILE_NAME);


    }

    private ArrayList getArrayFromDetails() {

        ArrayList<String> reception = getIntent().getStringArrayListExtra("details");
        reception.add(String.valueOf(getRandom()));

        return reception;

    }

    //rename value
    private void save(ArrayList<String> value) throws IOException {
        FileInputStream inputStream = openFileInput(FILE_NAME);
        FileOutputStream outputStream = openFileOutput(FILE_NAME,MODE_PRIVATE);

        if (inputStream.read() < 1){

            String files=String.valueOf(value);
            outputStream.write(files.getBytes());

        }else{
            StringBuilder stringb = new StringBuilder();

            String essai = "";
            int content;
            while ((content=inputStream.read())!=-1){
                essai = String.valueOf(stringb.append((char)content));
            }
            value.add(essai);
            String files=String.valueOf(value);
            outputStream.write(files.getBytes());

        }
        outputStream.close();
        inputStream.close();

        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }


    private boolean getRandom(){
        //renommer les variable
        Random rd = new Random();
        boolean rand = rd.nextBoolean();
        return rand;
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