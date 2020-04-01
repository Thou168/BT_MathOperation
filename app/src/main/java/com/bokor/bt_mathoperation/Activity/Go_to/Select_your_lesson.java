package com.bokor.bt_mathoperation.Activity.Go_to;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Select_your_lesson extends AppCompatActivity {
    LinearLayout level_1,level_2,level_3,level_4;
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_lesson);

        level_1=findViewById(R.id.relativelayout_level1);
        level_2=findViewById(R.id.relativelayout_level2);
        level_3=findViewById(R.id.relativelayout_level3);
        level_4=findViewById(R.id.relativelayout_level4);

        PushDownAnim.setPushDownAnimTo(level_1,level_2,level_3,level_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_practice.startAnimation(animFadein);

                startActivity(new Intent(Select_your_lesson.this, Lets_start_lesson.class));
            }
        });

        back=findViewById(R.id.back);
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                rl_practice.startAnimation(animFadein);

                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
