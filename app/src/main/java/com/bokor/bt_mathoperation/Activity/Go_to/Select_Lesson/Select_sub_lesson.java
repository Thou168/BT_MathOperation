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
import com.bokor.bt_mathoperation.Activity.Go_to.Adapter.Adapter_RecyclerView_Sub;
import com.bokor.bt_mathoperation.Activity.Symbol_Activity.Sub_class;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_2;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;

public class Select_sub_lesson extends AppCompatActivity {
    ImageView back;
    RelativeLayout bk;
    RecyclerView rv;
    private RecyclerView.Adapter mAdapter;

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    Bundle extras;
    String sub_select;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_lesson);
        id.clear();
        title.clear();
        id.add("01");
        title.add("វិធីដកលេខពីរខ្ទង់នឹងមួយខ្ទង់គ្មានខ្ចី");

        id.add("02");
        title.add("វិធីដកលេខពីរខ្ទង់នឹងមួយខ្ទង់មានខ្ចី");

        id.add("03");
        title.add("វិធីដកលេខពីរខ្ទង់នឹងពីរខ្ទង់គ្មានខ្ចី");

        id.add("04");
        title.add("វិធីដកលេខពីរខ្ទង់នឹងពីរខ្ទង់មានខ្ចី");

        rv = findViewById(R.id.my_recycler_view);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        mAdapter = new Adapter_RecyclerView_Sub(getApplicationContext(),id,title);
        rv.setAdapter(mAdapter);

        bk=findViewById(R.id.bk_id);
        bk.setBackgroundColor(getResources().getColor(R.color.bg_sub));
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
            sub_select = extras.getString("add_to");
            if (sub_select != null) {
                Intent intent = new Intent(getApplicationContext(), Sub_class.class);
                intent.putExtra("add_to","select_lesson");
                startActivity(intent);
                finish();
            }
        }else {
            finish();
        }
    }
}
