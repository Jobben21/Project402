package com.example.cs.peojec401;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Created by hp on 11/1/2561.
 */

public class SugarFragment2 extends Fragment{

    private ListView listview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.listview_food,container,false);

        listview = (ListView)view.findViewById(R.id.listview);
        listview.setAdapter(new EfficientAdapter(getContext()));


        return  view;
    }

    public class EfficientAdapter extends BaseAdapter {

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

                convertView = mInflater.inflate(R.layout.sugar2,null);


            }else {


            }

            return convertView;
        }
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getActivity().setTitle("two");
    }
}
