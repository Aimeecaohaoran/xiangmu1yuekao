package com.example.caohaoran0120.model;

import android.util.Log;

import com.example.caohaoran0120.bean.HomeBean;
import com.example.caohaoran0120.bean.RightBean;
import com.example.caohaoran0120.okhttp.HttpUtils;

public class ShowModel implements IShowModel{
    @Override
    public void getLeftData(String url, final GetLeftCallBack getLeftCallBack) {
        HttpUtils.getInstance().doGet(url, HomeBean.class, new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(Object oj) {
                getLeftCallBack.succ(oj);
                Log.i( "onSuccess: ",oj.toString());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }

    @Override
    public void getRightData(String url, final GetRightCallBack getRightCallBack) {
       HttpUtils.getInstance().doGet(url, RightBean.class, new HttpUtils.NetCallBack() {
           @Override
           public void onSuccess(Object oj) {
               getRightCallBack.succ(oj);
           }

           @Override
           public void onFailure(Exception e) {

           }
       });
    }

    @Override
    public void getXiangData(String url, final GetXiangCallBack getXiangCallBack) {
        HttpUtils.getInstance().doGet(url, RightBean.class, new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(Object oj) {
                getXiangCallBack.succ(oj);
                Log.i("onSuccess: ",oj.toString());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}
