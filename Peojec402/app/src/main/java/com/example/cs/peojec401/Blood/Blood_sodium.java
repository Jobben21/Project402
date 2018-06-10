package com.example.cs.peojec401.Blood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.SeekBar;

import com.example.cs.peojec401.R;

public class Blood_sodium extends AppCompatActivity {

    private SeekBar seekBar9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_sodium);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void Bar(){

        seekBar9 = (SeekBar)findViewById(R.id.seekBar9);
        seekBar9.setProgress(20);
        seekBar9.setEnabled(false);
    }



}
