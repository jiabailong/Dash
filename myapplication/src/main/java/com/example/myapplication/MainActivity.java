package com.example.myapplication;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    GameView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view=(GameView) findViewById(R.id.view);
//        view.setVisibility(View.INVISIBLE);
        view.setMaxValue(180);
        view.setMinValue(0);
        view.setStartRadian(160);
        view.setEndRadian(380);
        view.setValue(120);

//       view.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//               LBWindow lb=new LBWindow(view.getContext());
//            GameView gameView=new GameView(view.getContext());
//               gameView.setMaxValue(180);
//               gameView.setBackgroundColor(Color.argb(0,0,0,0));
//               gameView.setMinValue(0);
//               gameView.setStartRadian(160);
//               gameView.setEndRadian(380);
//               gameView.setValue(120);
//               lb.setWidth(500);
//               lb.setHeight(500);
//               lb.setView(gameView);
//               lb.show();
//           }
//       });

    }
}
