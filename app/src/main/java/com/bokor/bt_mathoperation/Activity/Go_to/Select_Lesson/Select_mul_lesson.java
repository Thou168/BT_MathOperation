package com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bokor.bt_mathoperation.Activity.Go_to.Adapter.Adapter_RecyclerView;
import com.bokor.bt_mathoperation.Activity.Go_to.Adapter.Adapter_RecyclerView_Mul;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;

public class Select_mul_lesson extends AppCompatActivity {
    ImageView back;
    RelativeLayout bk;
    RecyclerView rv;
    private RecyclerView.Adapter mAdapter;

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_your_lesson);
        id.clear();
        title.clear();
        id.add("01");
        title.add("វិធីគុណលេខពីរខ្ទង់នឹងមួយខ្ទង់គ្មានត្រាទុក");

        id.add("02");
        title.add("វិធីគុណលេខពីរខ្ទង់នឹងមួយខ្ទង់មានត្រាទុក");

        id.add("03");
        title.add("វិធីគុណលេខមួយខ្ទង់នឹងចំនួនសូន្យខាងចុង");

        id.add("04");
        title.add("វិធីគុណបីខ្ទង់នឹងមួយខ្ទង់មានត្រាទុក");

        rv = findViewById(R.id.my_recycler_view);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        mAdapter = new Adapter_RecyclerView_Mul(getApplicationContext(),id,title);
        rv.setAdapter(mAdapter);
        bk=findViewById(R.id.bk_id);
        bk.setBackgroundColor(getResources().getColor(R.color.bg_mul));

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
        finish();
    }
}
