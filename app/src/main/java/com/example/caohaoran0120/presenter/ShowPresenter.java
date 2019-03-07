package com.example.caohaoran0120.presenter;

import android.webkit.WebView;

import com.example.caohaoran0120.WebActivity;
import com.example.caohaoran0120.fragment.TwoFragment;
import com.example.caohaoran0120.model.IShowModel;
import com.example.caohaoran0120.model.ShowModel;

public class ShowPresenter implements IShowPresenter {
  private ShowModel showModel;
  private TwoFragment twoFragment;
    WebActivity webActivity;

    public ShowPresenter(TwoFragment twoFragment) {
        this.twoFragment = twoFragment;
        showModel = new ShowModel();
    }
    public ShowPresenter(WebActivity webActivity) {
        this.webActivity = webActivity;
        showModel = new ShowModel();
    }

    @Override
    public void getLeftModelData() {
        showModel.getLeftData("http://www.zhaoapi.cn/product/getCatagory", new IShowModel.GetLeftCallBack() {
            @Override
            public void succ(Object oj) {
                twoFragment.getLeftData(oj);
            }
        });

    }

    @Override
    public void getRightModelData(String cid) {
     showModel.getRightData("http://www.zhaoapi.cn/product/getProductCatagory"+"?cid="+cid, new IShowModel.GetRightCallBack() {
         @Override
         public void succ(Object oj) {
   twoFragment.getRightData(oj);
         }
     });
    }

    @Override
    public void getXiangModelData(String cid) {
        showModel.getXiangData("http://www.zhaoapi.cn/product/getProductCatagory" + "?cid=" + cid, new IShowModel.GetXiangCallBack() {
            @Override
            public void succ(Object oj) {
                webActivity.getXiangData(oj);
            }
        });
    }

    public void ondestroy(){
        if (twoFragment!=null){
            twoFragment=null;
        }
    }
}
