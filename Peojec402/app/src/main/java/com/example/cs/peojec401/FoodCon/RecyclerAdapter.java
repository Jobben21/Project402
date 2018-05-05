package com.example.cs.peojec401.FoodCon;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs.peojec401.DocumentFood;
import com.example.cs.peojec401.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    ArrayList<FoodList> arrayList ;
    Context c;


    public RecyclerAdapter(Context c,ArrayList<FoodList> foodList){

        this.arrayList=foodList;
        this.c=c;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_food2,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {

        FoodList foodList = arrayList.get(position);
        holder.name.setText(foodList.getName());
        holder.energy.setText(Integer.toString(foodList.getEnergy()));


        PicassoDown.downloadImage(c,foodList.getFoodpic(),holder.imgfood);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c,DocumentFood.class);
                i.putExtra("num",position);
                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  static  class  RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView name,energy;
        ImageView imgfood;
        public  RecyclerViewHolder(View view){
            super(view);
            name = (TextView)view.findViewById(R.id.comment);
            energy = (TextView)view.findViewById(R.id.date);
            imgfood = (ImageView)view.findViewById(R.id.menufood);

        }
    }
}