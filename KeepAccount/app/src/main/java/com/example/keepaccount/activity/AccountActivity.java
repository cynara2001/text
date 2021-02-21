package com.example.keepaccount.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.keepaccount.R;
import com.example.keepaccount.adapter.AccountListAdapter;
import com.example.keepaccount.database.dao.AccountDao;
import com.example.keepaccount.database.domain.Account;

import java.util.List;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView mAccountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        //初始化控件
        initUI();
        //初始化数据
        initData();
    }

    private void initData() {
        AccountDao accountDao = AccountDao.getInstance(getApplicationContext());
        List<Account> accountList = accountDao.findAll();
        AccountListAdapter adapter = new AccountListAdapter(getApplicationContext(), accountList);
        mAccountList.setAdapter(adapter);
    }

    private void initUI() {
        mAccountList = findViewById(R.id.lv_account_list);
        findViewById(R.id.btn_add).setOnClickListener(this);
        findViewById(R.id.btn_delete).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                showAlertDialog();
                break;
            case R.id.btn_delete:
                deleteDatabase();
                break;
        }
    }

    private void deleteDatabase() {
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        AlertDialog alertDialog = builder.create();
        View view = View.inflate(getApplicationContext(), R.layout.account_dialog, null);
        alertDialog.setView(view);
        alertDialog.show();

        EditText etSum = view.findViewById(R.id.et_sum);
        EditText etRemark = view.findViewById(R.id.et_remark);

        view.findViewById(R.id.btn_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = Integer.parseInt(etSum.getText().toString());
                String remark = etRemark.getText().toString();

                String fall1 = "金额 或 内容/备注 都要输入哦！";
                String fall2 = "金额 或 内容/备注 过长了哦！";

                //如果其中一个等于零的话，我们就不让它往下走
                if (sum == 0 || remark.length() == 0) {
                    Toast.makeText(getApplicationContext(), fall1, Toast.LENGTH_SHORT).show();
                    return;
                }
                if (sum > 1000 || remark.length() > 30) {
                    Toast.makeText(getApplicationContext(), fall2, Toast.LENGTH_SHORT).show();
                    return;
                }

                //保存到数据库
                save2db(sum, remark);

                alertDialog.dismiss();
            }

        });

        view.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
    }

    private void save2db(int sum, String remark) {
        AccountDao accountDao = AccountDao.getInstance(getApplicationContext());
        Account account = new Account(sum, remark);
        accountDao.insert(account);

        initData();
    }
}













