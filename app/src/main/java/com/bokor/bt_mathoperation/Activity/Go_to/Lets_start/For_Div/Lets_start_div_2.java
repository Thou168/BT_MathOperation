package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Div;

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

public class Lets_start_div_2 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView example,num_top,top_div,num_bottom,bottom_div,answer,txt_explain_top,txt_explain_top_mid,txt_explain_bottom_mid,txt_explain_bottom;
    TextView such_as;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_div);
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_div_2.this, Learn_1.class));
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
            @Override
            public void onClick(View view) {

            }
        });
    }
    private void id(){
        example=findViewById(R.id.example);
        example.setText("ឧទាហរណ៍  45 ៖ 9 = ?");
        num_top=findViewById(R.id.top_num);
        num_top.setText("45");
        top_div=findViewById(R.id.top_div);
        top_div.setText("9");
        num_bottom=findViewById(R.id.bottom_num);
        num_bottom.setText("45");
        bottom_div=findViewById(R.id.bottom_div);
        bottom_div.setText("5");
        answer=findViewById(R.id.answer);
        answer.setText("0");
        //box
        txt_explain_top=findViewById(R.id.txt_explain_top);
        txt_explain_top.setText(". 45 ជាតំណាងចែក");
        txt_explain_top_mid=findViewById(R.id.txt_explain_top_mid);
        txt_explain_top_mid.setText(". 9 ជាតួចែក");
        txt_explain_bottom_mid=findViewById(R.id.txt_explain_bottom_mid);
        txt_explain_bottom_mid.setText(". 5 ជាផលចែក");
        txt_explain_bottom=findViewById(R.id.txt_explain_bottom);
        txt_explain_bottom.setText(". ÷ ជាសញ្ញាចែក");
        such_as=findViewById(R.id.such_as);
        such_as.setText("ដូចនេះ 45 ៖ 9 = 5");
    }
}
