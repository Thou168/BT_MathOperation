package com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Fraction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Frac.Learn_Frac_4;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;

public class Lets_start_fraction_4 extends AppCompatActivity {
    ImageView img_back,sound;
    ShadowLayout shadowLayout;
    TextView txt_yg_ban,txt_jomnam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_fraction_2);
        id();
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_fraction_4.this, Learn_Frac_4.class));
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
        txt_yg_ban=findViewById(R.id.txt_yerng_ban);
        txt_yg_ban.setText(R.string.fraction_sub);
        txt_jomnam=findViewById(R.id.txt_jomnam);
        txt_jomnam.setText("ដើម្បីដកប្រភាគដែលមានភាគបែងដូចគ្នា យើងត្រូវដកភាគយកនឹងភាគយក រីឯភាគបែង\u200Bរក្សាទុកនៅដដែល។");
    }
}
