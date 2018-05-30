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
        food_name.setText(bundle.getString("name"));
        energy.setText(String.valueOf(bundle.getInt("energy")));
        carbo.setText(String.valueOf(bundle.getInt("carbo")));
        fat.setText(String.valueOf(bundle.getInt("fat")));
        protein.setText(String.valueOf(bundle.getInt("protein")));
        sugar.setText(String.valueOf(bundle.getInt("sugar")));
        ingred.setText(bundle.getString("ingred"));
        sodium.setText(String.valueOf(bundle.getInt("sodium")));
        method.setText(bundle.getString("method"));
        type.setText(bundle.getString("typeingred"));

        if(bundle.getString("foodpic").length()>0 &&bundle.getString("foodpic") != null){

            Picasso.with(getApplicationContext()).load(bundle.getString("foodpic")).into(foodpic);
        }
        else{
            Picasso.with(getApplicationContext()).load(R.drawable.arrow).into(foodpic);
        }


//        getData();

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





//    private void getIncomingintent(){
//        Log.d(TAG,"getIntent : checking for coming extra");
//
//        if( getIntent().hasExtra("maindish_name")){
//            Log.d(TAG,"getIntent : found for coming extra");
//
//         //   String maindish_url = getIntent().getStringExtra("maindish_image");
//            String maindish_name = getIntent().getStringExtra("maindish_food");
//            Log.d(TAG,"getIntent : NameofFood  "+maindish_name);
//
//            setImage(maindish_name);
//        }
//    }
//
//    private void setImage(String maindish_name){
//        Log.d(TAG,"setImage");
//
//        TextView name = (TextView) findViewById(R.id.food_name);
//        name.setText(maindish_name);
//
//       // ImageView imageView = (ImageView)findViewById(R.id.MainDish_image);
//       // imageView.setImageDrawable(maindish_url);
//    }







    private void getData() {
        //Creating a string request


        if(i==2){
            url = Config_food.DATA_URLKidney;
        } if(i==3){

            url=Config_food.DATA_URLSugar;
        }
        if(bt==6){

            url=Config_food.DATA_URLBT;
            Log.d("btttt","asdasd");
        }


         StringRequest stringRequest = new StringRequest(url,
                 new Response.Listener<String>() {

                     @Override
                     public void onResponse(String response) {
                         JSONObject j = null;


                         try {
                             //Parsing the fetched Json String to JSON Object
                             j = new JSONObject(response);

                             //Storing the Array of JSON String to our JSON Array
                             result = j.getJSONArray(Config_food.JSON_ARRAY);


                             int n = num;

                             Picasso.with(getApplicationContext())
                                     .load(getFoodpic(n))
                                     .into(foodpic);
                             food_name.setText(getName(n));
                             energy.setText(getEnergy(n));
                             carbo.setText(getCarbohydrate(n));
                             fat.setText(getFat(n));
                             method.setText(getMethodF(n));
                             ingred.setText(getINGRED(n));
                             protein.setText(getProtein(n));
                             sugar.setText(getSugar(n));
                             sodium.setText(getSodium(n));
                             type.setText(getType(n));

//                            name_profile.setText(getName(0));
//                            age_profile.setText(getAge(0));
//                            height_profile.setText(getHeight(0));
//                            weight_profile.setText(getWeight(0));
//                            gender_profile.setText(getGender(0));
                             //Calling method getStudents to get the students from the JSON Array
                             //getStudents(result);
                         } catch (JSONException e) {
                             e.printStackTrace();
                         }
                     }
                 },
                 new Response.ErrorListener() {
                     @Override
                     public void onErrorResponse(VolleyError error) {

                     }
                 });

         //Creating a request queue
         RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());

         //Adding request to the queue
         requestQueue.add(stringRequest);

    }

    //Method to get student name of a particular position
    private String getName(int position){
        String name="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            name = json.getString(Config_food.FOOD_NAME);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    //Doing the same with this method as we did with getName()
    private String getFoodpic(int position){
        String foodpic="";
        try {
            JSONObject json = result.getJSONObject(position);
            foodpic = json.getString(Config_food.FOODPIC);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return foodpic;
    }

    //Doing the same with this method as we did with getName()
    private String getEnergy(int position){
        String energy="";
        try {
            JSONObject json = result.getJSONObject(position);
            energy = json.getString(Config_food.ENERGY);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return energy;
    }
    private String getCarbohydrate(int position){
        String carbohydrate="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            carbohydrate = json.getString(Config_food.CARBO);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return carbohydrate;
    }

    private String getFat(int position) {
        String fat = "";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            fat = json.getString(Config_food.FAT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return fat;

    }

    private String getProtein(int position) {
        String protein = "";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            protein = json.getString(Config_food.PROTEIN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return protein;

    }
    private String getSugar(int position) {
        String sugar = "";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            sugar = json.getString(Config_food.SUGAR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return sugar;

    }

    private String getMethodF(int position) {
        String method = "";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            method = json.getString(Config_food.FOODMEDTHOD);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return method;

    }
    private String getINGRED(int position) {
        String ingred = "";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
             ingred= json.getString(Config_food.FOODINGRED);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return ingred;

    }

    private String getType(int position) {
        String type = "";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            type= json.getString(Config_food.TYPEINGRED);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return type;

    }

    private String getSodium(int position) {
        String sodium = "";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            sodium= json.getString(Config_food.SODIUM);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return sodium;

    }

}

