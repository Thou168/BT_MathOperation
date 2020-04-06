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
import android.widget.TextView;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Activity.Start_Up;
import com.bokor.bt_mathoperation.R;

import java.util.Timer;
import java.util.TimerTask;

public class Splashscreen extends AppCompatActivity {
    private Timer timer;
    private int i=0;
    TextView progress_view;
    ProgressBar splashProgress;
    static int splashTimeOut=3000;
    private AnimationDrawable animationDrawable;
    ImageView splashImageView,change_pc;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        progress_view=findViewById(R.id.textView);
        progress_view.setText("");
        splashProgress = findViewById(R.id.splashProgress);
        splashProgress.setProgress(0);
//        splashProgress.getProgressDrawable().setColorFilter(Color.WHITE, android.graphics.PorterDuff.Mode.SRC_IN);
//        final long period = 100;
//        timer=new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                //this repeats every 100 ms
//                if (i<100){
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            progress_view.setText(String.valueOf(i)+"%");
//                        }
//                    });
//                    splashProgress.setProgress(i);
//                    i++;
//                }else{
//                    //closing the timer
//                    timer.cancel();
//                    Intent intent =new Intent(Splashscreen.this,Start_Up.class);
//                    startActivity(intent);
//                    // close this activity
//                    finish();
//                }
//            }
//        }, 0, period);

        playProgress();
        change_pc = findViewById(R.id.change_pic);
        animation = AnimationUtils.loadAnimation(this, R.anim.button_click);
        change_pc.startAnimation(animation);
        Thread timer= new Thread(){
            public void run(){
                try{
                    sleep(splashTimeOut);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally {
                    Intent splash =new Intent(getApplicationContext(), Start_Up.class);
                    startActivity(splash);
                    finish();
                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void playProgress() {
        ObjectAnimator.ofInt(splashProgress, "progress", 100)
                .setDuration(3500)
                .start();
    }

}
