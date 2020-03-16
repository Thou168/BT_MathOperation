package com.bokor.bt_mathoperation.List_Lesson;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bokor.bt_mathoperation.R;

import java.util.Arrays;

public class List_Lesson extends AppCompatActivity {

    ImageView back_img;
    ListView lv;
    String[] title = {"Lesson 1","Lesson 2","Lesson 3","Lesson 4","Lesson 5","Lesson 6","Lesson 7","Lesson 8"};
    String[] desc = {"Level 1","Level 2","Level 3","Level 4","Level 5","Level 6","Level 7","Level 8"};
    int[] img = {R.drawable.ic_users,R.drawable.ic_event,R.drawable.ic_info,R.drawable.ic_exit_app,R.drawable.ic_chat_black_24dp,R.drawable.ic_delete_black_24dp,R.drawable.ic_message_black_24dp,R.drawable.ic_note_black_24dp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_lesson);

        back_img = findViewById(R.id.back_lesson);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        lv = findViewById(R.id.list_lesson);
        ListAdapter listAdapter = new ListAdapter(this,title,img,desc);
        lv.setAdapter(listAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String  itemValue = (String) lv.getItemAtPosition(i);
                Toast.makeText(getApplicationContext(),
                        "Position :"+ i +"  "+itemValue , Toast.LENGTH_SHORT)
                        .show();
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
        String[] mDesc;
        int[] imgs;

        ListAdapter(Context c,String[] title, int[] imgs,String[] des){
            super(c,R.layout.item_for_list,R.id.txt_title,title);
            this.context=c;
            this.mTitle=title;
            this.imgs = imgs;
            this.mDesc = des;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View item = layoutInflater.inflate(R.layout.item_for_list,parent,false);
            ImageView imageView = item.findViewById(R.id.img_item);
            TextView titleView = item.findViewById(R.id.txt_title);
            TextView desView = item.findViewById(R.id.txt_level);
            imageView.setImageResource(imgs[position]);
            titleView.setText(mTitle[position]);
            desView.setText(desc[position]);
            return item;
        }
    }
}
