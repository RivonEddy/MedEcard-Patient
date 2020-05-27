package com.medecard.user.medecard_patient;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class ViewRecordsActivity extends AppCompatActivity {

    Intent intent;
    ImageView imageView;
    EditText editText, editText1, editText2, editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records);

        imageView = (ImageView) findViewById(R.id.back_btn_vrec);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ViewRecordsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
