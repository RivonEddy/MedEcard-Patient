package com.medecard.user.medecard_patient;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.medecard.user.medecard_patient.fragments.HomeFragment;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class ViewProfileActivity extends AppCompatActivity {

    TextView disp_date;
    CalendarView calendarView;
    ImageButton back_to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);


        disp_date = (TextView) findViewById(R.id.disp_date);
//        calendarView = (CalendarView) findViewById(R.id.calendarView);
//
//        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView calendarView,
//                                            int year,
//                                            int month,
//                                            int dayOfMonth) {
//                String Date
//                        = dayOfMonth + "-"
//                        + (month + 1) + "-" + year;
//                disp_date.setText(Date);
//            }
//        });

        back_to_home = (ImageButton) findViewById(R.id.back_to_home);
        PushDownAnim.setPushDownAnimTo(back_to_home)
                .setScale(MODE_STATIC_DP, 2 )
                .setDurationPush(com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_INTERPOLATOR)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ViewProfileActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
