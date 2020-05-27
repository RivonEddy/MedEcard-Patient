package com.medecard.user.medecard_patient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chaos.view.PinView;

public class ForgotPassword2Activity extends AppCompatActivity {

    Button button;
    TextView textView;
    com.chaos.view.PinView pinView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password2);

        button = (Button) findViewById(R.id.otp_cnf_btn);
        textView = (TextView) findViewById(R.id.back_btn_fp2);
        pinView = (PinView) findViewById(R.id.forgot_passwd_otp);
        pinView.setEnabled(true);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgotPassword3Activity.class));
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ForgotPasswordActivity.class));
            }
        });

    }
}
