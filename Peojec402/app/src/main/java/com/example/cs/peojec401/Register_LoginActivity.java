package com.example.cs.peojec401;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs.peojec401.ConnectData.Con_regis;

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

public class Register_LoginActivity extends AppCompatActivity {

    private EditText username,pass;
    private Button login,register;
    private TextView eyeview;

    public static String nameLogin;
    public static String ageLogin;
    public static String passLogin;
    public static String heightLogin;
    public static String weightLogin;
    public static String genderLogin;
    public static String idLogin;
    private int setPtype;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_register__login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.bloods);
        setSupportActionBar(toolbar);

        username = (EditText)findViewById(R.id.username2);
        pass = (EditText) findViewById(R.id.pass);
        login = (Button)findViewById(R.id.login2);
        register = (Button)findViewById(R.id.register);
        eyeview = (TextView)findViewById(R.id.eyeview);

        final AlertDialog.Builder ad = new AlertDialog.Builder(this);
        final Con_regis  con_regis = new Con_regis(this);





        if (Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }
        eyeview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setPtype==1){
                    setPtype=0;
                    pass.setTransformationMethod(null);
                    if(pass.getText().length()>0){
                        pass.setSelection(pass.getText().length());
                        eyeview.setBackgroundResource(R.drawable.eyeoff);
                    }

                }else {
                    setPtype=1;
                    pass.setTransformationMethod(new PasswordTransformationMethod());
                    if(pass.getText().length()>0){
                        pass.setSelection(pass.getText().length());
                        eyeview.setBackgroundResource(R.drawable.eye);
                    }
                }

            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String url = "http://192.168.1.10/android/login.php?status=0";

                List<NameValuePair> params = new ArrayList<NameValuePair>();

                params.add(new BasicNameValuePair("struser", username.getText().toString()));
                params.add(new BasicNameValuePair("strpass", pass.getText().toString()));



                String resultServer  = getHttpPost(url,params);
                String name= "0";

                String pass ="";
                String id= "";

                String age = "";

                String height = "";

                String weight = "";

                String gender = "";


                JSONObject c;

                try {

                    c = new JSONObject(resultServer);

                    name = c.getString("name");
                    pass = c.getString("pass");
                    age = c.getString("age");

                    height = c.getString("height");
                    weight = c.getString("weight");
                    gender = c.getString("gender");
                    id = c.getString("id");
                } catch (JSONException e) {

// TODO Auto-generated catch block

                    e.printStackTrace();

                }

                if(name.equals("0"))

                {

                    if(username.getText().toString().equals("")){
                        new SweetAlertDialog(Register_LoginActivity.this,SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("เข้าสู่ระบบ")
                                .setContentText("กรุณาใส่ชื่อของท่าน")
                                .setConfirmText("ตกลง")
                                .show();

                        username.setError("กรุณาใส่ชื่อของท่าน");

                    }else{

                        new SweetAlertDialog(Register_LoginActivity.this,SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("เข้าสู่ระบบ")
                                .setContentText("กรุณาลงทะเบียนเข้าใช้งาน")
                                .setConfirmText("ตกลง")
                                .show();

                        username.setError("กรุณาใส่ชื่อของท่าน");
                    }




                }

                else

                {

                    nameLogin = name;
                    ageLogin = age;
                    passLogin=pass;
                    idLogin=id;
                    heightLogin=height;
                    weightLogin=weight;
                    genderLogin=gender;
                    SweetAlertDialog pDialog = new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);

                    //  pDialog = new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);

                    new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);

                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//                    pDialog.setTitleText("รอสักครู่");
//                    pDialog.setCancelable(false);
//                    pDialog.show();

                    Intent intent = new Intent(Register_LoginActivity.this,NavigationActivity.class);

                    startActivity(intent);


//            Intent newActivity = new Intent(MainActivity.this,DetailActivity.class);
//
//            newActivity.putExtra("MemberID", strMemberID);
//
//            startActivity(newActivity);

                }





//                if(username.getText().toString().isEmpty()){
//
//                    new SweetAlertDialog(Register_LoginActivity.this,SweetAlertDialog.WARNING_TYPE)
//                            .setTitleText("เข้าสู่ระบบ")
//                            .setContentText("กรอกชื่อผู้ใช้งานให้ครบถ้วน")
//                            .setConfirmText("ตกลง")
//                            .show();
//
//                   // username.setError("กรอกชื่อผู้ใช้งานให้ครบถ้วน");
//                }
//
//                else {
//
//                    SweetAlertDialog pDialog = new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
//
//                    //  pDialog = new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
//
//                    new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);
//
//                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
//                    pDialog.setTitleText("รอสักครู่");
//                    pDialog.setCancelable(false);
//                    pDialog.show();
//
//                    Intent intent = new Intent(Register_LoginActivity.this,NavigationActivity.class);
//                    startActivity(intent);
//
//                }




            }




        });



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_LoginActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }

    public String getHttpPost(String url,List<NameValuePair> params) {

        StringBuilder str = new StringBuilder();

        HttpClient client = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost(url);

        try {

            httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));

            HttpResponse response = client.execute(httpPost);

            StatusLine statusLine = response.getStatusLine();

            int statusCode = statusLine.getStatusCode();

            if (statusCode == 200) { // Status OK

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



}
