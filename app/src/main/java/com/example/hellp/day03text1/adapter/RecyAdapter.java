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
import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter {
    List<MeiBean.ResultsBean> list;
    Context mContext;

    public RecyAdapter(List<MeiBean.ResultsBean> list, Context context) {
        this.list = list;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        if (i == 1){
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_item1,null);
            holder = new Holder1(view);
        }
        if (i == 2){
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_item2,null);
            holder = new Holder2(view);
        }
        if (i == 3){
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_item3,null);
            holder = new Holder3(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == 1){
            Holder1 holder1 = (Holder1) viewHolder;
            holder1.tv.setText(list.get(i).getDesc());
            holder1.tv2.setText(list.get(i).getDesc());
            Glide.with(mContext).load(list.get(i).getUrl()).into(holder1.iv);
            Glide.with(mContext).load(list.get(i).getUrl()).into(holder1.iv2);
        }
        if (itemViewType == 2){
            Holder2 holder2 = (Holder2) viewHolder;
            holder2.tv.setText(list.get(i).getDesc());
            Glide.with(mContext).load(list.get(i).getUrl()).into(holder2.iv);
        }
        if (itemViewType == 3){
            Holder3 holder3 = (Holder3) viewHolder;
            holder3.tv.setText(list.get(i).getDesc());
            Glide.with(mContext).load(list.get(i).getUrl()).into(holder3.iv);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder1 extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        ImageView iv2;
        TextView tv2;
        public Holder1(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
            iv2 = itemView.findViewById(R.id.iv2);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
    class Holder2 extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public Holder2(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }
    class Holder3 extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public Holder3(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position %3 == 0){
            return 1;
        }
        if (position %3 == 1){
            return 2;
        }
        return 3;
    }
}
