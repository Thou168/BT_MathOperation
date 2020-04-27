package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Mul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_mul extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;

    TextView example,carry_on,top_num,bottom_num,answer,txt_explain_T,txt_explain_B,such_as;
    TextView two_char_top,one_char_top,one_char_bot,two_ans,one_ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_mul);

        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_mul.this, Learn_1.class));
            }
        });
        img_back=findViewById(R.id.img_back);
        PushDownAnim.setPushDownAnimTo(img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        sound=findViewById(R.id.sounds);
        PushDownAnim.setPushDownAnimTo(sound).setScale( MODE_SCALE, 0.89f  ).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}
