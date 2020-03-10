package com.bokor.bt_mathoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_click,btn_click2,btn_click3,btn_click4,btn_click5;
    Button btn_gone;
    Animation fadeout,fadein;
    TextView show_text;
    ViewGroup container;
    boolean visible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_text=findViewById(R.id.show_animation_text);
        fadeout= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        fadein= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        container=findViewById(R.id.transition_container);

        btn_gone = findViewById(R.id.btn_gone);

        btn_click = findViewById(R.id.sound_click);
        btn_click2 = findViewById(R.id.sound_click2);
        btn_click3 = findViewById(R.id.sound_click3);
        btn_click4 = findViewById(R.id.sound_click4);
        btn_click5 = findViewById(R.id.sound_click5);
        final MediaPlayer mp=MediaPlayer.create(this, R.raw.bells001);
        final MediaPlayer mp2=MediaPlayer.create(this, R.raw.bells002);
        final MediaPlayer mp3=MediaPlayer.create(this, R.raw.bells003);
        final MediaPlayer mp4=MediaPlayer.create(this, R.raw.bells004);
        final MediaPlayer mp5=MediaPlayer.create(this, R.raw.bells007);

        btn_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                TransitionManager.beginDelayedTransition(container);
                visible = !visible;
                show_text.setVisibility(visible ? View.VISIBLE: View.VISIBLE);
                show_text.setText("Click to play sound 1!");
            }
        });
        btn_click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
                TransitionManager.beginDelayedTransition(container);
                visible = !visible;
                show_text.setVisibility(visible ? View.VISIBLE: View.VISIBLE);
                show_text.setText("Click to play sound 2!");
            }
        });
        btn_click3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.start();
                TransitionManager.beginDelayedTransition(container);
                visible = !visible;
                show_text.setVisibility(visible ? View.VISIBLE: View.VISIBLE);
                show_text.setText("Click to play sound 3!");
            }
        });
        btn_click4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp4.start();
                TransitionManager.beginDelayedTransition(container);
                visible = !visible;
                show_text.setVisibility(visible ? View.VISIBLE: View.VISIBLE);
                show_text.setText("Click to play sound 4!");
            }
        });
        btn_click5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp5.start();
                TransitionManager.beginDelayedTransition(container);
                visible = !visible;
                show_text.setVisibility(visible ? View.VISIBLE: View.VISIBLE);
                show_text.setText("Click to play sound 5!");
            }
        });

        btn_gone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(container);
                visible = !visible;
                show_text.setVisibility(visible ? View.GONE: View.GONE);
            }
        });
        for_animation_button();
    }

    private void for_animation_button(){
        btn_click.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        view.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        btn_click2.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        view.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        btn_click3.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        view.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        btn_click4.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        view.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });

        btn_click5.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        view.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        view.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        view.getBackground().clearColorFilter();
                        view.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }

    private void animation_for_text(){

    }
}
