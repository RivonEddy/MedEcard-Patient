package com.medecard.user.medecard_patient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewTipsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips_exp);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
