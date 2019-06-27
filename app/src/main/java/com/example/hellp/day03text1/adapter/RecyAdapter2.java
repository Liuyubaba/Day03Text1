package com.example.hellp.day03text1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hellp.day03text1.R;
import com.example.hellp.day03text1.bean.MeiBean;

import java.util.ArrayList;

public class RecyAdapter2 extends RecyclerView.Adapter<RecyAdapter2.Holder> {
    ArrayList<MeiBean.ResultsBean> list;
    Context mContext;

    public RecyAdapter2(ArrayList<MeiBean.ResultsBean> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.layout_item5, null);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
        holder.tv.setText(list.get(i).getDesc());
        holder.tv2.setText(list.get(i).get_id());
        Glide.with(mContext).load(list.get(i).getUrl()).into(holder.iv);
        Glide.with(mContext).load(list.get(i).getUrl()).into(holder.iv2);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        ImageView iv2;
        TextView tv2;
        public Holder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            iv2 = itemView.findViewById(R.id.iv2);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}
