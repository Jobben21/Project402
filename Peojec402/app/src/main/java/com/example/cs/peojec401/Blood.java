package com.example.cs.peojec401;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.cs.peojec401.R;

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
import java.util.ArrayList;

import static com.example.cs.peojec401.Fragment_F4.i;
import static com.example.cs.peojec401.Register_LoginActivity.idLogin;

/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class Blood extends AsyncTask<Void,BloodList,Void>
{
    Context c;
    Activity activity;
    ArrayList<BloodList> arrayList = new ArrayList<>();
    public Blood(Context c){


        this.c =c;
        activity = (Activity)c;

    }

    String json_string = "http://192.168.1.8/android/get_bt1.php?status=0";


    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Void doInBackground(Void... params) {
        String userid = idLogin;

        try {



            URL url = new URL(json_string);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            OutputStream outputStream = httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            String post_data = URLEncoder.encode("userid","UTF-8")+"="+ URLEncoder.encode(userid,"UTF-8");

            bufferedWriter.write(post_data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();








            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;


            while ((line=bufferedReader.readLine())!=null)
            {
                stringBuilder.append(line+"\n");
            }

            httpURLConnection.disconnect();
            String json_string = stringBuilder.toString().trim();

            JSONObject jsonObject = new JSONObject(json_string);
            JSONArray jsonArray = jsonObject.getJSONArray("result");

            int count=0;
            while (count<jsonArray.length()){

                JSONObject jo = jsonArray.getJSONObject(count);
                count++;
                BloodList food_recyc = new BloodList(jo.getString("sugar")
                        ,jo.getString("choles")
                        ,jo.getString("hdl")
                        ,jo.getString("ldl")
                        ,jo.getString("potassium")
                        ,jo.getString("trigly")
                        ,jo.getString("sodium"));

                publishProgress(food_recyc);
            }

            Log.d("JSON STRING",json_string);

        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    protected void onProgressUpdate(BloodList... values) {
        arrayList.add(values[0]);

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


}
