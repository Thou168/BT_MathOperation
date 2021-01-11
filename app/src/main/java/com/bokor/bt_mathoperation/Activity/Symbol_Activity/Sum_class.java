package com.bokor.bt_mathoperation.Activity.Symbol_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_your_lesson;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Sub.Learn_Sub;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Sum_class extends AppCompatActivity {

    ImageView back_sum,alert;
    LinearLayout rl_play,rl_practice;
    TranslateAnimation transAnim;
    SharedPreferences preferences;
    SharedPreferences.Editor preferences_ed;
    MediaPlayer playgame_sound,learning_sound = new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum_class);
        alert=findViewById(R.id.alert);
        ViewFlipper simpleViewFlipper = findViewById(R.id.flipper);
        Animation in = AnimationUtils.loadAnimation(this, R.anim.bounce);
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setAutoStart(true);

        rl_play = findViewById(R.id.relativelayout_lesson);
        PushDownAnim.setPushDownAnimTo(rl_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                learning_sound();
                startActivity(new Intent(getApplicationContext(), Select_your_lesson.class));
            }
        });
        rl_practice=findViewById(R.id.relativelayout_game);
        PushDownAnim.setPushDownAnimTo(rl_practice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playgame_sound();
                clear_sum();
                Intent intent = new Intent(getApplicationContext(), Learn_1.class);
                intent.putExtra("sample_add", "addition");
                intent.putExtra("getBack","show");
                startActivity(intent);
            }
        });

        back_sum=findViewById(R.id.back_sum);
        PushDownAnim.setPushDownAnimTo(back_sum).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void playgame_sound(){
        playgame_sound=MediaPlayer.create(this, R.raw.games_play_sound);
        playgame_sound.start();
    }

    private void learning_sound(){
        learning_sound=MediaPlayer.create(this, R.raw.learning_game);
        learning_sound.start();
    }

    public void clear_sum(){
        preferences = getSharedPreferences("Game_add", MODE_PRIVATE);
        preferences_ed = preferences.edit();
        preferences_ed.clear();
        preferences_ed.apply();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
