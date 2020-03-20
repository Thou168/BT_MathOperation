package com.bokor.bt_mathoperation.List_Lesson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
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

import com.bokor.bt_mathoperation.List_Lesson.Display.Play_Display;
import com.bokor.bt_mathoperation.List_Lesson.List_level.List_Level;
import com.bokor.bt_mathoperation.R;

import java.util.Arrays;

public class List_Lesson extends AppCompatActivity {

    ImageView back_img;
    ListView lv;
    String[] title = {"មេរៀនទី 1","មេរៀនទី 2","មេរៀនទី 3","មេរៀនទី 4","មេរៀនទី 5","មេរៀនទី 6","មេរៀនទី 7","មេរៀនទី 8"};
    int[] img = {R.drawable.ic_hello,R.drawable.ic_hello,R.drawable.ic_hello,R.drawable.ic_hello,R.drawable.ic_hello,R.drawable.ic_hello,R.drawable.ic_hello,R.drawable.ic_hello};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_lesson);

        back_img = findViewById(R.id.back_lesson);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                Animation animFadein = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
                back_img.startAnimation(animFadein);
            }
        });

        lv = findViewById(R.id.list_lesson);
        ListAdapter listAdapter = new ListAdapter(this,title,img);
        lv.setAdapter(listAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  itemValue = (String) lv.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(), ""+itemValue , Toast.LENGTH_SHORT).show();
                startActivity(new Intent(List_Lesson.this, List_Level.class));
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
