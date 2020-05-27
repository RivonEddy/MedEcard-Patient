package com.medecard.user.medecard_patient.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.medecard.user.medecard_patient.adapters.RecyclerViewAdapter_Sharing;
import com.medecard.user.medecard_patient.models.Sharing;

import java.util.ArrayList;
import java.util.List;

public class SharingFragment extends Fragment {

        private RecyclerView myrecyclerview;
        private List<Sharing> listSharing;

        ImageView imageView;
        Intent intent;
        private Context context;
        @Override
        public void onAttach(Context context) {
                super.onAttach(context);
                this.context=context;
        }

        public static SharingFragment newInstance() {
                SharingFragment fragment = new SharingFragment();
                return fragment;
        }
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            listSharing = new ArrayList<>();

            listSharing.add(new Sharing(R.drawable.eyes,
                    "Dr Nnamdi Obiakor",
                    "St Nicholas Hospital, Lagos",
                    "Last Access: Sep 20, 2018",
                    R.drawable.ic_share_next_black_24dp));
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
                View view = inflater.inflate(R.layout.fragment_sharing, container,
                false);

                imageView = (ImageView) view.findViewById(R.id.tips_btn);

                imageView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                intent = new Intent(context, HealthTipsActivity.class);
                                startActivity(intent);
                        }
                });

                myrecyclerview = (RecyclerView) view.findViewById(R.id.sharing_recyclerView);
                RecyclerViewAdapter_Sharing recyclerViewAdapterRecords = new
                        RecyclerViewAdapter_Sharing(getContext(), listSharing);
                myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                myrecyclerview.setAdapter(recyclerViewAdapterRecords);

                return view;
        }
}