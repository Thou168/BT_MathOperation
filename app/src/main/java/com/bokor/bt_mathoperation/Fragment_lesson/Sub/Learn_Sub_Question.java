package com.bokor.bt_mathoperation.Fragment_lesson.Sub;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_mul_lesson;
import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_sub_lesson;
import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Item.Question;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.Random;

public class Learn_Sub_Question extends AppCompatActivity implements View.OnClickListener {
    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;
    int level_plus = 3;
    int status=1;
    TextView txt_level_current;
    TextView current_lv1,current_lv2,current_lv3,current_lv4;

    private Question question = new Question();

    private String answer;
    private int questionLength = question.questions.length;
    ImageView img_back;
    ImageView previous,next;
    Random random;
    EmojiRainLayout container;

    Vibrator vibe;
    MediaPlayer mp1,game_over;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    Bundle extras;
    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.the_slop_layout);
        random = new Random();
        container=findViewById(R.id.container);
//sound game
        mp1=MediaPlayer.create(this, R.raw.hand_clap);
        game_over=MediaPlayer.create(this,R.raw.game_over);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        btn_one = (Button)findViewById(R.id.btn_one);
        btn_two = (Button)findViewById(R.id.btn_two);
        btn_three = (Button)findViewById(R.id.btn_three);
        btn_four = (Button)findViewById(R.id.btn_four);
        PushDownAnim.setPushDownAnimTo(btn_one,btn_two,btn_three,btn_four).setScale(PushDownAnim.MODE_SCALE,0.80f).setOnClickListener(this);

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
                Toast.makeText(getApplicationContext(),"Previous",Toast.LENGTH_SHORT).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Next",Toast.LENGTH_SHORT).show();
            }
        });

        current_lv1=findViewById(R.id.current_level1);
        current_lv2=findViewById(R.id.current_level2);
        current_lv3=findViewById(R.id.current_level3);
        current_lv4=findViewById(R.id.current_level4);
        txt_level_current=findViewById(R.id.txt_level_current);

        tv_question = (TextView)findViewById(R.id.tv_question);

        NextQuestion(random.nextInt(questionLength));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                if (btn_one.getText() == answer) {
                    if (level_plus==4){
                        extras = getIntent().getExtras();
                        if (extras != null) {
                            userName = extras.getString("sample_sub");
                            if (userName!=null){
                                showAlertDialogEnd();
                            }
                        }else {
                            showAlertDialogEnd();
                        }
                    }else {
                        showAlertDialogPositive();
                    }
                } else {
                    surprise_wrong();
                }

                break;

            case R.id.btn_two:
                if (btn_two.getText() == answer) {
                    if (level_plus==4){
                        extras = getIntent().getExtras();
                        if (extras != null) {
                            userName = extras.getString("sample_sub");
                            if (userName!=null){
                                showAlertDialogEnd();
                            }
                        }else {
                            showAlertDialogEnd();
                        }
                    }else {
                        showAlertDialogPositive();
                    }
                } else {
                    surprise_wrong();
                }

                break;

            case R.id.btn_three:
                if (btn_three.getText() == answer) {
                    if (level_plus==4){
                        extras = getIntent().getExtras();
                        if (extras != null) {
                            userName = extras.getString("sample_sub");
                            if (userName!=null){
                                showAlertDialogEnd();
                            }
                        }else {
                            showAlertDialogEnd();
                        }
                    }else {
                        showAlertDialogPositive();
                    }
                } else {
                    surprise_wrong();
                }

                break;

            case R.id.btn_four:
                if (btn_four.getText() == answer) {
                    if (level_plus==4){
                        extras = getIntent().getExtras();
                        if (extras != null) {
                            userName = extras.getString("sample_sub");
                            if (userName!=null){
                                showAlertDialogEnd();
                            }
                        }else {
                            showAlertDialogEnd();
                        }
                    }else {
                        showAlertDialogPositive();
                    }
                } else {
                    surprise_wrong();
                }

                break;
        }
    }
    @Override
    public void onBackPressed() {
        final Dialog dialogBuilder = new Dialog(Learn_Sub_Question.this,R.style.CustomDialog);
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

    private void surprise_wrong(){
        container.stopDropping();
        showAlertDialogNegative();
        vibe.vibrate(200);
        game_over.start();
    }
    private void showAlertDialogNegative() {
        dialogBuilder = new AlertDialog.Builder(Learn_Sub_Question.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_new_fail, null);
        ImageView dialogButtonNegative = layoutView.findViewById(R.id.btnDialogNegative);
        ImageView home = layoutView.findViewById(R.id.home);
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
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Sub_Question.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void surprise_true(){
        mp1.start();

        //transition rain dialog win
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(2000);
        TransitionManager.beginDelayedTransition(container,autoTransition);

        //star drop
//        container.addEmoji(R.drawable.star1);
//        container.addEmoji(R.drawable.star2);
//        container.addEmoji(R.drawable.star3);
//        container.addEmoji(R.drawable.star4);
//        container.addEmoji(R.drawable.star5);
//        container.startDropping();
//        //container.stopDropping();
//        container.setPer(10);
//        container.setDuration(7200);
//        container.setDropDuration(2400);
//        container.setDropFrequency(500);
        //end
    }
    private void showAlertDialogPositive() {
        surprise_true();
        dialogBuilder = new AlertDialog.Builder(Learn_Sub_Question.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_new, null);
        ImageView dialogButtonPositive = layoutView.findViewById(R.id.btnDialogPositive);
        ImageView home = layoutView.findViewById(R.id.home);
        ImageView again = layoutView.findViewById(R.id.again);
//        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(dialogButtonPositive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                level_plus++;
                NextQuestion(random.nextInt(questionLength));
                bk_normal();
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Sub_Question.this, Home_Activity.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bk_normal();
                alertDialog.cancel();
            }
        });
    }
    private void showAlertDialogEnd() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn_Sub_Question.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView txt_exit_lv = layoutView.findViewById(R.id.txt_level_exit);
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេម");
        TextView lesson_exit_lv = layoutView.findViewById(R.id.lesson_level_exit);
        lesson_exit_lv.setText("វិធីដក");
        TextView ask_next = layoutView.findViewById(R.id.ask_next);
        ask_next.setText("តើអ្នកចង់បន្តទៅហ្គេមបន្ទាប់ទៀត ឬត្រឡប់ទៅកាន់មាតិកាដើមវិញ?");
        TextView con = layoutView.findViewById(R.id.con);
        con.setText("ហ្គេមបន្ទាប់");
        TextView back = layoutView.findViewById(R.id.back);
        dialogBuilder.setView(layoutView);
//        dialogBuilder.setCancelable(false);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(con).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_to = new Intent(getApplicationContext(),Select_mul_lesson.class);
                i_to.putExtra("add_to","learn");
                startActivity(i_to);
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Sub_Question.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void bk_normal(){
        container.stopDropping();
    }

    private void NextQuestion(int num){
        current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
        current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
        extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("sample_sub");
            if (userName != null) {
                //text current level
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
        }
        if (level_plus==3){
            current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
        }else if (level_plus==4){
            current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
        }
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));

        answer = question.getCorrectAnswer(num);
    }
}
