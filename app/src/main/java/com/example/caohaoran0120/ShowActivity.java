package com.example.caohaoran0120;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.caohaoran0120.fragment.OneFragment;
import com.example.caohaoran0120.fragment.SanFragment;
import com.example.caohaoran0120.fragment.SiFragment;
import com.example.caohaoran0120.fragment.TwoFragment;
import com.example.caohaoran0120.fragment.WuFragment;
import com.hjm.bottomtabbar.BottomTabBar;

public class ShowActivity extends AppCompatActivity {

    private BottomTabBar fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        fragment = findViewById(R.id.fragment);
        fragment.init(getSupportFragmentManager())
                .setImgSize(50,50)
                .setFontSize(16)
                .setTabPadding(4,6,10)
                .setChangeColor(Color.RED,Color.DKGRAY)
                .addTabItem("首页",R.drawable.ufos,OneFragment.class)
                .addTabItem("分类",R.drawable.fangs,TwoFragment.class)
                .addTabItem("发现",R.drawable.ufos,SanFragment.class)
                .addTabItem("购物车",R.drawable.my,SiFragment.class)
                .addTabItem("我的",R.drawable.my,WuFragment.class)
                .isShowDivider(false);
    }
}
