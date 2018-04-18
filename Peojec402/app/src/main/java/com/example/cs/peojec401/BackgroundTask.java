package com.example.cs.peojec401;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by นครินทร์ on 4/18/2018.
 */

public class BackgroundTask extends AsyncTask<Void,Food_recyc,Void>
{
    Context ctx;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Food_recyc> arrayList = new ArrayList<>();
    public BackgroundTask(Context ctx){


        this.ctx =ctx;
        activity = (Activity)ctx;
    }

String json_string = "http://172.25.74.140/android/get_food1.php?status=0";
    @Override
    protected void onPreExecute() {
        recyclerView = (RecyclerView)activity.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(ctx);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(ctx,arrayList);
        recyclerView.setAdapter(adapter)    ;
    }

    @Override
    protected Void doInBackground(Void... params) {
            try {
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
                JSONArray jsonArray = jsonObject.getJSONArray("rrr");

                int count=0;
                while (count<jsonArray.length()){

                    JSONObject jo = jsonArray.getJSONObject(count);
                    count++;
                    Food_recyc  food_recyc = new Food_recyc(jo.getString("name"),jo.getString("foodpic"),jo.getDouble("energy"));

                    publishProgress(food_recyc);
                }

                Log  .d("JSON STRING",json_string);

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
    protected void onProgressUpdate(Food_recyc... values) {
        arrayList.add(values[0]);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
