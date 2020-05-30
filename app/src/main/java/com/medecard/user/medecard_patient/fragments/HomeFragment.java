package com.medecard.user.medecard_patient.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medecard.user.medecard_patient.HealthTipsActivity;
import com.medecard.user.medecard_patient.R;
import com.medecard.user.medecard_patient.adapters.RecyclerViewAdapter_HealthTips;
import com.medecard.user.medecard_patient.models.HealthTips;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView myrecyclerview;
    private List<HealthTips> listHealthTips;
    ImageView imageView, btn_edit_abt;
    Intent intent;
    TextView text_abt, btn_done;
    EditText edit_abt;
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
        btn_edit_abt = (ImageView) view.findViewById(R.id.btn_edit_abt);
        text_abt = (TextView) view.findViewById(R.id.text_abt);
        edit_abt = (EditText) view.findViewById(R.id.edit_abt);
        btn_done = (TextView) view.findViewById(R.id.btn_done);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, HealthTipsActivity.class);
                startActivity(intent);
            }
        });

        btn_edit_abt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_abt.setVisibility(View.INVISIBLE);
                edit_abt.setVisibility(View.VISIBLE);
                btn_done.setVisibility(View.VISIBLE);
            }
        });

        btn_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit_abt.setVisibility(View.INVISIBLE);
                text_abt.setVisibility(View.VISIBLE);
                text_abt.setText(edit_abt.getText().toString());
                btn_done.setVisibility(View.GONE);
            }
        });

        return view;
    }
}