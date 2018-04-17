package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

public class EditActivity extends AppCompatActivity {

    private Button email_edit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Toolbar toolbar = (Toolbar) findViewById(R.id.register);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        email_edit_button = (Button)findViewById(R.id. email_edit_button);
        email_edit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (SaveData()) {
                    Intent intent = new Intent(EditActivity.this,NavigationActivity.class);
                    startActivity(intent);

                }
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public boolean SaveData(){

        final EditText e_name = (EditText) findViewById(R.id.email_edit);
        final EditText e_age = (EditText)findViewById(R.id.Age_edit);
        final EditText e_height = (EditText)findViewById(R.id.Height_edit);
        final EditText e_weight = (EditText)findViewById(R.id.weight_edit);
        final RadioGroup gender = (RadioGroup) findViewById(R.id.radio_gender_edit);

        int checkedRadioButtonID = gender.getCheckedRadioButtonId ( );
        RadioButton checkedRadioButton = ( RadioButton )findViewById ( checkedRadioButtonID );

        String checkedLabel = checkedRadioButton.getText ( ).toString ( );


        final AlertDialog.Builder ad= new AlertDialog.Builder(this);

        ad.setTitle("Error!");
        ad.setIcon(android.R.drawable.btn_star_big_on);
        ad.setPositiveButton("Close",null);

        if(e_name.getText().length()==0){

            new SweetAlertDialog(EditActivity.this,SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("เเก้ไขข้อมูลส่วนตัว")
                    .setContentText("กรอกข้อมูลให้ครบถ้วน")
                    .setConfirmText("ตกลง")
                    .show();


            return false;

        }


        String url = "http://192.168.1.40/android/addData.php?status=0";

        List<NameValuePair> para = new ArrayList<NameValuePair>();

        para.add(new BasicNameValuePair("name",e_name.getText().toString()));
        para.add(new BasicNameValuePair("age",e_age.getText().toString()));
        para.add(new BasicNameValuePair("height",e_height.getText().toString()));
        para.add(new BasicNameValuePair("weight",e_weight.getText().toString()));
        para.add(new BasicNameValuePair("gender",checkedLabel));



        String resultServer = gettHttpPost(url,para);

        String StatusId = "";
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

        }else
        {
            Toast.makeText(EditActivity.this,StatusId,
                    Toast.LENGTH_SHORT).show();
            e_name.setText("");
            e_age.setText("");
            e_height.setText("");
            e_weight.setText("");



        }

        return  true;
    }

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

}
