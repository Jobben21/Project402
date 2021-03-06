package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by hp on 9/1/2561.
 */

public class Fragment_C extends Fragment {


    private Button button_cal;
    private EditText age_cal, weight_cal, height_cal;
    private RadioGroup radioGroupGender;
    private RadioButton woman_radio, man_radio;
    private LinearLayout calculator;
    private LinearLayout profile_layout;


    float weight;
    float height;
    float height2;
    int age;

    boolean gender = true;
    public Fragment_C() {

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout_c, container, false);

        button_cal = (Button) view.findViewById(R.id.button_cal);

        age_cal = (EditText) view.findViewById(R.id.age_cal);
        weight_cal = (EditText) view.findViewById(R.id.weight_cal);
        height_cal = (EditText) view.findViewById(R.id.height_cal);

        radioGroupGender = (RadioGroup) view.findViewById(R.id.radio_cal_gender);
        woman_radio = (RadioButton) view.findViewById(R.id.woman_cal);
        man_radio = (RadioButton) view.findViewById(R.id.man_cal);



        button_cal = (Button) view.findViewById(R.id.button_cal);
        button_cal.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                checking();
            }
            });

        return view;
    }
    public void checking(){


       if(age_cal.getText().toString().isEmpty() &&  weight_cal.getText().toString().isEmpty()
                && height_cal.getText().toString().isEmpty()  ){

            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("คำนวนพลังงาน")
                    .setContentText("กรุณากรอกข้อมูลให้ถูกต้อง")
                    .setConfirmText("ตกลง")
                    .show();
           age_cal.setError("กรอกอายุให้ถูกต้อง 1-110");
           weight_cal.setError("กรอกน้ำหนักห้ถูกต้อง 30-200");
           height_cal.setError("กรอกส่วนสูงห้ถูกต้อง 110-200");
        }
        else if(age_cal.getText().toString().length() >= 4 ){

            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("คำนวนพลังงาน")
                    .setContentText("กรุณากรอกข้อมูลให้ถูกต้อง")
                    .setConfirmText("ตกลง")
                    .show();

            age_cal.setError("กรอกอายุให้ภูกต้อง 1-110");


        }else if (weight_cal.getText().toString().length() >= 4 ){

            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("คำนวนพลังงาน")
                    .setContentText("กรุณากรอกข้อมูลให้ถูกต้อง")
                    .setConfirmText("ตกลง")
                    .show();

            weight_cal.setError("กรอกน้ำหนักห้ถูกต้อง 30-200");

        }else if ( height_cal.getText().toString().length() >= 4){

            new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("คำนวนพลังงาน")
                    .setContentText("กรุณากรอกข้อมูลให้ถูกต้อง")
                    .setConfirmText("ตกลง")
                    .show();


            height_cal.setError("กรอกส่วนสูงห้ถูกต้อง 110-200");

        }

      else  if(age_cal.getText().length() == 0){
            age_cal.setError("กรอกอายุให้ถูกต้อง 1 - 100");
        }
      else  if(weight_cal.getText().length() == 0 ){
            weight_cal.setError("กรอกน้ำหนักห้ถูกต้อง 30-200");
        }
      else  if(height_cal.getText().length() == 0){
            height_cal.setError("กรอกส่วนสูงห้ถูกต้อง 110-200");
        }
        else {
            checking2();
        }


    }

    public void checking2(){

        new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE).setTitleText("คำนวณผล")
                .setConfirmText("ใช่").setCancelText("ไม่")
                .showCancelButton(true).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener(){
            @Override public void onClick(SweetAlertDialog sweetAlertDialog) {


                Log.i("weight",weight_cal.getText().toString());
                Log.i("weight",height_cal.getText().toString());

                weight = Float.parseFloat(weight_cal.getText().toString());
                height = Float.parseFloat(height_cal.getText().toString());
                age = Integer.parseInt(age_cal.getText().toString());
                height2 = Float.parseFloat(height_cal.getText().toString());


                float bmiValue = calculateBMI(weight,height);
                float bmrValue = calculateBMR(age,weight,height2,gender);

                String bmiInterpretation = interpretBMI(bmiValue);
                String bmiInterpretation2 = Imagebmi(bmiValue);

                Intent intent = new Intent(getActivity().getBaseContext(), AfterCalCulat.class);
                intent.putExtra("bmi",bmiInterpretation);
                intent.putExtra("bmi2",bmiInterpretation2);
                intent.putExtra("bmiValue",bmiValue);
                intent.putExtra("bmrValue",bmrValue);

                startActivity(intent);

            }}).show();}


    private float calculateBMI (float weight, float height) {

//        float a = (float) ((float) (height/100.0)*1.0);
        height = height/100;
//        System.out.println(height);
        double x = Math.pow(height,2);
//        System.out.println(x);
        double a = weight / x;
//        System.out.print(a);
        return (float) a;
    }

    private float calculateBMR(int age,float weight,float height2,boolean gender){

        float BMRMAN = 0;

        if(woman_radio.isChecked()){

            gender = true;
            BMRMAN = (float) (665+ (9.6 *weight )+ (1.8 * height2 )- (4.7 * age));



        }
        else{
            gender = false;
            BMRMAN = (float) (66+ (13.7 *weight )+ (5 * height2 )- (6.8 * age));

        }


        return BMRMAN;
    }


    private String interpretBMI(float bmiValue) {

        String message = "";

        if (bmiValue < 18.5) {
            message = "น้ำหนักต่ำกว่าเกณฑ์";
        } else if (18.5 < bmiValue && bmiValue < 22.9) {
            message = "สมส่วน";
        } else if (23 < bmiValue && bmiValue < 24.9) {
            message = "น้ำหนักเกิน";
        }else if (25 < bmiValue && bmiValue < 29.9) {
            message = "โรคอ้วน";
        }
        else {
            message = "โรคอ้วนอันตราย";
        }

        return message;
    }

    private String Imagebmi(float bmiValue) {

        String message1 = "";
        if (bmiValue <= 18.5) {
            message1 = "vsad";
        }
        else if(bmiValue >= 18.5 && bmiValue <= 24.9){
            message1 = "vhappy";
        }
        else if(bmiValue >= 25 && bmiValue <= 29.9){
            message1 = "vconfused";
        }
        else if(bmiValue >= 30 && bmiValue <= 34.9){
            message1 = "vconfused";
        }
        else if(bmiValue >= 35 && bmiValue <= 39.9){
            message1 = "vsad";
        }
        else{
            message1 = "vsad";
        }

        return message1;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getActivity().setTitle("คำนวนพลังงาน");
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
