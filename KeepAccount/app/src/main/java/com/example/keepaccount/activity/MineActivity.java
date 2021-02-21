package com.example.keepaccount.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.keepaccount.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MineActivity extends AppCompatActivity {

    private String url = "https://v1.alapi.cn/api/eventHitory";
    private EditText tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        tvRes = findViewById(R.id.et_res);
        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get();
            }
        });
    }

    /**
     * 异步get请求
     */
    private void get() {

        //第一步获取okHttpClient对象
        OkHttpClient client = new OkHttpClient.Builder()
                .build();
        //第二步构建Request对象
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        //第三步构建Call对象
        Call call = client.newCall(request);
        //第四步，异步get请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("ttit", e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Looper.prepare();
                //得到子线程
                String result = response.body().string();
                Log.e("ttit", result);
                tvRes.setText(result);
            }
        });
    }
}