package com.example.cs.peojec401;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cs.peojec401.FoodCon.DisplayList;
import com.example.cs.peojec401.FoodCon.FoodList;
import com.example.cs.peojec401.FoodCon.PicassoDown;
import com.example.cs.peojec401.FoodCon.RecyclerAdapter;

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

import static com.example.cs.peojec401.Fragment_F4.i;

public class FoodAct extends AppCompatActivity {
    Toolbar toolbar;
    Fragment fragment = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);


        toolbar = (Toolbar) findViewById(R.id.bloods);

        setSupportActionBar(toolbar);



       new  BackgroundTask(getApplicationContext());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
class BackgroundTask extends AsyncTask<Void,FoodList,Void>
{
    Context c;
    Activity activity;
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<FoodList> arrayList = new ArrayList<>();
    public BackgroundTask(Context c){


        this.c =c;
        activity=(Activity)this.c;


    }

    String json_string = "http://172.20.10.2/android/get_food1.php?status=0";
    String json_string1 = "http://172.20.10.2/android/get_food2.php?status=0";
    String json_string2 = "http://172.20.10.2/android/get_foodbt.php?status=0";

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
            if(i==2){
                json_string=json_string1;
//                }else if(i==3){
//                    json_string=json_string2;
//                    URL url = new URL(json_string);
//                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                    httpURLConnection.setRequestMethod("POST");
//                    httpURLConnection.setDoOutput(true);
//                    httpURLConnection.setDoInput(true);
//                    OutputStream outputStream = httpURLConnection.getOutputStream();
//                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//                    String post_data = URLEncoder.encode("resodium", "UTF-8") + "=" + URLEncoder.encode(Resulttwo, "UTF-8");
//
//                    bufferedWriter.write(post_data);
//                    bufferedWriter.flush();
//                    bufferedWriter.close();
//                    outputStream.close();
//
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

      class RecycleAdapter1  extends RecyclerView.Adapter<RecycleAdapter1.RecyclerViewHolder1>{
        ArrayList<FoodList> arrayList ;
        Context c;
        int sum=0;

        @Override
        public RecyclerViewHolder1 onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_food2,parent,false);

            RecyclerViewHolder1 recyclerViewHolder1 = new RecyclerViewHolder1(view);
            return recyclerViewHolder1;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder1 holder, final int position) {
            final FoodList foodList = arrayList.get(position);
            holder.name.setText(foodList.getName());
            holder.energy.setText(Integer.toString(foodList.getEnergy()));


            PicassoDown.downloadImage(c,foodList.getFoodpic(),holder.imgfood);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sum = position;
                    Intent i = new Intent(c,DocumentFood.class);
                    Bundle bundle = new Bundle();
                    i.putExtra("num",sum);

                    c.startActivity(i);
                }
            });
        }



        @Override
        public int getItemCount() {
            return 0;
        }

        public  static  class  RecyclerViewHolder1 extends RecyclerView.ViewHolder{

            TextView name,energy;
            ImageView imgfood;
            public  RecyclerViewHolder1(View view){
                super(view);
                name = (TextView)view.findViewById(R.id.comment);
                energy = (TextView)view.findViewById(R.id.date);
                imgfood = (ImageView)view.findViewById(R.id.menufood);

            }
        }
    }

