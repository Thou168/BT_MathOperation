package com.bokor.bt_mathoperation.Fragment_lesson.Frac;

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

import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_capacity_lesson;
import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_fraction_lesson;
import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_weight_lesson;
import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Div.Learn_Div_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Div.Learn_Div_3;
import com.bokor.bt_mathoperation.Fragment_lesson.Weight.Learn_weight_1;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Learn_Frac_4 extends AppCompatActivity {
    ImageView img_change;
    ImageView img_change_new;
    TextView txt_ask;
    TextView txt_level_current;
    int level_plus = 1;
    int status=1;
    TextView current_lv1,current_lv2,current_lv3,current_lv4;
    Random random;

    ImageView img_back;
    ImageView previous,next;
    RelativeLayout btn1,btn2,btn3,btn4;
    TextView txt_front_1,txt_bot_1,txt_front_2,txt_bot_2;
    TextView btn_1_top,btn_1_bot,btn_2_top,btn_2_bot,btn_3_top,btn_3_bot,btn_4_top,btn_4_bot;
    TextView symbol;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    GifImageView gifImageView;
    TextView num_result,answer;
    EmojiRainLayout container;

    Vibrator vibe;
    MediaPlayer mp1,game_over;
    Bundle extras;
    String userName;
    //second dialog alert
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_relative_frac);
        extras = getIntent().getExtras();
        if (extras!=null){
            userName = extras.getString("sample_frac");
        }

        txt_ask=findViewById(R.id.txt_ask);
        txt_ask.setText("ចូរគណនាការដកប្រភាគខាងក្រោម៖");
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
                if (userName!=null){
                    if (level_plus==1){
                        Intent i = new Intent(getApplicationContext(), Learn_Frac_3.class);
                        i.putExtra("to_lv_3","to3");
                        startActivity(i);
                        finish();

                        SharedPreferences sp = getSharedPreferences("Game_frac", Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putInt("your_lv_4", 4);
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
                level_plus++;
                showNextQuiz();
            }
        });
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);

        //id answer button
        btn_1_top=findViewById(R.id.btn_1_top);
        btn_1_bot=findViewById(R.id.btn_1_bot);
        btn_2_top=findViewById(R.id.btn_2_top);
        btn_2_bot=findViewById(R.id.btn_2_bot);
        btn_3_top=findViewById(R.id.btn_3_top);
        btn_3_bot=findViewById(R.id.btn_3_bot);
        btn_4_top=findViewById(R.id.btn_4_top);
        btn_4_bot=findViewById(R.id.btn_4_bot);

        //txt add fraction
        txt_front_1=findViewById(R.id.txt_1_front);
        txt_bot_1=findViewById(R.id.txt_1_bot);
        txt_front_2=findViewById(R.id.txt_2_front);
        txt_bot_2=findViewById(R.id.txt_2_bot);

        symbol=findViewById(R.id.symbol);
        symbol.setText("-");

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
        showNextQuiz();
    }
    private void showNextQuiz(){
        extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("sample_frac");
            if (userName != null) {
                //text current level
                preferences = getSharedPreferences("Game_frac", Context.MODE_PRIVATE);
                preferences.getInt("level_current_frac_4", 1);
                status = preferences.getInt("level_current_frac_4",1);
                Log.d("status action 4", String.valueOf(status));

                previous.setVisibility(View.VISIBLE);
                if (level_plus==status){
                    next.setVisibility(View.INVISIBLE);
                }else next.setVisibility(View.VISIBLE);

                current_lv1.setText("13");
                current_lv2.setText("14");
                current_lv3.setText("15");
                current_lv4.setText("16");
                if (level_plus==1){
                    current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 13");
                }else if (level_plus==2){
                    current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 14");
                }else if (level_plus==3){
                    current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 15");
                }else if (level_plus==4){
                    current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 16");
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
            //front
            txt_front_1.setText("2");
            txt_bot_1.setText("6");
            //end
            txt_front_2.setText("1");
            txt_bot_2.setText("6");

            //btn txt
            btn_1_top.setText("4");
            btn_1_bot.setText("6");

            btn_2_top.setText("1");
            btn_2_bot.setText("6");

            btn_3_top.setText("3");
            btn_3_bot.setText("6");

            btn_4_top.setText("2");
            btn_4_bot.setText("6");
            //btn
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==2){
            //front
            txt_front_1.setText("4");
            txt_bot_1.setText("7");
            //end
            txt_front_2.setText("2");
            txt_bot_2.setText("7");

            //btn txt
            btn_1_top.setText("2");
            btn_1_bot.setText("7");

            btn_2_top.setText("3");
            btn_2_bot.setText("7");

            btn_3_top.setText("4");
            btn_3_bot.setText("7");

            btn_4_top.setText("5");
            btn_4_bot.setText("7");
            //btn
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==3){
            //front
            txt_front_1.setText("5");
            txt_bot_1.setText("8");
            //end
            txt_front_2.setText("1");
            txt_bot_2.setText("8");

            //btn txt
            btn_1_top.setText("2");
            btn_1_bot.setText("8");

            btn_2_top.setText("3");
            btn_2_bot.setText("8");

            btn_3_top.setText("4");
            btn_3_bot.setText("8");

            btn_4_top.setText("5");
            btn_4_bot.setText("8");
            //btn
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==4){
            //front
            txt_front_1.setText("7");
            txt_bot_1.setText("9");
            //end
            txt_front_2.setText("2");
            txt_bot_2.setText("9");

            //btn txt
            btn_1_top.setText("2");
            btn_1_bot.setText("9");

            btn_2_top.setText("3");
            btn_2_bot.setText("9");

            btn_3_top.setText("4");
            btn_3_bot.setText("9");

            btn_4_top.setText("5");
            btn_4_bot.setText("9");
            //btn
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_frac");
                        if (userName!=null){
                            showAlertDialogEnd();
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
            editor.putInt("level_current_frac_4", status);
            editor.apply();
            System.out.println("Save = " + editor.putInt("level_current_frac_4", status));
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
        final Dialog dialogBuilder = new Dialog(Learn_Frac_4.this,R.style.CustomDialog);
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
        dialogBuilder = new AlertDialog.Builder(Learn_Frac_4.this);
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
                startActivity(new Intent(Learn_Frac_4.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();
        dialogBuilder = new AlertDialog.Builder(Learn_Frac_4.this);
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
                if (level_plus==status){
                    status++;
                }
                Save();
                level_plus++;
                Log.d("status level", String.valueOf(status));
                Log.d("current level", String.valueOf(level_plus));
                showNextQuiz();
                bk_normal();
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Frac_4.this, Home_Activity.class));
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

    private void showAlertDialogEnd() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn_Frac_4.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView txt_exit_lv = layoutView.findViewById(R.id.txt_level_exit);
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេម");
        TextView lesson_exit_lv = layoutView.findViewById(R.id.lesson_level_exit);
        lesson_exit_lv.setText("ប្រភាគ");
        TextView ask_next = layoutView.findViewById(R.id.ask_next);
        ask_next.setText("តើអ្នកចង់បន្តទៅហ្គេមបន្ទាប់ទៀត ឬត្រឡប់ទៅកាន់មាតិកាដើមវិញ?");
        TextView con = layoutView.findViewById(R.id.con);
        con.setText("ហ្គេមបន្ទាប់");
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
                if (extras != null) {
                    userName = extras.getString("sample_frac");
                    if (userName != null) {
                        Intent i_to = new Intent(getApplicationContext(), Learn_weight_1.class);
                        i_to.putExtra("sample_weight","learn");
                        startActivity(i_to);
                        finish();
                    }
                }else {
                    Intent i_to = new Intent(getApplicationContext(), Select_weight_lesson.class);
                    i_to.putExtra("add_to", "learn");
                    startActivity(i_to);
                    finish();
                }
            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Frac_4.this, Home_Activity.class));
                finish();
            }
        });
    }

    private void bk_normal(){
        container.stopDropping();
    }

}
