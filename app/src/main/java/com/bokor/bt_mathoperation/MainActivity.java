package com.bokor.bt_mathoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_click,btn_click2,btn_click3,btn_click4,btn_click5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            }
        });
        btn_click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp2.start();
            }
        });
        btn_click3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp3.start();
            }
        });
        btn_click4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp4.start();
            }
        });
        btn_click5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp5.start();
            }
        });
    }
}
