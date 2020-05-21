package com.bokor.bt_mathoperation.Activity.Symbol_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_mul_lesson;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Mul.Learn_Mul_1;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Mul_class extends AppCompatActivity {

    ImageView back_mul,alert;
    LinearLayout rl_play,rl_practice;
    TranslateAnimation transAnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mul_class);
        rl_play = findViewById(R.id.relativelayout_lesson);
        alert=findViewById(R.id.alert);
        ViewFlipper simpleViewFlipper = findViewById(R.id.flipper);
        Animation in = AnimationUtils.loadAnimation(this, R.anim.bounce);
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setAutoStart(true);
//        time_alert();

        PushDownAnim.setPushDownAnimTo(rl_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Select_mul_lesson.class));
            }
        });
        rl_practice=findViewById(R.id.relativelayout_game);
        PushDownAnim.setPushDownAnimTo(rl_practice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Learn_Mul_1.class);
                intent.putExtra("sample_mul", "multiply");
                startActivity(intent);
            }
        });
        back_mul=findViewById(R.id.back_mul);
        PushDownAnim.setPushDownAnimTo(back_mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                back_mul.startAnimation(animFadein);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
