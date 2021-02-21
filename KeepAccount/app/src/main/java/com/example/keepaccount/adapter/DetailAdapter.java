package com.example.keepaccount.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.keepaccount.R;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailViewHolder> {

    private Context mContext;

    //private List<String> list;//传入一个列表数据，再通过构造方法

    public DetailAdapter(Context context){
        //写它的构造方法，给mContext赋值
        this.mContext = context;
    }

    @NonNull
    @Override
    public DetailAdapter.DetailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new DetailViewHolder(LayoutInflater.from(mContext).inflate(R.layout.expend_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DetailAdapter.DetailViewHolder holder, int position) {
        holder.textView.setText("sum");
    }

    @Override
    public int getItemCount() {
        return 30;//写死的30 //return list；
    }

    //Adapter里面有一个泛型，所以要在这里再写一个类

    class DetailViewHolder extends RecyclerView.ViewHolder{

        //把布局里的控件给它声明一下
        private TextView textView;

        public DetailViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_sum);
        }
    }
}

