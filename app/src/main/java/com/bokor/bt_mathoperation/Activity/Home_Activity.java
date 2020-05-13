package com.bokor.bt_mathoperation.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Capacity_class;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Decimal_class;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Div_class;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Fraction_class;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Mul_class;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Sub_class;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Sum_class;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Weight_class;
import com.bokor.bt_mathoperation.R;
import com.google.android.material.navigation.NavigationView;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Home_Activity extends AppCompatActivity implements View.OnClickListener {
//    DrawerLayout drawerLayout;
//    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ImageButton img_setting;
//    Toolbar toolbar;
    ImageButton btn_sum,btn_mul,btn_div,btn_fraction,btn_weight,btn_capacity,btn_decimal;
    Button btn_next;
    ImageButton btn_sub;
    Context context;
    ImageView back;
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
//        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("BT_MathOperation");

        img_setting = findViewById(R.id.settings);
        img_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home_Activity.this, Info.class));
            }
        });

//        drawerLayout = findViewById(R.id.drawer_layout_id);
//        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
//        drawerLayout.addDrawerListener(toggle);
//        drawerLayout.setClickable(true);
//        setSupportActionBar(toolbar);

//        toggle.setDrawerIndicatorEnabled(false);
//        toggle.syncState();
//        toolbar.setNavigationIcon(R.drawable.ic_info);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
//                toolbar.startAnimation(animFadein);
//            }
//        });
//        toolbar.setNavigationOnClickListener(new View.OnClickListener () { @Override public void onClick(View view) { if (drawerLayout.isDrawerOpen (Gravity.LEFT)) { drawerLayout.closeDrawer (Gravity.LEFT); } else { drawerLayout.openDrawer (Gravity.LEFT); } } });
        navigationView = findViewById(R.id.navi);
    }

    private void call_id(){
        back=findViewById(R.id.back);
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onBackPressed();
                startActivity(new Intent(Home_Activity.this,Start_Up.class));
            }
        });

        btn_sum = findViewById(R.id.btn_sum);
        PushDownAnim.setPushDownAnimTo(btn_sum).setOnClickListener(new View.OnClickListener() {
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
//                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
        btn_mul = findViewById(R.id.btn_mul);
        PushDownAnim.setPushDownAnimTo(btn_mul).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Mul_class.class));
            }
        });
        btn_div = findViewById(R.id.btn_div);
        PushDownAnim.setPushDownAnimTo(btn_div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Div_class.class));
            }
        });

        btn_fraction = findViewById(R.id.btn_fraction);
        PushDownAnim.setPushDownAnimTo(btn_fraction).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Fraction_class.class));
            }
        });

        btn_weight = findViewById(R.id.btn_weight);
        PushDownAnim.setPushDownAnimTo(btn_weight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Weight_class.class));
            }
        });

        btn_capacity = findViewById(R.id.btn_capacity);
        PushDownAnim.setPushDownAnimTo(btn_capacity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Capacity_class.class));
            }
        });

        btn_decimal = findViewById(R.id.btn_decimal);
        PushDownAnim.setPushDownAnimTo(btn_decimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Decimal_class.class));
            }
        });

        btn_next = findViewById(R.id.btnNext);
        PushDownAnim.setPushDownAnimTo(btn_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_Activity.this, Sound_Activity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
            finish();
//        }
    }

    @Override
    public void onClick(View view) {
//        if(view.getId() == R.id.btn_show_gif){
//            img_gif.setImageResource(R.drawable.gif2);
//        }
    }
}
