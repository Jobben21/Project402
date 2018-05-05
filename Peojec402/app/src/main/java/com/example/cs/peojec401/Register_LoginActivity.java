package com.example.cs.peojec401;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cs.peojec401.ConnectData.Con_regis;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Register_LoginActivity extends AppCompatActivity {

    private EditText username;
    private Button login,register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_register__login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.bloods);
        setSupportActionBar(toolbar);

        username = (EditText)findViewById(R.id.username2);
        login = (Button)findViewById(R.id.login2);
        register = (Button)findViewById(R.id.register);

        final Con_regis  con_regis = new Con_regis(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1 = username.getText().toString();


                String type = "login";

              /*  con_regis.execute(type, username1,null);
                SweetAlertDialog pDialog = new SweetAlertDialog(Register_LoginActivity.this,SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("รอสักครู่");
                pDialog.setCancelable(false);
                pDialog.show(); */

                if(username.getText().toString().isEmpty()){

                    new SweetAlertDialog(Register_LoginActivity.this,SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("เข้าสู่ระบบ")
                            .setContentText("กรอกชื่อผู้ใช้งานให้ครบถ้วน")
                            .setConfirmText("ตกลง")
                            .show();

                   // username.setError("กรอกชื่อผู้ใช้งานให้ครบถ้วน");
                }

                else {

                    SweetAlertDialog pDialog = new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);

                    pDialog = new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);

                    new SweetAlertDialog(Register_LoginActivity.this, SweetAlertDialog.PROGRESS_TYPE);

                    pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                    pDialog.setTitleText("รอสักครู่");
                    pDialog.setCancelable(false);
                    pDialog.show();

                    Intent intent = new Intent(Register_LoginActivity.this,NavigationActivity.class);
                    startActivity(intent);
                }
            }




        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register_LoginActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }





}
