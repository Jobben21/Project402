package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cs.peojec401.ConnectData.Config_food;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Created by hp on 12/3/2561.
 */

public class DocumentFood extends AppCompatActivity {

    private static final String TAG = "DocumentFood";
    private JSONArray result;
    private TextView food_name,energy,carbo,fat,protein,sugar;
    private ImageView foodpic;
    private Random ran;

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

        foodpic = (ImageView)  findViewById(R.id.foodpic);
        getData();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getIncomingintent();
    }
//    @Override
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }
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


    private void getData(){
        //Creating a string request

        StringRequest stringRequest = new StringRequest(Config_food.DATA_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;



                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(Config_food.JSON_ARRAY);




                            Picasso.with(getApplicationContext())
                                    .load(getFoodpic(0))
                                    .into(foodpic);
                            food_name.setText(getName(0));
                            energy.setText(getEnergy(0));
                            carbo.setText(getCarbohydrate(0));
                            fat.setText(getFat(0));
                            protein.setText(getProtein(0));
                            sugar.setText(getSugar(0));

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

    private Integer getRan(){
            ran = new Random();
        int num= ran.nextInt(5);

        return num;
    }
}

