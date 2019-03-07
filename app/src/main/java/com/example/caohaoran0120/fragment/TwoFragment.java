package com.example.caohaoran0120.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.caohaoran0120.R;
import com.example.caohaoran0120.adapter.MyLeftAdapter;
import com.example.caohaoran0120.adapter.MyRightAdapter;
import com.example.caohaoran0120.bean.HomeBean;
import com.example.caohaoran0120.bean.RightBean;
import com.example.caohaoran0120.presenter.ShowPresenter;

import java.util.List;

public class TwoFragment extends Fragment {
    private RecyclerView right, left_cey;
    private MyRightAdapter myRightAdapter;
    private ShowPresenter showPresenter;
    private MyLeftAdapter myLeftAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.two_layout, container, false);
        left_cey = view.findViewById(R.id.left_cey);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        left_cey.setLayoutManager(linearLayoutManager);
       right = view.findViewById(R.id.right_cey);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        right.setLayoutManager(gridLayoutManager);
        showPresenter = new ShowPresenter(this);
        showPresenter.getLeftModelData();
        showPresenter.getRightModelData("1");
        return view;
    }
    public void getLeftData(Object oj){
        final HomeBean homeBean= (HomeBean) oj;
        Log.i( "getLeftData: ",oj.toString());
        myLeftAdapter = new MyLeftAdapter(getActivity(), homeBean);
        myLeftAdapter.setOnLeftOncliklinsener(new MyLeftAdapter.LeftOnclicklinsenner() {
            @Override
            public void dianji(int i, List<HomeBean.DataBean> dataBeanList) {
                showPresenter.getRightModelData(dataBeanList.get(i).getCid());
                myRightAdapter.notifyDataSetChanged();
            }
        });
        left_cey.setAdapter(myLeftAdapter);

    }
    public void getRightData(Object oj){
       RightBean rightBean= (RightBean) oj;
        myRightAdapter = new MyRightAdapter(getActivity(), rightBean);
        right.setAdapter(myRightAdapter);

    }
    //防止内存泄漏
    @Override
    public void onDestroy() {
        super.onDestroy();
        showPresenter.ondestroy();
    }
}
