package com.example.cs.myapplication.SQLite.FragmentBlood;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cs.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BloodFragment extends Fragment {


    public BloodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = (View)inflater.inflate(R.layout.fragment_blood, container, false);


        return v;
    }

}
