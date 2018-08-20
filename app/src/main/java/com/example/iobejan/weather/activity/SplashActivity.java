package com.example.iobejan.weather.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.example.iobejan.weather.R;
import com.example.iobejan.weather.z_base.BaseCompatActivity;

public class SplashActivity extends BaseCompatActivity{
    @Override
    protected int getActivityLayout() {
        return R.layout.splash_activity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        }, 2000);
    }

    // TODO: 17/08/2018 transition for image view to the next activity (Log in)
}
