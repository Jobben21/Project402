package com.example.cs.peojec401.FoodCon;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.cs.peojec401.R;

//public class DisplayList extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_display_list);
//
//       BackgroundTask backgroundTask = new BackgroundTask(DisplayList.this);
//        backgroundTask.execute();
//    }
//}
public class DisplayList extends Fragment {

    public DisplayList(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_display_list, container, false);

        BackgroundTask backgroundTask = new BackgroundTask(getActivity());
        backgroundTask.execute();

        return rootView;
    }
}
