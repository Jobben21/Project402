package com.example.cs.peojec401.FoodCon;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.cs.peojec401.R;

import java.util.ArrayList;

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
    Context c;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<FoodList> arrayList = new ArrayList<>();

    public DisplayList(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_display_list, container, false);

        BackgroundTask backgroundTask = new BackgroundTask(getContext(),"");
        backgroundTask.execute();

        return rootView;
    }
}
