package com.bokor.bt_mathoperation.Fragment_lesson.Div;

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

import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Div.Lets_start_div_3;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Div.Lets_start_div_4;
import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_div_lesson;
import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_fraction_lesson;
import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_mul_lesson;
import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_sub_lesson;
import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Frac.Learn_Frac_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Mul.Learn_Mul_3;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Learn_Div_4 extends AppCompatActivity {
    TextView qt_top,qt_bottom,qt_result,result_view;
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
    MediaPlayer mp1,game_over,askgame3,askgame4,stop_sound,yes_sound,no_sound;
    Bundle extras;
    String userName;
    TextView symbol;
    TextView txt_slop;
    RelativeLayout rl;
    SharedPreferences preferences;
    SharedPreferences.Editor preferences_ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_div);
        extras = getIntent().getExtras();
        if (extras!=null){
            userName = extras.getString("sample_div");
        }

        symbol=findViewById(R.id.symbol);
        symbol.setText("÷");
        qt_top=findViewById(R.id.num_top);
        qt_bottom=findViewById(R.id.num_bottom);
        qt_result=findViewById(R.id.num_result);
        result_view=findViewById(R.id.num_result_view);
        txt_slop=findViewById(R.id.txt_slop);
        rl=findViewById(R.id.rl);

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
                if (userName!=null){
                    if (level_plus==1){
                        Intent i = new Intent(getApplicationContext(), Learn_Div_3.class);
                        i.putExtra("to_lv_3","to3");
                        startActivity(i);
                        finish();

                        SharedPreferences sp = getSharedPreferences("Game_div", Activity.MODE_PRIVATE);
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
                stopPlaying();
                level_plus++;
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
        showNextQuiz();
    }
    private void showNextQuiz(){
        extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("sample_div");
            if (userName != null) {
                //text current level
                preferences = getSharedPreferences("Game_div", Context.MODE_PRIVATE);
                preferences.getInt("level_current_div_4", 1);
                status = preferences.getInt("level_current_div_4",1);
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
        result_view.setVisibility(View.VISIBLE);
        result_view.setText("??");
        qt_result.setVisibility(View.INVISIBLE);

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
            rl.setVisibility(View.VISIBLE);
            txt_slop.setVisibility(View.GONE);
            qt_top.setText("120");
            qt_bottom.setText("5");
            qt_result.setText("24");
            //btn
            btn1.setText("23");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("24");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qt_result.setVisibility(View.VISIBLE);
                    result_view.setVisibility(View.INVISIBLE);
                    showAlertDialogPositive();
                }
            });
            btn3.setText("25");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("26");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==2){
            rl.setVisibility(View.VISIBLE);
            txt_slop.setVisibility(View.GONE);
            qt_top.setText("350");
            qt_bottom.setText("7");
            qt_result.setText("50");
            //btn
            btn1.setText("50");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qt_result.setVisibility(View.VISIBLE);
                    result_view.setVisibility(View.INVISIBLE);
                    showAlertDialogPositive();

                }
            });
            btn2.setText("51");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("52");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("53");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==3){
            rl.setVisibility(View.GONE);
            txt_slop.setVisibility(View.VISIBLE);
            txt_slop.setTextSize(16f);
            askgame3=MediaPlayer.create(this,R.raw.division_4_e3_sipar);
            askgame3.start();
            txt_slop.setText("នារីមានសៀវភៅ120ក្បាល។ នាងបានចែកសៀវភៅទាំងនេះឱ្យទៅប្អូនៗនាងទាំង4នាក់ ដោយក្នុងម្នាក់ៗទទួលបានចំណែកស្មើៗគ្នា។ តើប្អូនៗរបស់នាងបានសៀវភៅម្នាក់ប៉ុន្មានក្បាល។\u200B");
            //btn
            btn1.setText("10");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("20");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("30");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    qt_result.setVisibility(View.VISIBLE);
//                    result_view.setVisibility(View.INVISIBLE);
                    showAlertDialogPositive();

                }
            });
            btn4.setText("40");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==4) {
            rl.setVisibility(View.GONE);
            txt_slop.setVisibility(View.VISIBLE);
            txt_slop.setTextSize(16f);
            askgame3=MediaPlayer.create(this,R.raw.division_4_e4_sipar);
            askgame3.start();
            txt_slop.setText("លោកគ្រូសំមានក្រូច250ផ្លែ គាត់ចែកឱ្យសិស្សចំនួន5នាក់។ តើសិស្សម្នាក់ៗទទួលបានក្រូចប៉ុន្មានផ្លែ?");
            //btn
            btn1.setText("20");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("30");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("40");
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
                    qt_result.setVisibility(View.VISIBLE);
                    result_view.setVisibility(View.INVISIBLE);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_div");
                        if (userName != null) {
                            showAlertDialogEnd();
                        }
                    } else {
                        showAlertDialogEnd();
                    }
                }
            });
        }
    }

    public void Save() {
        if (userName!=null) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("level_current_div_4", status);
            editor.apply();
            System.out.println("Save = " + editor.putInt("level_current_div_4", status));
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
        }else if(askgame3 != null) {
            askgame3.stop();
            askgame3.release();
            askgame3 = null;
        }else if(askgame4 != null) {
            askgame4.stop();
            askgame4.release();
            askgame4 = null;
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
        final Dialog dialogBuilder = new Dialog(Learn_Div_4.this,R.style.CustomDialog);
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
                    Intent intent = new Intent(Learn_Div_4.this, Lets_start_div_4.class);
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
        dialogBuilder = new AlertDialog.Builder(Learn_Div_4.this);
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
                startActivity(new Intent(Learn_Div_4.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();
        dialogBuilder = new AlertDialog.Builder(Learn_Div_4.this);
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
                stopPlaying();
                startActivity(new Intent(Learn_Div_4.this, Home_Activity.class));
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

    private void showAlertDialogEnd() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn_Div_4.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView txt_exit_lv = layoutView.findViewById(R.id.txt_level_exit);
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេម");
        TextView lesson_exit_lv = layoutView.findViewById(R.id.lesson_level_exit);
        lesson_exit_lv.setText("វិធីចែក");
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
                stopPlaying();
                if (extras != null) {
                    userName = extras.getString("sample_div");
                    if (userName != null) {
                        clear_frac();
                        Intent i_to = new Intent(getApplicationContext(), Learn_Frac_1.class);
                        i_to.putExtra("sample_frac","learn");
                        startActivity(i_to);
                        finish();
                    }
                }else {
                    Intent i_to = new Intent(getApplicationContext(), Select_fraction_lesson.class);
                    i_to.putExtra("add_to", "learn");
                    startActivity(i_to);
                    finish();
                }
            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
                startActivity(new Intent(Learn_Div_4.this, Home_Activity.class));
                finish();
            }
        });
    }

    public void clear_frac(){
        preferences = getSharedPreferences("Game_frac", MODE_PRIVATE);
        preferences_ed = preferences.edit();
        preferences_ed.clear();
        preferences_ed.apply();
    }

    private void bk_normal(){
        container.stopDropping();
    }
}
