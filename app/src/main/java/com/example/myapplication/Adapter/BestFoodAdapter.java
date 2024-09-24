package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.myapplication.Domain.Foods;
import com.example.myapplication.R;

import java.util.ArrayList;

public class BestFoodAdapter extends RecyclerView.Adapter<BestFoodAdapter.myViewHolder> {
   ArrayList<Foods> items;
   Context context;
    public BestFoodAdapter(ArrayList<Foods> foods) {
        this.items = foods;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View itemView= LayoutInflater.from(context).inflate(R.layout.viewholder_best_deal,parent,false);
        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Foods food=items.get(position);
        holder.timeTxt.setText(food.getTimeValue()+" min");
        holder.titleTxt.setText(food.getTitle());
        holder.starTxt.setText(""+food.getStar());
        holder.priceTxt.setText("$"+food.getPrice());
        Glide.with(context).load(food.getImagedPath())
                .transform(new CenterCrop(),new RoundedCorners(30))
                .into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTxt,priceTxt,starTxt,timeTxt;
        public ImageView pic;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.titleText);
            priceTxt=itemView.findViewById(R.id.priceTxt);
            starTxt=itemView.findViewById(R.id.startTxt);
            timeTxt=itemView.findViewById(R.id.timetxt);
            pic=itemView.findViewById(R.id.pic);

        }
    }
}
