package com.example.hellp.day03text1.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.hellp.day03text1.R;
import com.example.hellp.day03text1.adapter.RecyAdapter;
import com.example.hellp.day03text1.bean.MeiBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoolFragment extends Fragment {


    private View view;
    private ImageView mIv;
    private RecyclerView mRv;

    public ShoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shool, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mIv = (ImageView) inflate.findViewById(R.id.iv);
        mRv = (RecyclerView) inflate.findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        initData();
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        Request request = new Request.Builder()
                .get()
                .url("https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1")
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(getActivity()).load("https://www.wanandroid.com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png").into(mIv);
                        Gson gson = new GsonBuilder().serializeNulls().create();
                        MeiBean meiBean = gson.fromJson(string, MeiBean.class);
                        List<MeiBean.ResultsBean> results = meiBean.getResults();
                        RecyAdapter recyAdapter = new RecyAdapter(results, getActivity());
                        mRv.setAdapter(recyAdapter);
                    }
                });
            }
        });
    }
}
