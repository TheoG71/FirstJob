package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        public static final String EXTRA_TEXT= "com.example.application.example.EXTRA_TEXT";
    JSONObject main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_D = (Button) findViewById(R.id.btn_details);
        Button btn_A = (Button) findViewById(R.id.btn_answer);



        btn_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAnswer();
            }
        });

        Spinner dropdown = findViewById(R.id.category);
        String[] items = new String[]{"front", "front", "back", "Magasin", "Livreur", "Baby sitter", "Serveur", "Pet sitter"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setSelection(0);
        dropdown.setAdapter(adapter);

        Button btn_getJobs = (Button) findViewById(R.id.actu);

        btn_getJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selected = dropdown.getSelectedItem().toString();

                TextView txt = (TextView) findViewById(R.id.test);
                TextView title = (TextView) findViewById(R.id.title);
                TextView desc = (TextView) findViewById(R.id.desc);

                String URL = "https://jobs.github.com/positions.json?description=" + selected;


                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonArrayRequest objectRequest = new JsonArrayRequest(
                        Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.e("Rest Response", response.toString());


                        try {
                            ListView listView = (ListView)findViewById(R.id.list);
                            ArrayList<String> arrayList = new ArrayList<>();


                            for (int i=0;i < response.length() ;i++){
                                main = response.getJSONObject(i);
                                arrayList.add(main.getString("title"));
                            }

                            ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
                            listView.setAdapter(arrayAdapter);

                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    ArrayList info = new ArrayList();

                                    try {
                                        JSONObject main2 = response.getJSONObject(position);
                                        info.add(main2.getString("created_at"));
                                        info.add(main2.getString("company"));
                                        info.add(main2.getString("location"));
                                        info.add(main2.getString("title"));
                                        info.add(main2.getString("description"));
                                        //ajouter un bool pour le bouton de truc de ces grands morts
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    openActivityDetails(info);
                                }
                            });

                        } catch (JSONException e) {
                            txt.setText("j'ai rien");
                            Toast.makeText(MainActivity.this, "j'ai rien recu", Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Rest Response", error.toString());
                    }
                }
                );
                requestQueue.add(objectRequest);
            }
        });
    }

    private void openActivityDetails(ArrayList info) {
        Intent intent = new Intent(this, details.class);
        intent.putStringArrayListExtra("info",new ArrayList<>(info));
        Log.e("info :", info.toString());
        startActivity(intent);
    }

    private void openActivityAnswer() {
        Intent intent = new Intent(this, AnswerActivity.class);
        startActivity(intent);
    }

}