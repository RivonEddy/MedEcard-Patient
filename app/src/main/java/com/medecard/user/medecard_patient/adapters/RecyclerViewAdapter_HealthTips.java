package com.medecard.user.medecard_patient.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medecard.user.medecard_patient.R;
import com.medecard.user.medecard_patient.ViewTipsActivity;
import com.medecard.user.medecard_patient.models.HealthTips;

import java.util.List;

public class RecyclerViewAdapter_HealthTips extends RecyclerView
        .Adapter<RecyclerViewAdapter_HealthTips.MyViewHolder> {

    Intent intent;

    Context mContext;
    List<HealthTips> mData;

    public RecyclerViewAdapter_HealthTips(Context mContext, List<HealthTips> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.recycler_health_tips, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.recycler_ht.setOnClickListener(v1 -> {
            intent = new Intent(mContext, ViewTipsActivity.class);
            mContext.startActivity(intent);
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tip_pic.setImageResource(mData.get(i).getTips_pic());
        myViewHolder.tip_desc.setText(mData.get(i).getTips_desc());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout recycler_ht;
        private ImageView tip_pic;
        private TextView tip_desc;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recycler_ht = (LinearLayout) itemView.findViewById(R.id
                    .recycler_health_tips);
            tip_pic = (ImageView) itemView.findViewById(R.id.tips_pic);
            tip_desc = (TextView) itemView.findViewById(R.id.tips_desc);

        }
    }

}
