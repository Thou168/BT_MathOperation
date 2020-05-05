package com.bokor.bt_mathoperation.Fragment_lesson.Sub;

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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_your_lesson;
import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_2;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_4;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import pl.droidsonroids.gif.GifImageView;

public class Learn_Sub_4 extends Fragment {
    private ImageView img_dif;
    private Button btn1,btn2,btn3,btn4;
    private TextView symbol;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog alertDialog;
    private GifImageView gifImageView;
    private TextView num_result,answer;
    private EmojiRainLayout container;
    private ImageView img_hand;
    private Vibrator vibe;
    private MediaPlayer mp1;
    private TextView numTop,numButtom;
//    second dialog alert
    static final int TIME_OUT = 3000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.learn_4, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        id(view);
        //onClick
        PushDownAnim.setPushDownAnimTo(img_dif).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_practice.startAnimation(animFadein);
                exit_dialog();
            }
        });

        mp1=MediaPlayer.create(getActivity(), R.raw.hand_clap);
        vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        PushDownAnim.setPushDownAnimTo(btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn1.setBackground(getActivity().getDrawable(R.drawable.button_state_sound));
                showAlertDialogEnd();
            }
        });
        PushDownAnim.setPushDownAnimTo(btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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


        num_result.setText("???");


        answer.setPaintFlags(answer.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        Animation animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.alpha_scale_animation);
        animation2.setInterpolator(new LinearInterpolator());
        img_hand.startAnimation(animation2);
        img_hand.setVisibility(View.VISIBLE);
//        LinearLayout ln_hand = view.findViewById(R.id.ln_hand);
//        ln_hand.setVisibility(View.GONE);



    }
    private void id(View view){
        numTop=view.findViewById(R.id.num_top);
        numTop.setText("890");
        numButtom=view.findViewById(R.id.num_bottom);
        numButtom.setText("120");

        btn1=view.findViewById(R.id.btn_1);
        btn1.setText("770");
        btn2=view.findViewById(R.id.btn_2);
        btn2.setText("670");
        btn3=view.findViewById(R.id.btn_3);
        btn3.setText("870");
        btn4=view.findViewById(R.id.btn_4);
        btn4.setText("570");

        img_dif=view.findViewById(R.id.img_back);

        answer=view.findViewById(R.id.answer);
        num_result=view.findViewById(R.id.num_result);
        container=view.findViewById(R.id.container);
        img_hand = view.findViewById(R.id.img_hand);
        symbol=view.findViewById(R.id.symbol);
        symbol.setText("-");
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
    private void exit_dialog(){
        final Dialog dialogBuilder = new Dialog(getActivity(),R.style.CustomDialog);
        dialogBuilder.setContentView(R.layout.layout_dialog_alert);
        Button no = dialogBuilder.findViewById(R.id.no);
        Button yes = dialogBuilder.findViewById(R.id.yes);
        PushDownAnim.setPushDownAnimTo(no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
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
        dialogBuilder = new AlertDialog.Builder(getActivity());
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
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Home",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), Home_Activity.class));
                getActivity().finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(getActivity());
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
                startActivity(new Intent(getActivity(), Learn_2.class));
                getActivity().finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Home",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), Home_Activity.class));
                getActivity().finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Again",Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
                btn3.setBackground(getActivity().getDrawable(R.drawable.button_state_info));
            }
        });
    }
    private void showAlertDialogEnd() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(getContext());
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView con = layoutView.findViewById(R.id.con);
        TextView back = layoutView.findViewById(R.id.back);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setView(layoutView);
        dialogBuilder.setCancelable(false);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(con).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Select_your_lesson.class));
                getActivity().finish();

            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Back",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), Home_Activity.class));
                getActivity().finish();
            }
        });
    }
}
