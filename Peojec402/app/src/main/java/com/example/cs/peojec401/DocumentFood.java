package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by hp on 12/3/2561.
 */

public class DocumentFood extends AppCompatActivity {

    private static final String TAG = "DocumentFood";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_food_dialog);

        Log.d(TAG,"onCreate; Started.");


       // MainDishFood();
    }

    private void getIncomingintent(){
        Log.d(TAG,"getIntent : checking for coming extra");

        if(getIntent().hasExtra("maindish_image")&&getIntent().hasExtra("maindish_name")){
            Log.d(TAG,"getIntent : found for coming extra");

            String maindish_url = getIntent().getStringExtra("maindish_image");
            String maindish_name = getIntent().getStringExtra("maindish_food");

            setImage(maindish_url,maindish_name);
        }
    }

    private void setImage(String maindish_url,String maindish_name){
        Log.d(TAG,"setImage");

       TextView name = (TextView) findViewById(R.id.MainDish_food);
        name.setText(maindish_name);

        ImageView imageView = (ImageView)findViewById(R.id.MainDish_image);

    }
}
