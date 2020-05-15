package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Add;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Sum_class;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Multiply_Two_digit_and_one_digit_numbers extends AppCompatActivity {

    TextView start;
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    MediaPlayer mediaPlayer,mediaPlayer2;
    boolean isPlaying = false;
    int choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_lesson);
        mediaPlayer=MediaPlayer.create(this,R.raw.plus_first);
        mediaPlayer2=MediaPlayer.create(this,R.raw.plus_second);
        start=findViewById(R.id.start);
//        start.setOutlineProvider(new ZoftinoCustomOutlineProvider(8));
//        start.setClipToOutline(true);
//        TextView textView = (TextView) findViewById(R.id.shadow_txt);
//        textView.setOutlineProvider(new ZoftinoCustomOutlineProvider(10));
//        textView.setClipToOutline(true);
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Multiply_Two_digit_and_one_digit_numbers.this, Learn_1.class);
                intent.putExtra("choice", 2);
                startActivity(intent);

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
//                    }else if (mediaPlayer2.isPlaying()){
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

    @Override
    public void onBackPressed() {
        finish();
    }
}
