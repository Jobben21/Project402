package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AfterCalCulate2 extends AppCompatActivity {

    float bmiValue;
    TextView BMIvale,BMI_description,BMI_description2,BMI_description3,BMI_description4,BMI_description5,BMIvalue,BMIvalue2,BMIvalue3;
    View view1,view2,view3;
    LinearLayout bean,rice,swim,weight,jumping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_cal_culate2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.register);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        BMIvalue = (TextView)findViewById(R.id.BMIvalue);
        BMIvalue2 = (TextView)findViewById(R.id.BMIvalue2);
        BMIvalue3 = (TextView)findViewById(R.id.BMIvalue3);

        BMIvale = (TextView)findViewById(R.id.BMIvalue5);
        BMI_description = (TextView)findViewById(R.id.bmi5_description);
        BMI_description2 = (TextView)findViewById(R.id.bmi5_description2);
        BMI_description3 = (TextView)findViewById(R.id.bmi5_description3);
        BMI_description4 = (TextView)findViewById(R.id.bmi5_description4);
        BMI_description5 = (TextView)findViewById(R.id.bmi5_description5);

        view1 = (View)findViewById(R.id.view1);
        view2 = (View)findViewById(R.id.view2);

        bean = (LinearLayout)findViewById(R.id.beans);
        rice = (LinearLayout)findViewById(R.id.rice);
        swim = (LinearLayout)findViewById(R.id.swim);
        weight = (LinearLayout)findViewById(R.id.weightfitting);
        jumping = (LinearLayout)findViewById(R.id.jump);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

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

            BMIvalue.setText("มากกว่า 30");
            BMIvalue2.setText("อ้วนมาก / โรคอ้วนระดับ 3");
            BMIvalue3.setText("อันตรายระดับ 3");
            BMIvale.setText("้ข้อแนะนำ");
            BMI_description.setText("ควรควบคุมอาหารโดยลดปริมาณอาหารหรือปรับเปลี่ยนอาหารจากที่ให้พลังงานมากเป็นอาหารที่ให้พลังงานน้อย ทั้งนี้พลังงานที่ได้รับไม่ควรต่ำกว่า 1200 กิโลแคลอรีต่อวัน ลดอาหารไขมัน/เนื้อสัตว์ อาหารผัด/ทอด ขนมหวาน เครื่องดื่มที่ใส่น้ำตาล แอลกอฮอล์");
            BMI_description2.setText("ออกกำลังกายแบบแอโรบิกอย่างสม่ำเสมอทุกวัน สะสมอย่างน้อยวันละ 30 นาที อาจแบ่งเป็นวันละ 2 - 3 ครั้งก็ได้ และเพิ่มการเคลื่อนไหวร่างกายให้มากขึ้นในชีวิตประจำวัน เพื่อให้มีการใช้พลังงานเพิ่มขึ้น อย่างน้อยวันละ 200 - 300 กิโลแคลอรี");
            BMI_description3.setText("3. ควรฝึกความแข็งแรงของกล้ามเนื้อ ด้วยการฝึกกายบริหารหรือยกน้ำหนัก จะช่วยเสริมให้ร่างกายมีการใช้พลังงานเพิ่มมากขึ้น ทำให้ไขมันลดลง");
            BMI_description4.setText("4. ถ้าคุณสามารถลดพลังงานเข้าจากอาหารลงได้วันละ 400 กิโลแคลอรี และเพิ่มการใช้ พลังงานจากการออกกำลังกายวันละ 200 กิโลแคลอรี รวมแล้วคุณมีพลังงาพร่องลงไปวันละ 600 กิโลแคลอรี ออกกำลังกายประมาณ 6 วัน คิดเป็นพลังงานพร่อง 3600 กิโลแคลอรี คุณจะลดไขมันลงได้ประมาณครึ่งกิโลกรัมต่อสัปดาห์ พลังงานเข้าหรือออก 3500 กิโลแคลอรี จะเพิ่มหรือลดไขมันได้ 1 ปอนด์ หรือ 0.45 กิโลกรัม");
            BMI_description5.setText("5. ควรปรึกษาแพทย์หรือผู้เชี่ยวชาญในการลดและควบคุมน้ำหนัก");

        }
        else if(bmiValue <18.5){

            BMIvalue.setText("น้อยกว่า 18.50");
            BMIvalue2.setText("น้ำหนักน้อย / ผอม");
            BMIvalue3.setText("มากกว่าคนปกติ");

            BMIvale.setText("ข้อแนะนำ");
            BMI_description.setText("ควรกินอาหารให้หลากหลายครบ 5 หมู่ในสัดส่วนที่เหมาะสมและปริมาณมากขึ้น");
            BMI_description2.setText("ควรเคลื่อนไหวและออกกำลังกายอย่างสม่ำเสมอทุกวันหรือเกือบทุกวัน สะสมให้ได้อย่างน้อยวันละ 30 นาทีที่ง่ายที่สุดคือ การเดิน ");
            bean.setVisibility(View.GONE);
            rice.setVisibility(View.GONE);
            swim.setVisibility(View.GONE);
            weight.setVisibility(View.GONE);
            jumping.setVisibility(View.GONE);

        }
        else if(bmiValue >= 18.5 && bmiValue < 22.9 ){

            BMIvalue.setText("ระหว่าง 18.50 - 22.90");
            BMIvalue2.setText("ปกติ (สุขภาพดี)");
            BMIvalue3.setText("เท่าคนปกติ");

            BMIvale.setText("ข้อแนะนำ");
            BMI_description.setText("ควรกินอาหารให้หลากหลายครบ 5 หมู่ในสัดส่วนที่เหมาะสม กินเท่าที่ร่างกายต้องการวันไหนกินมากเกินไป วันต่อมาก็กินลดลง");
            BMI_description2.setText("ควรเคลื่อนไหวและออกกำลังกายอย่างสม่ำเสมอทุกวัน อย่างน้อยวันละ 20 - 30 นาที อย่างน้อยสัปดาห์ละ 3 วัน ที่ง่าย ที่สุดคือ การเดิน");


        }
        else if(bmiValue >= 25 && bmiValue <= 29.9){

            BMIvalue.setText("ระหว่าง 25 - 29.90");
            BMIvalue2.setText("อ้วน / โรคอ้วนระดับ 2");
            BMIvalue3.setText("อันตรายระดับ 2");

            BMIvale.setText("ข้อแนะนำ");
            BMI_description.setText("ควรควบคุมอาหารโดยลดปริมาณอาหารหรือปรับเปลี่ยนอาหารจากที่ให้พลังงานมากเป็นอาหารที่ให้พลังงานน้อย ทั้งนี้พลังงานที่ได้รับไม่ควรต่ำกว่า 1200 กิโลแคลอรีต่อวัน ลดอาหารไขมัน/เนื้อสัตว์ อาหารผัด/ทอด ขนมหวาน เครื่องดื่มที่ใส่น้ำตาล แอลกอฮอล์");
            BMI_description2.setText("ออกกำลังกายแบบแอโรบิกอย่างสม่ำเสมอทุกวันหรือเกือบทุกวันอย่างน้อยให้เหนื่อยพอควรโดยหายใจกระชั้นขึ้น ประมาณ 40-60 นาทีต่อวัน หรือแบ่งเป็นวันละ 2 ครั้ง ๆ ละ 20 - 30 นาที");
            BMI_description3.setText("3. ควรฝึกความแข็งแรงของกล้ามเนื้อ ด้วยการฝึกกายบริหารหรือยกน้ำหนัก จะช่วยเสริมให้ร่างกายมีการใช้พลังงานเพิ่มมากขึ้น ทำให้ไขมันลดลง");
           
        }
         else if(bmiValue >= 23 && bmiValue < 24.9){

            BMIvalue.setText("ระหว่าง 23 - 24.90");
            BMIvalue2.setText("ท้วม / โรคอ้วนระดับ 1");
            BMIvalue3.setText("อันตรายระดับ 1");

            BMIvale.setText("ข้อแนะนำ");
            BMI_description.setText("พลังงานที่ได้รับไม่ควรต่ำกว่า 1200 กิโลแคลอรีต่อวัน โดยลดอาหารไขมัน/ เนื้อสัตว์ อาหารผัด/ทอด ขนมหวาน เครื่องดื่มที่ใส่น้ำตาล แอลกอฮอล์");
            BMI_description2.setText("ออกกำลังกายแบบแอโรบิกอย่างสม่ำเสมอทุกวัน สะสมอย่างน้อยวันละ 30 นาที อาจแบ่งเป็นวันละ 2 - 3 ครั้งก็ได้ และเพิ่มการเคลื่อนไหวร่างกายให้มากขึ้นในชีวิตประจำวัน เพื่อให้มีการใช้พลังงานเพิ่มขึ้น อย่างน้อยวันละ 200 - 300 กิโลแคลอรี");

        }
    }

}
