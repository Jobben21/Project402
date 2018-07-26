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

/**
 * A simple {@link Fragment} subclass.
 */
public class BloodFragment extends Fragment {

    EditText e_sugar,e_sodium,e_potassium,e_choles,e_ldl,e_hdl,e_tri,dataBloods;
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

//               if("0".equals(e_sugar.getText().toString())&& "0".equals( e_sodium.getText().toString())
//                       && "0".equals(e_potassium.getText().toString())&& "0".equals( e_choles .getText().toString())
//                       && "0".equals(e_ldl.getText().toString())&& "0".equals(e_hdl.getText().toString())
//                       && "0".equals(e_tri.getText().toString())) {
//
//               }

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


//
//               Intent intent = new Intent(getActivity().getBaseContext(), class);
//               intent.putExtra("sugar", sugar);

           }
       });

    }



    public void Calendar(){

        dataBloods.setOnClickListener(new View.OnClickListener() {
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
                                dataBloods.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
    }

}
//
//if( e_sodium .getText().toString().trim().equals("") || e_potassium.getText().toString().trim().equals("")) {
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