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
    ImageView imageView;
    Intent intent;
    TextView textView;
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

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, HealthTipsActivity.class);
                startActivity(intent);
            }
        });

        myrecyclerview = (RecyclerView) view.findViewById(R.id.health_tips_recyclerview);
        RecyclerViewAdapter_HealthTips recyclerViewAdapterRecords = new RecyclerViewAdapter_HealthTips(getContext(),
                listHealthTips);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        myrecyclerview.setAdapter(recyclerViewAdapterRecords);

        return view;
    }
}