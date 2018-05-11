package com.example.cs.peojec401;

import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cs.peojec401.ConnectData.Config_bt;
import com.example.cs.peojec401.FoodCon.FoodList;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static com.example.cs.peojec401.Register_LoginActivity.idLogin;

public class ProfileOfBloodsActivity extends AppCompatActivity {

    private TextView p_sugar,p_choles,p_hdl,p_ldl,p_potas,p_tri,p_so;
    private TextView p_sugar2,p_choles2,p_hdl2,p_ldl2,p_potas2,p_tri2,p_so2;
    private JSONArray result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_of_bloods);
        Toolbar toolbar = (Toolbar) findViewById(R.id.register);
        setSupportActionBar(toolbar);


        p_sugar = (TextView) findViewById(R.id.profile_sugar);
        p_choles = (TextView)findViewById(R.id.Profile_choles);
        p_hdl = (TextView) findViewById(R.id.profile_hdl);
        p_ldl = (TextView) findViewById(R.id.Profile_ldl);
        p_potas = (TextView) findViewById(R.id.profile_potassium);
        p_tri = (TextView) findViewById(R.id.profile_tri);
        p_so = (TextView) findViewById(R.id.profile_sodium);


        p_sugar2 = (TextView) findViewById(R.id.profile_sugar2);
        p_choles2 = (TextView)findViewById(R.id.Profile_choles2);
        p_hdl2 = (TextView) findViewById(R.id.profile_hdl2);
        p_ldl2 = (TextView) findViewById(R.id.Profile_ldl2);
        p_potas2 = (TextView) findViewById(R.id.profile_potassium2);
        p_tri2 = (TextView) findViewById(R.id.profile_tri2);
        p_so2 = (TextView) findViewById(R.id.profile_sodium2);

        if (Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



            addID();


    }

    private String addID() {

        String login_url = "http://192.168.1.8/android/get_bt.php?status=0";

      JSONObject  j = null;

        try {
            String user_name = idLogin;

            URL url = new URL(login_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
         String result = "";


            String line = "";
            while ((line = bufferedReader.readLine()) != null) {

                result+=line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
                 j = new JSONObject(result);
                this.result=j.getJSONArray("result");


            if(this.result.length()==1){
                p_sugar.setText(getSugar(0));
                p_choles.setText(getCholes(0));
                p_hdl.setText(getHdl(0));
                p_ldl.setText(getLdl(0));
                p_potas.setText(getPotassium(0));
                p_tri.setText(getTri(0));
                p_so.setText(getSodium(0));
            }else if(this.result.length()==2)
            {
                p_sugar.setText(getSugar(0));
                p_choles.setText(getCholes(0));
                p_hdl.setText(getHdl(0));
                p_ldl.setText(getLdl(0));
                p_potas.setText(getPotassium(0));
                p_tri.setText(getTri(0));
                p_so.setText(getSodium(0));

                p_sugar2.setText(getSugar(1));
                p_choles2.setText(getCholes(1));
                p_hdl2.setText(getHdl(1));
                p_ldl2.setText(getLdl(1));
                p_potas2.setText(getPotassium(1));
                p_tri2.setText(getTri(1));
                p_so2.setText(getSodium(1));
            }else if(this.result.length()>2){

                p_sugar.setText(getSugar(this.result.length()-2));
                p_choles.setText(getCholes(this.result.length()-2));
                p_hdl.setText(getHdl(this.result.length()-2));
                p_ldl.setText(getLdl(this.result.length()-2));
                p_potas.setText(getPotassium(this.result.length()-2));
                p_tri.setText(getTri(this.result.length()-2));
                p_so.setText(getSodium(this.result.length()-2));

                p_sugar2.setText(getSugar(this.result.length()-1));
                p_choles2.setText(getCholes(this.result.length()-1));
                p_hdl2.setText(getHdl(this.result.length()-1));
                p_ldl2.setText(getLdl(this.result.length()-1));
                p_potas2.setText(getPotassium(this.result.length()-1));
                p_tri2.setText(getTri(this.result.length()-1));
                p_so2.setText(getSodium(this.result.length()-1));

            }

                return result;

        } catch (MalformedURLException e) {
            Toast.makeText(ProfileOfBloodsActivity.this, "JJ", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(ProfileOfBloodsActivity.this, "MM", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }




    private void getData(){
        //Creating a string request

        StringRequest stringRequest = new StringRequest(Config_bt.DATA_URL,
                new Response.Listener<String>() {


                    @Override
                    public void onResponse(String response) {
                        JSONObject j = null;






                        try {
                            //Parsing the fetched Json String to JSON Object
                            j = new JSONObject(response);

                            //Storing the Array of JSON String to our JSON Array
                            result = j.getJSONArray(Config_bt.JSON_ARRAY);

                            if(result.length()==1){
                            p_sugar.setText(getSugar(0));
                            p_choles.setText(getCholes(0));
                            p_hdl.setText(getHdl(0));
                            p_ldl.setText(getLdl(0));
                            p_potas.setText(getPotassium(0));
                            p_tri.setText(getTri(0));
                            p_so.setText(getSodium(0));
                            }else if(result.length()==2)
                            {
                                p_sugar.setText(getSugar(0));
                                p_choles.setText(getCholes(0));
                                p_hdl.setText(getHdl(0));
                                p_ldl.setText(getLdl(0));
                                p_potas.setText(getPotassium(0));
                                p_tri.setText(getTri(0));
                                p_so.setText(getSodium(0));

                                p_sugar2.setText(getSugar(1));
                                p_choles2.setText(getCholes(1));
                                p_hdl2.setText(getHdl(1));
                                p_ldl2.setText(getLdl(1));
                                p_potas2.setText(getPotassium(1));
                                p_tri2.setText(getTri(1));
                                p_so2.setText(getSodium(1));
                            }else if(result.length()>2){

                                p_sugar.setText(getSugar(result.length()-2));
                                p_choles.setText(getCholes(result.length()-2));
                                p_hdl.setText(getHdl(result.length()-2));
                                p_ldl.setText(getLdl(result.length()-2));
                                p_potas.setText(getPotassium(result.length()-2));
                                p_tri.setText(getTri(result.length()-2));
                                p_so.setText(getSodium(result.length()-2));

                                p_sugar2.setText(getSugar(result.length()-1));
                                p_choles2.setText(getCholes(result.length()-1));
                                p_hdl2.setText(getHdl(result.length()-1));
                                p_ldl2.setText(getLdl(result.length()-1));
                                p_potas2.setText(getPotassium(result.length()-1));
                                p_tri2.setText(getTri(result.length()-1));
                                p_so2.setText(getSodium(result.length()-1));

                            }
                            //Calling method getStudents to get the students from the JSON Array
                            //getStudents(result);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(ProfileOfBloodsActivity.this, idLogin, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getApplication(),content+"",Toast.LENGTH_LONG).show();


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


    //Method to get student name of a particular position
    private String getSugar(int position){
        String sugar="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            sugar = json.getString("sugar");
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
            choles = json.getString("choles");
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
            hdl = json.getString("hdl");
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
            ldl = json.getString("ldl");
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
            potas = json.getString("potassium");
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
            tri = json.getString("trigly");
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
            sod = json.getString("sodium");
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
