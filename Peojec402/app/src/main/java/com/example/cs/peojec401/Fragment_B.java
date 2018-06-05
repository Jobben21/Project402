package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

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

import static com.example.cs.peojec401.Register_LoginActivity.idLogin;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_B extends Fragment {

    //returning our layout file
    //change R.layout.yourlayoutfilename for each of your fragments


    private Button button_b;
    private AfterBldT afterBldT;
    private EditText sugar_t,sodium_t,potassium_t,choles_t,ldl_t,hdl_t,tri_t;
    private RadioButton hospital1, hospital2;
    private ArrayList<EditText> BloodList;
    private  String Sugar,Sodium,Potassium,Choles,Hdl,Ldl,Tri,hospital;
    private  float sugar,sodium,potassium,choles,hdl,ldl,tri;
    private boolean checking = true;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout_b, container, false);

        sugar_t = (EditText) view.findViewById(R.id.sugar_t);
        sodium_t = (EditText) view.findViewById(R.id.sodium_t);
        potassium_t = (EditText) view.findViewById(R.id.potassium_t);
        choles_t = (EditText) view.findViewById(R.id.choles_t);
        ldl_t = (EditText) view.findViewById(R.id.ldl_t);
        hdl_t = (EditText) view.findViewById(R.id.hdl_t);
        tri_t = (EditText) view.findViewById(R.id.tri_t);

        hospital1 = (RadioButton) view.findViewById(R.id.radioButton3);
                hospital2 = (RadioButton) view.findViewById(R.id.radioButton4);


        if (Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }
        button_b = (Button) view.findViewById(R.id.button_blood);
        button_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               if(SaveData()) {

                   inputBloodTest();

                  }
                //}
            }
        });
        return view;
    }


            public boolean SaveData() {




                String url = "http://172.20.10.2/android/add_bt.php?status=0";

                List<NameValuePair> para = new ArrayList<NameValuePair>();
                para.add(new BasicNameValuePair("user_id", idLogin));
                para.add(new BasicNameValuePair("sugar", sugar_t.getText().toString()));
                para.add(new BasicNameValuePair("choles", choles_t.getText().toString()));
                para.add(new BasicNameValuePair("hdl", hdl_t.getText().toString()));
                para.add(new BasicNameValuePair("ldl", ldl_t.getText().toString()));
                para.add(new BasicNameValuePair("potassium", potassium_t.getText().toString()));
                para.add(new BasicNameValuePair("trigly", tri_t.getText().toString()));
                para.add(new BasicNameValuePair("sodium", sodium_t.getText().toString()));


                String resultServer = gettHttpPost(url, para);

                String StatusId = "";
                String Error = "Unknow Status!";
                String a = "";
                JSONObject c;
                try {
                    c = new JSONObject(resultServer);
                    a = c.getString("StatusID");
                    StatusId = c.getString("StatusID");

                    Error = c.getString("Error");

                } catch (JSONException e) {
                    e.printStackTrace();
                }




                return true;
            }


            private String gettHttpPost(String url, List<NameValuePair> para) {

                StringBuilder str = new StringBuilder();
                HttpClient client = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(url);

                try {
                    httppost.setEntity(new UrlEncodedFormEntity(para, "UTF-8"));

                    HttpResponse response = client.execute(httppost);
                    StatusLine statusline = response.getStatusLine();
                    int statusCode = statusline.getStatusCode();
                    if (statusCode == 200) {

                        HttpEntity entity = response.getEntity();
                        InputStream content = entity.getContent();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                        String line;
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

            @Override
            public void onViewCreated(View view, Bundle savedInstanceState) {
                getActivity().setTitle("ผลตรวจเลือด");
            }


            public void inputBloodTest() {

                if(sugar_t.getText().length() == 0) {
                     sugar_t.setText("0");
                     sugar = Float.parseFloat(sugar_t.getText().toString());
                     sugarInBlood(sugar,hospital1);
                     Sugar = sugarInBlood(sugar,hospital1);
                }else{
                    sugar = Float.parseFloat(sugar_t.getText().toString());
                    Sugar = sugarInBlood(sugar,hospital1);
                }
                if(sodium_t.getText().length() == 0) {
                    sodium_t.setText("0");
                    sodium = Float.parseFloat(sodium_t.getText().toString());
                    Sodium = sodiumInBlood(sodium,hospital1);
                }else{
                    sodium = Float.parseFloat(sodium_t.getText().toString());
                    Sodium = sodiumInBlood(sodium,hospital1);
                }
                if( potassium_t.getText().length() == 0) {
                    potassium_t.setText("0");
                    potassium = Float.parseFloat(potassium_t.getText().toString());
                    Potassium = potassiumInBlood(potassium,hospital1);
                }else{
                    potassium = Float.parseFloat(potassium_t.getText().toString());
                    Potassium = potassiumInBlood(potassium,hospital1);
                }
                if( choles_t.getText().length() == 0) {
                    choles_t.setText("0");
                    choles = Float.parseFloat(choles_t.getText().toString());
                    Choles = cholesInBlood(choles,hospital1);
                }else{
                    choles = Float.parseFloat(choles_t.getText().toString());
                    Choles = cholesInBlood(choles,hospital1);
                }
                if( hdl_t.getText().length() == 0) {
                    hdl_t.setText("0");
                    hdl = Float.parseFloat(hdl_t.getText().toString());
                    Hdl = hdlInBlood(hdl,hospital1);
                }
                else{
                    hdl = Float.parseFloat(hdl_t.getText().toString());
                    Hdl = hdlInBlood(hdl,hospital1);
                }
                if( ldl_t.getText().length() == 0) {
                    ldl_t.setText("0");
                    ldl = Float.parseFloat(ldl_t.getText().toString());
                    Ldl = ldlInBlood(ldl,hospital1);
                }
                else{
                    ldl = Float.parseFloat(ldl_t.getText().toString());
                    Ldl = ldlInBlood(ldl,hospital1);
                }
                if( tri_t.getText().length() == 0) {
                    tri_t.setText("0");
                    tri = Float.parseFloat(tri_t.getText().toString());
                    Tri = triInBlood(tri,hospital1);
                }else{
                    tri = Float.parseFloat(tri_t.getText().toString());
                    Tri = triInBlood(tri,hospital1);
                }

                int i = 0;


                Log.e("hu",tri_t.getText().toString());

                if("0".equals(sugar_t.getText().toString())&& "0".equals( sodium_t.getText().toString())
                        && "0".equals( potassium_t.getText().toString())&& "0".equals(  choles_t.getText().toString())
                        && "0".equals( hdl_t.getText().toString())&& "0".equals(  ldl_t.getText().toString())
                        && "0".equals( tri_t.getText().toString())){

                    new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("อ่านผลตรวจเลือด")
                            .setContentText("กรุณากรอกข้อมูลอย่างน้อย 1 ค่า")
                            .setConfirmText("ตกลง")
                            .show();

                }

                else if (sugar_t.getText().length() > 3 || sodium_t.getText().length() > 3
                        || choles_t.getText().length() > 3 ||ldl_t.getText().length() > 3
                        ||  tri_t.getText().length() > 3){

                    new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("อ่านผลตรวจเลือด")
                            .setContentText("กรุณากรอกข้อมูลให้ถูกต้อง")
                            .setConfirmText("ตกลง")
                            .show();
                }
                else if (potassium_t.getText().length() >= 3 || hdl_t.getText().length() > 3){

                    new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("อ่านผลตรวจเลือด")
                            .setContentText("กรุณากรอกข้อมูลให้ถูกต้อง")
                            .setConfirmText("ตกลง")
                            .show();
                }






//                if (SaveData()) {
//                    inputBloodTest();
                    Blood();
//                }
            }

            public void Blood() {

                            new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE).setTitleText("แปรผลตรวจเลือด")
                                    .setContentText("น้ำตาล                  "+sugar+" mg/dl"+"\n"+
                                                    "โซเดียม               "+sodium+" mmol/dl"+"\n"+
                                                    "โพเเทสเซียม        "+potassium+" mg/dl"+"\n"+
                                                    "คอลเลสเตอรอล   "+choles+" mg/dl"+"\n"+
                                                    "เเอลดีเเอล            "+ldl+" mg/dl"+"\n"+
                                                    "เอชดีเเอล             "+hdl+" mg/dl"+"\n"+
                                                    "ไตรกลีเซอร์ไรด์     "+tri+" mg/dl")
                                    .setConfirmText("ใช่").setCancelText("ไม่")
                                    .showCancelButton(true).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sweetAlertDialog) {

                                    String check = checkHospital(checking);

                                    afterBldT = new AfterBldT();
                                    Intent intent = new Intent(getActivity().getBaseContext(), AfterBldT.class);
                                    intent.putExtra("sugar", sugar);
                                    intent.putExtra("sodium", sodium);
                                    intent.putExtra("potassium", potassium);
                                    intent.putExtra("choles", choles);
                                    intent.putExtra("ldl", ldl);
                                    intent.putExtra("hdl", hdl);
                                    intent.putExtra("tri", tri);


                                    intent.putExtra("message1", Sugar);
                                    intent.putExtra("message2", Sodium);
                                    intent.putExtra("message3", Potassium);
                                    intent.putExtra("message4", Choles);
                                    intent.putExtra("message5", Ldl);
                                    intent.putExtra("message6", Hdl);
                                    intent.putExtra("message7", Tri);
                                    intent.putExtra("check", check);

                                    startActivity(intent);


                                }
                            }).show();


                        }

            private String sugarInBlood(float sugar,RadioButton hospital1) {

                String message1 = "";

                if(hospital1.isChecked()) {
                    if (sugar >= 70 && sugar <= 110) {
                        message1 = "ok";
                    } else if (sugar == 0) {
                        message1 = "minus";
                    } else if (sugar < 70) {
                        message1 = "cancell2";
                    }
                         else if (sugar > 110 && sugar <500) {
                            message1 = "cancell";
                        } else if(sugar > 500){
                            message1 = "normall";
                        }

                }

                else {
                    if (sugar >= 70 && sugar <= 100) {
                        message1 = "ok";
                    } else if (sugar == 0) {
                        message1 = "minus";
                    } else if (sugar < 70) {

                        message1 = "cancell2";
                    }
                    else if (sugar > 100) {
                        message1 = "cancell";
                    } else {
                        message1 = "normall";
                    }

                }
                return message1;
            }

            private String sodiumInBlood(float sodium,RadioButton hospital1) {

                String message2 = "";

                if(hospital1.isChecked()) {


                    if (136 <= sodium && sodium <= 145) {
                        message2 = "ok";
                    } else if (sodium == 0) {
                        message2 = "minus";
                    } else if (sodium < 136) {
                        message2 = "cancell2";
                    } else if (sodium > 146) {
                        message2 = "cancell";
                    } else {
                        message2 = "normal";
                    }
                }

                else{
                    if (136 <= sodium && sodium <= 145) {
                        message2 = "ok";
                    } else if (sodium == 0) {
                        message2 = "minus";
                    } else if (sodium < 136) {
                        message2 = "cancell2";
                    } else if (sodium > 146) {
                        message2 = "cancell";
                    } else {
                        message2 = "normal";
                    }
                }
                return message2;
            }

            private String potassiumInBlood(float potassium,RadioButton hospital1) {

                String message3 = "";

                if(hospital1.isChecked()) {
                    if (3.5 <= potassium && potassium <= 4.5) {
                        message3 = "ok";
                    } else if (potassium == 0) {
                        message3 = "minus";
                    } else if (potassium < 3.5) {
                        message3 = "cancell2";
                    } else if (potassium > 4.5) {
                        message3 = "cancell";
                    } else {
                        message3 = "ok";
                    }
                }
                else {

                    if (3.5 <= potassium && potassium <= 5.1) {
                        message3 = "ok";
                    } else if (potassium == 0) {
                        message3 = "minus";
                    } else if (potassium < 3.5) {
                        message3 = "cancell2";
                    } else if (potassium > 5.1) {
                        message3 = "cancell";
                    } else {
                        message3 = "ok";
                    }
                }
                return message3;

            }

            private String cholesInBlood(float choles,RadioButton hospital1) {

                String message4 = "";


                if(hospital1.isChecked()) {
                    if (50 <= choles && choles <= 200) {
                        message4 = "ok";
                    } else if (choles == 0) {
                        message4 = "minus";
                    } else if (choles < 49) {
                        message4 = "cancell2";
                    } else if (200 < choles && choles <= 239) {
                        message4 = "cancell";
                    } else if ( choles > 240) {
                        message4 = "cancell3";
                    }
                }
                else{

                    if (50 <= choles && choles <= 200) {
                        message4 = "ok";
                    } else if (choles == 0) {
                        message4 = "minus";
                    } else if (choles < 49) {
                        message4 = "cancell2";
                    } else if (200 < choles && choles <= 239) {
                        message4 = "cancell";
                    } else if ( choles > 240) {
                        message4 = "cancell3";
                    }
                }
                return message4;
            }

            private String ldlInBlood(float ldl,RadioButton hospital1) {

                String message5 = "";

                if(hospital1.isChecked()){
                    if (0 < ldl && ldl <= 130) {
                        message5 = "ok";
                    } else if (ldl == -1) {
                        message5 = "minus";
                    } else if (130 < ldl && ldl <= 159) {
                        message5 = "cancell";
                    } else if (159 < ldl && ldl <= 189) {
                        message5 = "cancell3";
                    } else if (ldl > 190) {
                        message5 = "cancell5";
                    }
                }
                else {
                    if (0 < ldl && ldl <= 100) {
                        message5 = "ok";
                    } else if (ldl == -1) {
                        message5 = "minus";
                    } else if (100 < ldl && ldl <= 129) {
                        message5 = "cancell";
                    } else if (130 < ldl && ldl <= 159) {
                        message5 = "cancell3";
                    } else if (ldl > 190) {
                        message5 = "cancell5";
                    }
                }
                return message5;
            }

            private String hdlInBlood(float hdl,RadioButton hospital1) {

                String message6 = "";

                if(hospital1.isChecked()) {
                    if (40 <= hdl && hdl <= 60) {
                        message6 = "ok";
                    } else if (hdl == 0) {
                        message6 = "cancell";
                    } else if (hdl < 35) {
                        message6 = "cancell2";
                    } else if (hdl > 60) {
                        message6 = "cancell";
                    } else {
                        message6 = "cancell";
                    }
                }
                else {
                    if (35 <= hdl && hdl <= 60) {
                        message6 = "ok";
                    } else if (hdl == 0) {
                        message6 = "minus";
                    } else if (hdl < 35) {
                        message6 = "cancell2";
                    } else if (hdl > 60) {
                        message6 = "cancell";
                    } else {
                        message6 = "cancell";
                    }
                }
                return message6;
            }

            private String triInBlood(float tri,RadioButton hospital1) {

                String message7 = "";

                if(hospital1.isChecked()) {
                    if (50 <= tri && tri <= 150) {
                        message7 = "ok";
                    } else if (tri == 0) {
                        message7 = "minus";
                    } else if (tri < 50) {
                        message7 = "cancell2";
                    } else if (tri > 151 && tri < 199) {
                        message7 = "cancell";
                    }else if (tri > 200 && tri < 499) {
                        message7 = "cancell3";
                    } else if (tri > 500) {
                        message7 = "cancell4";
                    } else {
                        message7 = "cancell4";
                    }
                }
               else {

                    if (30 <= tri && tri <= 150) {
                        message7 = "ok";
                    } else if (tri == 0) {
                        message7 = "minus";
                    } else if (tri < 30) {
                        message7 = "cancell2";
                    } else if (tri > 151 && tri < 199) {
                        message7 = "cancell";
                    }else if (tri > 200 && tri < 499) {
                        message7 = "cancell3";
                    } else if (tri > 500) {
                        message7 = "cancell4";
                    } else {
                        message7 = "minus";
                    }
                }
                return message7;
            }

            public String checkHospital(boolean checking){

                String message8 = "";

                if(hospital1.isChecked() == checking){
                    message8 = "Sirihospital";
                }
                else if (hospital2.isChecked() == checking){
                    message8 = "TUhospital";
                }

                return message8;
            }


        }
