package com.example.cs.peojec401;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
//    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText e_name,e_height,e_weight,e_age,e_pass;
    private TextView eyeview;
    private RadioGroup gender;
    private  int setPtype;
    String StatusId="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.loginn);
        setSupportActionBar(toolbar);
        gender = (RadioGroup) findViewById(R.id.radio_gender);
        e_name = (EditText) findViewById(R.id.e_name);
        e_pass = (EditText) findViewById(R.id.e_pass);
        e_age = (EditText)findViewById(R.id.Age_login);
        e_height = (EditText)findViewById(R.id.Height_login);
        e_weight = (EditText)findViewById(R.id.weight_login);

        eyeview = (TextView) findViewById(R.id.eyeview1);
        setPtype=1;

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);




        if (Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }
        eyeview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(setPtype==1){
                    setPtype=0;
                    e_pass.setTransformationMethod(null);
                    if(e_pass.getText().length()>0){
                        e_pass.setSelection(e_pass.getText().length());
                        eyeview.setBackgroundResource(R.drawable.eyeoff);
                    }

                }else {
                    setPtype=1;
                    e_pass.setTransformationMethod(new PasswordTransformationMethod());
                    if(e_pass.getText().length()>0){
                        e_pass.setSelection(e_pass.getText().length());
                        eyeview.setBackgroundResource(R.drawable.eye);
                    }
                }

            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                if(e_name.getText().length()==0 ){



                    e_name.setError("กรุณาใส่ชื่อของท่าน");


                }
                 if(e_height.getText().length()==0){



                    e_height.setError("กรอกสข้อมูส่วนสูง");

                }
                 if(e_weight.getText().length()==0){


                    e_weight.setError("กรอกข้อมูลน้ำหนัก");
                }
                 if(e_age.getText().length()==0){


                    e_age.setError("กรุณากรอกอายุ");
                } if(e_name.getText().length()==0 && e_height.getText().length()==0 && e_weight.getText().length()==0
                        && e_age.getText().length()==0){

                    new SweetAlertDialog(LoginActivity.this,SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("ลงทะเบียน")
                            .setContentText("กรุณากรอกข้อมูลให้ครบถ้วน")
                            .setConfirmText("ตกลง")
                            .show();
                    e_name.setError("กรุณากรอกชื่อ");
                    e_weight.setError("กรุณากรอกน้ำหนัก");
                    e_height.setError("กรุณากรอกส่วนสูง");
                    e_age.setError("กรุณากรอกอายุ");


                }

                //attemptLogin();
                if (e_name.getText().length()!=0 && e_height.getText().length()!=0 && e_weight.getText().length()!=0
                        && e_age.getText().length()!=0) {
                    SaveData();
                    if(!StatusId.equals("2")) {
                        Intent intent = new Intent(LoginActivity.this, Register_LoginActivity.class);
                        startActivity(intent);
                    }else{

                        new SweetAlertDialog(LoginActivity.this,SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("ลงทะเบียน")
                                .setContentText("มีชื่อนี้แล้วในระบบ")
                                .setConfirmText("ตกลง")
                                .show();
                    }


                }

            }
        });

//        mLoginFormView = findViewById(R.id.login_form);
//        mProgressView = findViewById(R.id.login_progress);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    //// "SAVE DATA"

    public boolean SaveData(){


        int checkedRadioButtonID = gender.getCheckedRadioButtonId ( );
        RadioButton checkedRadioButton = ( RadioButton )findViewById ( checkedRadioButtonID );

        String checkedLabel = checkedRadioButton.getText ( ).toString ( );


        final AlertDialog.Builder ad= new AlertDialog.Builder(this);

        ad.setTitle("Error!");
        ad.setIcon(android.R.drawable.btn_star_big_on);
        ad.setPositiveButton("Close",null);





        String url = "http://172.25.74.91/android/addData.php?status=0";

        List<NameValuePair> para = new ArrayList<NameValuePair>();

        para.add(new BasicNameValuePair("name",e_name.getText().toString()));
        para.add(new BasicNameValuePair("pass",e_pass.getText().toString()));
        para.add(new BasicNameValuePair("age",e_age.getText().toString()));
        para.add(new BasicNameValuePair("height",e_height.getText().toString()));
        para.add(new BasicNameValuePair("weight",e_weight.getText().toString()));
        para.add(new BasicNameValuePair("gender",checkedLabel));



        String resultServer = gettHttpPost(url,para);

        StatusId = "";
        String Error = "Unknow Status!";
        String a="";
        JSONObject c;
        try{
            c = new JSONObject(resultServer);
            a = c.getString("StatusID");
            StatusId = c.getString("StatusID");

            Error = c.getString("Error");

        } catch (JSONException e){
            e.printStackTrace();
        }

        if(StatusId.equals("0")){
            ad.setMessage(Error);
            ad.show();

        }else if (StatusId.equals("2")){

            ad.setMessage(Error);
            ad.show();


        }





        return  true;
    }


/// "HTTP"

    private String gettHttpPost(String url, List<NameValuePair> para) {

        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try{
            httppost.setEntity(new UrlEncodedFormEntity(para,"UTF-8"));

            HttpResponse response = client.execute(httppost);
            StatusLine statusline = response.getStatusLine();
            int statusCode = statusline.getStatusCode();
            if(statusCode==200){

                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line ;
                while ((line = reader.readLine())!=null){
                    str.append(line);
                }
            }else{
                Log.e("Log","Failed to download result..");
            }

        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        return str.toString();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }



}

