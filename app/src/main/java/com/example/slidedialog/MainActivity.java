package com.example.slidedialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Animation animationSlideIn;
    Animation animationSlideOut;
    LinearLayout panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animationSlideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in);
        animationSlideOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out);

        panel = findViewById(R.id.panel);

        panel.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.startAnimation(animationSlideIn);
                panel.setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panel.startAnimation(animationSlideOut);
                panel.setVisibility(View.GONE);
            }
        });
    }
}