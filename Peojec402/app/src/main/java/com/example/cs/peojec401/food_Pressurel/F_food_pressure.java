package com.example.cs.peojec401.food_Pressurel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs.peojec401.FoodCon.BackgroundTask;
import com.example.cs.peojec401.R;



public class F_food_pressure extends Fragment {



    public F_food_pressure () {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_display_list, container, false);

        BackgroundTask backgroundTask = new BackgroundTask(getActivity(),"");
        backgroundTask.execute();

        return rootView;
    }


}