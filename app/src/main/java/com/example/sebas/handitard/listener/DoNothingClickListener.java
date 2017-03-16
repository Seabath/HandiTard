package com.example.sebas.handitard.listener;

import android.view.View;
import android.widget.Toast;

public class DoNothingClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), "This does nothing", Toast.LENGTH_SHORT).show();
    }
}
