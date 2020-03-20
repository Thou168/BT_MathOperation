package com.bokor.bt_mathoperation.Splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Splashscreen extends AppCompatActivity {

    ImageView logo;
    ProgressBar splashProgress;
    static int splashTimeOut=4500;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
//        logo=(ImageView)findViewById(R.id.logo);
        splashProgress = findViewById(R.id.splashProgress);
        splashProgress.getProgressDrawable().setColorFilter(Color.BLACK, android.graphics.PorterDuff.Mode.SRC_IN);
        playProgress();
//
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent i = new Intent(Splashscreen.this, Home_Activity.class);
//                startActivity(i);
//                finish();
//            }
//        },splashTimeOut);
//

        final ImageView splashImageView = findViewById(R.id.logo);
        splashImageView.setBackgroundResource(R.drawable.splash);
        final AnimationDrawable frameAnimation = (AnimationDrawable)splashImageView.getBackground();
        Thread timer= new Thread(){
            public void run(){
                try{
                    Animation myanim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mysplashanimation);
                    splashImageView.startAnimation(myanim);
                    sleep(4500);
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
                frameAnimation.start();
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
