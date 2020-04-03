package com.bokor.bt_mathoperation.Activity.Symbol_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_your_lesson;
import com.bokor.bt_mathoperation.Lesson_learn.Learn;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Div_class extends AppCompatActivity {

    ImageView back_div,alert;
    LinearLayout rl_play,rl_practice;
    TranslateAnimation transAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div_class);
        alert=findViewById(R.id.alert);
        time_alert();

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
        back_div = findViewById(R.id.back_div);
        back_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
//                back_div.startAnimation(animFadein);
            }
        });
    }

    public void time_alert(){
        transAnim = new TranslateAnimation(0, 0, 0,
                35);
        transAnim.setStartOffset(0);
        transAnim.setDuration(2000);
        transAnim.setRepeatCount(1999999999);
        transAnim.setFillAfter(true);
        transAnim.setInterpolator(new BounceInterpolator());
        transAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                alert.clearAnimation();
                final int left = alert.getLeft();
                final int top = alert.getTop();
                final int right = alert.getRight();
                final int bottom = alert.getBottom();
                alert.layout(left, top, right, bottom);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        alert.startAnimation(transAnim);
    }

    @Override
    public void onBackPressed() {
        finish();
//        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
