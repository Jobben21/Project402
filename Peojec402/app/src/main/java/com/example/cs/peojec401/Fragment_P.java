package com.example.cs.peojec401;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_P extends Fragment{

    private TextView age_profile,height_profile,weight_profile,BMI_profile,BMR_profile;
    ArrayList<Example> calculator;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
     View view = inflater.inflate(R.layout.fragment_layout_p,container,false);



        calculator = new ArrayList<>();
        Example ex = new Example();

        return view;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getActivity().setTitle("ประวัติส่วนตัว");

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

    private class ArrayList<T> {
    }
}
