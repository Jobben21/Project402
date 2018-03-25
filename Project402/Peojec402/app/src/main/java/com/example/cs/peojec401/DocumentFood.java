package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        Log.d(TAG,"onCreate; Started.");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getIncomingintent();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    private void getIncomingintent(){
        Log.d(TAG,"getIntent : checking for coming extra");

        if( getIntent().hasExtra("maindish_name")){
            Log.d(TAG,"getIntent : found for coming extra");

         //   String maindish_url = getIntent().getStringExtra("maindish_image");
            String maindish_name = getIntent().getStringExtra("maindish_food");
            Log.d(TAG,"getIntent : NameofFood  "+maindish_name);

            setImage(maindish_name);
        }
    }

    private void setImage(String maindish_name){
        Log.d(TAG,"setImage");

        TextView name = (TextView) findViewById(R.id.MainDish_food);
        name.setText(maindish_name);

       // ImageView imageView = (ImageView)findViewById(R.id.MainDish_image);
       // imageView.setImageDrawable(maindish_url);
    }
}
