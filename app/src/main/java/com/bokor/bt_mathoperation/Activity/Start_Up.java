package com.bokor.bt_mathoperation.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Size;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bokor.bt_mathoperation.Activity.Info_List.Sponsor_screen;
import com.bokor.bt_mathoperation.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;
import com.thekhaeng.pushdownanim.PushDownAnim;

import nl.dionsegijn.konfetti.KonfettiView;

public class Start_Up extends AppCompatActivity {

    LinearLayout img_play;
    ImageButton info,sound;
    LinearLayout bk,sp;
    RelativeLayout rl;
    AlertDialog.Builder dialogBuilder;
    Dialog dialog;
    ShimmerTextView sm;
    Shimmer shimmer;
    ShimmerFrameLayout shimmerFrameLayout;
    KonfettiView konfettiView;
//    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__up);
        shimmerFrameLayout=findViewById(R.id.shimmer_board);
        shimmerFrameLayout.startShimmer();
        sm=findViewById(R.id.shimmer_tv);
        toggleAnimation(sm);


        rl=findViewById(R.id.rl_start_up);
        bk=findViewById(R.id.bk_click);
        bk.setLongClickable(false);
        sp=findViewById(R.id.ln_sponsor);
        sp.setLongClickable(false);
        PushDownAnim.setPushDownAnimTo(bk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(Start_Up.this, About_us.class));
                dialog_info_bokor();
            }
        });
        PushDownAnim.setPushDownAnimTo(sp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(Start_Up.this, About_us.class));
                dialog_info_sipar();
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
                Intent i = new Intent(Start_Up.this,Sponsor_screen.class);
                startActivity(i,ActivityOptions.makeSceneTransitionAnimation(Start_Up.this).toBundle());
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
    public void toggleAnimation(View target) {
        if (shimmer != null && shimmer.isAnimating()) {
            shimmer.cancel();
        } else {
            shimmer = new Shimmer();
            shimmer.start(sm);
            shimmer.setDuration(3000);
            shimmer.setStartDelay(2000);
        }
    }

    private void dialog_info_bokor(){
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Start_Up.this,R.style.CustomDialog);
        dialog = new Dialog(this,R.style.CustomDialog);
        View layoutView = getLayoutInflater().inflate(R.layout.activity_about_us, null);
        TextView textView = layoutView.findViewById(R.id.text);
        ImageView img_view = layoutView.findViewById(R.id.img_bokor);
        img_view.setVisibility(View.VISIBLE);
        img_view.setImageDrawable(getDrawable(R.drawable.bokor));
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText("BOKOR Technology Co., Ltd. is a professional software development, network infrastructure integration and IT consulting service company. We understand the gap between technology and business and their correlations. We ensure quality service and solution delivery to meet customers’ need, budget and time. We have strong passion in serving software service sector and commit to provide best-fit technology which is seamlessly integrated into customer working environment.");
        ImageButton img_back = layoutView.findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
//        dialogBuilder.setCancelable(false);
        dialog.setContentView(layoutView);
//        final AlertDialog alertDialog = dialogBuilder.create();
//
        PushDownAnim.setPushDownAnimTo(img_back).setScale(PushDownAnim.MODE_SCALE,0.80f).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    private void dialog_info_sipar(){
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Start_Up.this,R.style.CustomDialog);
        dialog = new Dialog(this,R.style.CustomDialog);
        View layoutView = getLayoutInflater().inflate(R.layout.activity_about_us,null);
//        RelativeLayout rl = layoutView.findViewById(R.id.rl_slide_down);
        TextView textView = layoutView.findViewById(R.id.text);
        ImageView img_view = layoutView.findViewById(R.id.img_sipar);
        img_view.setVisibility(View.VISIBLE);
        img_view.setImageDrawable(getDrawable(R.drawable.sipar));
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText("ស៊ីប៉ាគឺជាអង្គការសាមគ្គីភាពអន្តរជាតិមួយដែលត្រូវបានបង្កើតឡើងនៅឆ្នាំ១៩៨២នៅប្រទេសបារាំងដើម្បីជួយជនភៀសខ្លួនមកពីអាស៊ីអាគ្នេយ៍តាមរយៈកម្មវិធីអប់រំ។\n" +
                "នៅឆ្នាំ១៩៩១ស៊ីប៉ាបានមកប្រទេសកម្ពុជាហើយចូលរួមក្នុងការស្តារនិងអភិវឌ្ឍប្រទេសដោយពង្រឹងប្រព័ន្ធអប់រំរបស់ខ្លួន។\n" +
                "សព្វថ្ងៃស៊ីប៉ាគឺជាតួអង្គសំខាន់មួយក្នុងវិស័យអប់រំដោយប្រយុទ្ធប្រឆាំងនឹងអក្ខរកម្មក្នុងចំណោមយុវជននិងមនុស្សពេញវ័យតាមរយៈការផ្សព្វផ្សាយនិងការលើកកម្ពស់សៀវភៅនិងការអា\n" +
                "ដូច្នេះតាំងពី២០ឆ្នាំមកស៊ីប៉ាបានបង្កើតបណ្តាញកន្លែងផ្សេងៗគ្នាសម្រាប់ការអានថេរនិងចល័តដើម្បីទ្រទ្រង់ការអភិវឌ្ឍន៍ការអាននៅកម្ពុជា៖បណ្ណាល័យថេរនៅសាលាបឋមសិក្សាឬក្នុងពន្ធនាគារបណ្ណល័យចល័តនៅតាមសហគមន៍សាលាមត្តេយ្យឬមណ្ឌលកុមារកំព្រានៅភ្នំពេញ។ កណ្តាលនិងកំពង់ស្ពឺជាមជ្ឈមណ្ឌលសម្រាប់ស្ត្រីនិងកុមារងាយរងគ្រោះឬសូម្បីតែមជ្ឈមណ្ឌលស្តារនីតិសម្បទាកុមារពិការ។\n");
        ImageButton img_back = layoutView.findViewById(R.id.img_back);
        img_back.setVisibility(View.VISIBLE);
//        dialogBuilder.setCancelable(false);
        dialog.setContentView(layoutView);
//        final AlertDialog alertDialog = dialogBuilder.create();

        PushDownAnim.setPushDownAnimTo(img_back).setScale(PushDownAnim.MODE_SCALE,0.80f).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
}
