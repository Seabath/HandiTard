package com.example.sebas.handitard.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.sebas.handitard.R;
import com.example.sebas.handitard.listener.DoNothingClickListener;

public class MainActivity extends AppCompatActivity {

    Button btn_essentiel;
    Button btn_loisir;
    Button btn_entourage;
    Button btn_sante;
    Button btn_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_essentiel = (Button) findViewById(R.id.btn_essentiel);
        btn_loisir = (Button) findViewById(R.id.btn_loisir);
        btn_entourage = (Button) findViewById(R.id.btn_entourage);
        btn_sante = (Button) findViewById(R.id.btn_sante);
        btn_tel = (Button) findViewById(R.id.btn_telephone);

        btn_loisir.setOnClickListener(new DoNothingClickListener());
        btn_entourage.setOnClickListener(new DoNothingClickListener());
        btn_sante.setOnClickListener(new DoNothingClickListener());
        btn_tel.setOnClickListener(new DoNothingClickListener());
        btn_essentiel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EssentielActivity.class);
                startActivity(intent);
            }
        });

        btn_loisir.setEnabled(false);
        btn_entourage.setEnabled(false);
        btn_sante.setEnabled(false);
        btn_tel.setEnabled(false);

        new ColorThread().start();
    }


    private class ColorThread extends Thread {
        public void run() {
            try {   //Ceci est dégueu mais osef, c'est pour une appli dégueu
                while (true) {
                    runOnUiThread(new AbleRunnable(btn_essentiel, false));

                    runOnUiThread(new AbleRunnable(btn_entourage, true));
                    sleep(2000);
                    runOnUiThread(new AbleRunnable(btn_entourage, false));

                    runOnUiThread(new AbleRunnable(btn_sante, true));
                    sleep(2000);
                    runOnUiThread(new AbleRunnable(btn_sante, false));

                    runOnUiThread(new AbleRunnable(btn_loisir, true));
                    sleep(2000);
                    runOnUiThread(new AbleRunnable(btn_loisir, false));

                    runOnUiThread(new AbleRunnable(btn_tel, true));
                    sleep(2000);
                    runOnUiThread(new AbleRunnable(btn_tel, false));

                    runOnUiThread(new AbleRunnable(btn_essentiel, true));
                    sleep(2000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class AbleRunnable implements Runnable {

        Button btn;
        boolean b;

        public AbleRunnable(Button btn, boolean b) {
            this.btn = btn;
            this.b = b;
        }

        @Override
        public void run() {
            btn.setEnabled(b);
        }
    }
}
