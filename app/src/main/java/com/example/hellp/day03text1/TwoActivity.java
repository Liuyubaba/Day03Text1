package com.example.hellp.day03text1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.hellp.day03text1.adapter.FragmentAdapter;
import com.example.hellp.day03text1.fragment.LikeFragment;
import com.example.hellp.day03text1.fragment.ShoolFragment;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ShoolFragment());
        fragments.add(new LikeFragment());
        ArrayList<String> title = new ArrayList<>();
        title.add("校门");
        title.add("关注");
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), fragments, title);
        mVp.setAdapter(fragmentAdapter);
        mTab.setupWithViewPager(mVp);
    }
}
