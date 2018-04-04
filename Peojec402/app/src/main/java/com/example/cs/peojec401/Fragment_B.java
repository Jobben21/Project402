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
import android.widget.Spinner;
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

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_B extends Fragment {

    //returning our layout file
    //change R.layout.yourlayoutfilename for each of your fragments


    private Button button_b;
    private AfterBldT afterBldT;
    private EditText sugar_t,sodium_t,potassium_t,choles_t,ldl_t,hdl_t,tri_t;
    private Spinner hospitalSpinner;
    private ArrayList<EditText> BloodList;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout_b, container, false);

        sugar_t = (EditText) view.findViewById(R.id.sugar_t);
        sodium_t = (EditText) view.findViewById(R.id.sodium_t);
        potassium_t = (EditText) view.findViewById(R.id.potassium_t);
        choles_t = (EditText) view.findViewById(R.id.choles_t);
        ldl_t = (EditText) view.findViewById(R.id.ldl_t);
        hdl_t = (EditText) view.findViewById(R.id.hdl_t);
        tri_t = (EditText) view.findViewById(R.id.tri_t);

        // hospitalSpinner = (Spinner)view.findViewById(R.id.spinnerblood);


        if (Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }
        button_b = (Button) view.findViewById(R.id.button_blood);
        button_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sugar_t.getText().length() == 0) {
                    sugar_t.setError("กรอกข้อมูลให้ครบถ้วน");

                    new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE).setTitleText("แปรผลตรวจเลือด")
                            .setConfirmText("ใช่").setCancelText("ไม่")
                            .showCancelButton(true).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            inputBloodTest();

                            if (sugar_t.getText().length() == 0) {
                                sugar_t.setError("กรอกข้อมูลให้ครบถ้วน");

                            } else if (sugar_t.getText().length() >= 6) {
                                sugar_t.setError("ใส่ข้อมูลไม่ถูกต้อง");


                            } else {
                                if (SaveData()) {

                                    new SweetAlertDialog(getActivity(), SweetAlertDialog.SUCCESS_TYPE).setTitleText("แปรผลตรวจเลือด")
                                            .setConfirmText("ใช่").setCancelText("ไม่")
                                            .showCancelButton(true).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sweetAlertDialog) {

                                            inputBloodTest();

                                        }
                                    }).show();

                                }
                            }

                        }
                    });
                }


            }
        });
        return view;
    }

            public boolean SaveData() {

//        final EditText e_sugar = (EditText) findViewById(R.id.sugar_t);
//        final EditText e_sodium = (EditText)findViewById(R.id.sodium_t);
//        final EditText e_potassium = (EditText)findViewById(R.id.potassium_t);
//        final EditText e_choles = (EditText)findViewById(R.id.choles_t);
//        final EditText e_hdl = (EditText)findViewById(R.id.hdl_t);
//        final EditText e_ldl = (EditText)findViewById(R.id.ldl_t);
//        final EditText e_trigly = (EditText)findViewById(R.id.tri_t);


                String url = "http://192.168.1.37/android/add_bt.php?status=0";

                List<NameValuePair> para = new ArrayList<NameValuePair>();

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

                Toast.makeText(getContext(), StatusId,
                        Toast.LENGTH_SHORT).show();
//        sugar_t.setText("");
//        sodium_t.setText("");
//        potassium_t.setText("");
//        choles_t.setText("");
//        ldl_t.setText("");
//        hdl_t.setText("");
//        tri_t.setText("");


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

            public void Blood(View view) {

                sugar_t = (EditText) view.findViewById(R.id.sugar_t);
                sodium_t = (EditText) view.findViewById(R.id.sodium_t);
                potassium_t = (EditText) view.findViewById(R.id.potassium_t);
                choles_t = (EditText) view.findViewById(R.id.choles_t);
                ldl_t = (EditText) view.findViewById(R.id.ldl_t);
                hdl_t = (EditText) view.findViewById(R.id.sodium_t);
                tri_t = (EditText) view.findViewById(R.id.tri_t);

                ArrayList<EditText> FirstList = new ArrayList<EditText>() {{
                    add(sugar_t);
                    add(sodium_t);
                    add(potassium_t);
                    add(choles_t);
                    add(ldl_t);
                    add(hdl_t);
                    add(tri_t);
                }};


            }

            public void inputBloodTest() {

                float sugar = Float.parseFloat(sugar_t.getText().toString());
                sugarInBlood(sugar);
                String Sugar = sugarInBlood(sugar);

                float sodium = Float.parseFloat(sodium_t.getText().toString());
                sodiumInBlood(sodium);
                String Sodium = sodiumInBlood(sodium);

                float potassium = Float.parseFloat(potassium_t.getText().toString());
                potassiumInBlood(potassium);
                String Potassium = potassiumInBlood(potassium);

                float choles = Float.parseFloat(choles_t.getText().toString());
                String Choles = cholesInBlood(choles);


                float hdl = Float.parseFloat(hdl_t.getText().toString());
                hdlInBlood(hdl);
                String Hdl = hdlInBlood(hdl);


                float ldl = Float.parseFloat(ldl_t.getText().toString());
                ldlInBlood(ldl);
                String Ldl = ldlInBlood(ldl);


                float tri = Float.parseFloat(tri_t.getText().toString());
                String Tri = triInBlood(tri);

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

                startActivity(intent);

            }

            private String sugarInBlood(float sugar) {

                String message1 = "";

                if (sugar >= 70 && sugar <= 120) {
                    message1 = "ok";
                } else {
                    if (sugar < 70) {
                        message1 = "cancell";
                    } else if (sugar > 130) {
                        message1 = "cancell";
                    } else {
                        message1 = "normall";
                    }
                }
                return message1;
            }

            private String sodiumInBlood(float sodium) {

                String message2 = "";

                if (136 <= sodium && sodium <= 145) {
                    message2 = "ok";
                } else if (sodium < 136) {
                    message2 = "cancell";
                } else if (sodium > 146) {
                    message2 = "cancell";
                } else {
                    message2 = "normal";
                }
                return message2;
            }

            private String potassiumInBlood(float potassium) {

                String message3 = "";

                if (3.5 <= potassium && potassium <= 5.1) {
                    message3 = "ok";
                } else if (potassium < 3.5) {
                    message3 = "cancell";
                } else if (potassium > 5.1) {
                    message3 = "cancell";
                } else {
                    message3 = "ok";
                }
                return message3;

            }

            private String cholesInBlood(float choles) {

                String message4 = "";

                if (50 <= choles && choles <= 200) {
                    message4 = "ok";
                } else if (choles < 40) {
                    message4 = "cancell";
                } else if (choles > 100) {
                    message4 = "cancell";
                } else {
                    message4 = "ok";
                }
                return message4;
            }

            private String ldlInBlood(float ldl) {

                String message5 = "";

                if (0 <= ldl && ldl <= 100) {
                    message5 = "ok";
                } else if (ldl > 100) {
                    message5 = "cancell";
                }

                return message5;
            }

            private String hdlInBlood(float hdl) {

                String message6 = "";

                if (35 <= hdl && hdl <= 60) {
                    message6 = "ok";
                } else if (hdl < 35) {
                    message6 = "cancell";
                } else if (hdl > 60) {
                    message6 = "ok";
                } else {
                    message6 = "ok";
                }
                return message6;
            }

            private String triInBlood(float tri) {

                String message7 = "";

                if (50 <= tri && tri <= 200) {
                    message7 = "ok";
                } else if (tri < 50) {
                    message7 = "cancell";
                } else if (tri > 200) {
                    message7 = "cancell";
                } else {
                    message7 = "ok";
                }
                return message7;
            }


        }
