package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cs.peojec401.FoodCon.DisplayList;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_F4 extends Fragment{


    private TextView descript_f,descript_h,descript_k,descript_p,descript_s;
    private CardView food_for_you1,food_heart1,food_kidney1,food_sugar1,food_pressure1;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_layout_f,container,false);


        food_heart1 = (CardView)v.findViewById(R.id.firstmenu);
        food_kidney1 = (CardView)v.findViewById(R.id.secondmenu);
        food_sugar1   = (CardView)v.findViewById(R.id.thridmenu);
        food_pressure1  = (CardView)v.findViewById(R.id.fourtmenu);
        food_for_you1  = (CardView)v.findViewById(R.id.fivemenu);

        food_heart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(),FoodActivity.class);
                intent.putExtra("num",1);

                startActivity(intent);
            }});

        food_kidney1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(),DisplayList.class);
                intent.putExtra("num",2);
                startActivity(intent);
            }});
       food_sugar1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(getActivity().getBaseContext(),FoodActivity.class);
               intent.putExtra("num",3);
               startActivity(intent);
           }});
       food_pressure1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(getActivity().getBaseContext(),FoodActivity.class);
               intent.putExtra("num",4);
               startActivity(intent);
           }});
        food_for_you1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity().getBaseContext(),FoodRecod_F4.class);
                intent.putExtra("num",5);
                startActivity(intent);
            }});

        return v;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getActivity().setTitle("เมนูอาหารตามโรค");
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
