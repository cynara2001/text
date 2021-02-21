package com.example.keepaccount.adapter;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.keepaccount.R;
import com.example.keepaccount.database.dao.AccountDao;
import com.example.keepaccount.database.domain.Account;

import java.util.List;

public class AccountListAdapter extends BaseAdapter {


    private final Context context;
    private final List<Account> accountList;

    public AccountListAdapter(Context context, List<Account> accountList) {
    this.context = context;
    this.accountList = accountList;
    }

    @Override
    public int getCount() {
        return accountList.size();
    }

    @Override
    public Object getItem(int position) {
        return accountList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return accountList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            convertView=View.inflate(context, R.layout.expend_item,null);
        }

        TextView tvSum = convertView.findViewById(R.id.tv_sum);
        TextView tvRemark = convertView.findViewById(R.id.tv_remarks);


        tvSum.setText(accountList.get(position).getSum()+"");
        tvRemark.setText(accountList.get(position).getRemark());
        return convertView;
    }
}
