package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Div;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Div.Learn_Div_3;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_div_3 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView example,num_top,top_div,num_bottom,bottom_div,answer,txt_explain_top,txt_explain_top_mid,txt_explain_bottom_mid,txt_explain_bottom;
    TextView such_as;
    LinearLayout ln_somnol;
    LinearLayout ln_mainbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_div);
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_div_3.this, Learn_Div_3.class));
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
        PushDownAnim.setPushDownAnimTo(sound).setScale( MODE_SCALE, 0.89f  ) .setOnClickListener(new View.OnClickListener() {
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
        ln_mainbox=findViewById(R.id.ln_main_box);
        ln_mainbox.setVisibility(View.GONE);
        example=findViewById(R.id.example);
        example.setText("ឧទាហរណ៍  ៖  ដារ៉ាមានប៉ោម42ផ្លែ។ គាត់បានចែកប៉ោមទាំងនេះឱ្យប្អូនជីដូនមួយគាត់ទាំង8នាក់ក្នុងចំណែកស្មើៗគ្នា។ តើប្អូនជីដូនមួយម្នាក់ៗ ទទួលបានប៉ោមប៉ុន្មានផ្លែ? ហើយដារ៉ានៅសល់ប៉ោមប៉ុន្មានផ្លែទៀត?");
        num_top=findViewById(R.id.top_num);
        num_top.setText("42");
        top_div=findViewById(R.id.top_div);
        top_div.setText("5");
        num_bottom=findViewById(R.id.bottom_num);
        num_bottom.setText("40");
        bottom_div=findViewById(R.id.bottom_div);
        bottom_div.setText("8");
        answer=findViewById(R.id.answer);
        answer.setText("02");

        ln_somnol=findViewById(R.id.ln_som_nol);
        ln_somnol.setVisibility(View.VISIBLE);
        //box
        txt_explain_top=findViewById(R.id.txt_explain_top);
        txt_explain_top.setText("42 ជាតំណាងចែក");
        txt_explain_top_mid=findViewById(R.id.txt_explain_top_mid);
        txt_explain_top_mid.setText("5 ជាតួចែក");
        txt_explain_bottom_mid=findViewById(R.id.txt_explain_bottom_mid);
        txt_explain_bottom_mid.setText("8 ជាផលចែក");
        txt_explain_bottom=findViewById(R.id.txt_explain_bottom);
        txt_explain_bottom.setText("÷ ជាសញ្ញាចែក");
        such_as=findViewById(R.id.such_as);
        such_as.setText("ដូចនេះ 42 ៖ 5 = 8 សំណល់ 2");
    }
}
