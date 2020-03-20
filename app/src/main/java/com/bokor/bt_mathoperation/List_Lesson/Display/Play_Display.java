package com.bokor.bt_mathoperation.List_Lesson.Display;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Vibrator;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import pl.droidsonroids.gif.GifImageView;

public class Play_Display extends AppCompatActivity implements View.OnClickListener {

    TextView first_num_id,symbol_id,last_num_id,equal_id,result_id;
    Button ans_1,ans_2,ans_3;
    boolean visible;
    EmojiRainLayout container;
    ImageButton img_back;
    Vibrator vibe;

    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
//        gifImageView=findViewById(R.id.gifImageView);
        call_id();
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        dialogBuilder = new AlertDialog.Builder(Play_Display.this);
        View layoutView = getLayoutInflater().inflate(R.layout.layout_dialog_alert, null);
        Button exit = layoutView.findViewById(R.id.yes);
        Button no = layoutView.findViewById(R.id.no);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimation;
        alertDialog.getWindow().getDecorView().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.cancel();
            }
        });
    }

    private void call_id(){
        //imgbtn id
        img_back=findViewById(R.id.leave_id);

        //container
        container=findViewById(R.id.container);

        //sound and vibrate
        final MediaPlayer mp1=MediaPlayer.create(this, R.raw.bells001);
        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        //text id
        first_num_id=findViewById(R.id.first_num_id);
        symbol_id=findViewById(R.id.symbol_id);
        last_num_id=findViewById(R.id.last_num_id);
        equal_id=findViewById(R.id.equal_id);
        result_id=findViewById(R.id.result_id);
        result_id.setVisibility(View.GONE);

        //button id
        ans_1=findViewById(R.id.ans_1);
        ans_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp1.start();
                //transition rain dialog win
                AutoTransition autoTransition = new AutoTransition();
                autoTransition.setDuration(2000);
                TransitionManager.beginDelayedTransition(container,autoTransition);

                container.addEmoji(R.drawable.ic_hello);
                container.addEmoji(R.drawable.ic_hello);
                container.addEmoji(R.drawable.ic_hello);
                container.addEmoji(R.drawable.ic_hello);
                container.addEmoji(R.drawable.ic_hello);

//                container.addEmoji(R.drawable.flower1);
//                container.addEmoji(R.drawable.flower2);
//                container.addEmoji(R.drawable.flower3);
//                container.addEmoji(R.drawable.flower4);
//                container.addEmoji(R.drawable.flower5);
//                container.addEmoji(R.drawable.joker);

                container.stopDropping();
                container.setPer(10);
                container.setDuration(7200);
                container.setDropDuration(2400);
                container.setDropFrequency(500);
                container.startDropping();
                //end

                visible = !visible;
                result_id.setVisibility(visible ? View.VISIBLE: View.VISIBLE);
                result_id.setText("True");
                result_id.setTextColor(getResources().getColor(R.color.yellow));
                showAlertDialogPositive();
            }
        });
        ans_2=findViewById(R.id.ans_2);
        ans_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe.vibrate(200);
                result_id.setText("False");
                result_id.setTextColor(getResources().getColor(R.color.logo_orange));
                showAlertDialogNegative();
            }
        });
        ans_3=findViewById(R.id.ans_3);
        ans_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibe.vibrate(200);
                result_id.setText("False");
                result_id.setTextColor(getResources().getColor(R.color.aqua));
                showAlertDialogNegative();
            }
        });
    }

    private void showAlertDialogNegative() {
        dialogBuilder = new AlertDialog.Builder(Play_Display.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_negative, null);
        final Button dialogButtonNegative = layoutView.findViewById(R.id.btnDialogNegative);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        PushDownAnim.setPushDownAnimTo(dialogButtonNegative).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Play_Display.this,"Try again",Toast.LENGTH_SHORT).show();
                alertDialog.cancel();
            }
        });
    }
    private void showAlertDialogPositive() {
        dialogBuilder = new AlertDialog.Builder(Play_Display.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_positive, null);
        Button dialogButtonPositive = layoutView.findViewById(R.id.btnDialogPositive);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.SlidingDialogAnimation;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        PushDownAnim.setPushDownAnimTo(dialogButtonPositive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Play_Display.this,"Next step",Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}
