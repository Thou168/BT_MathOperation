package com.bokor.bt_mathoperation.Activity.Go_to;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bokor.bt_mathoperation.Lesson_learn.Learn;
import com.bokor.bt_mathoperation.List_Lesson.Display.Play_Display;
import com.bokor.bt_mathoperation.R;
import com.dd.ShadowLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Lets_start_lesson extends AppCompatActivity {

    TextView start;
    ImageView img_back;
    ShadowLayout shadowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lets_start_lesson);

        start=findViewById(R.id.start);
//        start.setOutlineProvider(new ZoftinoCustomOutlineProvider(8));
//        start.setClipToOutline(true);
//        TextView textView = (TextView) findViewById(R.id.shadow_txt);
//        textView.setOutlineProvider(new ZoftinoCustomOutlineProvider(10));
//        textView.setClipToOutline(true);
        shadowLayout=findViewById(R.id.shadow_id);
        PushDownAnim.setPushDownAnimTo(shadowLayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Lets_start_lesson.this, Learn.class));
            }
        });
        img_back=findViewById(R.id.img_back);
        PushDownAnim.setPushDownAnimTo(img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
