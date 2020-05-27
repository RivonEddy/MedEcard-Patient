package com.medecard.user.medecard_patient.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.medecard.user.medecard_patient.R;
import com.medecard.user.medecard_patient.models.Sharing;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter_Sharing extends RecyclerView.Adapter<RecyclerViewAdapter_Sharing.MyViewHolder> {

    Context mContext;
    List<Sharing> mData;

    public RecyclerViewAdapter_Sharing(Context mContext, List<Sharing> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.recycler_share, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.civ_doc_img.setImageResource(mData.get(i).getDoc_pic());
        myViewHolder.tv_doc_name.setText(mData.get(i).getDoc_name());
        myViewHolder.tv_hosp_location.setText(mData.get(i).getHosp_address());
        myViewHolder.tv_date.setText(mData.get(i).getDate());
        myViewHolder.btn_exp.setImageResource(mData.get(i).getExp_btn());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView civ_doc_img;
        private TextView tv_doc_name;
        private TextView tv_hosp_location;
        private TextView tv_date;
        private ImageView btn_exp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            civ_doc_img = (CircleImageView) itemView.findViewById(R.id.shr_doc_img);
            tv_doc_name = (TextView) itemView.findViewById(R.id.shr_doc_name);
            tv_hosp_location = (TextView) itemView.findViewById(R.id.shr_hosp_address);
            tv_date = (TextView) itemView.findViewById(R.id.shr_date);
            btn_exp = (ImageView) itemView.findViewById(R.id.shr_exp_btn);

        }
    }
}
