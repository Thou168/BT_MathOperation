package com.bokor.bt_mathoperation.Fragment_lesson.Addition;

import androidx.appcompat.app.AppCompatActivity;

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
import android.os.Handler;
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
import android.widget.TextView;
import android.widget.Toast;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Learn_2 extends AppCompatActivity {

    TextView qt_top,qt_bottom,qt_result;
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
    MediaPlayer mp1,game_over;
    Bundle extras;
    String userName;

    String userBack;
    SharedPreferences preferences;
    int backSave,backSaveFrom1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn);
        extras = getIntent().getExtras();
        if (extras!=null){
            userName = extras.getString("sample_add");
            userBack = extras.getString("to_lv_2");
            backSave = extras.getInt("to_2",0);
            backSaveFrom1 = extras.getInt("to_2_back",0);
        }

        Log.d("Two_back", String.valueOf(backSaveFrom1));

        qt_top=findViewById(R.id.num_top);
        qt_bottom=findViewById(R.id.num_bottom);
        qt_result=findViewById(R.id.num_result);

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

                if (userName!=null || userBack!=null){
                    if (level_plus==1){
                        Intent i = new Intent(getApplicationContext(),Learn_1.class);
                        i.putExtra("to_lv_1","to1");
                        i.putExtra("to_1",backSave);
                        startActivity(i);
                        finish();
                    } else {
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
                if (userBack!=null){
                    if (level_plus<4){
                        level_plus++;
                    } else {
                        nextAction();
                    }
                }else {
                    preferences = getSharedPreferences("Game_add",Context.MODE_PRIVATE);
                    if (preferences.getInt("level_current_add_3", 1) > 0) {
                        if (level_plus==4) {
                            nextAction();
                        }
                    }
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

        //sound game
        mp1=MediaPlayer.create(this, R.raw.hand_clap);
        game_over=MediaPlayer.create(this,R.raw.game_over);


        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        if (userBack!=null){
            level_plus=4;
        }
        showNextQuiz();
    }
    private void showNextQuiz(){
        extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("sample_add");
            if (userName != null || userBack!=null) {
                //text current level
                preferences = getSharedPreferences("Game_add", Context.MODE_PRIVATE);
                preferences.getInt("level_current_add_2", 1);
                status = preferences.getInt("level_current_add_2",1);
                Log.d("status action 2", String.valueOf(status));

                previous.setVisibility(View.VISIBLE);
                if (level_plus==status){
                    next.setVisibility(View.INVISIBLE);
                    if (userBack != null) {
                        next.setVisibility(View.VISIBLE);
                    }
                }else {
                    Log.d("123 status", String.valueOf(status));
                    next.setVisibility(View.VISIBLE);
                }
                current_lv1.setText("5");
                current_lv2.setText("6");
                current_lv3.setText("7");
                current_lv4.setText("8");
                if (level_plus==1){
                    current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 5");
                }else if (level_plus==2){
                    current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 6");
                }else if (level_plus==3){
                    current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 7");
                }else if (level_plus==4){
                    current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 8");
                    if (userBack!=null){
                        current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
                        current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
                        current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
                        current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
                    }
                    if (level_plus==4) {
                        if (preferences.getInt("your_lv_3", 0)==3) {
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
        qt_result.setText("??");

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
            qt_top.setText("15");
            qt_bottom.setText("8");

            //btn
            btn1.setText("22");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("23");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                    qt_result.setText("23");
                }
            });
            btn3.setText("24");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("25");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==2){
            qt_top.setText("38");
            qt_bottom.setText("9");

            //btn
            btn1.setText("47");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                    qt_result.setText("47");
                }
            });
            btn2.setText("48");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("49");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("50");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==3){
            qt_top.setText("51");
            qt_bottom.setText("9");

            //btn
            btn1.setText("58");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("59");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("60");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                    qt_result.setText("60");
                }
            });
            btn4.setText("61");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==4){
            qt_top.setText("84");
            qt_bottom.setText("7");

            //btn
            btn1.setText("88");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("89");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("90");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("91");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qt_result.setText("91");
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_add");
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
            editor.putInt("level_current_add_2", status);
            editor.apply();
            System.out.println("Save = " + editor.putInt("level_current_add_2", status));
        }
    }

    private void surprise_wrong(){
        container.stopDropping();
        showAlertDialogNegative();
        vibe.vibrate(200);
        game_over.start();
//        game_over.setLooping(true);
    }

    private void surprise_true(){
        mp1.start();
//        mp1.setLooping(true);

        //transition rain dialog win
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(2000);
        TransitionManager.beginDelayedTransition(container,autoTransition);

    }

    @Override
    public void onBackPressed() {
        final Dialog dialogBuilder = new Dialog(Learn_2.this,R.style.CustomDialog);
        dialogBuilder.setContentView(R.layout.layout_dialog_alert);
        Button no = dialogBuilder.findViewById(R.id.no);
        Button yes = dialogBuilder.findViewById(R.id.yes);
        PushDownAnim.setPushDownAnimTo(no).setScale(PushDownAnim.MODE_SCALE,0.80f).setOnClickListener(new View.OnClickListener() {
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
        dialogBuilder = new AlertDialog.Builder(Learn_2.this);
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
                bk_normal();
                showNextQuiz();
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_2.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();
        dialogBuilder = new AlertDialog.Builder(Learn_2.this);
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
                if (level_plus!=4) {
                    if (level_plus==status){
                        status++;
                        Log.d("view status lv 2: ", String.valueOf(status));
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
                        userName = extras.getString("sample_add");
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
                startActivity(new Intent(Learn_2.this, Home_Activity.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bk_normal();
                showNextQuiz();
                alertDialog.cancel();
            }
        });
    }

    private void nextAction(){
        Intent intent = new Intent(getApplicationContext(), Learn_3.class);
        intent.putExtra("sample_add", "learn2");
        startActivity(intent);
        finish();
    }

    private void showAlertDialogEnd() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn_2.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView txt_exit_lv = layoutView.findViewById(R.id.txt_level_exit);
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេមមេរៀន");
        TextView lesson_exit_lv = layoutView.findViewById(R.id.lesson_level_exit);
        lesson_exit_lv.setText("វិធីបូកលេខពីរខ្ទង់នឹងមួយខ្ទង់មានត្រាទុក");
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេមមេរៀន");
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
                startActivity(new Intent(Learn_2.this, Learn_3.class));
                finish();

            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_2.this, Home_Activity.class));
                finish();
            }
        });
    }

    private void bk_normal(){
        container.stopDropping();
    }
}
