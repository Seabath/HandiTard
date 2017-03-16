package com.example.sebas.handitard.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.sebas.handitard.R;
import com.example.sebas.handitard.listener.DoNothingClickListener;

public class EssentielActivity extends AppCompatActivity {

    Button btn_infirmiere;
    Button btn_ouverture;
    Button btn_temp;
    Button btn_eclairage;
    Button btn_tel;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essentiel);

        btn_infirmiere = (Button) findViewById(R.id.btn_infirmière);
        btn_ouverture = (Button) findViewById(R.id.btn_ouverture);
        btn_temp = (Button) findViewById(R.id.btn_temperature);
        btn_eclairage = (Button) findViewById(R.id.btn_eclairage);
        btn_tel = (Button) findViewById(R.id.btn_telephone);

        btn_ouverture.setOnClickListener(new DoNothingClickListener());
        btn_temp.setOnClickListener(new DoNothingClickListener());
        btn_infirmiere.setOnClickListener(new DoNothingClickListener());
        btn_tel.setOnClickListener(new DoNothingClickListener());
        btn_eclairage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EclairageActivity.class);
                startActivity(intent);
            }
        });

        btn_ouverture.setEnabled(false);
        btn_temp.setEnabled(false);
        btn_eclairage.setEnabled(false);
        btn_tel.setEnabled(false);

        new ColorThread().start();
    }


    private class ColorThread extends Thread {
        public void run() {
            try {   //Ceci est dégueu mais osef, c'est pour une appli dégueu
                while (true) {
                    runOnUiThread(new AbleRunnable(btn_infirmiere, false));

                    runOnUiThread(new AbleRunnable(btn_ouverture, true));
                    sleep(2000);
                    runOnUiThread(new AbleRunnable(btn_ouverture, false));

                    runOnUiThread(new AbleRunnable(btn_temp, true));
                    sleep(2000);
                    runOnUiThread(new AbleRunnable(btn_temp, false));

                    runOnUiThread(new AbleRunnable(btn_eclairage, true));
                    sleep(2000);
                    runOnUiThread(new AbleRunnable(btn_eclairage, false));

                    runOnUiThread(new AbleRunnable(btn_tel, true));
                    sleep(2000);
                    runOnUiThread(new AbleRunnable(btn_tel, false));

                    runOnUiThread(new AbleRunnable(btn_infirmiere, true));
                    sleep(2000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class AbleRunnable implements Runnable {

        Button btn;
        boolean b;

        AbleRunnable(Button btn, boolean b) {
            this.btn = btn;
            this.b = b;
        }

        @Override
        public void run() {
            btn.setEnabled(b);
        }
    }
}
