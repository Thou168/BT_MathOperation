package com.bokor.bt_mathoperation.Difficulty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bokor.bt_mathoperation.R;
import com.google.android.material.tabs.TabLayout;

public class Difficulty extends AppCompatActivity {

    TabLayout tabLayout;
    ImageView img_dif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        img_dif=findViewById(R.id.back_dif);
        img_dif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                img_dif.startAnimation(animFadein);

                onBackPressed();
            }
        });

        tab_dif();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void tab_dif(){
        this.tabLayout = findViewById(R.id.tab_dif);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.easy));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.normal));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.hard));
    }
}
