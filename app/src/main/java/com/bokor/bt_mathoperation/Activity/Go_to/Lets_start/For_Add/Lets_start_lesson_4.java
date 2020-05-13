package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Add;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_4;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_lesson_4 extends AppCompatActivity {

    TextView start;
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    MediaPlayer mediaPlayer,mediaPlayer2;
    boolean isPlaying = false;

    TextView example,carry_on,top_num,bottom_num,answer,txt_explain_T,txt_explain_B,such_as;
    TextView two_char_top,two_char_bot,one_char_top,one_char_bot,two_ans,one_ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_lesson);
        id();

        mediaPlayer=MediaPlayer.create(this,R.raw.plus_first);
        mediaPlayer2=MediaPlayer.create(this,R.raw.plus_second);
        start=findViewById(R.id.start);
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_lesson_4.this, Learn_4.class));
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
            @Override
            public void onClick(View view) {
//                if (isPlaying) {
//                    if (mediaPlayer.isPlaying()) {
//                        mediaPlayer.pause();
//                    }else {
//                        mediaPlayer2.pause();
//                    }
//                    Toast.makeText(getApplicationContext(),"សម្លេងត្រូវបានផ្អាក",Toast.LENGTH_SHORT).show();
//                }else{
//                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                        @Override
//                        public void onCompletion(MediaPlayer mp) {
//                            try {
//                                mediaPlayer2.start();
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//                    try {
//                        mediaPlayer.start();
//                        if (!mediaPlayer.isPlaying()){
//                            mediaPlayer2.start();
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//                isPlaying = !isPlaying;
            }
        });
    }

    private void id(){
        example=findViewById(R.id.example);
        example.setText("ឧទាហរណ៍ ៖ 36 + 48 = ?");
        carry_on=findViewById(R.id.carry_on);
        carry_on.setVisibility(View.VISIBLE);
        top_num=findViewById(R.id.top_num);
        top_num.setText("3​​  6");
        bottom_num=findViewById(R.id.bottom_num);
        bottom_num.setText("4​​  8");
        answer=findViewById(R.id.answer);
        answer.setText("8​​  4");
        txt_explain_T=findViewById(R.id.txt_explain_top);
        txt_explain_T.setText(". 6 បូក 8 ស្មើរនឹង 14 សរសេរលេខ 4 ត្រាទុក 1");
        txt_explain_B=findViewById(R.id.txt_explain_bottom);
        txt_explain_B.setText(". 1 បូក 3 ស្មើរនឹង 4 បូកនឹង 4 ស្មើនឹង 8 សរសេរលេខ 8");
        such_as=findViewById(R.id.such_as);
        such_as.setText("ដូចនេះ 36 + 48 = 84");

        //box
        two_char_top=findViewById(R.id.two_char_top);
        two_char_top.setText("3");
        two_char_bot=findViewById(R.id.two_char_bot);
        two_char_bot.setText("4");
        two_char_bot.setVisibility(View.VISIBLE);
        one_char_top=findViewById(R.id.one_char_top);
        one_char_top.setText("6");
        one_char_bot=findViewById(R.id.one_char_bot);
        one_char_bot.setText("8");
        two_ans=findViewById(R.id.two_ans);
        two_ans.setText("8");
        one_ans=findViewById(R.id.one_ans);
        one_ans.setText("4");
    }
    @Override
    public void onBackPressed() {
        finish();
    }

}
