package com.bokor.bt_mathoperation.Fragment_lesson.Deci;

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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Capacity.Lets_start_capacity;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Decimal.Lets_start_decimal;
import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Capa.Learn_capa_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Capa.Learn_capa_2;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Learn_Decimal_1 extends AppCompatActivity {
    TextView txt_top,txt_bot,result;
    TextView txt_ask;
    TextView txt_new;
    LinearLayout ln_view;
    RelativeLayout rl;
    TableLayout table_1,table_2;
    TextView first_second,below_second;
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
    RelativeLayout btn1_rl,btn2_rl,btn3_rl,btn4_rl;
    //second dialog alert
    String userBack;
    //second dialog alert
    SharedPreferences preferences;
    SharedPreferences.Editor preferences_ed;
    int backSave;
    String getBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_decimal);
        getBack = getIntent().getStringExtra("getBack");
        extras = getIntent().getExtras();
        if (extras!=null){
            userBack = extras.getString("to_lv_1");
            backSave = extras.getInt("to_1",0);
        }

        txt_ask=findViewById(R.id.txt_ask);
        txt_top=findViewById(R.id.first_q);
        txt_bot=findViewById(R.id.first_below);
        result=findViewById(R.id.result);
        txt_new=findViewById(R.id.show_question);
        first_second=findViewById(R.id.first_second);
        below_second=findViewById(R.id.first_second_below);

        table_1=findViewById(R.id.table_1);
        table_2=findViewById(R.id.table_2);
        //relative button
        btn1_rl=findViewById(R.id.btn_1_r);
        btn2_rl=findViewById(R.id.btn_2_r);
        btn3_rl=findViewById(R.id.btn_3_r);
        btn4_rl=findViewById(R.id.btn_4_r);
        PushDownAnim.setPushDownAnimTo(btn1_rl,btn2_rl,btn3_rl,btn4_rl).setScale(PushDownAnim.MODE_SCALE,0.80f);

        rl=findViewById(R.id.rl);
        ln_view=findViewById(R.id.ln_view_1);
//        txt_ask.setText("ចូរជ្រើសរើសចម្លើយដែលត្រឹមត្រូវ:");
        current_lv1=findViewById(R.id.current_level1);
        current_lv2=findViewById(R.id.current_level2);
        current_lv3=findViewById(R.id.current_level3);
        current_lv4=findViewById(R.id.current_level4);
        //text current level
        current_lv1.setText("1");
        current_lv2.setText("2");
        current_lv3.setText("3");
        current_lv4.setText("4");

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
                level_plus--;
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
                    level_plus++;
                }
                showNextQuiz();
            }
        });
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
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
        preferences = getSharedPreferences("Game_deci", Context.MODE_PRIVATE);
        preferences.getInt("level_current_deci_1", 0);

        txt_level_current.setText("កម្រិត "+level_plus);
        result.setText("??");
        txt_ask.setTextSize(18f);
        rl.setVisibility(View.GONE);
//        txt_ask.setText("ចូរជ្រើសរើសចំនួនទសភាគភាគដប់ដែលត្រឹមត្រូវ:");

        if (level_plus>1){
            previous.setVisibility(View.VISIBLE);
        }else previous.setVisibility(View.INVISIBLE);

        if (level_plus==status){
            next.setVisibility(View.INVISIBLE);
            if (userBack!=null){
                next.setVisibility(View.VISIBLE);
            }
        }else next.setVisibility(View.VISIBLE);

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
            if (userBack!=null){
                current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
                current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
                current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
                current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
            }
        }

        if (level_plus==1){
            ask=MediaPlayer.create(this,R.raw.decimal_1_e1_sipar);
            ask.start();
//            txt_ask.setText("5/10=_____");
            txt_top.setText("5");
            txt_bot.setText("10");
            txt_ask.setText("ចូរជ្រើសរើសចំនួនទសភាគដែលមានតម្លៃស្មើនឹង៖");
            ln_view.setVisibility(View.VISIBLE);
            rl.setVisibility(View.GONE);
            table_2.setVisibility(View.VISIBLE);
            table_1.setVisibility(View.GONE);

            //btn
            btn1.setText("0.25");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("0.5");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    result.setText("0.5");
                    showAlertDialogPositive();
                }
            });
            btn3.setText("0.51");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("0.510");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==2){
            ask=MediaPlayer.create(this,R.raw.decimal_1_e2_sipar);
            ask.start();
//            txt_ask.setText("2/10=_____");
            txt_new.setText("0.2 =");
            first_second.setVisibility(View.INVISIBLE);
            below_second.setVisibility(View.INVISIBLE);
            table_2.setVisibility(View.GONE);
            table_1.setVisibility(View.VISIBLE);
            first_second.setText("2");
            below_second.setText("10");
            txt_ask.setText("ចូរជ្រើសរើសប្រភាគដែលមានតម្លៃស្មើ៖");
            rl.setVisibility(View.VISIBLE);
            ln_view.setVisibility(View.GONE);
            //btn
            btn1_rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    first_second.setVisibility(View.VISIBLE);
                    below_second.setVisibility(View.VISIBLE);
                    showAlertDialogPositive();
                }
            });
            btn2_rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3_rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4_rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==3){
            ask=MediaPlayer.create(this,R.raw.decimal_1_e3_sipar);
            ask.start();
//            txt_ask.setText("8/10=_____");
            txt_top.setText("8");
            txt_bot.setText("10");
            txt_ask.setText("ចូរជ្រើសរើសចំនួនទសភាគដែលមានតម្លៃស្មើ៖");
            ln_view.setVisibility(View.VISIBLE);
            rl.setVisibility(View.GONE);
            table_2.setVisibility(View.VISIBLE);
            table_1.setVisibility(View.GONE);
            //btn
            btn1.setText("0.85");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("0.7");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("0.8");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    result.setText("0.8");
                    showAlertDialogPositive();
                }
            });
            btn4.setText("0.88");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==4){
            ask=MediaPlayer.create(this,R.raw.decimal_1_e4_sipar);
            ask.start();
//            txt_ask.setText("1/10=_____");
            txt_top.setText("1");
            txt_bot.setText("10");
            txt_ask.setText("ចូរជ្រើសរើសចំនួនទសភាគដែលមានតម្លៃស្មើ៖");
            ln_view.setVisibility(View.VISIBLE);
            rl.setVisibility(View.GONE);
            table_2.setVisibility(View.VISIBLE);
            table_1.setVisibility(View.GONE);
            //btn
            btn1.setText("0.4");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("0.9");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("0.01");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("0.1");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    result.setText("0.1");
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_deci");
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
        yes_sound=MediaPlayer.create(this, R.raw.yes_sound);
        yes_sound.start();
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
        final Dialog dialogBuilder = new Dialog(Learn_Decimal_1.this,R.style.CustomDialog);
        dialogBuilder.setContentView(R.layout.layout_dialog_alert);
        Button no = dialogBuilder.findViewById(R.id.no);
        Button yes = dialogBuilder.findViewById(R.id.yes);
        PushDownAnim.setPushDownAnimTo(no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                yes_sound();
                //back play sound
                if (getBack!=null){
                    finish();
                } else {
                    Intent intent = new Intent(Learn_Decimal_1.this, Lets_start_decimal.class);
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
        dialogBuilder = new AlertDialog.Builder(Learn_Decimal_1.this);
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
                startActivity(new Intent(Learn_Decimal_1.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();
        dialogBuilder = new AlertDialog.Builder(Learn_Decimal_1.this);
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
                    level_plus++;
                    Log.d("status level", String.valueOf(status));
                    Log.d("current level", String.valueOf(level_plus));
                    showNextQuiz();
                    bk_normal();
                }else {
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_deci");
                        nextAction();
                    }
                }
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                startActivity(new Intent(Learn_Decimal_1.this, Home_Activity.class));
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
        if (userName != null || userBack != null) {
            Intent intent = new Intent(getApplicationContext(), Learn_Decimal_2.class);
            intent.putExtra("sample_deci", "learn_deci1");
            intent.putExtra("to_2_back",backSave);
            intent.putExtra("to_2",backSave);
            startActivity(intent);
            finish();
        }
    }
    private void showAlertDialogEnd() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn_Decimal_1.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView txt_exit_lv = layoutView.findViewById(R.id.txt_level_exit);
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេមមេរៀន");
        TextView lesson_exit_lv = layoutView.findViewById(R.id.lesson_level_exit);
        lesson_exit_lv.setText("ចំនួនទសភាគ ភាគដប់");
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
                startActivity(new Intent(Learn_Decimal_1.this, Learn_Decimal_2.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                startActivity(new Intent(Learn_Decimal_1.this, Home_Activity.class));
                finish();
            }
        });
    }

    private void bk_normal(){
        container.stopDropping();
    }

}
