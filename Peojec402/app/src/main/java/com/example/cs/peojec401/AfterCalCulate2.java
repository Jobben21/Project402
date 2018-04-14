package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class AfterCalCulate2 extends AppCompatActivity {

    float bmiValue;
    TextView BMIvale,BMI_description,BMI_description2,BMI_description3,BMI_description4,BMI_description5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_cal_culate2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();


        return true;
    }

    public void onStart(){

        super.onStart();
        Intent intent = getIntent();

        bmiValue = intent.getFloatExtra("bmiValue",0);

        TextView bmi =(TextView)findViewById(R.id.BMII);
        bmi.setText(String.format("%.1f",bmiValue));

        checkData(bmiValue);

    }

    public void checkData(float bmiValue){

        if(bmiValue < 18.5){

        }
      /*  else if(){

        }
        else if(){

        }
        else if(){

        }
        else if(){

        }*/
    }

}
