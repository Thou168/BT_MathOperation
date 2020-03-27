package com.bokor.bt_mathoperation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.bokor.bt_mathoperation.Activity.Info_List.About_us;
import com.bokor.bt_mathoperation.R;

public class Info extends AppCompatActivity {

    ImageButton img_home;
    Button btn_about,btn_sponsor,btn_version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_activity);
        img_home=findViewById(R.id.img_home);
        img_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        btn_about=findViewById(R.id.about_us);
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Info.this, About_us.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(Info.this,Start_Up.class));
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}
