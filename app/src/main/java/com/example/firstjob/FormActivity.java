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
import android.widget.Button;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.lang.*;

public class FormActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Button btn = (Button) findViewById(R.id.btn_send);
        Button files = (Button) findViewById(R.id.open_files);
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
                    openActivity();
                }
            }
        });
    }


    private void openActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        Random rd = new Random();
        boolean rand = rd.nextBoolean();
        String res = String.valueOf(rand);
        TextView test = (TextView) findViewById(R.id.test);
        test.setText(res);
        ArrayList<String> arrayDetails = new ArrayList<String>();
        arrayDetails.add(res);
        test.setText(String.valueOf(arrayDetails));
        //startActivity(intent);
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