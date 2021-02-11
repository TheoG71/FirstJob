package com.example.firstjob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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

import com.example.firstjob.adapters.AnswerItemAdapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        public static final String EXTRA_TEXT= "com.example.application.example.EXTRA_TEXT";
    JSONObject main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mButtonAnswer = (Button) findViewById(R.id.btn_answer);
        mButtonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityAnswer();
            }
        });

        Spinner dropdown = findViewById(R.id.category);
        String[] mItems = new String[]{"Front-End", "Back-End", "Full Stack", "Java", "C/C++", "Server", "Python"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, mItems);
        dropdown.setSelection(0);
        dropdown.setAdapter(adapter);

        Button mButtonGetJobs = (Button) findViewById(R.id.actu);
        mButtonGetJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mValueSelected = dropdown.getSelectedItem().toString();

                String mURL = "https://jobs.github.com/positions.json?description=" + mValueSelected;
                //Call API
                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                JsonArrayRequest objectRequest = new JsonArrayRequest(
                        Request.Method.GET, mURL, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            List<AnswerItem> mAnswerItemList = new ArrayList<>();
                            ListView listView = (ListView)findViewById(R.id.list);

                            for (int i=0;i < response.length() ;i++){
                                main = response.getJSONObject(i);
                                String mDesc = main.getString("description");
                                mDesc = mDesc.replaceAll("\\<.*?>", "");
                                mDesc = mDesc.substring(0,50);
                                mDesc += "...";
                                mAnswerItemList.add(new AnswerItem(main.getString("title"), mDesc,"",""));
                            }

                            listView.setAdapter(new AnswerItemAdapter(MainActivity.this, mAnswerItemList));
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    ArrayList info = new ArrayList();

                                    try {
                                        JSONObject mInfoAPI = response.getJSONObject(position);
                                        info.add(mInfoAPI.getString("created_at"));
                                        info.add(mInfoAPI.getString("company"));
                                        info.add(mInfoAPI.getString("location"));
                                        info.add(mInfoAPI.getString("title"));
                                        info.add(mInfoAPI.getString("description").replaceAll("\\\n", " ").replaceAll("\\<.*?>", ""));
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    openActivityDetails(info);
                                }
                            });

                        } catch (JSONException e) {
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
        Intent intent = new Intent(this, DetailsActivity.class);
        //send to DetailsActivity an array
        intent.putStringArrayListExtra("info",new ArrayList<>(info));
        startActivity(intent);
    }

    private void openActivityAnswer() {
        //Check if myfile.txt is empty
        String filename = "myfile.txt";
        FileInputStream mfileInputStream = null;
        try {
            mfileInputStream = openFileInput(filename);
            InputStreamReader mInputStreamReader = new InputStreamReader(mfileInputStream);
            BufferedReader mBufferedReader = new BufferedReader(mInputStreamReader);
            if (mBufferedReader.readLine() == null){
                Toast.makeText(this, "You have to postulate", Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(this, AnswerActivity.class);
                startActivity(intent);
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}