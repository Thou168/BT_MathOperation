package com.bokor.bt_mathoperation.Splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.R;

public class Splashscreen extends AppCompatActivity {

    ProgressBar splashProgress;
    static int splashTimeOut=4500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        splashProgress = findViewById(R.id.splashProgress);
        splashProgress.getProgressDrawable().setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN);
        playProgress();

        final ImageView splashImageView = findViewById(R.id.logo_splash);
//        splashImageView.setBackgroundResource(R.drawable.splash_screen);
//        final AnimationDrawable frameAnimation = (AnimationDrawable)splashImageView.getBackground();
        Thread timer= new Thread(){
            public void run(){
                try{
                    Animation myanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mysplashanimation);
                    splashImageView.startAnimation(myanim);
                    sleep(splashTimeOut);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent splash =new Intent(getApplicationContext(),Home_Activity.class);
                    startActivity(splash);
                }
            }
        };
        timer.start();
        splashImageView.post(new Runnable(){
            @Override
            public void run() {
//                frameAnimation.start();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                .setDuration(5000)
                .start();
    }

}
