package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.example.cs.peojec401.Register_LoginActivity.idLogin;
import static com.example.cs.peojec401.Register_LoginActivity.nameLogin;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {
    public static String bt_sugar;
    public static String bt_sodium;
    public static String bt_potass;
    public static String bt_choles;
    public static String bt_hld;
    public static String bt_ldl;
    public static String bt_tri;

    private JSONArray result;

    private TextView headname;

    public int sum_sugar;
    public int sum_sodium;
    public int sum_potass;
    public int sum_choles;
    public int sum_hld;
    public int sum_ldl;
    public int sum_tri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);


//        headname =(TextView) findViewById(R.id.head_name);

        addID();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        display(R.id.nav_home);
//        Intent i=getIntent();
//        String name = i.getStringExtra("name");
//        headname.setText(name);

    }



    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//  }
// else {
//       super.onBackPressed();

//            new SweetAlertDialog(NavigationActivity.this, SweetAlertDialog.SUCCESS_TYPE).setTitleText("ออกจากระบบ")
//                    .setConfirmText("ใช่").setCancelText("ไม่")
//                    .showCancelButton(true).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                @Override
//                public void onClick(SweetAlertDialog sweetAlertDialog) {
//
//                    Intent intent = new Intent(NavigationActivity.this,Register_LoginActivity.class);
//                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(intent);
//
//                }
//
//
//            }).show();


        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            Intent intent = new Intent(NavigationActivity.this,Register_LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    private void display(int id){

         Fragment fragment = null;

        switch (id){
            case R.id.nav_home:
                fragment = new Fragment_H();
                break;
            case R.id.nav_blood:
                fragment = new Fragment_B();
                break;
            case R.id.nav_foodmenu:
                fragment = new Fragment_F4();
                break;
            case R.id.nav_carolries:
                fragment = new Fragment_C();
                break;
            case R.id.nav_profile:
                fragment = new Fragment_P();
                break;
            case R.id.action_logout:
                Intent intent = new Intent(NavigationActivity.this,Register_LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
        if(fragment != null){

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content_navigation,fragment).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }
        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item){
            // Handle navigation view item clicks here.

            int id = item.getItemId();

            display(id);
            return true;
        }


    private String addID() {

        String login_url = "http://172.25.74.91/android/get_bt.php?status=0";

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

//                bt_choles=getCholes(this.result.length()-1);
//                bt_sugar=getSugar(this.result.length()-1);
//                bt_sodium=getSodium(this.result.length()-1);
//                bt_potass=getPotassium(this.result.length()-1);
//                bt_hld=getHdl(this.result.length()-1);
//                bt_ldl=getLdl(this.result.length()-1);
//                bt_tri=getTri(this.result.length()-1);
            if(getSugar(this.result.length())==""){

                sum_sugar=0;
            }else if(getSugar(this.result.length())!=""){
               sum_sugar=Integer.valueOf(getSugar(this.result.length()-1));
            }  if(getSodium(this.result.length())==""){

                sum_sodium=0;
            }else if(getSodium(this.result.length())!=""){
                sum_sodium=Integer.valueOf(getSodium(this.result.length()-1));
            }  if(getPotassium(this.result.length())==""){

                sum_potass=0;
            }else if(getPotassium(this.result.length())!=""){
                sum_potass=Integer.valueOf(getPotassium(this.result.length()-1));
            }  if(getCholes(this.result.length())==""){

                sum_choles=0;
            }else if(getCholes(this.result.length())!=""){
                sum_choles=Integer.valueOf(getCholes(this.result.length()-1));
            }  if(getHdl(this.result.length())==""){

                sum_hld=0;
            }else if(getHdl(this.result.length())!=""){

               sum_hld=Integer.valueOf(getHdl(this.result.length()-1));
            }  if(getLdl(this.result.length())==""){

                sum_ldl=0;
            }else if(getLdl(this.result.length())!=""){
                sum_ldl=Integer.valueOf(getLdl(this.result.length()-1));
            }  if(getTri(this.result.length())==""){

                sum_tri=0;
            }else if(getTri(this.result.length())!=""){
                sum_tri=Integer.valueOf(getTri(this.result.length()-1));
            }



            ///
            if(sum_sugar>=70 &&sum_sugar<=110){
                bt_sugar="1";
            }else{
                bt_sugar="0";
            } if(sum_sodium>=136 &&sum_sodium<=145){
                bt_sodium="1";
            }else{
                bt_sodium="0";
            } if(sum_potass>=3.5 &&sum_potass<=4.5){
                bt_potass="1";
            }else{
                bt_potass="0";
            } if(sum_choles>=50 &&sum_choles<=200){
                bt_choles="1";
            }else{
                bt_choles="0";
            } if(sum_ldl>=129 &&sum_ldl<130){
                bt_ldl="1";
            }else{
                bt_ldl="0";
            } if(sum_hld>=40){
                bt_hld="1";
            }else{
                bt_hld="0";
            } if(sum_tri>=50 &&sum_tri<=150){
                bt_tri="1";
            }else{
                bt_tri="0";
            }
                //Toast.makeText(NavigationActivity.this,bt_sugar+"-"+bt_sodium+"-"+bt_potass+"-"+bt_tri,Toast.LENGTH_SHORT).show();
//            if(this.result.length()==1){
//                bt_choles=getCholes(0);
//                bt_sugar=getSugar(0);
//                bt_sodium=getSodium(0);
//                bt_potass=getPotassium(0);
//                bt_hld=getHdl(0);
//                bt_ldl=getLdl(0);
//                bt_tri=getTri(0);
//                Toast.makeText(NavigationActivity.this,1+"",Toast.LENGTH_SHORT).show();
//
//            }else if(this.result.length()==2)
//            {
//                bt_choles=getCholes(1);
//                bt_sugar=getSugar(1);
//                bt_sodium=getSodium(1);
//                bt_potass=getPotassium(1);
//                bt_hld=getHdl(1);
//                bt_ldl=getLdl(1);
//                bt_tri=getTri(1);
//                Toast.makeText(NavigationActivity.this,2+"",Toast.LENGTH_SHORT).show();
//            }else if(this.result.length()==3)
//            {
//                bt_choles=getCholes(2);
//                bt_sugar=getSugar(2);
//                bt_sodium=getSodium(2);
//                bt_potass=getPotassium(2);
//                bt_hld=getHdl(2);
//                bt_ldl=getLdl(2);
//                bt_tri=getTri(2);
//                Toast.makeText(NavigationActivity.this,3+"",Toast.LENGTH_SHORT).show();
//            }
//            else if(this.result.length()==4)
//            {
//                bt_choles=getCholes(3);
//                bt_sugar=getSugar(3);
//                bt_sodium=getSodium(3);
//                bt_potass=getPotassium(3);
//                bt_hld=getHdl(3);
//                bt_ldl=getLdl(3);
//                bt_tri=getTri(3);
//                Toast.makeText(NavigationActivity.this,4+"",Toast.LENGTH_SHORT).show();
//            }
//            else if(this.result.length()>4){
//                bt_choles=getCholes(this.result.length()-1);
//                bt_sugar=getSugar(this.result.length()-1);
//                bt_sodium=getSodium(this.result.length()-1);
//                bt_potass=getPotassium(this.result.length()-1);
//                bt_hld=getHdl(this.result.length()-1);
//                bt_ldl=getLdl(this.result.length()-1);
//                bt_tri=getTri(this.result.length()-1);
//                Toast.makeText(NavigationActivity.this,5+"",Toast.LENGTH_SHORT).show();
//            }

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

}
