package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_H extends Fragment  {



    private CardView onet_t;


    public Fragment_H(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final  View v =  inflater.inflate(R.layout.fragment_layout_h,container,false);
        Bundle bundle = getArguments();
        onet_t = (CardView) v.findViewById(R.id.function1);
        onet_t.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Fragment_B fragment2 = new   Fragment_B();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_navigation, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        CardView   twot = (CardView) v.findViewById(R.id.function2);
        twot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               Fragment_F4 fragment4 = new   Fragment_F4();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_navigation, fragment4);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        CardView threet = (CardView) v.findViewById(R.id.function3);
        threet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Fragment_C fragmentc = new   Fragment_C();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction =        fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_navigation, fragmentc);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        CardView  fourt = (CardView) v.findViewById(R.id.function4);
        fourt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Fragment_P fragmentp = new Fragment_P();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_navigation, fragmentp);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
            });

      return v;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("หน้าเมนูหลัก");

    }






}
