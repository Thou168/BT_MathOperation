package com.bokor.bt_mathoperation.Activity.Symbol_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_your_lesson;
import com.bokor.bt_mathoperation.Lesson_learn.Learn;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Div_class extends AppCompatActivity {

    ImageView back_div;
    LinearLayout rl_play,rl_practice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div_class);
        rl_play = findViewById(R.id.relativelayout_lesson);
        PushDownAnim.setPushDownAnimTo(rl_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_play.startAnimation(animFadein);

                startActivity(new Intent(getApplicationContext(), Select_your_lesson.class));
            }
        });
        rl_practice=findViewById(R.id.relativelayout_game);
        PushDownAnim.setPushDownAnimTo(rl_practice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_practice.startAnimation(animFadein);

                startActivity(new Intent(getApplicationContext(), Learn.class));
            }
        });
        back_div = findViewById(R.id.back_div);
        back_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
//                back_div.startAnimation(animFadein);
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
