package com.bokor.bt_mathoperation.Fragment_lesson.Weight;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Weight.Change_scale_from_kilogram_to_gram;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Weight.Lets_start_weight;
import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_2;
import com.bokor.bt_mathoperation.Fragment_lesson.Frac.Learn_Frac_2;
import com.bokor.bt_mathoperation.Fragment_lesson.Frac.Learn_Frac_4;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Learn_weight_3 extends AppCompatActivity {
    TextView txt_ask;
    ImageView img_change;
    ImageView img_change_new;
    TextView txt_level_current;
    int level_plus = 1;
    int status=1;
    TextView current_lv1,current_lv2,current_lv3,current_lv4;
    Random random;

    ImageView img_back;
    ImageView previous,next;
    Button btn1,btn2,btn3,btn4;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    GifImageView gifImageView;
    TextView num_result,answer;
    EmojiRainLayout container;

    Vibrator vibe;
    MediaPlayer mp1,game_over,ask,stop_sound,yes_sound,no_sound;
    Bundle extras;
    String userName;
    //second dialog alert
    String userBack;
    SharedPreferences preferences;
    RelativeLayout rl_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_kilogram);
        extras = getIntent().getExtras();
        if (extras!=null){
            userName = extras.getString("sample_weight");
            userBack = extras.getString("to_lv_3");
        }
        rl_main = findViewById(R.id.rl_main);
        rl_main.setVisibility(View.GONE);

        txt_ask=findViewById(R.id.txt_ask);
        txt_ask.setTextSize(20);
        img_change=findViewById(R.id.img_change);
        img_change.setVisibility(View.GONE);
        img_change_new=findViewById(R.id.img_change_new);
        img_change_new.setVisibility(View.GONE);
        current_lv1=findViewById(R.id.current_level1);
        current_lv2=findViewById(R.id.current_level2);
        current_lv3=findViewById(R.id.current_level3);
        current_lv4=findViewById(R.id.current_level4);

        txt_level_current=findViewById(R.id.txt_level_current);


        img_back=findViewById(R.id.img_back);
        previous=findViewById(R.id.img_previous);
        next=findViewById(R.id.img_next);
        PushDownAnim.setPushDownAnimTo(img_back,previous,next).setScale(PushDownAnim.MODE_SCALE,0.80f);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                if (userName!=null || userBack!=null){
                    if (level_plus==1){
                        Intent i = new Intent(getApplicationContext(), Learn_weight_2.class);
                        i.putExtra("to_lv_2","to2");
                        i.putExtra("to_2", 2);
                        startActivity(i);
                        finish();

                        SharedPreferences sp = getSharedPreferences("Game_weight", Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("your_lv_3", 3);
                        editor.apply();
                    }else {
                        level_plus--;
                    }
                }else {
                    level_plus--;
                }
                showNextQuiz();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                if (userBack!=null){
                    if (level_plus<4){
                        level_plus++;
                    }else {
                        nextAction();
                    }
                }else {
                    preferences = getSharedPreferences("Game_weight",Context.MODE_PRIVATE);
                    if (preferences.getInt("level_current_weight_4", 1) > 0) {
                        if (level_plus==4) {
                            nextAction();
                        }
                    }
                    level_plus++;
                    Log.d("current 3", String.valueOf(preferences.getInt("level_current_weight_4",1)));
                }
                showNextQuiz();
            }
        });
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        btn1.setTextSize(28);
        btn2.setTextSize(28);
        btn3.setTextSize(28);
        btn4.setTextSize(28);
        PushDownAnim.setPushDownAnimTo(btn1,btn2,btn3,btn4).setScale(PushDownAnim.MODE_SCALE,0.89f);
        ImageView img_hand = findViewById(R.id.img_hand);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_scale_animation);
        animation2.setInterpolator(new LinearInterpolator());
        img_hand.startAnimation(animation2);
        img_hand.setVisibility(View.VISIBLE);

        container=findViewById(R.id.container);

        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (userBack!=null){
            level_plus=4;
        }
        showNextQuiz();
    }
    private void showNextQuiz(){
        extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("sample_weight");
            if (userName != null || userBack!=null) {
                //text current level
                preferences = getSharedPreferences("Game_weight", Context.MODE_PRIVATE);
                preferences.getInt("level_current_weight_3", 1);
                status = preferences.getInt("level_current_weight_3",1);
                Log.d("status action 3", String.valueOf(status));

                previous.setVisibility(View.VISIBLE);
                if (level_plus==status){
                    next.setVisibility(View.INVISIBLE);
                    if (userBack != null) {
                        next.setVisibility(View.VISIBLE);
                    }
                }else next.setVisibility(View.VISIBLE);

                current_lv1.setText("9");
                current_lv2.setText("10");
                current_lv3.setText("11");
                current_lv4.setText("12");
                if (level_plus==1){
                    current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 9");
                }else if (level_plus==2){
                    current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 10");
                }else if (level_plus==3){
                    current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 11");
                }else if (level_plus==4){
                    current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 12");
                    if (userBack!=null){
                        current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
                        current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
                        current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
                        current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
                    }
                    if (level_plus==4) {
                        if (preferences.getInt("your_lv_4", 0)==4) {
                            next.setVisibility(View.VISIBLE);
                        }
                    }
                }
            }
        }else {
            txt_level_current.setText("កម្រិត "+level_plus);
            current_lv1.setText("1");
            current_lv2.setText("2");
            current_lv3.setText("3");
            current_lv4.setText("4");
            //previous and next
            if (level_plus>1){
                previous.setVisibility(View.VISIBLE);
            }else previous.setVisibility(View.INVISIBLE);

            if (level_plus==status){
                next.setVisibility(View.INVISIBLE);
            }else next.setVisibility(View.VISIBLE);
        }

        if (level_plus==1){
            current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
            current_lv2.setBackground(getDrawable(R.drawable.gradient_level_not_complete));
            current_lv3.setBackground(getDrawable(R.drawable.gradient_level_not_complete));
            current_lv4.setBackground(getDrawable(R.drawable.gradient_level_not_complete));
        }else if (level_plus==2){
            current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
            current_lv3.setBackground(getDrawable(R.drawable.gradient_level_not_complete));
            current_lv4.setBackground(getDrawable(R.drawable.gradient_level_not_complete));
        }else if (level_plus==3){
            current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
            current_lv4.setBackground(getDrawable(R.drawable.gradient_level_not_complete));
        }else if (level_plus==4){
            current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
        }

        if (level_plus==1){
            ask=MediaPlayer.create(this,R.raw.weight_3_e1_sipar);
            ask.start();
            txt_ask.setText("តើ85គីឡូក្រាម ស្មើនឹងប៉ុន្មានក្រាម?");

            //btn
            btn1.setText("8ក");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("85000ក");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                }
            });
            btn3.setText("85ក");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("850ក");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==2){
            ask=MediaPlayer.create(this,R.raw.weight_3_e2_sipar);
            ask.start();
            txt_ask.setText("តើ0.31គីឡូក្រាម ស្មើនឹងប៉ុន្មានក្រាម?");

            //btn
            btn1.setText("310ក");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                }
            });
            btn2.setText("3.1ក");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("31ក");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("3100ក");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==3){
            ask=MediaPlayer.create(this,R.raw.weight_3_e3_sipar);
            ask.start();
            txt_ask.setText("តើ12គ.ក 200ក ស្មើនឹងប៉ុន្មានក្រាម?");
            //btn
            btn1.setText("10200ក");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("12220ក");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("12200ក");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                }
            });
            btn4.setText("21200ក");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==4){
            ask=MediaPlayer.create(this,R.raw.weight_3_e4_sipar);
            ask.start();
            txt_ask.setText("មីងសនទិញសាច់គោ2គ.ក និង500ក និងសាច់មាន់ 3គ.ក។ តើមីងសនទិញសាច់ទាំងអស់ទម្ងន់ប៉ុន្មានគ.ក?");

            //btn
            btn1.setText("3គក​50ក");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("5គ.ក");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("5000ក");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("5គក500ក");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_weight");
                        if (userName!=null || userBack!=null){
                            showAlertDialogPositive();
                        }
                    }else {
                        showAlertDialogEnd();
                    }
                }
            });

        }
    }

    public void Save() {
        if (userName!=null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("level_current_weight_3", status);
            editor.apply();
            System.out.println("Save = " + editor.putInt("level_current_weight_3", status));
        }
    }

    private void surprise_wrong(){
        stopPlaying();
        game_over=MediaPlayer.create(this,R.raw.game_over);
        game_over.start();

        container.stopDropping();
        showAlertDialogNegative();
        vibe.vibrate(200);
    }

    private void surprise_true(){
        stopPlaying();
        mp1=MediaPlayer.create(this, R.raw.hand_clap);
        mp1.start();

        //transition rain dialog win
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(2000);
        TransitionManager.beginDelayedTransition(container,autoTransition);
    }

    private void stop_play(){
        stopPlaying();
        stop_sound=MediaPlayer.create(this, R.raw.stop_play);
        stop_sound.start();
    }

    private void yes_sound(){
//        yes_sound=MediaPlayer.create(this, R.raw.yes_sound);
//        yes_sound.start();
    }
    private void no_sound(){
        no_sound=MediaPlayer.create(this, R.raw.no_sound);
        no_sound.start();
    }

    private void stopPlaying() {
        if (mp1 != null) {
            mp1.stop();
            mp1.release();
            mp1 = null;
        }else if(game_over != null) {
            game_over.stop();
            game_over.release();
            game_over = null;
        }else if(ask != null) {
            ask.stop();
            ask.release();
            ask = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlaying();
    }

    @Override
    public void onBackPressed() {
        stopPlaying();
        stop_play();
        final Dialog dialogBuilder = new Dialog(Learn_weight_3.this,R.style.CustomDialog);
        dialogBuilder.setContentView(R.layout.layout_dialog_alert);
        Button no = dialogBuilder.findViewById(R.id.no);
        Button yes = dialogBuilder.findViewById(R.id.yes);
        PushDownAnim.setPushDownAnimTo(no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                yes_sound();
                if (userName!=null){
                    finish();
                }else {
                    Intent intent = new Intent(Learn_weight_3.this, Change_scale_from_kilogram_to_gram.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("soundbackstop", "sound");
                    startActivity(intent);
                }
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                no_sound();
                dialogBuilder.cancel();
            }
        });
        dialogBuilder.show();
    }

    private void showAlertDialogNegative() {
        dialogBuilder = new AlertDialog.Builder(Learn_weight_3.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_new_fail, null);
        ImageView dialogButtonNegative = layoutView.findViewById(R.id.btnDialogNegative);
        ImageView home = layoutView.findViewById(R.id.home);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setView(layoutView);
//        dialogBuilder.setCancelable(false);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowFalse;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        PushDownAnim.setPushDownAnimTo(dialogButtonNegative).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                bk_normal();
                showNextQuiz();
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                startActivity(new Intent(Learn_weight_3.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();
        dialogBuilder = new AlertDialog.Builder(Learn_weight_3.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_new, null);
        ImageView dialogButtonPositive = layoutView.findViewById(R.id.btnDialogPositive);
        ImageView home = layoutView.findViewById(R.id.home);
        ImageView again = layoutView.findViewById(R.id.again);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
//        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(dialogButtonPositive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                if (level_plus!=4) {
                    if (level_plus==status){
                        status++;
                    }
                    Save();
                    level_plus++;
                    Log.d("status level", String.valueOf(status));
                    Log.d("current level", String.valueOf(level_plus));
                    showNextQuiz();
                    bk_normal();
                }else {
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_weight");
                        if (userName != null || userBack!=null) {
                            nextAction();
                        }
                    }
                }
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                startActivity(new Intent(Learn_weight_3.this, Home_Activity.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                bk_normal();
                showNextQuiz();
                alertDialog.cancel();
            }
        });
    }

    private void nextAction(){
        Intent intent = new Intent(getApplicationContext(), Learn_weight_4.class);
        intent.putExtra("sample_weight", "learn_weight3");
        startActivity(intent);
        finish();
    }

    private void showAlertDialogEnd() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn_weight_3.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView txt_exit_lv = layoutView.findViewById(R.id.txt_level_exit);
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេមមេរៀន");
        TextView lesson_exit_lv = layoutView.findViewById(R.id.lesson_level_exit);
        lesson_exit_lv.setText("ការប្តូរខ្នាតពី គីឡូក្រាម ទៅ ក្រាម");
        TextView con = layoutView.findViewById(R.id.con);
        TextView back = layoutView.findViewById(R.id.back);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setView(layoutView);
//        dialogBuilder.setCancelable(false);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(con).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                startActivity(new Intent(Learn_weight_3.this, Learn_weight_4.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                startActivity(new Intent(Learn_weight_3.this, Home_Activity.class));
                finish();
            }
        });
    }

    private void bk_normal(){
        container.stopDropping();
    }

}
