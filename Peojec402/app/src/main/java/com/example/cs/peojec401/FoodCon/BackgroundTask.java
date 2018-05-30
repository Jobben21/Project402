package com.example.cs.peojec401.FoodCon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.cs.peojec401.AfterBldT;
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
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import static com.example.cs.peojec401.AfterBldT.Resultfive;
import static com.example.cs.peojec401.AfterBldT.Resultfour;
import static com.example.cs.peojec401.AfterBldT.Resultone;
import static com.example.cs.peojec401.AfterBldT.Resultseven;
import static com.example.cs.peojec401.AfterBldT.Resultsix;
import static com.example.cs.peojec401.AfterBldT.Resultthree;
import static com.example.cs.peojec401.AfterBldT.Resulttwo;
import static com.example.cs.peojec401.AfterBldT.bt;
import static com.example.cs.peojec401.FoodRecod_F4.checkedLabelcholes;
import static com.example.cs.peojec401.FoodRecod_F4.checkedLabelsodium;
import static com.example.cs.peojec401.FoodRecod_F4.checkedLabelsugar;
import static com.example.cs.peojec401.FoodRecod_F4.checkedLabeltrigly;
import static com.example.cs.peojec401.FoodRecod_F4.se;
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
    FoodList foodList;
    String typefood="";


    public BackgroundTask(Context c,String type){


        this.c =c;
        activity = (Activity)c;
        this.typefood=type;
    }
    String json_string="";
    String json_string1 = "http://172.25.74.91/android/get_foodheart.php?status=0";
    String json_string2 = "http://172.25.74.91/android/get_foodkidney.php?status=0";
    String json_string3 = "http://172.25.74.91/android/get_foodsugar.php?status=0";
    String json_string4 = "http://172.25.74.91/android/get_foodpressure.php?status=0";
    String json_string5 = "http://172.25.74.91/android/get_food_by_select.php";
    String json_string6 = "http://172.25.74.91/android/get_food_by_blood.php";

    @Override
    protected void onPreExecute() {

        recyclerView = (RecyclerView) activity.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerAdapter(c,arrayList);
        recyclerView.setAdapter(adapter);



    }

    @Override
    protected Void doInBackground(Void... params) {


        try {
            if (i == 1) {
                json_string = json_string1;
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
                            ,jo.getInt("sugar")
                            ,jo.getString("method")
                            ,jo.getString("ingred")
                            ,jo.getString("typeingred")
                            ,jo.getString("foodtype"));

                    if(jo.getString("foodtype").equals(typefood)){publishProgress(food_recyc);}
                    else if(typefood.equals("เมนูทั้งหมด")){
                        publishProgress(food_recyc);
                    }
                }

            }
            if (i == 2) {
                json_string = json_string2;
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
                            ,jo.getInt("sugar")
                            ,jo.getString("method")
                            ,jo.getString("ingred")
                            ,jo.getString("typeingred")
                            ,jo.getString("foodtype"));
                    if(jo.getString("foodtype").equals(typefood)){publishProgress(food_recyc);}
                    else if(typefood.equals("เมนูทั้งหมด")){
                        publishProgress(food_recyc);
                    }
                }

            }
            if (i == 3) {
                json_string = json_string3;
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
                            ,jo.getInt("sugar")
                            ,jo.getString("method")
                            ,jo.getString("ingred")
                            ,jo.getString("typeingred")
                            ,jo.getString("foodtype"));

                    if(jo.getString("foodtype").equals(typefood)){publishProgress(food_recyc);}
                    else if(typefood.equals("เมนูทั้งหมด")){
                        publishProgress(food_recyc);
                    }
                }

            }
            if (i == 4) {

                json_string = json_string4;
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
                            ,jo.getInt("sugar")
                            ,jo.getString("method")
                            ,jo.getString("ingred")
                            ,jo.getString("typeingred")
                            ,jo.getString("foodtype"));
                    if(jo.getString("foodtype").equals(typefood)){publishProgress(food_recyc);}
                    else if(typefood.equals("เมนูทั้งหมด")){
                        publishProgress(food_recyc);
                    }

                }
            }
            if (se == 5) {

                String se_choles = checkedLabelcholes;
                String se_trigly = checkedLabeltrigly;
                String se_sugar = checkedLabelsugar;
                String se_sodium = checkedLabelsodium;


                //  Toast.makeText(activity,resugar+" ",Toast.LENGTH_SHORT).show();


                json_string = json_string5;
                URL url = new URL(json_string);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("se_choles", "UTF-8") + "=" + URLEncoder.encode(se_choles, "UTF-8")+"&"+
                        URLEncoder.encode("se_trigly", "UTF-8") + "=" + URLEncoder.encode(se_trigly, "UTF-8")+"&"+
                        URLEncoder.encode("se_sugar", "UTF-8") + "=" + URLEncoder.encode(se_sugar, "UTF-8")+"&"+
                        URLEncoder.encode("se_sodium", "UTF-8") + "=" + URLEncoder.encode(se_sodium, "UTF-8");



                bufferedWriter.write(post_data);

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                httpURLConnection.disconnect();
                String json_string = stringBuilder.toString().trim();

                JSONObject jsonObject = new JSONObject(json_string);
                JSONArray jsonArray = jsonObject.getJSONArray("result");


                int count = 0;
                while (count < jsonArray.length()) {

                    JSONObject jo = jsonArray.getJSONObject(count);
                    count++;
                    FoodList food_recyc = new FoodList(jo.getString("name")
                            , jo.getString("foodpic")
                            , jo.getInt("energy")
                            , jo.getInt("fat")
                            , jo.getInt("carbohydrate")
                            , jo.getInt("protein")
                            , jo.getInt("sugar")
                            ,jo.getString("method")
                            ,jo.getString("ingred")
                            ,jo.getString("typeingred")
                            ,jo.getString("foodtype"));
                    if(jo.getString("foodtype").equals(typefood)){publishProgress(food_recyc);}
                    else if(typefood.equals("เมนูทั้งหมด")){
                        publishProgress(food_recyc);
                    }
                }
            }
            if (bt == 6) {

                String resugar = Resultone;
                String resodium = Resulttwo;
                String repotassium = Resultthree;
                String recholes = Resultfour;
                String rehdl = Resultfive;
                String reldl = Resultsix;
                String retrigly = Resultseven;

              //  Toast.makeText(activity,resugar+" ",Toast.LENGTH_SHORT).show();


                json_string = json_string6;
                URL url = new URL(json_string);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("resugar", "UTF-8") + "=" + URLEncoder.encode(resugar, "UTF-8")+"&"+
               URLEncoder.encode("resodium", "UTF-8") + "=" + URLEncoder.encode(resodium, "UTF-8")+"&"+
                        URLEncoder.encode("repotassium", "UTF-8") + "=" + URLEncoder.encode(repotassium, "UTF-8")+"&"+
                        URLEncoder.encode("recholes", "UTF-8") + "=" + URLEncoder.encode(recholes, "UTF-8") +"&"+
                        URLEncoder.encode("rehdl", "UTF-8") + "=" + URLEncoder.encode(rehdl, "UTF-8")+"&"+
                        URLEncoder.encode("reldl", "UTF-8") + "=" + URLEncoder.encode(reldl, "UTF-8") +"&"+
                        URLEncoder.encode("retrigly", "UTF-8") + "=" + URLEncoder.encode(retrigly, "UTF-8");



                bufferedWriter.write(post_data);

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line + "\n");
                }

                httpURLConnection.disconnect();
                String json_string = stringBuilder.toString().trim();

                JSONObject jsonObject = new JSONObject(json_string);
                JSONArray jsonArray = jsonObject.getJSONArray("result");


                int count = 0;
                while (count < jsonArray.length()) {

                    JSONObject jo = jsonArray.getJSONObject(count);
                    count++;
                    FoodList food_recyc = new FoodList(jo.getString("name")
                            , jo.getString("foodpic")
                            , jo.getInt("energy")
                            , jo.getInt("fat")
                            , jo.getInt("carbohydrate")
                            , jo.getInt("protein")
                            , jo.getInt("sugar")
                            ,jo.getString("method")
                            ,jo.getString("ingred")
                            ,jo.getString("typeingred")
                            ,jo.getString("foodtype"));
                    if(jo.getString("foodtype").equals(typefood)){publishProgress(food_recyc);}
                    else if(typefood.equals("เมนูทั้งหมด")){
                        publishProgress(food_recyc);
                    }

                }

            }


        } catch (ProtocolException e) {
            Log.d("aaaaaaaaaaaaaaaaaaaaaaa","asdasdasdasdasdasdasdadasdasdsa");
            e.printStackTrace();
        } catch (IOException e) {
            Log.d("bbbbbbbbbbbbbbbbbbbbb","asdasdasdasdasdasdasdadasdasdsa");
            e.printStackTrace();
        } catch (JSONException e) {
            Log.d("cccccccccccccccccc", e.toString());
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
