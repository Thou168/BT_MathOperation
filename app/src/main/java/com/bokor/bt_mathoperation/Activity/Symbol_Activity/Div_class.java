package com.bokor.bt_mathoperation.Activity.Symbol_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bokor.bt_mathoperation.Difficulty.Difficulty;
import com.bokor.bt_mathoperation.List_Lesson.List_Lesson;
import com.bokor.bt_mathoperation.R;

public class Div_class extends AppCompatActivity {

    ImageView back_div;
    RelativeLayout rl_play,rl_practice,rl_quiz,rl_duel,rl_learn,rl_test,rl_exam,rl_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div_class);
        rl_play = findViewById(R.id.rl_play);
        rl_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                rl_play.startAnimation(animFadein);

                startActivity(new Intent(getApplicationContext(), List_Lesson.class));
            }
        });
        rl_practice=findViewById(R.id.rl_practice);
        rl_practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                rl_practice.startAnimation(animFadein);

                startActivity(new Intent(getApplicationContext(), List_Lesson.class));
            }
        });
//        rl_quiz = findViewById(R.id.rl_Quiz);
//        rl_quiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_quiz.startAnimation(animFadein);
//            }
//        });
//        rl_duel=findViewById(R.id.rl_duel);
//        rl_duel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_duel.startAnimation(animFadein);
//            }
//        });
//        rl_learn = findViewById(R.id.rl_learn);
//        rl_learn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_learn.startAnimation(animFadein);
//            }
//        });
//        rl_test=findViewById(R.id.rl_test);
//        rl_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_test.startAnimation(animFadein);
//            }
//        });
//        rl_exam = findViewById(R.id.rl_exam);
//        rl_exam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_exam.startAnimation(animFadein);
//            }
//        });
//        rl_time=findViewById(R.id.rl_time);
//        rl_time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_time.startAnimation(animFadein);
//            }
//        });
//
        back_div = findViewById(R.id.back_div);
        back_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                back_div.startAnimation(animFadein);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
