package com.example.cs.peojec401;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.cs.peojec401.FoodCon.FoodList;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by นครินทร์ on 5/11/2018.
 */

public class BloodDisplay extends AppCompatActivity {

    private TextView p_sugar,p_choles,p_hdl,p_ldl,p_potas,p_tri,p_so;
    private TextView p_sugar2,p_choles2,p_hdl2,p_ldl2,p_potas2,p_tri2,p_so2;
    private JSONArray result;
    ArrayList<BloodList> arrayList ;
    BloodList bloodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_of_bloods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.register);
        setSupportActionBar(toolbar);


        p_sugar = (TextView) findViewById(R.id.profile_sugar);
        p_choles = (TextView)findViewById(R.id.Profile_choles);
        p_hdl = (TextView) findViewById(R.id.profile_hdl);
        p_ldl = (TextView) findViewById(R.id.Profile_ldl);
        p_potas = (TextView) findViewById(R.id.profile_potassium);
        p_tri = (TextView) findViewById(R.id.profile_tri);
        p_so = (TextView) findViewById(R.id.profile_sodium);


        p_sugar2 = (TextView) findViewById(R.id.profile_sugar2);
        p_choles2 = (TextView)findViewById(R.id.Profile_choles2);
        p_hdl2 = (TextView) findViewById(R.id.profile_hdl2);
        p_ldl2 = (TextView) findViewById(R.id.Profile_ldl2);
        p_potas2 = (TextView) findViewById(R.id.profile_potassium2);
        p_tri2 = (TextView) findViewById(R.id.profile_tri2);
        p_so2 = (TextView) findViewById(R.id.profile_sodium2);

        if (Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }
        Blood backgroundWorker = new Blood(this);
        backgroundWorker.execute();
        OnReg();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void OnReg(){

        for(int a=0;a<=5;a++){
               bloodList = arrayList.get(a);
        }

            p_sugar.setText(bloodList.getSugar());
            p_choles.setText(bloodList.getCholes());
            p_hdl.setText(bloodList.getHdl());
            p_ldl.setText(bloodList.getLdl());
            p_potas.setText(bloodList.getPotassium());
            p_tri.setText(bloodList.getTrigly());
            p_so.setText(bloodList.getSodium());

    }
}
