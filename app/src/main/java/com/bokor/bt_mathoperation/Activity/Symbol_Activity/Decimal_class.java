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

import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_decimal_lesson;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Capa.Learn_capa_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Deci.Learn_Decimal_1;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Decimal_class extends AppCompatActivity {

    ImageView back_decimal,alert;
    LinearLayout rl_play,rl_practice;
    TranslateAnimation transAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_class);
        alert=findViewById(R.id.alert);
        ViewFlipper simpleViewFlipper = findViewById(R.id.flipper);
        Animation in = AnimationUtils.loadAnimation(this, R.anim.bounce);
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setAutoStart(true);
//        time_alert();

        rl_play = findViewById(R.id.relativelayout_lesson);
        PushDownAnim.setPushDownAnimTo(rl_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), Select_decimal_lesson.class));
            }
        });
        rl_practice=findViewById(R.id.relativelayout_game);
        PushDownAnim.setPushDownAnimTo(rl_practice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Learn_Decimal_1.class);
                intent.putExtra("sample_deci", "deci");
                startActivity(intent);
            }
        });

        back_decimal = findViewById(R.id.back_decimal);
        PushDownAnim.setPushDownAnimTo(back_decimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
//        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
