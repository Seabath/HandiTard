package com.example.sebas.handitard.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.sebas.handitard.R;

public class EclairageActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eclairage);
        new Thread(){
            @Override
            public void run() {
                try {
                    sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        finish();
                    }
                });
            }
        }.start();
    }
}
