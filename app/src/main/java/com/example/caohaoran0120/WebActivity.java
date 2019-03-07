package com.example.caohaoran0120;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.example.caohaoran0120.adapter.MyRightAdapter;
import com.example.caohaoran0120.bean.RightBean;
import com.example.caohaoran0120.presenter.ShowPresenter;

public class WebActivity extends AppCompatActivity {

    private WebView web;
    private Button btn_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        web =findViewById(R.id.web);
        btn_web = findViewById(R.id.btn_web);
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(WebActivity.this)
                        .setTitle("Android调用JS中的CallJs效果")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                web.loadUrl("http://www.zhaoapi.cn/product/getProductCatagory?cid=2");
                            }
                        }).show();

            }
        });
    }
    public void getXiangData(Object oj){
        RightBean rightBean= (RightBean) oj;
        ShowPresenter showPresenter = new ShowPresenter(this);
        showPresenter.getXiangModelData("1");


    }
}
