package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.stevesoltys.indeed.Indeed;
import com.stevesoltys.indeed.exception.IndeedParameterException;
import com.stevesoltys.indeed.exception.IndeedParseException;
import com.stevesoltys.indeed.model.IndeedResult;
import com.stevesoltys.indeed.model.IndeedSearchResults;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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

        Spinner dropdown = findViewById(R.id.category);
        String[] items = new String[]{"Agriculture", "Soutien scolaire", "Aide senior", "Magasin", "Livreur", "Baby sitter", "Serveur", "Pet sitter"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setSelection(0);
        dropdown.setAdapter(adapter);


        Button btn_getJobs = (Button) findViewById(R.id.actu);

        btn_getJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected = dropdown.getSelectedItem().toString();
                ListView lv = (ListView) findViewById(R.id.list);

                String URL = "https://jobs.github.com/positions.json?description=" + selected;

                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonArrayRequest objectRequest = new JsonArrayRequest(
                        Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        //a changer !


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                );
            }
        });
    }

    private void openActivityDetails() {
        Intent intent = new Intent(this, details.class);
        startActivity(intent);
    }

    private void openActivityAnswer() {
        Intent intent = new Intent(this, answer.class);
        startActivity(intent);
    }

}