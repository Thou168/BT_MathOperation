package com.bokor.bt_mathoperation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bokor.bt_mathoperation.Activity.Info_List.About_us;
import com.bokor.bt_mathoperation.Activity.Info_List.Sponsor_screen;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Start_Up extends AppCompatActivity {

    LinearLayout img_play;
    ImageButton info,sound;
    ImageView bk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__up);
        bk=findViewById(R.id.bk_click);
        PushDownAnim.setPushDownAnimTo(bk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Start_Up.this, About_us.class));
            }
        });

//        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);
        info=findViewById(R.id.info);
        img_play = findViewById(R.id.ln_play);
        sound=findViewById(R.id.sounds);
//        img_play.startAnimation(hyperspaceJumpAnimation);
        PushDownAnim.setPushDownAnimTo(img_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(Start_Up.this, Sponsor_screen.class));
                Intent i = new Intent(Start_Up.this,Sponsor_screen.class);
//                startActivity(i);
                startActivity(i,ActivityOptions.makeSceneTransitionAnimation(Start_Up.this).toBundle());
//                overridePendingTransition(R.anim.fade_in, R.anim.fadeout);
            }
        });

        PushDownAnim.setPushDownAnimTo(info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Start_Up.this, Info.class));
            }
        });

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.setImageDrawable(getDrawable(R.drawable.off_sound));
                Toast.makeText(getApplicationContext(),"បិទសម្លេង",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
