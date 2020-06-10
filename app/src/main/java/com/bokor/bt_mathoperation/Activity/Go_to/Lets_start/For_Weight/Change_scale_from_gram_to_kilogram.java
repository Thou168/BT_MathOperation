package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Weight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Weight.Learn_weight_4;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Change_scale_from_gram_to_kilogram extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView example,answer,such_as;
    TextView answer_below;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_scale_weight);
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Change_scale_from_gram_to_kilogram.this, Learn_weight_4.class));
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
        example.setText("ឧទាហរណ៍ ៖ 4300g = ..........kg..........g");
        answer_below=findViewById(R.id.answer_below);
        answer_below.setVisibility(View.VISIBLE);
        answer=findViewById(R.id.answer);
        answer.setText("4300g = 4000 + 300g");
        such_as=findViewById(R.id.such_as);
        such_as.setText("ដូចនេះ 4300g = 4kg 300g");
    }
}
