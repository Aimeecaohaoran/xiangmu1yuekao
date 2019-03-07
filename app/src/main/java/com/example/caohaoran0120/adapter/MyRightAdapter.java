package com.example.caohaoran0120.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.caohaoran0120.R;
import com.example.caohaoran0120.WebActivity;
import com.example.caohaoran0120.bean.HomeBean;
import com.example.caohaoran0120.bean.RightBean;

import java.util.List;

public class MyRightAdapter extends RecyclerView.Adapter<MyRightAdapter.MyRightViewHolder> {
    private Context context;
    private RightBean rightBean;
    private MyRightViewHolder myRightViewHolder;

    public MyRightAdapter(Context context, RightBean rightBean) {
        this.context = context;
        this.rightBean = rightBean;
    }

    @NonNull
    @Override
    public MyRightViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.layout_list, null);
        myRightViewHolder = new MyRightViewHolder(view);
        return myRightViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRightViewHolder myRightViewHolder, final int i) {
    myRightViewHolder.title.setText(rightBean.getData().get(i).getList().get(i).getName());
    myRightViewHolder.price.setText(rightBean.getData().get(i).getList().get(i).getPcid()+"");
        Glide.with(context).load(rightBean.getData().get(i).getList().get(i).getIcon()).into(myRightViewHolder.image);
        myRightViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               context.startActivity(new Intent(context,WebActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return rightBean.getData().size();
    }

    public class MyRightViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView title,price;
        public MyRightViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.image);

        }
    }
    private MyRightAdapter.RightOnclicklinsenner rightOnclicklinsenner;

    public void setOnRightOncliklinsener(MyRightAdapter.RightOnclicklinsenner rightOnclicklinsenner) {
        this.rightOnclicklinsenner = rightOnclicklinsenner;
    }
    public interface RightOnclicklinsenner{
        void tiaozhuan(int i,String cid);
    }

}
