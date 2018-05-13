package com.example.cs.peojec401;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AfterCalCulat extends AppCompatActivity{

    private Button button_cal;
    private ImageButton information;
    final Context context = this;
    private Button button_dialog2;
    private TextView bmi,bmr;
    private ImageView imageViewFood;

   public static float bmiValue;
    public static float bmrValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_cal_culat);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

//       bmi_p = (TextView) findViewById(R.id.bmi);
//        bmr_p = (TextView) findViewById(R.id.bmr);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        popUp();

        button_cal = (Button)findViewById(R.id.button_cal);
        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SweetAlertDialog(AfterCalCulat.this,SweetAlertDialog.WARNING_TYPE).setTitleText("คุณต้องการ")
                        .setContentText("กลับสู่หน้าหลัก").setConfirmText("หน้าเมนูหลัก").setCancelText("ไม่ต้องการ")
                        .showCancelButton(true).setCancelClickListener(
                        new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.cancel();

                            }
                        }).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog dialog) {

                        new SweetAlertDialog(AfterCalCulat.this,SweetAlertDialog.SUCCESS_TYPE).setTitleText("เรียบร้อย").setConfirmClickListener(
                                new SweetAlertDialog.OnSweetClickListener(){
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {

                                        Intent intent = new Intent(AfterCalCulat.this,NavigationActivity.class);
                                        startActivity(intent);
                                    }
                                }
                        ).show();
                    }
                }).show();

            }
        });
    }




    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public void onStart(){

        super.onStart();
        Intent intent = getIntent();

        String message = intent.getStringExtra("bmi");
        String message2 = intent.getStringExtra("bmi2");

        float weight = intent.getFloatExtra("WEIGHT",0);
        float height = intent.getFloatExtra("HEIGHT",0);

        bmiValue = intent.getFloatExtra("bmiValue",0);
        bmrValue = intent.getFloatExtra("bmrValue",0);

        TextView bmi =(TextView)findViewById(R.id.bmi);
        bmi.setText(String.format("%.1f",bmiValue));

        TextView bmr =(TextView)findViewById(R.id.bmr);
        bmr.setText(String.format("%.1f",bmrValue));

        TextView description =(TextView)findViewById(R.id.explanation_BMI);
        description.setText(message);

        imageViewFood =(ImageView)findViewById(R.id.imageViewFood);

        showImage(message2);
      //  SaveData();
    }

    public void popUp(){

        information = (ImageButton)findViewById(R.id.BMIinformation);
        information.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AfterCalCulat.this,AfterCalCulate2.class);
                intent.putExtra("bmiValue",bmiValue);
                startActivity(intent);

            }
        });
    }


    public boolean SaveData() {




        String url = "http://192.168.1.8/android/add_bmr.php?status=0";

        List<NameValuePair> para = new ArrayList<NameValuePair>();

        para.add(new BasicNameValuePair("bmi", bmr.getText().toString()));
        para.add(new BasicNameValuePair("bmr", bmi.getText().toString()));


        String resultServer = gettHttpPost(url, para);

        String StatusId = "";
        String Error = "Unknow Status!";
        String a = "";
        JSONObject c;
        try {
            c = new JSONObject(resultServer);
            a = c.getString("StatusID");
            StatusId = c.getString("StatusID");

            Error = c.getString("Error");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Toast.makeText(getApplicationContext(), StatusId,
                Toast.LENGTH_SHORT).show();



        return true;
    }


    private String gettHttpPost(String url, List<NameValuePair> para) {

        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try {
            httppost.setEntity(new UrlEncodedFormEntity(para, "UTF-8"));

            HttpResponse response = client.execute(httppost);
            StatusLine statusline = response.getStatusLine();
            int statusCode = statusline.getStatusCode();
            if (statusCode == 200) {

                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }




    public void showImage(String message2){

        int resource_id = this.getResources().getIdentifier("drawable/" + message2, null, this.getPackageName());
        imageViewFood =(ImageView)findViewById(R.id.imageViewFood);
        imageViewFood.setImageResource(resource_id);

    }

}
