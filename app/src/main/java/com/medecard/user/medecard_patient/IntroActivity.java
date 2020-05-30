package com.medecard.user.medecard_patient;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.medecard.user.medecard_patient.adapters.IntroVewPagerAdapter;
import com.medecard.user.medecard_patient.models.ScreenItem;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.List;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroVewPagerAdapter introVewPagerAdapter;
    TextView textView;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // make app on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);
        // hide the action bar
        getSupportActionBar().hide();
        // when this activity is about to be launched, we need to check if it's been opened before
        if (restorePrefData()){
            Intent mainActivity = new Intent(getApplicationContext(), LogRegActivity.class);
            startActivity(mainActivity);
            finish();
        }

        // ini views
        tabIndicator = findViewById(R.id.tab_indicator);
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_getStarted);
        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.button_animation);

        // fill list screen
        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Meet New Doctors", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit id reiciendis ratione distinctio ipsam atque quos sed velit iusto tenetur.", R.drawable.new_doctors));
        mList.add(new ScreenItem("Share your Records", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit id reiciendis ratione distinctio ipsam atque quos sed velit iusto tenetur.", R.drawable.share_records));
        mList.add(new ScreenItem("Easy Payment", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit id reiciendis ratione distinctio ipsam atque quos sed velit iusto tenetur.", R.drawable.easy_pay));
        mList.add(new ScreenItem("Sign Up Today", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit id reiciendis ratione distinctio ipsam atque quos sed velit iusto tenetur.", R.drawable.sign_up));

        // setup viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        introVewPagerAdapter = new IntroVewPagerAdapter(this, mList);
        screenPager.setAdapter(introVewPagerAdapter);

        textView = (TextView) findViewById(R.id.next_btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, LogRegActivity.class));
                finish();
            }
        });

        // setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);

        // next button click Listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()) {
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()-1) { // when we reach the last screen
                    loadLastScreen();
                }
            }
        });

        // tablayout add change listener
        tabIndicator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == mList.size()-1){
                    loadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        PushDownAnim.setPushDownAnimTo(btnGetStarted)
                .setScale(MODE_STATIC_DP, 10)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent mainActivity = new Intent(getApplicationContext(), LogRegActivity.class);
                        startActivity(mainActivity);

                        savePrefsData();
                        finish();
                    }
                });

    }

    private boolean restorePrefData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened", false);
        return  isIntroActivityOpenedBefore;
    }

    private void savePrefsData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("myprefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.commit();
    }

    //show the GETSTARTED button and hide the indicator and the next button
    private void loadLastScreen() {
        textView.setVisibility(View.INVISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);

        btnGetStarted.setAnimation(btnAnim);

    }
}
