package com.example.cs.peojec401.Blood;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cs.peojec401.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import static com.example.cs.peojec401.Register_LoginActivity.idLogin;


public class Blood_Sugar extends AppCompatActivity {

    private TextView p_sugar;
    private TextView p_sugar2;
    private TextView p_sugar3;
    private TextView p_sugar4;
    private JSONArray result;
    private TextView p_avg;
    private TextView p_date;
    private TextView p_date2;
    private TextView p_date3;
    private TextView p_date4;
    public  int avg;
    private SeekBar seekBarex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood__sugar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        p_sugar=(TextView)findViewById(R.id.data_sugar);
        p_sugar2=(TextView)findViewById(R.id.data_sugar2);
        p_sugar3=(TextView)findViewById(R.id.data_sugar3);
        p_sugar4=(TextView)findViewById(R.id.data_sugar4);
        p_avg=(TextView)findViewById(R.id.sum_sugar);
        p_date =(TextView)findViewById(R.id.date_sugar);
        p_date2 =(TextView)findViewById(R.id.date_sugar2);
        p_date3 =(TextView)findViewById(R.id.date_sugar3);
        p_date4 =(TextView)findViewById(R.id.date_sugar4);
        seekBarex = (SeekBar)findViewById(R.id.seekBar8);
        Bar();
        addID();




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void Bar(){

        seekBarex = (SeekBar)findViewById(R.id.seekBar8);
        seekBarex.setProgress(20);
        seekBarex.setEnabled(false);
    }

       private String addID() {

        String login_url = "http://192.168.1.10/android/get_bt.php?status=0";

      JSONObject j = null;

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

//            Toast.makeText(ProfileOfBloodsActivity.this,row1[0]+row1[1]+"",Toast.LENGTH_SHORT).show();
            if(this.result.length()==1){
                p_sugar.setText(getSugar(0));
                avg = (Integer.valueOf(getSugar(0)));
                p_avg.setText(String.valueOf(avg));
                p_date.setText(getDate(0));

            }else if(this.result.length()==2)
            {
                p_sugar.setText(getSugar(0));


                p_sugar2.setText(getSugar(1));

                avg = (Integer.valueOf(getSugar(0))+Integer.valueOf(getSugar(1)))/2;

                p_avg.setText(String.valueOf(avg));

                p_date.setText(getDate(0));
                p_date2.setText(getDate(1));



            }else if(this.result.length()==3)
            {
                p_sugar.setText(getSugar(0));


                p_sugar2.setText(getSugar(1));


                p_sugar3.setText(getSugar(2));

                avg = (Integer.valueOf(getSugar(0))+Integer.valueOf(getSugar(1))
                        +Integer.valueOf(getSugar(2)))/3;

                p_avg.setText(String.valueOf(avg));

                p_date.setText(getDate(0));
                p_date2.setText(getDate(1));
                p_date3.setText(getDate(2));


            }
            else if(this.result.length()==4)
            {
                p_sugar.setText(getSugar(0));


                p_sugar2.setText(getSugar(1));


                p_sugar3.setText(getSugar(2));


                p_sugar4.setText(getSugar(3));

                avg = (Integer.valueOf(getSugar(0))+Integer.valueOf(getSugar(1))
                        +Integer.valueOf(getSugar(2))
                        +Integer.valueOf(getSugar(3)))/4;

                p_avg.setText(String.valueOf(avg));
                p_date.setText(getDate(0));
                p_date2.setText(getDate(1));
                p_date3.setText(getDate(2));
                p_date4.setText(getDate(3));
            }
            else if(this.result.length()>4){

                p_sugar.setText(getSugar(this.result.length()-4));

                p_sugar2.setText(getSugar(this.result.length()-3));

                p_sugar3.setText(getSugar(this.result.length()-2));


                p_sugar4.setText(getSugar(this.result.length()-1));

                avg = (Integer.valueOf(getSugar(this.result.length()-4))+Integer.valueOf(getSugar(this.result.length()-3))
                        +Integer.valueOf(getSugar(this.result.length()-2))
                        +Integer.valueOf(getSugar(this.result.length()-1)))/4;

                p_avg.setText(String.valueOf(avg));
                p_date.setText(getDate(this.result.length()-4));

                p_date2.setText(getDate(this.result.length()-3));

                p_date3.setText(getDate(this.result.length()-2));


                p_date4.setText(getDate(this.result.length()-1));
            }

                return result;

        } catch (MalformedURLException e) {
//            Toast.makeText(ProfileOfBloodsActivity.this, "JJ", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (IOException e) {
//            Toast.makeText(ProfileOfBloodsActivity.this, "MM", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
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


    private  String getDate(int position){

        String date="";
        try {
            //Getting object of given index
            JSONObject json = result.getJSONObject(position);

            //Fetching name from that object
            date = json.getString("date");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Returning the name
        return date;
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
