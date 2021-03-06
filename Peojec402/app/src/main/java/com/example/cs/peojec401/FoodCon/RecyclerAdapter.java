package com.example.cs.peojec401.FoodCon;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs.peojec401.AfterBldT;
import com.example.cs.peojec401.DocumentFood;
import com.example.cs.peojec401.R;


import java.util.ArrayList;
import java.util.List;


import static com.example.cs.peojec401.DisplayList1.spinner;
import static com.example.cs.peojec401.FoodCon.BackgroundTask.mm;


/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

   ArrayList<FoodList> arrayList ;
    Context c;

        int size=0;

    int sum=0;

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
//        Toast.makeText(c,arrayList.size()+"1123 ", Toast.LENGTH_SHORT).show();



                final FoodList foodList = arrayList.get(position);


                holder.name.setText(foodList.getName());
               // holder.energy.setText(Integer.toString(foodList.getEnergy()));
                //holder.disease.setText(foodList.getFood_di());
                if(foodList.getFood_di().equals("เบาหวาน")){
                    holder.disease.setText("ควบคุมน้ำตาล");
                }else if(foodList.getFood_di().equals("ไตรกลีเซอไรด์")){
                    holder.disease.setText("ควบคุมไขมัน");
                }else if(foodList.getFood_di().equals("คอเลสเตอรอล")){
                    holder.disease.setText("ควบคุมไขมัน");
                }else if(foodList.getFood_di().equals("หัวใจ")){
                    holder.disease.setText("ควบคุมไขมัน");
                }else if(foodList.getFood_di().equals("โรคไต")){
                    holder.disease.setText("ควบคุมโซเดียม,โพแทสเซียม,โปรตีน");
                }else if(foodList.getFood_di().equals("ความดันโลหิต")){
                    holder.disease.setText("ควบคุมโซเดียม,ไขมัน");
                }


                PicassoDown.downloadImage(c, foodList.getFoodpic(), holder.imgfood);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        sum = position;
                        Intent i = new Intent(c, DocumentFood.class);
                        Bundle bundle = new Bundle();
                        i.putExtra("num", sum);
                        i.putExtra("name", foodList.getName());
                        i.putExtra("energy", foodList.getEnergy());
                        i.putExtra("carbo", foodList.getCarbo());
                        i.putExtra("fat", foodList.getFat());
                        i.putExtra("foodpic", foodList.getFoodpic());
                        i.putExtra("protein", foodList.getProtein());
                        i.putExtra("method", foodList.getMethod());
                        i.putExtra("ingred", foodList.getIngred());
                        i.putExtra("typeingred", foodList.getTypeingred());
                        i.putExtra("food_di",foodList.getFood_di());
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
        TextView disease;
        ImageView imgfood,imgno1;
        public  RecyclerViewHolder(View view){
            super(view);
            name = (TextView)view.findViewById(R.id.comment);
            energy = (TextView)view.findViewById(R.id.date);
            imgfood = (ImageView)view.findViewById(R.id.menufood);
            disease = (TextView)view.findViewById(R.id.dis_food1);

        }
    }


    }


