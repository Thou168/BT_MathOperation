package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Fraction;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Frac.Learn_Frac_4;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_fraction_4 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView txt_yg_ban,txt_jomnam;

    TextView num1_top,num1_bot,num2_top,num2_bot,num3_top,num3_bot;
    MediaPlayer lesson_frac4,letstart = new MediaPlayer();
    String getSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_fraction_2);
        getSound = getIntent().getStringExtra("soundbackstop");
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letStart();
                startActivity(new Intent(Lets_start_fraction_4.this, Learn_Frac_4.class));
                finish();
            }
        });
        img_back=findViewById(R.id.img_back);
        PushDownAnim.setPushDownAnimTo(img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        sound=findViewById(R.id.sounds);
        PushDownAnim.setPushDownAnimTo(sound).setScale( MODE_SCALE, 0.89f  ) .setOnClickListener(new View.OnClickListener() {
            private boolean isPlaying = false;
            @Override
            public void onClick(View view) {
                if(isPlaying) {
                    sound.setImageResource(R.drawable.sound_on);
                    isPlaying=false;
                    sound();
                } else {
                    sound.setImageResource(R.drawable.sound_off);
                    isPlaying=true;
                    stopPlaying();
                }
            }
        });
    }
    private void id(){
        txt_yg_ban=findViewById(R.id.txt_yerng_ban);
        txt_yg_ban.setText(R.string.fraction_add2);
        txt_jomnam=findViewById(R.id.txt_jomnam);

        num1_top=findViewById(R.id.first_q);
        num1_top.setText("2");
        num2_top=findViewById(R.id.second_q);
        num2_top.setText("1");
        num3_top=findViewById(R.id.result_q);
        num3_top.setText("1");
        TextView subview = findViewById(R.id.symbol);
        subview.setText("-");

        txt_jomnam.setText("ដើម្បីដកប្រភាគដែលមានភាគបែងដូចគ្នា យើងត្រូវដកភាគយកនឹងភាគយក រីឯភាគបែង\u200Bរក្សាទុកនៅដដែល។");
    }

    private void letStart(){
        letstart=MediaPlayer.create(this, R.raw.let_startgame);
        letstart.start();
    }

    private void sound(){
        stopPlaying();
        lesson_frac4=MediaPlayer.create(this, R.raw.fraction_4_sipar);
        lesson_frac4.start();
    }

    private void stopPlaying() {
        if (lesson_frac4 != null) {
            lesson_frac4.stop();
            lesson_frac4.release();
            lesson_frac4 = null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getSound!=null){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
//                    sound();
                }
            }, 6000);
        } else {
            sound();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlaying();
    }

    @Override
    public void onBackPressed() {
        stopPlaying();
        finish();
    }
}
