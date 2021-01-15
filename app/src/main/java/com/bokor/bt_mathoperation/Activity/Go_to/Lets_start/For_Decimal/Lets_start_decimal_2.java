package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Decimal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Deci.Learn_Decimal_2;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_decimal_2 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    MediaPlayer mediaPlayer,mediaPlayer2;
    boolean isPlaying = false;

    TextView example,such_as;
    ImageView img;
    RelativeLayout close;
    MediaPlayer lesson_deci2,letstart = new MediaPlayer();
    String getSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_decimal);
        getSound = getIntent().getStringExtra("soundbackstop");
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        mediaPlayer=MediaPlayer.create(this,R.raw.plus_first);
        mediaPlayer2=MediaPlayer.create(this,R.raw.plus_second);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                letStart();
                startActivity(new Intent(Lets_start_decimal_2.this, Learn_Decimal_2.class));
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
        example=findViewById(R.id.example);
        example.setText("ឧទាហរណ៍ ៖ ការ៉េមួយបែងចែកជា១០០ចំណែកស្មើគ្នា។ យើងផាត់ពណ៌តែបីចំណែកតាងដោយ៣ភាគ១០០ ឬ០.០៣។");
        such_as=findViewById(R.id.such_as);
        such_as.setText(R.string.doch_nis_decimal_2);
        img=findViewById(R.id.img);
        img.setImageResource(R.drawable.percentage_decimal_real);
        close = findViewById(R.id.close);
        close.setVisibility(View.GONE);
    }

    private void letStart(){
        letstart=MediaPlayer.create(this, R.raw.let_startgame);
        letstart.start();
    }

    private void sound(){
        stopPlaying();
        lesson_deci2= MediaPlayer.create(this, R.raw.decimal_2_sipar);
        lesson_deci2.start();
    }

    private void stopPlaying() {
        if (lesson_deci2 != null) {
            lesson_deci2.stop();
            lesson_deci2.release();
            lesson_deci2 = null;
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
