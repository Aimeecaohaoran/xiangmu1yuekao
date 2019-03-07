package com.example.caohaoran0120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.caohaoran0120.R;
import com.example.caohaoran0120.bean.HomeBean;

import java.util.List;

public class MyLeftAdapter extends RecyclerView.Adapter<MyLeftAdapter.MyLeftViewHolder> {
    private Context context;
    private HomeBean homeBean;
    private MyLeftViewHolder myLeftViewHolder;

    public MyLeftAdapter(Context context, HomeBean homeBean) {
        this.context = context;
        this.homeBean = homeBean;
    }
 private LeftOnclicklinsenner leftOnclicklinsenner;

    public void setOnLeftOncliklinsener(LeftOnclicklinsenner leftOnclicklinsenner) {
        this.leftOnclicklinsenner = leftOnclicklinsenner;
    }

    @NonNull
    @Override
    public MyLeftViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.left_layout, null);
        myLeftViewHolder = new MyLeftViewHolder(view);
        return myLeftViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyLeftViewHolder myLeftViewHolder, final int i) {
        myLeftViewHolder.text.setText(homeBean.getData().get(i).getName());
        myLeftViewHolder.text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                List<HomeBean.DataBean> list = homeBean.getData();
                leftOnclicklinsenner.dianji(i,list);
            }
        });
    }

    @Override
    public int getItemCount() {
        return homeBean.getData().size();
    }

    public class MyLeftViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public MyLeftViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text_left);
        }
    }
    public interface LeftOnclicklinsenner{
        void dianji(int i,List<HomeBean.DataBean> dataBeanList);
    }

}
