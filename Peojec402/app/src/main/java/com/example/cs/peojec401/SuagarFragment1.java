package com.example.cs.peojec401;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by hp on 11/1/2561.
 */

public class SuagarFragment1 extends Fragment {

    private ListView listview;
    private TextView result;
    private ArrayList<String> list;

    private RecyclerView mRecyclerView;
    private MainDishFragment.ListAdapter mListadapter;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {



        View view =  inflater.inflate(R.layout.listview_food,container,false);

        listview = (ListView)view.findViewById(R.id.listview);
        listview.setAdapter(new EfficientAdapter(getContext()));

       // result = (TextView)view.findViewById(R.id.Result);
      //  Intent inent;
        return  view;

    }


    public class EfficientAdapter extends BaseAdapter{

        public Context mContext;
        public LayoutInflater mInflater;

        public EfficientAdapter(Context context){

            mContext=context;
            mInflater = LayoutInflater.from(mContext);
        }

        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){

                convertView = mInflater.inflate(R.layout.sugar1,null);


            }else {


            }

            return convertView;
        }
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }
}
