package com.bokor.bt_mathoperation.Activity.Go_to.Adapter;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Add.Multiply_Two_digit_and_one_digit_numbers;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Add.The_sum_of_two_digit_and_one_digit_numbers_is_a_factor;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Add.Lets_start_lesson_3;
import com.bokor.bt_mathoperation.Activity.Go_to.Lets_start.For_Add.Lets_start_lesson_4;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;

public class Adapter_RecyclerView extends RecyclerView.Adapter<Adapter_RecyclerView.ViewHolder> {

    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> title = new ArrayList<>();
    Context context;
    private Adapter_RecyclerView adapter_recyclerView = this;

    public Adapter_RecyclerView(Context applicationContext, ArrayList<String> id, ArrayList<String> title) {

        this.context = applicationContext;
        this.id = id;
        this.title = title;

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView idTextView;
        public TextView titleTextView;
        CardView cardView;

        public ViewHolder(final View itemView) {
            super(itemView);

            idTextView = itemView.findViewById(R.id.textViewName);
            idTextView.setBackgroundResource(R.drawable.gradient_add);
            titleTextView = itemView.findViewById(R.id.textViewVersion);
            cardView = itemView.findViewById(R.id.card_view);


        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public Adapter_RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_for_list, parent, false);

        Adapter_RecyclerView.ViewHolder viewHolder = new Adapter_RecyclerView.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.idTextView.setText(id.get(position));
        holder.titleTextView.setText(title.get(position));
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                if (position == 0) {
                    Intent go = new Intent(context, Multiply_Two_digit_and_one_digit_numbers.class);
                    go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(go);
//                    Toast.makeText(context,"position 1",Toast.LENGTH_SHORT).show();
                }else if (position == 1){
                    Intent go = new Intent(context, The_sum_of_two_digit_and_one_digit_numbers_is_a_factor.class);
                    go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(go);
//                    Toast.makeText(context,"position 2",Toast.LENGTH_SHORT).show();
                }else if (position == 2){
                    Intent go = new Intent(context, Lets_start_lesson_3.class);
                    go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(go);
//                    Toast.makeText(context,"position 3",Toast.LENGTH_SHORT).show();
                }else {
                    Intent go = new Intent(context, Lets_start_lesson_4.class);
                    go.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(go);
//                    Toast.makeText(context,"position 4",Toast.LENGTH_SHORT).show();
                }
            }
        });
        PushDownAnim.setPushDownAnimTo(holder.cardView);
    }

    @Override
    public int getItemCount() {
        return id.size();
    }
}