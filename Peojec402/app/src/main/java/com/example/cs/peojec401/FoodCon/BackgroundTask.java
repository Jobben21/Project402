package com.example.cs.peojec401.FoodCon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.cs.peojec401.ProfileOfBloodsActivity;
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

public class BackgroundTask extends AsyncTask<Void,FoodList,Void>
{
    Context c;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<FoodList> arrayList = new ArrayList<>();
    public BackgroundTask(Context c){


        this.c =c;
        activity = (Activity)c;

    }

    String json_string = "http://192.168.1.8/android/get_food1.php?status=0";
    String json_string1 = "http://192.168.1.8/android/get_food2.php?status=0";

    @Override
    protected void onPreExecute() {
        recyclerView = (RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(c);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(c,arrayList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected Void doInBackground(Void... params) {


            try {
                if(i==2){
                   json_string=json_string1;
                }
                URL url = new URL(json_string);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
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
                    FoodList food_recyc = new FoodList(jo.getString("name")
                            ,jo.getString("foodpic")
                            ,jo.getInt("energy")
                            ,jo.getInt("fat")
                            ,jo.getInt("carbohydrate")
                            ,jo.getInt("protein")
                            ,jo.getInt("sugar"));

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
    protected void onProgressUpdate(FoodList... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }


}
