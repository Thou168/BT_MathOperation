package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Sub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Sub.Learn_Sub;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_sub_4 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView example,carry_on,top_num,bottom_num,answer,txt_explain_T,txt_explain_B,such_as;
    TextView two_char_top,two_char_bot,one_char_top,one_char_bot,two_ans,one_ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_sub_1);
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_sub_4.this, Learn_Sub.class));
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
        example.setText("ឧទាហរណ៏ ៖ 83 - 36 = ?");
        carry_on=findViewById(R.id.carry_on);
//        carry_on.setVisibility(View.VISIBLE);
        top_num=findViewById(R.id.top_num);
        top_num.setText("8​​  3");
        bottom_num=findViewById(R.id.bottom_num);
        bottom_num.setText("3​​  6");
        answer=findViewById(R.id.answer);
        answer.setText("4​​  7");
        txt_explain_T=findViewById(R.id.txt_explain_top);
        txt_explain_T.setText("3 ដក 6 មិនបានទេ ខ្ចី 1 ពីខ្ទង់ដប់។ 83 គឺ 7 ដប់ 13 រាយ។ 13 ដក 6 នៅសល់ 7 សរសេរលេខ 7");
        txt_explain_B=findViewById(R.id.txt_explain_bottom);
        txt_explain_B.setText("7 ដក 3 នៅសល់ 4 សរសេរលេខ 4");
        such_as=findViewById(R.id.such_as);
        such_as.setText("ដូចនេះ 83 - 36 = 47");

        //box
        two_char_top=findViewById(R.id.two_char_top);
        two_char_top.setText("8");
        two_char_bot=findViewById(R.id.two_char_bot);
        two_char_bot.setText("3");
        two_char_bot.setVisibility(View.VISIBLE);
        one_char_top=findViewById(R.id.one_char_top);
        one_char_top.setText("3");
        one_char_bot=findViewById(R.id.one_char_bot);
        one_char_bot.setText("6");
        two_ans=findViewById(R.id.two_ans);
        two_ans.setText("4");
        one_ans=findViewById(R.id.one_ans);
        one_ans.setText("7");
    }
}
