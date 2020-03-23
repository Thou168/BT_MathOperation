package com.bokor.bt_mathoperation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.Toast;

import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Start_Up extends AppCompatActivity {

    ImageButton img_play,back,sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__up);

        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);
        back=findViewById(R.id.settings);
        img_play = findViewById(R.id.img_play);
        sound=findViewById(R.id.sounds);
        img_play.startAnimation(hyperspaceJumpAnimation);
        PushDownAnim.setPushDownAnimTo(img_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Start_Up.this, Home_Activity.class));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Start_Up.this,Setting.class));
            }
        });

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.setImageDrawable(getDrawable(R.drawable.off_sound));
                sound.setBackgroundDrawable(getDrawable(R.drawable.bg_background_off));
                Toast.makeText(getApplicationContext(),"បិទសម្លេង",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
