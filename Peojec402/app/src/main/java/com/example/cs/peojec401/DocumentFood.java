package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.CircularArray;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cs.peojec401.ConnectData.Config;
import com.example.cs.peojec401.ConnectData.Config_food;
import com.example.cs.peojec401.FoodCon.FoodList;
import com.example.cs.peojec401.FoodCon.PicassoDown;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

import static com.example.cs.peojec401.AfterBldT.bt;
import static com.example.cs.peojec401.Fragment_F4.i;

/**
 * Created by hp on 12/3/2561.
 */

public class DocumentFood extends AppCompatActivity {

    private static final String TAG = "DocumentFood";
    private JSONArray result;
    private TextView food_name,energy,carbo,fat,protein,sugar,ingred,method,type,sodium;
    private ImageView foodpic;
    private Random ran;

    private Button mainmenu;
    int num;
    String url="";
    ArrayList<FoodList> arrayList ;
    FoodList foodList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_food_dialog);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        Log.d(TAG,"onCreate; Started.");

        food_name= (TextView) findViewById(R.id.food_name);
        energy = (TextView) findViewById(R.id.energy_food);
        carbo = (TextView) findViewById(R.id.carbo_food);
        fat = (TextView) findViewById(R.id.fat_food);
        protein= (TextView) findViewById(R.id.protein_food);
        sugar = (TextView) findViewById(R.id.sugar_food);
        ingred = (TextView)findViewById(R.id.Option_foods);
        sodium = (TextView)findViewById(R.id.sodium_food);
        method = (TextView)findViewById(R.id.method_f);
        foodpic = (ImageView)  findViewById(R.id.foodpic);
        type = (TextView) findViewById(R.id.option2);
        mainmenu=(Button)findViewById(R.id.close_dialog2);

        Bundle bundle = getIntent().getExtras();
         num =bundle.getInt("num");
       // Toast.makeText(getApplicationContext(),bundle.getInt("energy")+" ",Toast.LENGTH_SHORT).show();
        if(!String.valueOf(bundle.getInt("energy")).equals("0")){
            energy.setText(String.valueOf(bundle.getInt("energy")));
        }else{
            energy.setText("-");
        }
        if (!String.valueOf(bundle.getInt("carbo")).equals("0")){
            carbo.setText(String.valueOf(bundle.getInt("carbo")));
        }else{

            carbo.setText("-");
        }
        if(!String.valueOf(bundle.getInt("fat")).equals("0")){
            fat.setText(String.valueOf(bundle.getInt("fat")));

        }else{

            fat.setText("-");
        }
        if(!String.valueOf(bundle.getInt("protein")).equals("0")){
            protein.setText(String.valueOf(bundle.getInt("protein")));

        }else{

            protein.setText("-");
        }

        if(!String.valueOf(bundle.getInt("sugar")).equals("0")){
           sugar.setText(String.valueOf(bundle.getInt("sugar")));

        }else{

            sugar.setText("-");
        }
        if(!String.valueOf(bundle.getInt("sodium")).equals("0")){
            sodium.setText(String.valueOf(bundle.getInt("sodium")));

        }else
        {

            sodium.setText("-");
        }
        food_name.setText(bundle.getString("name"));
        ingred.setText(bundle.getString("ingred"));
        method.setText(bundle.getString("method"));
        type.setText(bundle.getString("typeingred"));

        if(bundle.getString("foodpic").length()>0 &&bundle.getString("foodpic") != null){

            Picasso.with(getApplicationContext()).load(bundle.getString("foodpic")).into(foodpic);
        }
        else{
            Picasso.with(getApplicationContext()).load(R.drawable.arrow).into(foodpic);
        }




        mainmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DocumentFood.this,NavigationActivity.class);
                startActivity(intent);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getIncomingintent();
    }
     @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

