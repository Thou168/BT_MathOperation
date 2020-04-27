package com.bokor.bt_mathoperation.Fragment_lesson.Sub;

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
import android.os.Vibrator;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_2;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import pl.droidsonroids.gif.GifImageView;

public class Learn_Sub extends AppCompatActivity {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_sub);

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
        ImageView img_hand = findViewById(R.id.img_hand);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_scale_animation);
        animation2.setInterpolator(new LinearInterpolator());
        img_hand.startAnimation(animation2);
        img_hand.setVisibility(View.VISIBLE);

        container=findViewById(R.id.container);
        mp1=MediaPlayer.create(this, R.raw.hand_clap);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        PushDownAnim.setPushDownAnimTo(btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialogPositive();
                btn1.setBackground(getDrawable(R.drawable.button_state_sound));

            }
        });
        PushDownAnim.setPushDownAnimTo(btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                surprise_true();
                surprise_wrong();
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
        num_result.setText("?");

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
        final Dialog dialogBuilder = new Dialog(Learn_Sub.this,R.style.CustomDialog);
        dialogBuilder.setContentView(R.layout.layout_dialog_alert);
        Button no = dialogBuilder.findViewById(R.id.no);
        Button yes = dialogBuilder.findViewById(R.id.yes);
        PushDownAnim.setPushDownAnimTo(no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder.cancel();
            }
        });
        dialogBuilder.show();
    }

    private void showAlertDialogNegative() {
        dialogBuilder = new AlertDialog.Builder(Learn_Sub.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_new_fail, null);
        ImageButton dialogButtonNegative = layoutView.findViewById(R.id.btnDialogNegative);
        ImageButton home = layoutView.findViewById(R.id.home);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowFalse;
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
                Toast.makeText(Learn_Sub.this,"Home",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Learn_Sub.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn_Sub.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_new, null);
        ImageButton dialogButtonPositive = layoutView.findViewById(R.id.btnDialogPositive);
        ImageButton home = layoutView.findViewById(R.id.home);
        ImageButton again = layoutView.findViewById(R.id.again);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(dialogButtonPositive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Sub.this, Learn_2.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Learn_Sub.this,"Home",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Learn_Sub.this, Home_Activity.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Learn_Sub.this,"Again",Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
                btn2.setBackground(getDrawable(R.drawable.button_state_info));
            }
        });
    }
}
