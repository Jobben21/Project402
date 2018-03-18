package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_B extends Fragment {

    //returning our layout file
    //change R.layout.yourlayoutfilename for each of your fragments


    private Button button_b;
    private AfterBldT afterBldT;
    private EditText sugart,sodium_t,potassium_t,choles_t,ldl_t,hdl_t,tri_t;
    private Spinner hospitalSpinner;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_layout_b,container,false);

        sugart = (EditText)view.findViewById(R.id.sugar_t);
        sodium_t = (EditText)view.findViewById(R.id.sodium_t);
        potassium_t = (EditText)view.findViewById(R.id. potassium_t );
        choles_t = (EditText)view.findViewById(R.id.choles_t);
        ldl_t = (EditText)view.findViewById(R.id. ldl_t );
        hdl_t = (EditText)view.findViewById(R.id.sodium_t);
        tri_t= (EditText)view.findViewById(R.id. tri_t);

       // hospitalSpinner = (Spinner)view.findViewById(R.id.spinnerblood);

        button_b = (Button)view.findViewById(R.id.button_blood);
        button_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sugart.getText().length() == 0) {
                    sugart.setError("กรอกข้อมูลให้ครบถ้วน");

                } else if (sugart.getText().length() >= 6) {
                    sugart.setError("ใส่ข้อมูลไม่ถูกต้อง");
                }else{

                    new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE).setTitleText("แปรผลตรวจเลือด")
                            .setConfirmText("ใช่").setCancelText("ไม่")
                            .showCancelButton(true).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener(){
                        @Override public void onClick(SweetAlertDialog sweetAlertDialog) {

                            inputBloodTest();

                        }}).show();


                }
            }   });

        return view;
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        getActivity().setTitle("ผลตรวจเลือด");

    }
    public void inputBloodTest(){

        float sugar = Float.parseFloat(sugart.getText().toString());
        sugarInBlood(sugar);
        String Sugar =  sugarInBlood(sugar);

        float sodium = Float.parseFloat(sodium_t.getText().toString());
        sodiumInBlood(sodium);
        String Sodium =  sodiumInBlood(sodium);

        float potassium = Float.parseFloat(potassium_t.getText().toString());
        potassiumInBlood(potassium);
        String Potassium =  potassiumInBlood(potassium);

        float choles = Float.parseFloat(choles_t.getText().toString());
        String  Choles  = cholesInBlood(choles);


        float  hdl = Float.parseFloat(hdl_t.getText().toString());
        hdlInBlood(hdl);
        String  Hdl= hdlInBlood(hdl);


        float ldl = Float.parseFloat(ldl_t.getText().toString());
        ldlInBlood(ldl);
        String  Ldl =  ldlInBlood(ldl);



        float tri= Float.parseFloat( tri_t.getText().toString());
        String  Tri  = triInBlood(tri);

        afterBldT = new AfterBldT();
        Intent intent = new Intent(getActivity().getBaseContext(), AfterBldT.class);
        intent.putExtra("sugar",sugar);
        intent.putExtra("sodium",sodium);
        intent.putExtra("potassium",potassium);
        intent.putExtra("choles",choles);
        intent.putExtra("ldl",ldl);
        intent.putExtra("hdl",hdl);
        intent.putExtra("tri",tri);

        intent.putExtra("message1",Sugar);
        intent.putExtra("message2",Sodium );
        intent.putExtra("message3",Potassium);
        intent.putExtra("message4",Choles);
        intent.putExtra("message5",Ldl);
        intent.putExtra("message6",Hdl);
        intent.putExtra("message7",Tri);

        startActivity(intent);

    }

    private String sugarInBlood(float sugar) {

        String message1 = "";

        if (70 <= sugar && sugar<= 100) {
            message1 =  "smilee";
        }
        else {
             if (sugar < 70) {
                message1 = "sadd";
            } else if (sugar > 130) {
                message1 = "sadd";
            } else {
                message1 = "normal";
            }
        }
        return message1;
    }
    private String sodiumInBlood(float sodium) {

        String message2 = "";

        if (136 <= sodium && sodium<= 145) {
            message2 = "smilee";
        } else if (sodium < 136) {
            message2 = "sadd";
        }
        else if (sodium > 146)  {
            message2 = "sadd";
        }
        else{
            message2 = "normal";
        }
        return message2;
    }
    private String potassiumInBlood(float potassium) {

        String message3 = "";

        if (3.5 <= potassium && potassium <= 5.1) {
            message3 = "smilee";
        } else if (potassium < 3.5 ) {
            message3 = "sadd";
        }
        else if (potassium > 5.1)  {
            message3 = "sadd";
        }
        else{
            message3 = "normal";
        }
        return message3;

    }

    private String cholesInBlood(float choles) {

        String message4 = "";

        if (50 <= choles && choles<= 200) {
            message4 ="smilee";
        } else if (choles < 40) {
            message4 = "sadd";
        }
        else if (choles > 300)  {
            message4 = "sadd";
        }
        else  {
            message4 = "normal";
        }
        return message4;
    }

    private String ldlInBlood(float ldl) {

        String message5 = "";

        if (0 <= ldl && ldl<= 100) {
            message5 = "smilee";
        }
        else if (ldl > 100)  {
            message5 = "sadd";
        }

        return message5;
    }
    private String hdlInBlood(float hdl) {

        String message6 = "";

        if (35 <= hdl && hdl<= 60) {
            message6 = "smilee";
        } else if (hdl < 35) {
            message6= "sadd";
        }
        else if (hdl > 60)  {
            message6 = "smilee";
        }
        else   {
            message6 = "normal";
        }
        return message6;
    }

    private String triInBlood(float tri) {

        String message7 = "";

        if (50 <= tri && tri<= 200) {
            message7 = "smilee";
        } else if (tri < 50) {
            message7 = "sadd";
        }
        else if (tri > 200)  {
            message7 = "sadd";
        }
        else  {
            message7 = "normal";
        }
        return message7;
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
