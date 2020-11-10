package com.bokor.bt_mathoperation.Fragment_lesson.Frac;

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

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_2;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_3;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Learn_Frac_2 extends AppCompatActivity {
    TextView t1,t2,t3,t4;
    ImageView img_g2_1,img_g2_2,img_g2_3,img_g2_4;
    TextView txt_ask;
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
    //second dialog alert
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn_fraction_denominator);
        img_g2_1=findViewById(R.id.img_g2_1);
        img_g2_2=findViewById(R.id.img_g2_2);
        img_g2_3=findViewById(R.id.img_g2_3);
        img_g2_4=findViewById(R.id.img_g2_4);

        txt_ask=findViewById(R.id.txt_ask);

        txt_ask.setTextSize(15);
        t1=findViewById(R.id.txt1);
        t1.setTextSize(15);
        t2=findViewById(R.id.txt2);
        t2.setTextSize(15);
        t3=findViewById(R.id.txt3);
        t3.setTextSize(15);
        t4=findViewById(R.id.txt4);
        t4.setTextSize(15);

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
//                extras = getIntent().getExtras();
//                if (extras!=null){
//                    userName = extras.getString("sample_add");
//                    if (userName!=null){
//                        if (level_plus==1) {
//                            Intent i = new Intent(getApplicationContext(), Learn_1.class);
//                            i.putExtra("back", "this");
//                            startActivity(i);
//                        }
//                    }
//                }
                level_plus--;
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

        answer=findViewById(R.id.answer);
        answer.setPaintFlags(answer.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        showNextQuiz();
    }
    private void showNextQuiz(){
        extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("sample_frac");
            if (userName != null) {
                //text current level
    //                previous.setVisibility(View.VISIBLE);
    //                if (level_plus==status){
    //                    next.setVisibility(View.INVISIBLE);
    //                }else next.setVisibility(View.VISIBLE);

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
            txt_ask.setText("ក្នុងចំណោមចម្លើយខាងក្រោម តើមួយណាជាការរៀបលំដាប់ប្រភាគពីតូចទៅធំ?");
            img_g2_1.setImageResource(R.drawable.frac_g2_1_1);
            img_g2_2.setImageResource(R.drawable.frac_g2_1_2);
            img_g2_3.setImageResource(R.drawable.frac_g2_1_3);
            img_g2_4.setImageResource(R.drawable.frac_g2_1_4);

            //btn
            btn1.setText("ក");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("ខ");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                }
            });
            btn3.setText("គ");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("ឃ");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==2){
            txt_ask.setText("ក្នុងចំណោមចម្លើយខាងក្រោម តើមួយណាជាការរៀបលំដាប់ប្រភាគពីតូចទៅធំ?");
            img_g2_1.setImageResource(R.drawable.frac_g2_2_3);
            img_g2_2.setImageResource(R.drawable.frac_g2_2_2);
            img_g2_3.setImageResource(R.drawable.frac_g2_2_1);
            img_g2_4.setImageResource(R.drawable.frac_g2_2_4);
            //btn
            btn1.setText("ក");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                }
            });
            btn2.setText("ខ");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("គ");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("ឃ");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==3){
            txt_ask.setText("ចូរជ្រើសរើសការរៀបលំដាប់ប្រភាគពីធំទៅតូច។");
            img_g2_1.setImageResource(R.drawable.frac_g2_3_1);
            img_g2_2.setImageResource(R.drawable.frac_g2_3_2);
            img_g2_3.setImageResource(R.drawable.frac_g2_3_3);
            img_g2_4.setImageResource(R.drawable.frac_g2_3_4);
            //btn
            btn1.setText("ក");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("ខ");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showAlertDialogPositive();
                }
            });
            btn3.setText("គ");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("ឃ");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==4){
            txt_ask.setText("ចូរជ្រើសរើសការរៀបលំដាប់ប្រភាគពីធំទៅតូច។");
            img_g2_1.setImageResource(R.drawable.frac_g2_4_1);
            img_g2_2.setImageResource(R.drawable.frac_g2_4_2);
            img_g2_3.setImageResource(R.drawable.frac_g2_4_3);
            img_g2_4.setImageResource(R.drawable.frac_g2_4_4);
            //btn
            btn1.setText("ក");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("ខ");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("គ");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_frac");
                        if (userName!=null){
                            showAlertDialogPositive();
                        }
                    }else {
                        showAlertDialogEnd();
                    }
                }
            });
            btn4.setText("ឃ");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });

        }

        //Question Baning
//        random = new Random();
//        String str = String.valueOf(random.nextInt((99 - 10) + 1) + 10);
////        int main_num = random.nextInt(9)-1;
//        String letter = Character.toString(str.charAt(1));
////        if (str.charAt(str.length()-1)=='9'){
////            str = str.replace(str.substring(str.length()-1), String.valueOf(main_num));
////        }
//        int in = Integer.parseInt(letter);
//        int int2 = random.nextInt((9-in) + 1) + 1;
//
//        final int result = Integer.parseInt(str) + int2;

//        qt_top.setText(String.valueOf(Integer.parseInt(str)));
//        qt_bottom.setText(String.valueOf(int2));
//        qt_result.setText(String.valueOf(result));

//        System.out.println("-------- "+result);
////       int num = random.nextInt((result+5) - (result-5) + 1) + (result-5);
//        System.out.println("======"+str+"==="+in);
//        ArrayList<Integer> nelist = new ArrayList<>();
//        while (nelist.size()<4){
//            int num = random.nextInt((result+2) - (result-2)) + (result-2);
//            if (!nelist.contains(num)){
//                nelist.add(num);
//            }
//        }
//        ArrayList<Integer> btnList = new ArrayList<>();
//        nelist.add(result);
//        ArrayList<Button> tv_list = new ArrayList<Button>();
//        tv_list.add(btn1);
//        tv_list.add(btn2);
//        tv_list.add(btn3);
//        tv_list.add(btn4);
//        while (btnList.size()<4){
//            for (int i = 0;i<nelist.size();i++){
//                if (!btnList.contains(nelist.get(i))){
//                    btnList.add(nelist.get(i));
//                    tv_list.get(i).setText(String.valueOf(btnList.get(i)));
//                    System.out.println("======"+btnList.get(i));
//                }
//            }
//            Collections.sort(btnList);
//        }
//        String value = btn1.getText().toString();
//        final int num1 = Integer.parseInt(value);
//        String value2 = btn2.getText().toString();
//        final int num2 = Integer.parseInt(value2);
//        String value3 = btn3.getText().toString();
//        final int num3 = Integer.parseInt(value3);
//        String value4 = btn4.getText().toString();
//        final int num4 = Integer.parseInt(value4);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(num1 == result){
//                    qt_result.setVisibility(View.VISIBLE);
//                    if (level_plus==4){
//                        extras = getIntent().getExtras();
//                        if (extras != null) {
//                            userName = extras.getString("sample_add");
//                            if (userName!=null){
//                                showAlertDialogPositive();
//                            }
//                        }else {
//                            showAlertDialogEnd();
//                        }
//                    }else {
//                        showAlertDialogPositive();
//                    }
//                }else{
//                    surprise_wrong();
//                }
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(num2 == result){
//                    qt_result.setVisibility(View.VISIBLE);
//                    if (level_plus==4){
//                        extras = getIntent().getExtras();
//                        if (extras != null) {
//                            userName = extras.getString("sample_add");
//                            if (userName!=null){
//                                showAlertDialogPositive();
//                            }
//                        }else {
//                            showAlertDialogEnd();
//                        }
//                    }else {
//                        showAlertDialogPositive();
//                    }
//                }else{
//                    surprise_wrong();
//                }
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(num3 == result){
//                    qt_result.setVisibility(View.VISIBLE);
//                    if (level_plus==4){
//                        extras = getIntent().getExtras();
//                        if (extras != null) {
//                            userName = extras.getString("sample_add");
//                            if (userName!=null){
//                                showAlertDialogPositive();
//                            }
//                        }else {
//                            showAlertDialogEnd();
//                        }
//                    }else {
//                        showAlertDialogPositive();
//                    }
//                }else{
//                    surprise_wrong();
//                }
//            }
//        });
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(num4 == result){
//                    qt_result.setVisibility(View.VISIBLE);
//                    if (level_plus==4){
//                        extras = getIntent().getExtras();
//                        if (extras != null) {
//                            userName = extras.getString("sample_add");
//                            if (userName!=null){
//                                showAlertDialogPositive();
//                            }
//                        }else {
//                            showAlertDialogEnd();
//                        }
//                    }else {
//                        showAlertDialogPositive();
//                    }
//                }else{
//                    surprise_wrong();
//                }
//            }
//        });
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

    @Override
    public void onBackPressed() {
        final Dialog dialogBuilder = new Dialog(Learn_Frac_2.this,R.style.CustomDialog);
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
        dialogBuilder = new AlertDialog.Builder(Learn_Frac_2.this);
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
                startActivity(new Intent(Learn_Frac_2.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();
        dialogBuilder = new AlertDialog.Builder(Learn_Frac_2.this);
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
                    }
                    level_plus++;
                    Log.d("status level", String.valueOf(status));
                    Log.d("current level", String.valueOf(level_plus));
                    showNextQuiz();
                    bk_normal();
                }else {
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_frac");
                        if (userName != null) {
                            Intent intent = new Intent(getApplicationContext(), Learn_Frac_3.class);
                            intent.putExtra("sample_frac", "learn_frac2");
                            startActivity(intent);
                            finish();
                        }
                    }
                }
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Frac_2.this, Home_Activity.class));
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

        dialogBuilder = new AlertDialog.Builder(Learn_Frac_2.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView txt_exit_lv = layoutView.findViewById(R.id.txt_level_exit);
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេមមេរៀន");
        TextView lesson_exit_lv = layoutView.findViewById(R.id.lesson_level_exit);
        lesson_exit_lv.setText("ការរៀបលំដាប់ប្រភាគមានភាគបែងដូចគ្នា");
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
                startActivity(new Intent(Learn_Frac_2.this, Learn_Frac_3.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Frac_2.this, Home_Activity.class));
                finish();
            }
        });
    }

    private void bk_normal(){
        container.stopDropping();
    }

}
