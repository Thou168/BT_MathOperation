package com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bokor.bt_mathoperation.Activity.Go_to.Adapter.Adapter_RecyclerView;
import com.bokor.bt_mathoperation.Activity.Go_to.Adapter.Adapter_RecyclerView_Div;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Div_class;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Mul_class;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;

public class Select_div_lesson extends AppCompatActivity {
    ImageView back;
    RelativeLayout bk;
    RecyclerView rv;
    private RecyclerView.Adapter mAdapter;

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    Bundle extras;
    String select_lesson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_lesson);
        id.clear();
        title.clear();
        id.add("01");
        title.add("វិធីចែកគ្មានសំណល់");

        id.add("02");
        title.add("វិធីចែកចំនួនលេខពីរខ្ទង់ នឹងមួយខ្ទង់គ្មានសំណល់");

        id.add("03");
        title.add("វិធីចែកចំនួនលេខពីរខ្ទង់ នឹងមួយខ្ទង់មានសំណល់");

        id.add("04");
        title.add("វិធីចែកចំនួនលេខបីខ្ទង់ នឹងមួយខ្ទង់គ្មានសំណល់");

        rv = findViewById(R.id.my_recycler_view);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        mAdapter = new Adapter_RecyclerView_Div(getApplicationContext(),id,title);
        rv.setAdapter(mAdapter);

        bk=findViewById(R.id.bk_id);
        bk.setBackgroundColor(getResources().getColor(R.color.bg_div));
        back=findViewById(R.id.back);
        back.setImageResource(R.drawable.back_white_new);
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        extras = getIntent().getExtras();
        if (extras != null) {
            select_lesson = extras.getString("add_to");
            if (select_lesson != null) {
                Intent intent = new Intent(getApplicationContext(), Div_class.class);
                intent.putExtra("add_to","select_lesson");
                startActivity(intent);
                finish();
            }
        }else {
            finish();
        }
    }
}
