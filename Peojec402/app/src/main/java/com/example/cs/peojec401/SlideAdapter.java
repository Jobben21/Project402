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
                "แอปพลิเคชั่นเเนะนำเมนูอาหาร","ผลตรวจเลือด","เเนะนำเมนูอาหาร","เเนะนำเมนูอาหารตามโรค"
        };

        public String[] lst_description = {

                "ในปัจจุบันผู้สูงอายุหันมาสนใจดูเเลสุขภาพ"+"\n"+
                        "มากขึ้น การรับประทานอาหารจึงเป็นปัจจัยที่สำคัญ"+"\n"+
                        "ดังนั้น ผู้สูงอายุควรใส่ใจเรื่องอาหารเพื่อสุขภาพที่ดีขึ้น",
                "นำผลตรวจเลือดที่ได้จากโรงพยาบาล " +"\n"+
                        "มาประเมินผลผล เพื่อตรวจสอบความผิดปกติ" +"\n"+
                        "พร้อมคำอธิบายผลตตรวจเลือดในเเต่ล่ะช่วง",
                "เเนะนำเมนูอาหารที่เหมาะสำหรับกับสุขภาพ" +"\n"+
                        "ร่างกายของผู้ใช้งานโดยใช้ผลตรวจเลือดมาวิเคราะห์",
                      //  " via the phone line at exactly the time ordered."

                "เเนะนำเมนูอาหารเหมาะกับโรคต่าง ๆ เช่น" +"\n"+
                        "โรคเบาหวาน โรคไต โรคความดันสูง โรคหัวใจ" +"\n"+
                        "เพื่อช่วยให้ผู้สูงอายุนสามารถทำเมนูให้เหมาะสมกับสุขภาพร่างกาย"
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
