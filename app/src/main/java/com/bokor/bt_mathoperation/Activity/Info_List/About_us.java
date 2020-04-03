package com.bokor.bt_mathoperation.Activity.Info_List;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class About_us extends AppCompatActivity {
    RelativeLayout rl;
    ImageButton img_back;
    ScrollView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        rl=findViewById(R.id.rl_slide_down);

        sv=findViewById(R.id.sv);
        sv.setScrollbarFadingEnabled(false);

//        img_back=findViewById(R.id.img_back);
//        PushDownAnim.setPushDownAnimTo(img_back).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                onBackPressed();
//            }
//        });
    }

    @Override
    public void onBackPressed() {
//        finish();
    }
}
