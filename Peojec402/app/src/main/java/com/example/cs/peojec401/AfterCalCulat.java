package com.example.cs.peojec401;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AfterCalCulat extends AppCompatActivity{

    private Button button_cal;
    private ImageButton information;
    final Context context = this;
    private Button button_dialog2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_cal_culat);
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        popUp();

        button_cal = (Button)findViewById(R.id.button_cal);
        button_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new SweetAlertDialog(AfterCalCulat.this,SweetAlertDialog.WARNING_TYPE).setTitleText("คุณต้องการ")
                        .setContentText("กลับสู่หน้าหลัก").setConfirmText("หน้าเมนูหลัก").setCancelText("ไม่ต้องการ")
                        .showCancelButton(true).setCancelClickListener(
                        new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.cancel();

                            }
                        }).setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog dialog) {

                        new SweetAlertDialog(AfterCalCulat.this,SweetAlertDialog.SUCCESS_TYPE).setTitleText("เรียบร้อย").setConfirmClickListener(
                                new SweetAlertDialog.OnSweetClickListener(){
                                    @Override
                                    public void onClick(SweetAlertDialog sweetAlertDialog) {

                                        Intent intent = new Intent(AfterCalCulat.this,NavigationActivity.class);
                                        startActivity(intent);

                                    }
                                }
                        ).show();
                    }
                }).show();

            }
        });
    }



    public void popUp(){

        information = (ImageButton)findViewById(R.id.BMIinformation);
        information.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.content_after_calcult_dialog);
                dialog.show();

                button_dialog2 = (Button)dialog.findViewById(R.id.close_dialog_bmi);
                button_dialog2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });

            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public void onStart(){

        super.onStart();
        Intent intent = getIntent();
        String message = intent.getStringExtra("bmi");
        float weight = intent.getFloatExtra("WEIGHT",0);
        float height = intent.getFloatExtra("HEIGHT",0);

        float bmiValue = intent.getFloatExtra("bmiValue",0);
        float bmrValue = intent.getFloatExtra("bmrValue",0);

        TextView bmi =(TextView)findViewById(R.id.bmi);
        bmi.setText(String.format("%.1f",bmiValue));

        TextView bmr =(TextView)findViewById(R.id.bmr);
        bmr.setText(String.format("%.1f",bmrValue));

        TextView description =(TextView)findViewById(R.id.explanation_BMI);
        description.setText(message);



    }



}
