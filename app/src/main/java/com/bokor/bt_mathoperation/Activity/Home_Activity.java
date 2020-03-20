package com.bokor.bt_mathoperation.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialog;
import com.bestsoft32.tt_fancy_gif_dialog_lib.TTFancyGifDialogListener;
import com.bokor.bt_mathoperation.Activity_Div.Div_class;
import com.bokor.bt_mathoperation.Activity_Mul.Mul_class;
import com.bokor.bt_mathoperation.Activity_Sub.Sub_class;
import com.bokor.bt_mathoperation.Activity_Sum.Sum_class;
import com.bokor.bt_mathoperation.R;
import com.google.android.material.navigation.NavigationView;
import com.thekhaeng.pushdownanim.PushDownAnim;

import pl.droidsonroids.gif.GifImageView;

import static com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_PUSH_SCALE;
import static com.thekhaeng.pushdownanim.PushDownAnim.DEFAULT_PUSH_STATIC;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_SCALE;
import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class Home_Activity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ImageButton img_setting;
    Toolbar toolbar;
    Button btn_sum,btn_mul,btn_div,btn_next;
    Button btn_sub;
//    Button gif;
//    GifImageView img_gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
//        gif=findViewById(R.id.btn_show_gif);
//        img_gif=findViewById(R.id.gifImageView);
//        gif.setOnClickListener(this);
        call_id();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("BT_MathOperation");

        img_setting = findViewById(R.id.settings);
        img_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Setting.class));
            }
        });
        drawerLayout = findViewById(R.id.drawer_layout_id);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        drawerLayout.setClickable(true);
        setSupportActionBar(toolbar);

        toggle.setDrawerIndicatorEnabled(false);
        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.ic_info);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
                toolbar.startAnimation(animFadein);
            }
        });
        toolbar.setNavigationOnClickListener(new View.OnClickListener () { @Override public void onClick(View view) { if (drawerLayout.isDrawerOpen (Gravity.LEFT)) { drawerLayout.closeDrawer (Gravity.LEFT); } else { drawerLayout.openDrawer (Gravity.LEFT); } } });
        navigationView = findViewById(R.id.navi);
    }

    private void call_id(){
        btn_sum = findViewById(R.id.btn_sum);
        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Sum_class.class));
            }
        });
        btn_sub = findViewById(R.id.btn_sub);
        PushDownAnim.setPushDownAnimTo(btn_sub).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Sub_class.class));
            }
        });
        btn_mul = findViewById(R.id.btn_mul);
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Mul_class.class));
            }
        });
        btn_div = findViewById(R.id.btn_div);
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Div_class.class));
            }
        });
        btn_next = findViewById(R.id.btnNext);
//        btn_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(Home_Activity.this, Sound_Activity.class));
//            }
//        });

//        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.button_click);
//        btn_next.startAnimation(hyperspaceJumpAnimation);
        PushDownAnim.setPushDownAnimTo(btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Sound_Activity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
//        if(view.getId() == R.id.btn_show_gif){
//            img_gif.setImageResource(R.drawable.gif2);
//        }
    }
}
