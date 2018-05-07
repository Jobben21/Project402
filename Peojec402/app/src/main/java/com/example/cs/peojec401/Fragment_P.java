package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cs.peojec401.ConnectData.Config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_P extends Fragment{

    private TextView  name_profile,age_profile,height_profile,weight_profile,BMI_profile,BMR_profile,gender_profile;
    ArrayList<Example> calculator;
    private Button bloodprofile;
    private ImageButton editprofile;
    private CardView cardView;
    private JSONArray result;
    private String name, gender,weight,height,age2;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_p,container,false);



        calculator = new ArrayList<>();
        Example ex = new Example();
        name_profile = (TextView) view.findViewById(R.id.name_profile);
        age_profile = (TextView) view.findViewById(R.id.age_Profile);
        height_profile = (TextView) view.findViewById(R.id.height_profile);
        weight_profile = (TextView) view.findViewById(R.id.weight_profile);
        gender_profile = (TextView) view.findViewById(R.id.gender_profile);
        cardView = (CardView)view.findViewById(R.id.bloodProfile);
        bloodprofile = (Button)view.findViewById(R.id.bloodprofile);
        editprofile = (ImageButton)view.findViewById(R.id.editprofile);


        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(),ProfileOfBloodsActivity.class);
                startActivity(intent);

            }
        });

        bloodprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(),NavigationActivity.class);
                startActivity(intent);

            }
        });

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(),EditActivity.class);
                name = name_profile.getText().toString();
                age2 = age_profile.getText().toString();
                gender = gender_profile.getText().toString();
                height = height_profile.getText().toString();
                weight = weight_profile.getText().toString();

                intent.putExtra("name",name);
                intent.putExtra("age2",age2);
                intent.putExtra("gender",gender);
                intent.putExtra("height",height);
                intent.putExtra("weight",weight);

                startActivity(intent);

            }
        });


        getData();

        return view;


    }



    private void getData(){
        //Creating a string request

        StringRequest stringRequest = new StringRequest(Config.DATA_URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;

                        Toast.makeText(getContext(),"Successfully",Toast.LENGTH_LONG).show();

                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(Config.JSON_ARRAY);


                            name_profile.setText(getName(0));
                            age_profile.setText(getAge(0));
                            height_profile.setText(getHeight(0));
                            weight_profile.setText(getWeight(0));
                            gender_profile.setText(getGender(0));
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
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

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
            name = json.getString(Config.NAME);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return name;
    }

    //Doing the same with this method as we did with getName()
    private String getAge(int position){
        String age="";
        try {
            JSONObject json = result.getJSONObject(position);
           age = json.getString(Config.AGE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return age;
    }

    //Doing the same with this method as we did with getName()
    private String getHeight(int position){
        String height="";
        try {
            JSONObject json = result.getJSONObject(position);
            height = json.getString(Config.HEIGHT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return height;
    }
    private String getWeight(int position){
        String weight="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            weight = json.getString(Config.WEIGHT);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return weight;
    }
    private String getGender(int position){
        String gender="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            gender = json.getString(Config.GENDER);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return gender;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getActivity().setTitle("ประวัติส่วนตัว");

    }

//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        //Setting the values to textviews for a selected item
//        name_profile.setText(getName(position));
//        age_profile.setText(getAge(position));
//        height_profile.setText(getHeight(position));
//        weight_profile.setText(getWeight(position));
//    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private class ArrayList<T> {
    }
}