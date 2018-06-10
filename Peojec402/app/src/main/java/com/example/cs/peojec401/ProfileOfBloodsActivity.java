package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.cs.peojec401.Blood.Blood_Sugar;
import com.example.cs.peojec401.Blood.Blood_choles;
import com.example.cs.peojec401.Blood.Blood_hdl;
import com.example.cs.peojec401.Blood.Blood_ldl;
import com.example.cs.peojec401.Blood.Blood_potssium;
import com.example.cs.peojec401.Blood.Blood_sodium;
import com.example.cs.peojec401.Blood.Blood_tri;

import org.json.JSONArray;


public class ProfileOfBloodsActivity extends AppCompatActivity {

    private TextView p_sugar,p_choles,p_hdl,p_ldl,p_potas,p_tri,p_so;
    private TextView p_sugar2,p_choles2,p_hdl2,p_ldl2,p_potas2,p_tri2,p_so2;
    private JSONArray result;
    private CardView click_sugar,click_sodium,click_potassium,click_chol,click_ldl,click_hdl,click_tri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_of_bloods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.register);
        setSupportActionBar(toolbar);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);





        click_sugar = (CardView)findViewById(R.id.click_sugar);
        click_sugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileOfBloodsActivity.this,Blood_Sugar.class);
                startActivity(intent);
            }
        });

        click_sodium = (CardView)findViewById(R.id.click_sodium);
        click_sodium .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileOfBloodsActivity.this,Blood_sodium.class);
                startActivity(intent);
            }
        });
        click_potassium = (CardView)findViewById(R.id.click_potass);
        click_potassium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileOfBloodsActivity.this,Blood_potssium.class);
                startActivity(intent);
            }
        });
        click_chol = (CardView)findViewById(R.id. click_choles);
        click_chol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileOfBloodsActivity.this,Blood_choles.class);
                startActivity(intent);
            }
        });
        click_ldl = (CardView)findViewById(R.id. click_ldl);
        click_ldl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileOfBloodsActivity.this,Blood_ldl.class);
                startActivity(intent);
            }
        });
        click_hdl = (CardView)findViewById(R.id.click_hdl);
        click_hdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileOfBloodsActivity.this,Blood_hdl.class);
                startActivity(intent);
            }
        });
        click_tri = (CardView)findViewById(R.id.click_tri);
        click_tri.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ProfileOfBloodsActivity.this,Blood_tri.class);
                startActivity(intent);
            }
        });

    }




    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
