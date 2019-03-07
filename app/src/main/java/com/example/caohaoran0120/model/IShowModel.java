package com.example.caohaoran0120.model;

public interface IShowModel {
    void getLeftData(String url,GetLeftCallBack getLeftCallBack);
     interface GetLeftCallBack{
        void succ(Object oj);
    }
    void getRightData(String url,GetRightCallBack getRightCallBack);
     interface GetRightCallBack{
        void succ(Object oj);
    }
    void getXiangData(String url,GetXiangCallBack getXiangCallBack);
    interface GetXiangCallBack{
        void succ(Object oj);
    }
}
