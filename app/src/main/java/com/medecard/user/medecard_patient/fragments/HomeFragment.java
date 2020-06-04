package com.medecard.user.medecard_patient.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.medecard.user.medecard_patient.HealthTipsActivity;
import com.medecard.user.medecard_patient.R;
import com.medecard.user.medecard_patient.ViewProfileActivity;
import com.medecard.user.medecard_patient.models.HealthTips;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.List;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class HomeFragment extends Fragment {

    private RecyclerView myrecyclerview;
    private List<HealthTips> listHealthTips;
    ImageView imageView, btn_crt_abt;
    Intent intent;
    TextView text_abt;
    EditText edit_abt;
    Button btn_view_prof;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listHealthTips = new ArrayList<>();

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

        listHealthTips.add(new HealthTips(R.drawable.bb2,
                "The best foods to help you sleep (and others to avoid)"));

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,
                false);

        imageView = (ImageView) view.findViewById(R.id.tips_btn);
        btn_crt_abt = (ImageView) view.findViewById(R.id.btn_crt_abt);
        text_abt = (TextView) view.findViewById(R.id.text_abt);
        edit_abt = (EditText) view.findViewById(R.id.edit_abt);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, HealthTipsActivity.class);
                startActivity(intent);
            }
        });

        text_abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_abt.setVisibility(View.INVISIBLE);
                edit_abt.setVisibility(View.VISIBLE);
                edit_abt.setText(text_abt.getText().toString());
                btn_crt_abt.setVisibility(View.VISIBLE);
            }
        });

        btn_crt_abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edit_abt.getText().toString().isEmpty()){
                    edit_abt.setError("Field cannot be empty");
                }
                else {
                    btn_crt_abt.setVisibility(View.INVISIBLE);
                    edit_abt.setVisibility(View.INVISIBLE);
                    text_abt.setVisibility(View.VISIBLE);
                    text_abt.setText(edit_abt.getText().toString());
                }
            }
        });

        btn_view_prof = (Button) view.findViewById(R.id.btn_view_prof);
        PushDownAnim.setPushDownAnimTo(btn_view_prof)
                .setScale(MODE_STATIC_DP, 13 )
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(context, ViewProfileActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}