package com.dreamliner.loadingsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sq580.lib.loading.LoadingDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoadingDialog.newInstance(this, "登录中...", false);
    }
}
