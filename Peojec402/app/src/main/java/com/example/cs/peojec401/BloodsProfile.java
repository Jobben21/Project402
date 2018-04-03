package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hp on 1/4/2561.
 */

public class BloodsProfile extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloods_profile);

      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar6);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
