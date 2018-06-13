package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.json.JSONArray;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.example.cs.peojec401.AfterCalCulat.bmiValue;
import static com.example.cs.peojec401.AfterCalCulat.bmrValue;
import static com.example.cs.peojec401.EditActivity.age_edit;
import static com.example.cs.peojec401.EditActivity.gender_edit;
import static com.example.cs.peojec401.EditActivity.height_edit;
import static com.example.cs.peojec401.EditActivity.seti;
import static com.example.cs.peojec401.EditActivity.weight_edit;
import static com.example.cs.peojec401.Register_LoginActivity.ageLogin;
import static com.example.cs.peojec401.Register_LoginActivity.genderLogin;
import static com.example.cs.peojec401.Register_LoginActivity.heightLogin;
import static com.example.cs.peojec401.Register_LoginActivity.nameLogin;
import static com.example.cs.peojec401.Register_LoginActivity.weightLogin;


/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_P extends Fragment{

    private TextView  name_profile,age_profile,height_profile,weight_profile,BMI_profile,BMR_profile,gender_profile;
    ArrayList<Example> calculator;
    private Button bloodprofile,logout;
    private ImageButton editprofile;
    private CardView cardView;
    private JSONArray result;
    private WebView webView;
    private String name, gender,weight,height,age2;
    Intent intent;

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
        BMI_profile = (TextView)view.findViewById(R.id.BMI_Profile);
        BMR_profile = (TextView)view.findViewById(R.id.BMR_Profile);
        logout = (Button)view.findViewById(R.id.logout);
//        webView = (WebView)view.findViewById(R.id.pdf);
//        String myPdfUrl = "https://drive.google.com/open?id=0Bwjc-xrXV84UNURoTnVCSzVQWVJwdUk2SUtpNzRicTl2Wi1z";
//        String url = "http://docs.google.com/gview?embedded=true&url=" + myPdfUrl;
//
//      //  Log.i(TAG, "Opening PDF: " + url);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl(url);

        if (Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }



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
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getBaseContext(),Register_LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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

        if(seti==0) {
            name_profile.setText(nameLogin);
            age_profile.setText(ageLogin);
            weight_profile.setText(weightLogin);
            height_profile.setText(heightLogin);
            gender_profile.setText(genderLogin);
            String bmr = String.valueOf(String.format("%.1f", bmrValue));
            String bmi = String.valueOf(String.format("%.1f", bmiValue));
            BMR_profile.setText(bmr);
            BMI_profile.setText(bmi);
        }else if(seti==1){

            name_profile.setText(nameLogin);
            age_profile.setText(age_edit);
            weight_profile.setText(weight_edit);
            height_profile.setText(height_edit);
            gender_profile.setText(gender_edit);
            String bmr = String.valueOf(String.format("%.1f", bmrValue));
            String bmi = String.valueOf(String.format("%.1f", bmiValue));
            BMR_profile.setText(bmr);
            BMI_profile.setText(bmi);
        }
        return view;


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