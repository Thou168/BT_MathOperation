package com.bokor.bt_mathoperation.Lesson_learn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.List_Lesson.Display.Play_Display;
import com.bokor.bt_mathoperation.R;
import com.google.android.material.tabs.TabLayout;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import pl.droidsonroids.gif.GifImageView;

public class Learn extends AppCompatActivity {

    ImageView img_dif;
    Button btn1,btn2,btn3,btn4;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    GifImageView gifImageView;
    TextView num_result,answer;
    EmojiRainLayout container;

    Vibrator vibe;
    MediaPlayer mp1;
    //second dialog alert
    static final int TIME_OUT = 3000;

    static final int MSG_DISMISS_DIALOG = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn);

        img_dif=findViewById(R.id.img_back);
        PushDownAnim.setPushDownAnimTo(img_dif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_practice.startAnimation(animFadein);

                onBackPressed();
            }
        });
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);

        container=findViewById(R.id.container);
        mp1=MediaPlayer.create(this, R.raw.bells001);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        PushDownAnim.setPushDownAnimTo(btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surprise_wrong();
            }
        });
        PushDownAnim.setPushDownAnimTo(btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                surprise_true();
                showAlertDialogPositive();
            }
        });
        PushDownAnim.setPushDownAnimTo(btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surprise_wrong();
            }
        });
        PushDownAnim.setPushDownAnimTo(btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                surprise_wrong();
            }
        });

        num_result=findViewById(R.id.num_result);
        num_result.setText("?   ?");

        answer=findViewById(R.id.answer);
        answer.setPaintFlags(answer.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);

    }

    private void surprise_wrong(){
        container.stopDropping();
        showAlertDialogNegative();
        vibe.vibrate(200);
    }

    private void surprise_true(){
        mp1.start();

        //transition rain dialog win
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(2000);
        TransitionManager.beginDelayedTransition(container,autoTransition);

        container.addEmoji(R.drawable.star1);
        container.addEmoji(R.drawable.star2);
        container.addEmoji(R.drawable.star3);
        container.addEmoji(R.drawable.star4);
        container.addEmoji(R.drawable.star5);
        container.startDropping();
        //container.stopDropping();
        container.setPer(10);
        container.setDuration(7200);
        container.setDropDuration(2400);
        container.setDropFrequency(500);
        //end
    }

    @Override
    public void onBackPressed() {
        final Dialog dialogBuilder = new Dialog(Learn.this,R.style.DialogTheme);
        dialogBuilder.setContentView(R.layout.layout_dialog_alert);
        Button no = dialogBuilder.findViewById(R.id.no);
        Button yes = dialogBuilder.findViewById(R.id.yes);
        dialogBuilder.setCancelable(false);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder.cancel();
            }
        });
        dialogBuilder.show();
    }

    private void showAlertDialogNegative() {
        dialogBuilder = new AlertDialog.Builder(Learn.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_negative, null);
        Button dialogButtonNegative = layoutView.findViewById(R.id.btnDialogNegative);
        ImageButton home = layoutView.findViewById(R.id.home);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimationFalse;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        PushDownAnim.setPushDownAnimTo(dialogButtonNegative).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Learn.this,"Try again",Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Learn.this,"Home",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Learn.this, Home_Activity.class));
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_positive, null);
        Button dialogButtonPositive = layoutView.findViewById(R.id.btnDialogPositive);
        ImageButton home = layoutView.findViewById(R.id.home);
        ImageButton again = layoutView.findViewById(R.id.again);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimationTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(dialogButtonPositive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Learn.this,"Next step",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Learn.this, Learn_2.class));
                finish();
//                alertDialog.dismiss();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Learn.this,"Home",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Learn.this, Home_Activity.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Learn.this,"Again",Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
            }
        });
    }
    public void timerDelayRemoveDialog(){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                showAlertDialogPositive();
            }
        }, TIME_OUT);
    }

}
