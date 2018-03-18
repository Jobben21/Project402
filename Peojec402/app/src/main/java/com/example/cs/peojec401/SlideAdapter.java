package com.example.cs.peojec401;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hp on 3/1/2561.
 */

public class SlideAdapter extends PagerAdapter {

        Context context;
        LayoutInflater inflater;



        public int[] lst_images = {
                R.drawable.slidet,
                R.drawable.slideo,
                R.drawable.slidet,
                R.drawable.slideo
        };

        public String[] lst_title = {
                "ONE","TWO","THREE","FOUR"
        };

        public String[] lst_description = {
                "According to South Korea's Unification Ministry," +"\n"+
                        "        North Korea made the first contact " +"\n"+
                        "via the phone line at exactly the time ordered.",
                "According to South Korea's Unification Ministry," +"\n"+
                        "        North Korea made the first contact" +"\n"+
                        " via the phone line at exactly the time ordered.",
                "According to South Korea's Unification Ministry," +"\n"+
                        "        North Korea made the first contact" +"\n"+
                        " via the phone line at exactly the time ordered.",
                "According to South Korea's Unification Ministry," +"\n"+
                        "        North Korea made the first contact" +"\n"+
                        " via the phone line at exactly the time ordered."
        };

         public int[] lst_backgroundColor = {

                 Color.rgb(255, 255, 255),
                 Color.rgb(255, 255, 255),
                 Color.rgb(255, 255, 255),
                 Color.rgb(255, 255, 255)
         };

    public SlideAdapter(Context context){
        this.context = context;
    }



    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view  =  inflater.inflate(R.layout.slide,container,false);

        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelayout);

        ImageView imgslide  = (ImageView)view.findViewById(R.id.slidet);

        TextView textView1 = (TextView)view.findViewById(R.id.caption1);
        TextView textView2 = (TextView)view.findViewById(R.id.caption2);

        layoutslide.setBackgroundColor(lst_backgroundColor[position]);
        imgslide.setImageResource(lst_images[position]);
        textView1.setText(lst_title[position]);
        textView2.setText(lst_description[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

     container.removeView((LinearLayout)object);
    }


}
