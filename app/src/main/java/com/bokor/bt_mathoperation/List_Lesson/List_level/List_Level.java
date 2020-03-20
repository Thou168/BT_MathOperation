package com.bokor.bt_mathoperation.List_Lesson.List_level;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.List_Lesson.Display.Play_Display;
import com.bokor.bt_mathoperation.R;

public class List_Level extends AppCompatActivity {

    ImageView back_img;
    ListView lv;
    String[] title = {"កម្រិត 1","កម្រិត 2","កម្រិត 3","កម្រិត 4"};
    int[] img = {R.drawable.calculate,R.drawable.calculate,R.drawable.calculate,R.drawable.calculate};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_level);

        back_img = findViewById(R.id.back_level);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                back_img.startAnimation(animFadein);
            }
        });

        lv = findViewById(R.id.list_level);
        ListAdapter listAdapter = new ListAdapter(this,title,img);
        lv.setAdapter(listAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  itemValue = (String) lv.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), ""+itemValue , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(List_Level.this, Play_Display.class));
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    class ListAdapter extends ArrayAdapter<String>{
        Context context;
        String[] mTitle;
        int[] imgs;

        ListAdapter(Context c,String[] title, int[] imgs){
            super(c,R.layout.item_for_list,R.id.txt_title,title);
            this.context=c;
            this.mTitle=title;
            this.imgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item = layoutInflater.inflate(R.layout.item_for_list,parent,false);
            ImageView imageView = item.findViewById(R.id.img_item);
            TextView titleView = item.findViewById(R.id.txt_title);
            imageView.setImageResource(imgs[position]);
            titleView.setText(mTitle[position]);
            return item;
        }
    }
}
