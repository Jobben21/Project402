package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_H extends Fragment  {



    private ImageButton onet_t;


    public Fragment_H(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final  View v =  inflater.inflate(R.layout.fragment_layout_h,container,false);
        Bundle bundle = getArguments();
        onet_t = (ImageButton) v.findViewById(R.id.oneh);
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

        ImageButton   twot = (ImageButton) v.findViewById(R.id.twoh);
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

        ImageButton threet = (ImageButton) v.findViewById(R.id.threeh);
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

        ImageButton  fourt = (ImageButton) v.findViewById(R.id.fourh);
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
