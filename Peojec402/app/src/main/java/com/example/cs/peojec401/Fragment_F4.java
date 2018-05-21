package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cs.peojec401.FoodCon.DisplayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_F4 extends Fragment{


    private TextView descript_f,descript_h,descript_k,descript_p,descript_s;
    private CardView food_for_you1,food_heart1,food_kidney1,food_sugar1,food_pressure1;
    private TextView heart,kidney,sugar,press;
    public static int i;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_layout_f,container,false);


        food_heart1 = (CardView)v.findViewById(R.id.firstmenu);
        food_kidney1 = (CardView)v.findViewById(R.id.secondmenu);
        food_sugar1   = (CardView)v.findViewById(R.id.thridmenu);
        food_pressure1  = (CardView)v.findViewById(R.id.fourtmenu);
        food_for_you1  = (CardView)v.findViewById(R.id.fivemenu);
        heart=(TextView)v.findViewById(R.id.heart_b);
        kidney=(TextView)v.findViewById(R.id.kidney_b);
        sugar=(TextView)v.findViewById(R.id.sugar_b);
        press=(TextView)v.findViewById(R.id.press_b);
        food_heart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 1;


                Intent intent = new Intent(getActivity().getBaseContext(),FoodActivity.class);
                intent.putExtra("n",1);
                startActivity(intent);
            }});

        food_kidney1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                i = 2;


                Intent intent = new Intent(getActivity().getBaseContext(),DisplayList1.class);
                intent.putExtra("n",2);
                startActivity(intent);
            }});
       food_sugar1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               i = 3;
               Intent intent = new Intent(getActivity().getBaseContext(),DisplayList1.class);
               intent.putExtra("n",3);
               startActivity(intent);
           }});
       food_pressure1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               i = 4;
               Intent intent = new Intent(getActivity().getBaseContext(),FoodActivity.class);
               intent.putExtra("n",4);
              // startActivity(intent);
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
