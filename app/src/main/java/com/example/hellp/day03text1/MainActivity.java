package com.example.hellp.day03text1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int time = 5;
    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                if (time > 0) {
                    mTvTime.setText(time-- + "");
                } else {
                    startActivity(new Intent(MainActivity.this,TwoActivity.class));
                    mTimer.cancel();
                    finish();
                }
            }
        }
    };
    /**
     * 欢迎您
     */
    private TextView mTv;
    /**
     * 5
     */
    private TextView mTvTime;
    private Timer mTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTvTime = (TextView) findViewById(R.id.tv_time);
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
            }
        }, 100, 1000);
    }
}
