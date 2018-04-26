package com.example.cs.peojec401;


import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.example.cs.peojec401.R.attr.background;

import static com.example.cs.peojec401.R.id.foodpic;

/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private  static  final  int TYPE_HEAD = 0;
    private  static  final  int TYPE_LIST = 1;
    Context c;

    ArrayList<Food_recyc> arrayList = new ArrayList<>();
    String url = "";
    Food_recyc food_recyc;

    public RecyclerAdapter(Context c,ArrayList<Food_recyc> arrayList){

        this.arrayList = arrayList;
        this.c=c;

        Toast.makeText(c, "adasd", Toast.LENGTH_SHORT).show();
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sugar1,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);


        return recyclerViewHolder   ;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        food_recyc = arrayList.get(position);
        holder.name.setText(food_recyc.getName());
//        PicassoDown.downloadImage(c,food_recyc.getFoodpic(),holder.foodpic);
            url=food_recyc.getFoodpic();
        PicassoDown.downloadImage(c,url,holder.foodpic);
        holder.energy.setText(String.valueOf(food_recyc.getEnergy()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }



    public  static  class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView name,energy;
        ImageView foodpic ;
        public  RecyclerViewHolder(View view){

            super(view);

            name  = (TextView) view.findViewById(R.id.textView6);
            foodpic = (ImageView) view.findViewById(R.id.food_sugar);
            energy = (TextView) view.findViewById(R.id.textView2);


        }



    }
}
