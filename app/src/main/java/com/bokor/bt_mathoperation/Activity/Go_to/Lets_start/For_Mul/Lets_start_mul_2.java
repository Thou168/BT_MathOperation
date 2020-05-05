package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Mul;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_mul_2 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView example,carry_on,top_num,bottom_num,answer,txt_explain_T,txt_explain_B,such_as;
    TextView two_char_top,one_char_top,one_char_bot,two_ans,one_ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_mul);
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_mul_2.this, Learn_1.class));
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
    private void id(){
        example=findViewById(R.id.example);
        example.setText("ឧទាហរណ៍ ៖ ស្វាយមួយឡូមាន 12 ផ្លែ។ តើស្វាយ 6 ឡូមានប៉ុន្មានផ្លែ? 12 × 6 = ?");
//        carry_on=findViewById(R.id.carry_on);
//        carry_on.setVisibility(View.GONE);
        top_num=findViewById(R.id.top_num);
        top_num.setText("1​​  2");
        bottom_num=findViewById(R.id.bottom_num);
        bottom_num.setText(" ​​   6");
        answer=findViewById(R.id.answer);
        answer.setText("7​​  2");
        txt_explain_T=findViewById(R.id.txt_explain_top);
        txt_explain_T.setText(". 6 គុណនឹង 2 ស្មើ 12 សរសេរលេខ 2 ត្រាទុក 1");
        txt_explain_B=findViewById(R.id.txt_explain_bottom);
        txt_explain_B.setText(". 6 គុណនឹង 1 ស្មើ 6 រួចបូកនឹង 1 ស្មើ 7 សរសេរលេខ 7");
        such_as=findViewById(R.id.such_as);
        such_as.setText("ដូចនេះ ស្វាយទាំងអស់មាន72ផ្លែ។");

        //box
        two_char_top=findViewById(R.id.two_char_top);
        two_char_top.setText("1");
        one_char_top=findViewById(R.id.one_char_top);
        one_char_top.setText("2");
        one_char_bot=findViewById(R.id.one_char_bot);
        one_char_bot.setText("6");
        two_ans=findViewById(R.id.two_ans);
        two_ans.setText("7");
        one_ans=findViewById(R.id.one_ans);
        one_ans.setText("2");
    }
}
