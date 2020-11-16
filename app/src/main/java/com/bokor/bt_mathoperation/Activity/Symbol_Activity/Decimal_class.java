package com.bokor.bt_mathoperation.Activity.Symbol_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_decimal_lesson;
import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Capa.Learn_capa_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Deci.Learn_Decimal_1;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Decimal_class extends AppCompatActivity {

    ImageView back_decimal,alert;
    LinearLayout rl_play,rl_practice;
    Bundle extras;
    String put_extra;
    SharedPreferences preferences;
    SharedPreferences.Editor preferences_ed;
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
                clear_deci();
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

    public void clear_deci(){
        preferences = getSharedPreferences("Game_deci", MODE_PRIVATE);
        preferences_ed = preferences.edit();
        preferences_ed.clear();
        preferences_ed.apply();
    }

    @Override
    public void onBackPressed() {
        extras = getIntent().getExtras();
        if (extras != null) {
            put_extra = extras.getString("add_to");
            if (put_extra != null) {
                Intent intent = new Intent(getApplicationContext(), Home_Activity.class);
                intent.putExtra("add_to","class");
                startActivity(intent);
                finish();
            }
        }else {
            finish();
        }
    }
}
