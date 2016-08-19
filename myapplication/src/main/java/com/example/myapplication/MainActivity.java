package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    GameView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(GameView) findViewById(R.id.view);
        view.setMaxValue(180);
        view.setMinValue(0);
        view.setValue(50);
    }
}
