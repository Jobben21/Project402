package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cs.peojec401.ConnectData.Config_bt;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hp on 1/4/2561.
 */

public class BloodsProfile extends AppCompatActivity{

    private TextView p_sugar,p_choles,p_hdl,p_ldl,p_potas,p_tri,p_so;
    private JSONArray result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bloods_profile);


        p_sugar = (TextView) findViewById(R.id.profile_sugar);
        p_choles = (TextView)findViewById(R.id.Profile_choles);
        p_hdl = (TextView) findViewById(R.id.profile_hdl);
        p_ldl = (TextView) findViewById(R.id.Profile_ldl);
        p_potas = (TextView) findViewById(R.id.profile_potassium);
        p_tri = (TextView) findViewById(R.id.profile_tri);
        p_so = (TextView) findViewById(R.id.profile_sodium);

      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar6);
        //setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getData();
    }



    private void getData(){
        //Creating a string request

        StringRequest stringRequest = new StringRequest(Config_bt.DATA_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;

                        Toast.makeText(BloodsProfile.this,"Successfully",Toast.LENGTH_LONG).show();

                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(Config_bt.JSON_ARRAY);

                            p_sugar.setText(getSugar(0));
                            p_choles.setText(getCholes(0));
                            p_hdl.setText(getHdl(0));
                            p_ldl.setText(getLdl(0));
                            p_potas.setText(getPotassium(0));
                            p_tri.setText(getTri(0));
                            p_so.setText(getSodium(0));
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
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //Adding request to the queue
        requestQueue.add(stringRequest);
    }



    //Method to get student name of a particular position
    private String getSugar(int position){
        String sugar="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            sugar = json.getString(Config_bt.SUGAR);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return sugar;
    }

    //Doing the same with this method as we did with getName()
    private String getCholes(int position){
        String choles="";
        try {
            JSONObject json = result.getJSONObject(position);
            choles = json.getString(Config_bt.CHOLES);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return choles;
    }

    //Doing the same with this method as we did with getName()
    private String getHdl(int position){
        String hdl="";
        try {
            JSONObject json = result.getJSONObject(position);
            hdl = json.getString(Config_bt.HDL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hdl;
    }
    private String getLdl(int position){
        String ldl="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            ldl = json.getString(Config_bt.LDL);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return ldl;
    }

    private String getPotassium(int position){
        String potas="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            potas = json.getString(Config_bt.POTAS);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return potas;
    }

    private String getTri(int position){
        String tri="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            tri = json.getString(Config_bt.TRI);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return tri;
    }

    private String getSodium(int position){
        String sod="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            sod = json.getString(Config_bt.SODIUM);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return sod;
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
