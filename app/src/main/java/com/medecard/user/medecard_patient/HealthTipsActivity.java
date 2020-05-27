package com.medecard.user.medecard_patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.medecard.user.medecard_patient.adapters.HealthTipsAdapter;

public class HealthTipsActivity extends AppCompatActivity {

    Integer[] image_array = {
            R.drawable.bb2,
    };

    String[] name_array = {
            "The Best Foods To Help You Sleep (and Others to Avoid)",
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);

        HealthTipsAdapter adapter = new HealthTipsAdapter(this, image_array, name_array);
        listView = (ListView) findViewById(R.id.listview_health);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), ViewTipsActivity.class);
                startActivity(intent);
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}