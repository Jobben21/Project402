package com.example.cs.peojec401.FoodCon;

import android.content.Context;
import android.widget.ImageView;

import com.example.cs.peojec401.R;
import com.squareup.picasso.Picasso;
/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class PicassoDown {



    public static  void  downloadImage(Context ctx, String imgurl, ImageView img){

        if(imgurl.length()>0 && imgurl != null){

           Picasso.with(ctx).load(imgurl).into(img);
        }
        else{
           Picasso.with(ctx).load(R.drawable.arrow).into(img);
        }
    }
}
