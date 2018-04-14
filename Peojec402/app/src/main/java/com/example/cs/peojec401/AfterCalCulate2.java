package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class AfterCalCulate2 extends AppCompatActivity {

    float bmiValue;
    TextView BMIvale,BMI_description,BMI_description2,BMI_description3,BMI_description4,BMI_description5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_cal_culate2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        BMIvale = (TextView)findViewById(R.id.BMI5);
        BMI_description = (TextView)findViewById(R.id.BMI5);
        BMI_description2 = (TextView)findViewById(R.id.bmi5_description2);
        BMI_description3 = (TextView)findViewById(R.id.bmi5_description3);
        BMI_description4 = (TextView)findViewById(R.id.bmi5_description4);
        BMI_description5 = (TextView)findViewById(R.id.bmi5_description5);

        BMI_description.setMovementMethod(LinkMovementMethod.getInstance());


        return true;
    }

    public void onStart(){

        super.onStart();
        Intent intent = getIntent();

        bmiValue = intent.getFloatExtra("bmiValue",0);

        TextView bmi =(TextView)findViewById(R.id.BMII);
        bmi.setText(String.format("%.1f",bmiValue));

        checkData(bmiValue);

    }

    public void checkData(float bmiValue){

        if(bmiValue > 30){

/*            BMIvale.setText("อ้วนมาก / อ้วนระดับ 3");
            BMI_description.setText("1. ควรควบคุมอาหารโดยลดปริมาณอาหารหรือปรับเปลี่ยนอาหารจากที่ให้พลังงานมากเป็นอาหารที่ให้พลังงานน้อย");
            BMI_description2.setText("2. ควรเคลื่อนไหวและออกกำลังกายแบบแอโรบิกอย่างสม่ำเสมอทุกวันหรือเกือบทุกวันอย่างน้อยให้เหนื่อย");
            BMI_description3.setText("3. ควรฝึกความแข็งแรงของกล้ามเนื้อ ด้วยการฝึกกายบริหารหรือยกน้ำหนัก จะช่วยเสริมให้ร่างกายมีการใช้พลังงานเพิ่มมากขึ้น ทำให้ไขมันลดลง");
           BMI_description4.setText("4. ถ้าคุณสามารถลดพลังงานเข้าจากอาหารลงได้วันละ 400 กิโลแคลอรี "); */
        }
      /*  else if(){

        }
        else if(){

        }
        else if(){

        }
        else if(){

        }*/
    }

}
