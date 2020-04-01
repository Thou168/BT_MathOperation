package com.bokor.bt_mathoperation.Activity.Symbol_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_your_lesson;
import com.bokor.bt_mathoperation.Lesson_learn.Learn;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Mul_class extends AppCompatActivity {

    ImageView back_mul;
    LinearLayout rl_play,rl_practice,rl_quiz,rl_duel,rl_learn,rl_test,rl_exam,rl_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_class);
        rl_play = findViewById(R.id.relativelayout_lesson);
        PushDownAnim.setPushDownAnimTo(rl_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_play.startAnimation(animFadein);

                startActivity(new Intent(getApplicationContext(), Select_your_lesson.class));
            }
        });
        rl_practice=findViewById(R.id.relativelayout_game);
        PushDownAnim.setPushDownAnimTo(rl_practice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_practice.startAnimation(animFadein);

                startActivity(new Intent(getApplicationContext(), Learn.class));
            }
        });
        back_mul=findViewById(R.id.back_mul);
        back_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                back_mul.startAnimation(animFadein);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
