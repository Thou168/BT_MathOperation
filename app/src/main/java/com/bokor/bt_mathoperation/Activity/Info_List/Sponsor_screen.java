package com.bokor.bt_mathoperation.Activity.Info_List;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.R;

public class Sponsor_screen extends AppCompatActivity {
    static int splashTimeOut = 4000;
    LinearLayout ln_View;
    TextView txt_sponsor;
    boolean visible;
    Thread timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor_screen);
        ln_View=findViewById(R.id.ln_view);
        txt_sponsor=findViewById(R.id.sponsor_txt);
        final Animation aniFade = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
//        ln_View.startAnimation(aniFade);
        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(
                this, R.animator.animator);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                float progress = (float) animation.getAnimatedValue();
//                ln_View.setTranslationY(progress);
                txt_sponsor.startAnimation(aniFade);
                ln_View.startAnimation(aniFade);
            }
        });

        valueAnimator.start();

        timer = new Thread() {
            public void run() {
                try {
                    sleep(splashTimeOut);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent splash = new Intent(getApplicationContext(), Home_Activity.class);
                    startActivity(splash);
                    finish();
                }
            }
        };
        timer.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
