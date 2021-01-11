package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Sub;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Sub.Learn_Sub;
import com.bokor.bt_mathoperation.Fragment_lesson.Sub.Learn_Sub_3;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_sub_3 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView example,carry_on,top_num,bottom_num,answer,txt_explain_T,txt_explain_B,such_as;
    TextView two_char_top,two_char_bot,one_char_top,one_char_bot,two_ans,one_ans;
    MediaPlayer lesson_sub3,letstart = new MediaPlayer();
    String getSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_sub_1);
        getSound = getIntent().getStringExtra("soundbackstop");
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letStart();
                startActivity(new Intent(Lets_start_sub_3.this, Learn_Sub_3.class));
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
        PushDownAnim.setPushDownAnimTo(sound).setScale( MODE_SCALE, 0.89f  ).setOnClickListener(new View.OnClickListener() {
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

    private void letStart(){
        letstart=MediaPlayer.create(this, R.raw.let_startgame);
        letstart.start();
    }

    private void sound(){
        stopPlaying();
        lesson_sub3=MediaPlayer.create(this, R.raw.subtraction_3_sipar);
        lesson_sub3.start();
    }

    private void stopPlaying() {
        if (lesson_sub3 != null) {
            lesson_sub3.stop();
            lesson_sub3.release();
            lesson_sub3 = null;
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

    private void id(){
        example=findViewById(R.id.example);
        example.setText("ឧទាហរណ៍ ៖ 65 - 21 = ?");
        carry_on=findViewById(R.id.carry_on);
//        carry_on.setVisibility(View.VISIBLE);
        top_num=findViewById(R.id.top_num);
        top_num.setText("65");
        bottom_num=findViewById(R.id.bottom_num);
        bottom_num.setText("21");
        answer=findViewById(R.id.answer);
        answer.setText("44");
        txt_explain_T=findViewById(R.id.txt_explain_top);
        txt_explain_T.setText("5 ដក 1 នៅសល់ 4 សរសេរលេខ 4");
        txt_explain_B=findViewById(R.id.txt_explain_bottom);
        txt_explain_B.setText("6 ដក 2 នៅសល់ 4 សរសេរលេខ 4");
        such_as=findViewById(R.id.such_as);
        such_as.setText("ដូចនេះ 65 - 21 = 44");

        //box
        two_char_top=findViewById(R.id.two_char_top);
        two_char_top.setText("6");
        two_char_bot=findViewById(R.id.two_char_bot);
        two_char_bot.setText("2");
        two_char_bot.setVisibility(View.VISIBLE);
        one_char_top=findViewById(R.id.one_char_top);
        one_char_top.setText("5");
        one_char_bot=findViewById(R.id.one_char_bot);
        one_char_bot.setText("1");
        two_ans=findViewById(R.id.two_ans);
        two_ans.setText("4");
        one_ans=findViewById(R.id.one_ans);
        one_ans.setText("4");
    }

    @Override
    public void onBackPressed() {
        stopPlaying();
        finish();
    }
}
