package com.dreamliner.loadingsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.sq580.lib.loading.LoadingDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.test_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadingDialog.newInstance(MainActivity.this, "获取支付信息中...", true);
            }
        });
    }
}
