package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Sub;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Sub.Learn_Sub;
import com.bokor.bt_mathoperation.Fragment_lesson.Sub.Learn_Sub_2;
//import com.bokor.bt_mathoperation.Fragment_lesson.Sub.Main_sub;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_sub_2 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView example,carry_on,top_num,bottom_num,answer,txt_explain_T,txt_explain_B,such_as;
    TextView two_char_top,two_char_bot,one_char_top,one_char_bot,two_ans,one_ans;
    LinearLayout ln_div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_sub_pop);
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_sub_2.this, Learn_Sub_2.class));
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
            private boolean isPlaying = false;
            @Override
            public void onClick(View view) {
                if(isPlaying) {
                    sound.setImageResource(R.drawable.sound_on);
                    isPlaying=false;
                } else {
                    sound.setImageResource(R.drawable.sound_off);
                    isPlaying=true;
                }
            }
        });
    }
    private void id(){
        example=findViewById(R.id.example);
        example.setText("ឧទាហរណ៍ ៖ 32 - 8 = ?");
        carry_on=findViewById(R.id.carry_on);
//        carry_on.setVisibility(View.VISIBLE);
        top_num=findViewById(R.id.top_num);
        top_num.setText("32");
        bottom_num=findViewById(R.id.bottom_num);
        bottom_num.setText("8");
        answer=findViewById(R.id.answer);
        answer.setText("24");
        txt_explain_T=findViewById(R.id.txt_explain_top);
        txt_explain_T.setText("2 ដក 8 មិនបានទេ ខ្ចី 1 ពីខ្ទង់ដប់។ 32 គឺ2ដប់ 12 រាយ។ 12 ដក 8 នៅសល់ 4 សរសេរលេខ 4");
        txt_explain_B=findViewById(R.id.txt_explain_bottom);
        txt_explain_B.setText("2 ទម្លាក់ចុះ សរសេរលេខ 2");
        such_as=findViewById(R.id.such_as);
        such_as.setText("ដូចនេះ 32 - 8 = 24");

//        ln_div=findViewById(R.id.ln_div);
//        ln_div.setVisibility(View.GONE);
        //box
        two_char_top=findViewById(R.id.two_char_top);
        two_char_top.setText("3");
        two_char_top.setPaintFlags(two_char_top.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        two_char_bot=findViewById(R.id.two_char_bot);
//        two_char_bot.setText("3");
//        two_char_bot.setVisibility(View.GONE);
        one_char_top=findViewById(R.id.one_char_top);
        one_char_top.setPaintFlags(two_char_top.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        one_char_top.setText("2");
        one_char_bot=findViewById(R.id.one_char_bot);
        one_char_bot.setText("8");
        two_ans=findViewById(R.id.two_ans);
        two_ans.setText("2");
        one_ans=findViewById(R.id.one_ans);
        one_ans.setText("4");
    }
}
