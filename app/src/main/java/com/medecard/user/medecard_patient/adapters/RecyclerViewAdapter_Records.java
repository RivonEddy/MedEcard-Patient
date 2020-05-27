package com.medecard.user.medecard_patient.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medecard.user.medecard_patient.R;
import com.medecard.user.medecard_patient.ViewRecordsActivity;
import com.medecard.user.medecard_patient.models.Records;

import java.util.List;

public class RecyclerViewAdapter_Records extends RecyclerView
        .Adapter<RecyclerViewAdapter_Records.MyViewHolder> {

    Intent intent;

    Context mContext;
    List<Records> mData;

    public RecyclerViewAdapter_Records(Context mContext, List<Records> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.recycler_records, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.recycler_recs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(mContext, ViewRecordsActivity.class);
                mContext.startActivity(intent);
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_date.setText(mData.get(i).getDate());
        myViewHolder.tv_hosp_location.setText(mData.get(i).getHosp_location());
        myViewHolder.tv_doctor_name.setText(mData.get(i).getDoctor_name());
        myViewHolder.tv_record_type.setText(mData.get(i).getRecord_type());
        myViewHolder.tv_record_status.setText(mData.get(i).getRecord_status());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout recycler_recs;
        private TextView tv_date;
        private TextView tv_hosp_location;
        private TextView tv_doctor_name;
        private TextView tv_record_type;
        private TextView tv_record_status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recycler_recs = (LinearLayout) itemView.findViewById(R.id
                    .recycler_recs);
            tv_date = (TextView) itemView.findViewById(R.id.rec_date);
            tv_hosp_location = (TextView) itemView.findViewById(R.id.rec_address);
            tv_doctor_name = (TextView) itemView.findViewById(R.id.rec_doc_name);
            tv_record_type = (TextView) itemView.findViewById(R.id.rec_record_type);
            tv_record_status = (TextView) itemView.findViewById(R.id.rec_record_status);

        }
    }

}
