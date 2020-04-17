package com.bokor.bt_mathoperation.Activity.Go_to;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

//import com.bokor.bt_mathoperation.Activity.Go_to.Adapter.CustumAdapter;
import com.bokor.bt_mathoperation.Activity.Go_to.Adapter.Adapter_RecyclerView;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;

public class Select_your_lesson extends AppCompatActivity {
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
        title.add("វិធីបូកលេខពីរខ្ទង់នឹងមួយខ្ទង់គ្មានត្រាទុក");

        id.add("02");
        title.add("វិធីបូកលេខពីរខ្ទង់នឹងមួយខ្ទង់មានត្រាទុក");

        id.add("03");
        title.add("វិធីបូកលេខពីរខ្ទង់នឹងពីរខ្ទង់គ្មានត្រាទុក");

        id.add("04");
        title.add("វិធីបូកលេខពីរខ្ទង់នឹងពីរខ្ទង់មានត្រាទុក");

        rv = findViewById(R.id.my_recycler_view);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(llm);
        mAdapter = new Adapter_RecyclerView(getApplicationContext(),id,title);
        rv.setAdapter(mAdapter);

        bk=findViewById(R.id.bk_id);
        bk.setBackgroundColor(getResources().getColor(R.color.bg_add));
        back=findViewById(R.id.back);
        back.setImageResource(R.drawable.back_add);
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
