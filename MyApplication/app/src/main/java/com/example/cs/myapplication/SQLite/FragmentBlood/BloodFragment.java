package com.example.cs.myapplication.SQLite.FragmentBlood;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.example.cs.myapplication.R;

import java.util.Calendar;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * A simple {@link Fragment} subclass.
 */
public class BloodFragment extends Fragment {

    EditText e_sugar,e_sodium,e_potassium,e_choles,e_ldl,e_hdl,e_tri,dateBloods;
    TextView error,error2,error3,error4,error5,error6,error7;
    private int e_sugar2,e_sodium2,e_choles2,e_ldl2,e_hdl2,e_tri2;
    private double e_potassium2;
    private  String sugar2,sodium2,potassium2,choles2,hdl2,ldl2,tri2;
    Button button;
    private int mYear,mMonth,mDay;

    public BloodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_blood, container, false);

        e_sugar = (EditText)v.findViewById(R.id.e_sugar);
        e_sodium = (EditText)v.findViewById(R.id.e_sodium);
        e_potassium = (EditText)v.findViewById(R.id.e_potass);
        e_choles  = (EditText)v.findViewById(R.id.e_chol);
        e_ldl = (EditText)v.findViewById(R.id.e_ldl);
        e_hdl = (EditText)v.findViewById(R.id. e_hdl);
        e_tri= (EditText)v.findViewById(R.id.e_tri);
        dateBloods= (EditText)v.findViewById(R.id.e_date);
        button = (Button)v.findViewById(R.id.confirmb);

        error = (TextView)v.findViewById(R.id.error1);
        error2 = (TextView)v.findViewById(R.id.error2);
        error3 = (TextView)v.findViewById(R.id.error3);
        error4 = (TextView)v.findViewById(R.id.error4);
        error5 = (TextView)v.findViewById(R.id.error5);
        error6 = (TextView)v.findViewById(R.id.error6);
        error7 = (TextView)v.findViewById(R.id.error7);

        dataBloods();
        Calendar();
        return v;
    }

    public void dataBloods(){

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if("0".equals(e_sugar.getText().toString())&& "0".equals( e_sodium.getText().toString())
                       && "0".equals(e_potassium.getText().toString())&& "0".equals( e_choles .getText().toString())
                       && "0".equals(e_ldl.getText().toString())&& "0".equals(e_hdl.getText().toString())
                       && "0".equals(e_tri.getText().toString())) {

                   new SweetAlertDialog(getActivity(), SweetAlertDialog.WARNING_TYPE)
                           .setTitleText("Bloods Test")
                           .setContentText("Please input bloods test at least 1 ")
                           .setConfirmText("OK")
                           .show();
               }

             ////SUGAR
               if(e_sugar.getText().toString().trim().length()>=3){
                   error.setVisibility(View.VISIBLE);
                   Log.d("YES","1");
               }
               if(e_sugar.getText().toString().trim().equals("")) {
                   e_sugar.setText("0");
                   e_sugar2 = (int) Float.parseFloat(e_sugar.getText().toString());
                   if(e_sugar2 == 0){
                       Log.d("YES","2");
                       sugar2  = "-";
                   }
               }else{
                   Log.d("YES","3");
                   e_sugar2 = (int) Float.parseFloat(e_sugar.getText().toString());
                   if(e_sugar2 == 0){
                       sugar2 = "-";
                   }
                   else{
                       Log.d("YES","4");
                       sugar2 = String.valueOf(e_sugar2);
                   }
               }
               if(e_sugar2 < 0 || e_sugar2 >=500 ){
                   Log.d("YES","5");
                   error.setVisibility(View.VISIBLE);
               }
               /////SODIUM
               if( e_sodium .getText().toString().trim().equals("") || e_potassium.getText().toString().trim().equals("")
                       || e_choles.getText().toString().trim().equals("")|| e_ldl.getText().toString().trim().equals("")
                       || e_hdl.getText().toString().trim().equals("")|| e_tri.getText().toString().trim().equals("")) {

                   e_sodium.setText("0");
                   e_potassium.setText("0");
                   e_choles.setText("0");
                   e_ldl.setText("0");
                   e_hdl.setText("0");
                   e_tri.setText("0");

                   e_sodium2 = (int) Float.parseFloat(e_sodium.getText().toString());
                   e_potassium2 = (int) Float.parseFloat(e_potassium.getText().toString());
                   e_choles2 = (int) Float.parseFloat(e_choles.getText().toString());
                   e_ldl2= (int) Float.parseFloat(e_ldl.getText().toString());
                   e_hdl2= (int) Float.parseFloat(e_hdl.getText().toString());
                   e_tri2= (int) Float.parseFloat(e_tri.getText().toString());

                   if(e_sodium2 == 0 || e_potassium2  == 0 || e_choles2 == 0
                           ||e_ldl2 == 0|| e_hdl2  == 0||  e_tri2  == 0){

                       Log.d("e_sodium","2");
                       sodium2  = "-";
                       potassium2  = "-";
                       choles2 = "-";
                       ldl2  = "-";
                       hdl2  = "-";
                       tri2 = "-";
                   }
               }else{
                   Log.d("e_sodium","3");
                   e_sodium2 = (int) Float.parseFloat(e_sodium.getText().toString());
                   e_potassium2 = (int) Float.parseFloat(e_potassium.getText().toString());
                   e_choles2 = (int) Float.parseFloat(e_choles.getText().toString());
                   e_ldl2= (int) Float.parseFloat(e_ldl.getText().toString());
                   e_hdl2= (int) Float.parseFloat(e_hdl.getText().toString());
                   e_tri2= (int) Float.parseFloat(e_tri.getText().toString());


                   if(e_sodium2 == 0 || e_potassium2  == 0 || e_choles2 == 0
                           ||e_ldl2 == 0|| e_hdl2  == 0||  e_tri2  == 0){

                       Log.d("e_sodium","4");
                       sodium2  = "-";
                       potassium2  = "-";
                       choles2 = "-";
                       ldl2  = "-";
                       hdl2  = "-";
                       tri2 = "-";
                   }
                   else{
                       Log.d("e_sodium","4");
                       sodium2 = String.valueOf(e_sugar2);
                       potassium2 = String.valueOf(e_potassium2);
                       choles2  = String.valueOf(e_choles2);
                       ldl2  = String.valueOf(e_ldl2);
                       hdl2  = String.valueOf(e_hdl2);
                       tri2  = String.valueOf(e_tri2);
                   }
               }
               if(  e_sodium2 < 0 ||  e_sodium2 >=500 ){
                   Log.d("e_sodium","5");
                   error2.setVisibility(View.VISIBLE);
               }
               if(  e_potassium2 < 0 ||  e_potassium2 >=10 ){
                   Log.d("e_potassium","5");
                   error3.setVisibility(View.VISIBLE);
               }
               if(  e_choles2 < 0 ||  e_choles2 >=300 ){
                   Log.d("e_cho","5");
                   error4.setVisibility(View.VISIBLE);
               }
               if(  e_ldl2 < 0 ||  e_ldl2 >=200 ){
                   Log.d("e_ldl2","5");
                   error5.setVisibility(View.VISIBLE);
               }
               if(  e_hdl2 < 0 ||  e_hdl2 >=200 ){
                   Log.d("e_sodium","5");
                   error6.setVisibility(View.VISIBLE);
               } if(  e_tri2 < 0 ||  e_tri2 >=700 ){
                   Log.d("e_sodium","5");
                   error7.setVisibility(View.VISIBLE);
               }

//
//               Intent intent = new Intent(getActivity().getBaseContext(), class);
//               intent.putExtra("sugar", sugar);

           }
       });

    }

    public void so(){

//       if( e_sodium .getText().toString().trim().equals("") || e_potassium.getText().toString().trim().equals("")) {
//        e_sodium .setText("0");
//        e_potassium.setText("0");
//
//        if(e_sodium2 == 0 || e_potassium2  == 0){
//        Log.d("e_sodium","2");
//        sodium2  = "-";
//        potassium2  = "-";
//        }
//        }else{
//        Log.d("e_sodium","3");
//
//        if(  e_sodium2 == 0 || e_potassium2  == 0){
//        sodium2 = "-";
//        potassium2  = "-";
//        }
//        else{
//        Log.d("e_sodium","4");
//        sodium2 = String.valueOf(e_sugar2);
//        potassium2 = String.valueOf(e_potassium2);
//        }
//        }
//        if(  e_sodium2 < 0 ||  e_sodium2 >=500 ){
//        Log.d("e_sodium","5");
//        error2.setVisibility(View.VISIBLE);
//        }
//        if(  e_potassium2 < 0 ||  e_potassium2 >=10 ){
//        Log.d("e_sodium","5");
//        error3.setVisibility(View.VISIBLE);
//        }
    }

    public void Calendar(){

        dateBloods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR); // current year
                mMonth = c.get(Calendar.MONTH); // current month
                mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                dateBloods.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
    }

}
