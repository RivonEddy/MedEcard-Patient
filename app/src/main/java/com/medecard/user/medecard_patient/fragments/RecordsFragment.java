package com.medecard.user.medecard_patient.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.medecard.user.medecard_patient.HealthTipsActivity;
import com.medecard.user.medecard_patient.R;
import com.medecard.user.medecard_patient.adapters.RecyclerViewAdapter_Records;
import com.medecard.user.medecard_patient.models.Records;

import java.util.ArrayList;
import java.util.List;

public class RecordsFragment extends Fragment {

    private RecyclerView myrecyclerview;
    private List<Records> listRecords;

    ImageView imageView;
    Intent intent;
    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public static RecordsFragment newInstance() {
        RecordsFragment fragment = new RecordsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listRecords = new ArrayList<>();

        listRecords.add(new Records("15-04-1982",
                "St Nicholas Hospital, Lagos",
                "Dr Nnamdi Obiakor",
                "Monthly Checkup",
                "Not Started"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_records, container,
                false);

        imageView = (ImageView) view.findViewById(R.id.tips_btn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, HealthTipsActivity.class);
                startActivity(intent);
            }
        });

        myrecyclerview = (RecyclerView) view.findViewById(R.id.records_recyclerview);
        RecyclerViewAdapter_Records recyclerViewAdapterRecords = new RecyclerViewAdapter_Records(getContext(), listRecords);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapterRecords);

        return view;
    }
}