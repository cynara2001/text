package com.example.keepaccount.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.keepaccount.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnLogin;
    private Button mBtnRegister;
    private EditText mEtUserName;
    private EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //第一步，找到控件
        initView();

        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);
    }


    //这个方法我们用来找到对应的控件
    private void initView() {
        mEtUserName = findViewById(R.id.et_1);
        mEtPassword = findViewById(R.id.et_2);
        mBtnLogin = findViewById(R.id.btn_login);
        mBtnRegister = findViewById(R.id.btn_register);
    }


    public void onClick(View v) {
        //需要获取输入的用户名和密码
        String username = mEtUserName.getText().toString();
        String password = mEtPassword.getText().toString();
        //弹出内容设置
        String ok = "登陆成功！";
        String fall = "账号或密码有误，请重新登录！";
        Intent intent = null;

        //假设正确的账号和密码分别是cy,123456
        switch (v.getId()) {
            case R.id.btn_register:
                //跳转到注册演示界面
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                finish();
                break;
            case R.id.btn_login:
                if (username.equals("cy") && password.equals("123456")) {
                    Toast.makeText(getApplicationContext(), ok, Toast.LENGTH_SHORT).show();
                    //如果正确的话进行跳转
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    //如果不正确的话,弹出登陆失败的Toast
                    Toast.makeText(getApplicationContext(), fall, Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

}
