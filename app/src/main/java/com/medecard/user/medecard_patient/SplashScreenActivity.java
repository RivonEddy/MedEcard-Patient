package com.medecard.user.medecard_patient;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler;
    private ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imv = (ImageView) findViewById(R.id.app_theme);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        imv.startAnimation(myanim);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, LogRegActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
