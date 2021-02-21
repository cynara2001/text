package com.example.keepaccount.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.keepaccount.R;

public class MainActivity extends AppCompatActivity {

    private Button mBtnDetail;//先声明控件
    private Button mBtnAccount;
    private Button mBtnMine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//在活动中加载了activity_main布局
        mBtnDetail = (Button) findViewById(R.id.button_1);
        mBtnAccount = (Button) findViewById(R.id.button_3);
        mBtnMine = (Button) findViewById(R.id.button_4);
        setListeners();

    }

    private void setListeners() {
        //在这里设置它的监听事件
        OnClick onClick = new OnClick();
        mBtnDetail.setOnClickListener(onClick);
        mBtnAccount.setOnClickListener(onClick);
        mBtnMine.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.button_1:
                    //跳转到Detail（账目明细）演示界面
                    intent = new Intent(MainActivity.this, DetailActivity.class);
                    break;
                case R.id.button_3:
                    //跳转到Account（记账页）演示界面
                    intent = new Intent(MainActivity.this, AccountActivity.class);
                    break;
                case R.id.button_4:
                    //跳转到Mine（我的）演示界面
                    intent = new Intent(MainActivity.this, MineActivity.class);
                    break;
            }
            startActivity(intent);
        }

    }
}
