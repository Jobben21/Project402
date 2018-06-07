package com.example.cs.peojec401;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.cs.peojec401.R.id.blooodt_normal;

public class AfterBldT extends AppCompatActivity {


    private TextView sugar_ab2,sodium_ab2,potass_ab2,chole_ab2,ldl_ab2,hdl_ab2,tri_ab2;
    final Context context = this;
    private Button next ,home;
    private ProgressBar progressBar,progressBar2,progressBar3,progressBar4,progressBar5,progressBar6,progressBar7;
    private SeekBar seekBarex;
    private TextView INFO2,INFO3,INFO4,INFO5,INFO6,INFO7,INFO8;
    private TextView seekBarMin, seekBarvalue2, seekBarvalue3, seekBarvalue4, seekBarvalue5,  seekBarvalue6,  seekBarvalue7;
    private TextView blood_normal ,blood_abnormal2 ,blood_abnormal,sodium_normal,
            sodium_abnormal2,sodium_abnormal,potassium_normal, potassium_abnormal2,potassium_abnormal,hdl_normal,hdl_abnormal3,hdl_abnormal4,
            ldl_normal,ldl_abnormal2,ldl_abnormal3,ldl_abnormal4,ldl_abnormal5,chl_normal2,chl_normal,chl_abnormal2,chl_abnormal3,
            tri_normal,tri_abnormal2,tri_abnormal,tri_abnormal3;

    private TextView bloodt_normal, bloodt_abnormal2,bloodt_abnormal,sodiumt_normal,sodiumt_abnormal2,sodiumt_abnormal,
            potassiumt_normal,potassiumt_abnormal2,potassiumt_abnormal,hdlt_normal,hdlt_abnormal3,hdlt_abnormal4,ldlt_normal,ldlt_abnormal2,
            ldlt_abnormal3,ldlt_abnormal4,ldlt_abnormal5,chlt_normal2,chlt_normal,chlt_abnormal2,chlt_abnormal3,
            trit_normal,trit_abnormal2, trit_abnormal,trit_abnormal3;

    public static int i;
    LinearLayout HeaderLayout,HeaderLayout2,HeaderLayout3,HeaderLayout4,HeaderLayout5,HeaderLayout6,HeaderLayout7;
    LinearLayout ChildLayout,ChildLayout2,ChildLayout3,ChildLayout4,ChildLayout5,ChildLayout6,ChildLayout7;
    CardView Main,Main2,Main3,Main4,Main5,Main6,Main7;

     public static String Resultone;
     public static String Resulttwo;
     public static String Resultthree;
    public static String Resultfour;
    public static String Resultfive;
    public static String Resultsix;
    public  static String Resultseven;
    public static int bt = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_bld_t);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        blood_normal = (TextView) findViewById(R.id.bloood_normal);
        blood_abnormal2 = (TextView) findViewById(R.id.blood_abnormal2);
        blood_abnormal = (TextView) findViewById(R.id.blood_abnormal);

        sodium_normal = (TextView) findViewById(R.id.sodium_normal);
        sodium_abnormal2 = (TextView) findViewById(R.id.sodium_abnormal2);
        sodium_abnormal = (TextView) findViewById(R.id.sodium_abnormal);

        potassium_normal = (TextView) findViewById(R.id.potassium_normal);
        potassium_abnormal2 = (TextView) findViewById(R.id.potassium_abnormal2);
        potassium_abnormal = (TextView) findViewById(R.id.potassium_abnormal );


        hdl_normal = (TextView) findViewById(R.id.hdl_normal);
        hdl_abnormal3 = (TextView) findViewById(R.id.hdl_abnormal3);
        hdl_abnormal4 = (TextView) findViewById(R.id.hdl_abnormal4 );



        ldl_normal = (TextView) findViewById(R.id.ldl_normal);
        ldl_abnormal2 = (TextView) findViewById(R.id.ldl_abnormal2);
        ldl_abnormal3 = (TextView) findViewById(R.id.ldl_abnormal3);
        ldl_abnormal5 = (TextView) findViewById(R.id.ldl_abnormal5);

        chl_normal = (TextView) findViewById(R.id.chl_normal);
        chl_normal2 = (TextView) findViewById(R.id.chl_normal2);
        chl_abnormal2 = (TextView) findViewById(R.id.chl_abnormal2);
        chl_abnormal3 = (TextView) findViewById(R.id.chl_abnormal3);


        tri_normal = (TextView) findViewById(R.id.tri_normal);
        tri_abnormal2 = (TextView) findViewById(R.id.tri_abnormal2);
        tri_abnormal = (TextView) findViewById(R.id.tri_abnormal);
        tri_abnormal3 = (TextView) findViewById(R.id.tri_abnormal3);

        bloodt_normal = (TextView) findViewById(blooodt_normal);
        bloodt_abnormal2 = (TextView) findViewById(R.id.bloodt_abnormal2);
        bloodt_abnormal = (TextView) findViewById(R.id.bloodt_abnormal);

        sodiumt_normal = (TextView) findViewById(R.id.sodiumt_normal);
        sodiumt_abnormal2 = (TextView) findViewById(R.id.sodiumt_abnormal2);
        sodiumt_abnormal = (TextView) findViewById(R.id.sodiumt_abnormal);

        potassiumt_normal = (TextView) findViewById(R.id.potassiumt_normal);
        potassiumt_abnormal2 = (TextView) findViewById(R.id.potassiumt_abnormal2);
        potassiumt_abnormal = (TextView) findViewById(R.id.potassiumt_abnormal );


        hdlt_normal = (TextView) findViewById(R.id.hdlt_normal);
        hdlt_abnormal3 = (TextView) findViewById(R.id.hdlt_abnormal3 );
        hdlt_abnormal4 = (TextView) findViewById(R.id.hdlt_abnormal4 );



        ldlt_normal = (TextView) findViewById(R.id.ldlt_normal);
        ldlt_abnormal2 = (TextView) findViewById(R.id.ldlt_abnormal2);
        ldlt_abnormal3 = (TextView) findViewById(R.id.ldlt_abnormal3);
        ldlt_abnormal5 = (TextView) findViewById(R.id.ldlt_abnormal5);

        chlt_normal2 = (TextView) findViewById(R.id.chlt_normal2);
        chlt_normal = (TextView) findViewById(R.id.chlt_normal);
        chlt_abnormal2 = (TextView) findViewById(R.id.chlt_abnormal2);
        chlt_abnormal3 = (TextView) findViewById(R.id.chlt_abnormal3);


        trit_normal = (TextView) findViewById(R.id.trit_normal);
        trit_abnormal2 = (TextView) findViewById(R.id.trit_abnormal2);
        trit_abnormal = (TextView) findViewById(R.id.trit_abnormal);
        trit_abnormal3 = (TextView) findViewById(R.id.trit_abnormal3);


        progressBar = (ProgressBar)findViewById(R.id.seekBar);
        progressBar2 = (ProgressBar)findViewById(R.id.seekBar2);
        progressBar3 = (ProgressBar)findViewById(R.id.seekBar3);
        progressBar4 = (ProgressBar)findViewById(R.id.seekBar4);
        progressBar5 = (ProgressBar)findViewById(R.id.seekBar5);
        progressBar6 = (ProgressBar)findViewById(R.id.seekBar6);
        progressBar7 = (ProgressBar)findViewById(R.id.seekBar7);

        seekBarex = (SeekBar)findViewById(R.id.seekBar8);

        INFO2 = (TextView)findViewById(R.id.INFO2);
        INFO3 = (TextView)findViewById(R.id.INFO3);
        INFO4 = (TextView)findViewById(R.id.INFO4);
        INFO5 = (TextView)findViewById(R.id.INFO5);
        INFO6 = (TextView)findViewById(R.id.INFO6);
        INFO7 = (TextView)findViewById(R.id.INFO7);
        INFO8 = (TextView)findViewById(R.id.INFO8);

        information();

        if (Build.VERSION.SDK_INT > 9) {

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }

    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void onStart(){
        super.onStart();

        Intent intent = getIntent();

        float sugar_ab = intent.getFloatExtra("sugar",0);
        float sodium_ab = intent.getFloatExtra("sodium",0);
        float potass_ab = intent.getFloatExtra("potassium",0);
        float chole_ab = intent.getFloatExtra("choles",0);
        float ldl_ab = intent.getFloatExtra("ldl",0);
        float hdl_ab= intent.getFloatExtra("hdl",0);
        float tri_ab = intent.getFloatExtra("tri",0);

        seekBar(sugar_ab,sodium_ab,potass_ab,chole_ab,ldl_ab,hdl_ab,tri_ab);
        inputData(sugar_ab,sodium_ab,potass_ab,chole_ab,ldl_ab,hdl_ab,tri_ab);


        String message1 = intent.getStringExtra("message1");
        String message2 = intent.getStringExtra("message2");
        String message3 = intent.getStringExtra("message3");
        String message4 = intent.getStringExtra("message4");
        String message5 = intent.getStringExtra("message5");
        String message6 = intent.getStringExtra("message6");
        String message7 = intent.getStringExtra("message7");
        String check = intent.getStringExtra("check");

        showImage(message1,message2 ,message3,message4,message5,message6,message7);


<<<<<<< HEAD
        String Resultone = recommendFood(message1);
        String Resulttwo = recommendFood2(message2);
        String Resultthree = recommendFood3(message3);
        String Resultfour =  recommendFood4(message4);
        String Resultfive =  recommendFood5(message5);
        String Resultsix =  recommendFood6(message6);
        String Resultseven =  recommendFood7(message7);
        String Resulteight =  check;
=======
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391

         Resultone = recommendFood(message1);
        Resulttwo = recommendFood2(message2);
        Resultthree = recommendFood3(message3);
        Resultfour =  recommendFood4(message4);
        Resultfive =  recommendFood5(message5);
        Resultsix =  recommendFood6(message6);
        Resultseven =  recommendFood7(message7);
        String Resulteight =  check;
        layoutgone(sugar_ab,sodium_ab,potass_ab,chole_ab,ldl_ab,hdl_ab,tri_ab,Resulteight);


        final ArrayList<String> listResult2 = new ArrayList<>();
        listResult2.add(Resultone);
        listResult2.add(Resulttwo);
        listResult2.add(Resultthree);
        listResult2.add(Resultfour);
        listResult2.add(Resultfive);
        listResult2.add(Resultsix);
        listResult2.add(Resultseven);
        listResult2.add(Resulteight);




        layOutDescription();

        next = (Button)findViewById(R.id.button_bloodAb);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast toast = Toast.makeText (AfterBldT.this, Resultone, Toast.LENGTH_LONG );
//                toast.show ( );


            bt =6;
                Toast.makeText(AfterBldT.this,bt+" ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),DisplayList1.class);
                startActivity(intent);


            }
        });
        home= (Button)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NavigationActivity.class);
                startActivity(intent);

            }
        });

    }

    public void  inputData(float sugar_ab1,float sodium_ab1 ,float potass_ab1,float chole_ab1,float ldl_ab1,float hdl_ab1,float tri_ab1 ){

        sugar_ab2 =(TextView)findViewById(R.id.sugar_ab2);
        sugar_ab2.setText(String.format("%.1f",sugar_ab1));


        sodium_ab2 =(TextView)findViewById(R.id.sodium_ab2);
        sodium_ab2.setText(String.format("%.1f",sodium_ab1));

        potass_ab2 =(TextView)findViewById(R.id.potassium_ab2);
        potass_ab2.setText(String.format("%.1f",potass_ab1));

        chole_ab2 =(TextView)findViewById(R.id.cl_ab2);
        chole_ab2.setText(String.format("%.1f",chole_ab1));

        ldl_ab2 =(TextView)findViewById(R.id.ldl_ab2);
        ldl_ab2.setText(String.format("%.1f",ldl_ab1));

        hdl_ab2 =(TextView)findViewById(R.id.hdl_ab2);
        hdl_ab2.setText(String.format("%.1f",hdl_ab1));

        tri_ab2 =(TextView)findViewById(R.id.tri_ab2);
        tri_ab2.setText(String.format("%.1f",tri_ab1));

    }

    public void  layoutgone(float sugar_ab1,float sodium_ab1 ,float potass_ab1,float chole_ab1,float ldl_ab1,float hdl_ab1,float tri_ab1,String Resulteight ) {

        Main = (CardView) findViewById(R.id.sugar_bd);
        Main2 = (CardView) findViewById(R.id.sodium_bd);
        Main3 = (CardView) findViewById(R.id.potassium_bd);
        Main4 = (CardView) findViewById(R.id.choles_bd);
        Main5 = (CardView) findViewById(R.id.ldl_bd);
        Main6 = (CardView) findViewById(R.id.hdl_bd);
        Main7 = (CardView) findViewById(R.id.trigry_bd);

        if(sugar_ab1 == 0.0){
            Main.setVisibility(View.GONE);
        }if(sodium_ab1 == 0.0){
            Main2.setVisibility(View.GONE);
        }if(potass_ab1 == 0.0){
            Main3.setVisibility(View.GONE);
        } if(chole_ab1 == 0.0){
            Main4.setVisibility(View.GONE);
        } if(ldl_ab1 == 0.0){
            Main5.setVisibility(View.GONE);
        } if(hdl_ab1 == 0.0){
            Main6.setVisibility(View.GONE);
        } if( tri_ab1 == 0.0){
            Main7.setVisibility(View.GONE);
        }



        if(Resulteight.toString().equalsIgnoreCase("Sirihospital")){

            blood_normal.setVisibility(View.VISIBLE);
            blood_abnormal2.setVisibility(View.VISIBLE);
            blood_abnormal.setVisibility(View.VISIBLE);

            sodium_normal.setVisibility(View.VISIBLE);
            sodium_abnormal2.setVisibility(View.VISIBLE);
            sodium_abnormal.setVisibility(View.VISIBLE);

            potassium_normal.setVisibility(View.VISIBLE);
            potassium_abnormal2.setVisibility(View.VISIBLE);
            potassium_abnormal.setVisibility(View.VISIBLE);


            hdl_normal.setVisibility(View.VISIBLE);
            hdl_abnormal3.setVisibility(View.VISIBLE);
            hdl_abnormal4.setVisibility(View.VISIBLE);



            ldl_normal.setVisibility(View.VISIBLE);
            ldl_abnormal2.setVisibility(View.VISIBLE);
            ldl_abnormal3.setVisibility(View.VISIBLE);
         //   ldl_abnormal4.setVisibility(View.VISIBLE);
            ldl_abnormal5.setVisibility(View.VISIBLE);

            chl_normal.setVisibility(View.VISIBLE);
            chl_normal2.setVisibility(View.VISIBLE);
            chl_abnormal2.setVisibility(View.VISIBLE);
            chl_abnormal3.setVisibility(View.VISIBLE);


            tri_normal.setVisibility(View.VISIBLE);
            tri_abnormal2.setVisibility(View.VISIBLE);
            tri_abnormal.setVisibility(View.VISIBLE);
            tri_abnormal3.setVisibility(View.VISIBLE);

        }
        else {

            bloodt_normal.setVisibility(View.VISIBLE);
            bloodt_abnormal2.setVisibility(View.VISIBLE);
            bloodt_abnormal.setVisibility(View.VISIBLE);

            sodiumt_normal.setVisibility(View.VISIBLE);
            sodiumt_abnormal2.setVisibility(View.VISIBLE);
            sodiumt_abnormal.setVisibility(View.VISIBLE);

            potassiumt_normal.setVisibility(View.VISIBLE);
            potassiumt_abnormal2.setVisibility(View.VISIBLE);
            potassiumt_abnormal.setVisibility(View.VISIBLE);


            hdlt_normal.setVisibility(View.VISIBLE);
            hdlt_abnormal3.setVisibility(View.VISIBLE);
            hdlt_abnormal4.setVisibility(View.VISIBLE);



            ldlt_normal.setVisibility(View.VISIBLE);
            ldlt_abnormal2.setVisibility(View.VISIBLE);
            ldlt_abnormal3.setVisibility(View.VISIBLE);
            ldlt_abnormal5.setVisibility(View.VISIBLE);

            chlt_normal2.setVisibility(View.VISIBLE);
            chlt_normal.setVisibility(View.VISIBLE);
            chlt_abnormal2.setVisibility(View.VISIBLE);
            chlt_abnormal3.setVisibility(View.VISIBLE);


            trit_normal.setVisibility(View.VISIBLE);
            trit_abnormal2.setVisibility(View.VISIBLE);
            trit_abnormal.setVisibility(View.VISIBLE);
            trit_abnormal3.setVisibility(View.VISIBLE);

        }





    }

    public void showImage(String message1,String message2 ,String message3,String message4,String message5,String message6,String message7){

        int resource_id = this.getResources().getIdentifier("drawable/"+message1, null, this.getPackageName());
        ImageView imageView = (ImageView)findViewById(R.id.image);
        imageView.setImageResource(resource_id);

        int resource_id1 = this.getResources().getIdentifier("drawable/"+message2, null, this.getPackageName());
        ImageView imageView1 = (ImageView)findViewById(R.id.image1);
        imageView1.setImageResource(resource_id1);

        int resource_id2 = this.getResources().getIdentifier("drawable/"+message3, null, this.getPackageName());
        ImageView imageView2 = (ImageView)findViewById(R.id.image2);
        imageView2.setImageResource(resource_id2);

        int resource_id3 = this.getResources().getIdentifier("drawable/"+message4, null, this.getPackageName());
        ImageView imageView3 = (ImageView)findViewById(R.id.image3);
        imageView3.setImageResource(resource_id3);

        int resource_id4 = this.getResources().getIdentifier("drawable/"+message5, null, this.getPackageName());
        ImageView imageView4 = (ImageView)findViewById(R.id.image4);
        imageView4.setImageResource(resource_id4);

        int resource_id5 = this.getResources().getIdentifier("drawable/"+message6, null, this.getPackageName());
        ImageView imageView5 = (ImageView)findViewById(R.id.image5);
        imageView5.setImageResource(resource_id5);

        int resource_id6 = this.getResources().getIdentifier("drawable/"+message7, null, this.getPackageName());
        ImageView imageView6 = (ImageView)findViewById(R.id.image6);
        imageView6.setImageResource(resource_id6);

    }

    public void seekBar(float sugar_ab1,float sodium_ab1 ,float potass_ab1,float chole_ab1,float ldl_ab1,float hdl_ab1,float tri_ab1){



        seekBarMin = (TextView)findViewById(R.id.seekbarmin);
        seekBarvalue2 = (TextView)findViewById(R.id.seekbarvalue2);
        seekBarvalue3 = (TextView)findViewById(R.id.seekbarvalue3);
        seekBarvalue4 = (TextView)findViewById(R.id.seekbarvalue4);
        seekBarvalue5 = (TextView)findViewById(R.id.seekbarvalue5);
        seekBarvalue6 = (TextView)findViewById(R.id.seekbarvalue6);
        seekBarvalue7 = (TextView)findViewById(R.id.seekbarvalue7);

        seekBarex.setMax(150);
        progressBar.setMax(150);
        progressBar2.setMax(250);
        progressBar3.setMax(10);
        progressBar4.setMax(300);
        progressBar5.setMax(300);
        progressBar6.setMax(100);
        progressBar7.setMax(700);

        seekBarex.setProgress((int) sugar_ab1);
        seekBarex.setEnabled(false);
        progressBar.setProgress((int) sugar_ab1);
        progressBar2.setProgress((int) sodium_ab1);
        progressBar3.setProgress((int) potass_ab1);
        progressBar4.setProgress((int) chole_ab1);
        progressBar5.setProgress((int) ldl_ab1);
        progressBar6.setProgress((int) hdl_ab1);
        progressBar7.setProgress((int) tri_ab1);



        seekBarMin.setText("ระดับน้ำตาล "+sugar_ab1);
        seekBarvalue2.setText("ระดับโซเดียม " +sodium_ab1);
        seekBarvalue3.setText("ระดับโพเเทสเซียม " +potass_ab1);
        seekBarvalue4.setText("ระดับตอลเลสเตอรอล "+chole_ab1);
        seekBarvalue5.setText("ระดับเเอลดีเอล "+ldl_ab1);
        seekBarvalue6.setText("ระดับเอซดีเเอล "+hdl_ab1);
        seekBarvalue7.setText("ระดับไตรกลีเซอไรด์ " +tri_ab1);


    }

    public String recommendFood(String message1){

    String result = "";
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);

        if(message1.equals("cancell2")){


            result = "1";
            blood_abnormal.setBackgroundResource(R.color.glass_color3);
            bloodt_abnormal.setBackgroundResource(R.color.glass_color3);
            progressBar.setProgressDrawable(drawable3);


        }

       else  if(message1.equals("cancell")) {

         result = "0";


         blood_abnormal2.setBackgroundResource(R.color.glass_color2);
         bloodt_abnormal2.setBackgroundResource(R.color.glass_color2);

         progressBar.setProgressDrawable(drawable2);


     }
        else   if(message1.equals("ok")) {
         result = "1";

         blood_normal.setBackgroundResource(R.color.glass_color);
         bloodt_normal.setBackgroundResource(R.color.glass_color);

<<<<<<< HEAD
         progressBar.setProgressDrawable( drawable );
=======
         progressBar.setProgressDrawable(drawable);
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391

     }
        return result;
    }
    public String recommendFood2(String message2){
<<<<<<< HEAD


        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);
=======
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391

        String result2 = "";
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);
        if(message2.equals("cancell2")){


            result2 = "1";

            sodium_abnormal2.setBackgroundResource(R.color.glass_color3);
            sodiumt_abnormal2.setBackgroundResource(R.color.glass_color3);
            progressBar2.setProgressDrawable(drawable3);


        }

        else   if(message2.equals("cancell")) {

            result2 = "0";

            sodium_abnormal.setBackgroundResource(R.color.glass_color2);
            sodiumt_abnormal.setBackgroundResource(R.color.glass_color2);

            progressBar2.setProgressDrawable(drawable2);

        }
        else if (message2.equals("ok"))
        {
            result2 = "1";

            sodium_normal.setBackgroundResource(R.color.glass_color);
            sodiumt_normal.setBackgroundResource(R.color.glass_color);

            progressBar2.setProgressDrawable(drawable);



        }
        return result2;
    }
    public String recommendFood3(String message3){
<<<<<<< HEAD

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);

=======
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391

        String result3 = "";
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);
        if(message3.equals("cancell2")){


            result3 = "1";

            potassium_abnormal2.setBackgroundResource(R.color.glass_color3);
            potassiumt_abnormal2.setBackgroundResource(R.color.glass_color3);

            progressBar3.setProgressDrawable(drawable3);


        }

        else   if(message3.equals("cancell")) {

            result3 = "0";

            potassium_abnormal.setBackgroundResource(R.color.glass_color2);
            potassiumt_abnormal.setBackgroundResource(R.color.glass_color2);

            progressBar3.setProgressDrawable(drawable2);

        }
        else if(message3.equals("ok")){
            result3 = "1";

            potassium_normal.setBackgroundResource(R.color.glass_color);
            potassiumt_normal.setBackgroundResource(R.color.glass_color);

            progressBar3.setProgressDrawable(drawable);

        }
        return result3;
    }
    public String recommendFood4(String message4){
<<<<<<< HEAD

=======
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391
        String result4 = "";

        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);

        if(message4.equals("cancell2")){


            result4 = "1";

            chl_normal2.setBackgroundResource(R.color.glass_color3);
            chlt_normal2.setBackgroundResource(R.color.glass_color3);


            progressBar4.setProgressDrawable(drawable3);

        }

        else  if(message4.equals("cancell")) {

            result4 = "0";


            chl_abnormal3.setBackgroundResource(R.color.glass_color2);
            chlt_abnormal3.setBackgroundResource(R.color.glass_color2);

            progressBar4.setProgressDrawable(drawable2);

        }
        else  if(message4.equals("cancell3")) {

            result4 = "0";


            chl_abnormal2.setBackgroundResource(R.color.glass_color2);
            chlt_abnormal2.setBackgroundResource(R.color.glass_color2);

            progressBar4.setProgressDrawable(drawable2);

        }
        else if(message4.equals("ok")){
            result4 = "1";

            chl_normal.setBackgroundResource(R.color.glass_color);
            chlt_normal.setBackgroundResource(R.color.glass_color);


            progressBar4.setProgressDrawable(drawable);

        }
        return result4;
    }
    public String recommendFood5(String message5){
<<<<<<< HEAD

=======
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);
<<<<<<< HEAD

=======
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391
        String result5 = "";

        if(message5.equals("cancell3")){


            result5 = "0";

            ldl_abnormal2.setBackgroundResource(R.color.glass_color2);
            ldlt_abnormal2.setBackgroundResource(R.color.glass_color2);

<<<<<<< HEAD
            progressBar5.setProgressDrawable(drawable2);
=======
            progressBar5.setProgressDrawable(drawable3);
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391
      }

        else if(message5.equals("cancell")) {

            result5 = "0";


            ldl_abnormal3.setBackgroundResource(R.color.glass_color2);
            ldlt_abnormal3.setBackgroundResource(R.color.glass_color2);

            progressBar5.setProgressDrawable(drawable2);

        }
        else if(message5.equals("cancell5")) {

            result5 = "0";


            ldl_abnormal5.setBackgroundResource(R.color.glass_color2);
            ldlt_abnormal5.setBackgroundResource(R.color.glass_color2);

            progressBar5.setProgressDrawable(drawable2);

        }

        else if(message5.equals("ok")){

            result5 = "1";


            ldl_normal.setBackgroundResource(R.color.glass_color);
            ldlt_normal.setBackgroundResource(R.color.glass_color);


            progressBar5.setProgressDrawable(drawable);
        }
        return result5;
    }
    public String recommendFood6(String message6){
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);
<<<<<<< HEAD

=======
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391
        String result6 = "";

        if(message6.equals("cancell2")){


            result6 = "1";

            hdl_abnormal3.setBackgroundResource(R.color.glass_color3);
            hdlt_abnormal3.setBackgroundResource(R.color.glass_color3);

            progressBar6.setProgressDrawable(drawable3);


        }

        else if(message6.equals("cancell")){

            result6 = "0";

            hdl_abnormal4.setBackgroundResource(R.color.glass_color2);
            hdlt_abnormal4.setBackgroundResource(R.color.glass_color2);

            progressBar6.setProgressDrawable(drawable2);

        }
        else if(message6.equals("ok"))
        {

            result6 = "1";


            hdl_normal .setBackgroundResource(R.color.glass_color);
            hdlt_normal.setBackgroundResource(R.color.glass_color);
            progressBar6.setProgressDrawable(drawable);


        }
        return result6;
    }
    public String recommendFood7(String message7){
<<<<<<< HEAD

=======
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.drawable.custom_progressbar);
        Drawable drawable2 = res.getDrawable(R.drawable.custom_progressbar2);
        Drawable drawable3 = res.getDrawable(R.drawable.custom_progressbar3);
<<<<<<< HEAD

=======
>>>>>>> a2a415d6238d5efe0655aaf19b19f3c09c0ef391
        String result7 = "";

        if(message7.equals("cancell2")){


            result7 = "1";

            tri_abnormal2.setBackgroundResource(R.color.glass_color3);
            trit_abnormal2.setBackgroundResource(R.color.glass_color3);

            progressBar7.setProgressDrawable(drawable3);


        }

        else  if(message7.equals("cancell")){

            tri_abnormal.setBackgroundResource(R.color.glass_color2);
            trit_abnormal.setBackgroundResource(R.color.glass_color2);

            result7 = "0";

            progressBar7.setProgressDrawable(drawable2);


        }else  if(message7.equals("cancell3")){

            tri_abnormal3.setBackgroundResource(R.color.glass_color2);
            trit_abnormal3.setBackgroundResource(R.color.glass_color2);

            result7 = "0";

            progressBar7.setProgressDrawable(drawable2);


        }
        else if(message7.equals("ok")){

            result7 = "1";

            tri_normal.setBackgroundResource(R.color.glass_color);
            trit_normal.setBackgroundResource(R.color.glass_color);

            progressBar7.setProgressDrawable(drawable);

        }
        return result7;
    }


    public void layOutDescription(){

        ChildLayout = (LinearLayout) findViewById(R.id.Childlayout);
        ChildLayout2 = (LinearLayout) findViewById(R.id.Childlayout2);
        ChildLayout3 = (LinearLayout) findViewById(R.id.Childlayout3);
        ChildLayout4 = (LinearLayout) findViewById(R.id.Childlayout4);
        ChildLayout5 = (LinearLayout) findViewById(R.id.Childlayout5);
        ChildLayout6 = (LinearLayout) findViewById(R.id.Childlayout6);
        ChildLayout7 = (LinearLayout) findViewById(R.id.Childlayout7);


        //set visibility to GONE
        ChildLayout.setVisibility(View.GONE);
        ChildLayout2.setVisibility(View.GONE);
        ChildLayout3.setVisibility(View.GONE);
        ChildLayout4.setVisibility(View.GONE);
        ChildLayout5.setVisibility(View.GONE);
        ChildLayout6.setVisibility(View.GONE);
        ChildLayout7.setVisibility(View.GONE);

        HeaderLayout = (LinearLayout) findViewById(R.id.Headerlayout);
        HeaderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ChildLayout.getVisibility()== View.GONE){

                    ChildLayout.setVisibility(View.VISIBLE);
                    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    ChildLayout.measure(widthSpec, heightSpec);
                    ValueAnimator mAnimator = slideAnimator(0,ChildLayout.getMeasuredHeight());
                    mAnimator.start();

                }else{
                    int finalHeight =  ChildLayout.getHeight();
                    ValueAnimator mAnimator = slideAnimator(finalHeight,0);
                    mAnimator.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            //Height=0, but it set visibility to GONE
                            ChildLayout.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }

                    });
                    mAnimator.start();


                }
            }
        });
        HeaderLayout2 = (LinearLayout) findViewById(R.id.HeaderLayout2);
        HeaderLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ChildLayout2.getVisibility()== View.GONE){
                    ChildLayout2.setVisibility(View.VISIBLE);
                    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    ChildLayout2.measure(widthSpec, heightSpec);
                    ValueAnimator mAnimator = slideAnimator2(0,ChildLayout2.getMeasuredHeight());
                    mAnimator.start();
                }else{
                    int finalHeight =  ChildLayout2.getHeight();
                    ValueAnimator mAnimator = slideAnimator2(finalHeight,0);
                    mAnimator.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            //Height=0, but it set visibility to GONE
                            ChildLayout2.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }

                    });
                    mAnimator.start();
                }
            }
        });
        HeaderLayout3 = (LinearLayout) findViewById(R.id.HeaderLayout3);
        HeaderLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ChildLayout3.getVisibility()== View.GONE){
                    ChildLayout3.setVisibility(View.VISIBLE);
                    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    ChildLayout3.measure(widthSpec, heightSpec);
                    ValueAnimator mAnimator = slideAnimator3(0,ChildLayout3.getMeasuredHeight());
                    mAnimator.start();
                }else{
                    int finalHeight =  ChildLayout3.getHeight();
                    ValueAnimator mAnimator = slideAnimator3(finalHeight,0);
                    mAnimator.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            //Height=0, but it set visibility to GONE
                            ChildLayout3.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }

                    });
                    mAnimator.start();
                }
            }
        });
        HeaderLayout4 = (LinearLayout) findViewById(R.id.HeaderLayout4);
        HeaderLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ChildLayout4.getVisibility()== View.GONE){
                    ChildLayout4.setVisibility(View.VISIBLE);
                    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    ChildLayout4.measure(widthSpec, heightSpec);
                    ValueAnimator mAnimator = slideAnimator4(0,ChildLayout4.getMeasuredHeight());
                    mAnimator.start();
                }else{
                    int finalHeight =  ChildLayout4.getHeight();
                    ValueAnimator mAnimator = slideAnimator4(finalHeight,0);
                    mAnimator.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            //Height=0, but it set visibility to GONE
                            ChildLayout4.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }

                    });
                    mAnimator.start();
                }
            }
        });
        HeaderLayout5 = (LinearLayout) findViewById(R.id.HeaderLayout5);
        HeaderLayout5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ChildLayout5.getVisibility()== View.GONE){
                    ChildLayout5.setVisibility(View.VISIBLE);
                    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    ChildLayout5.measure(widthSpec, heightSpec);
                    ValueAnimator mAnimator = slideAnimator5(0,ChildLayout5.getMeasuredHeight());
                    mAnimator.start();
                }else{
                    int finalHeight =  ChildLayout5.getHeight();
                    ValueAnimator mAnimator = slideAnimator5(finalHeight,0);
                    mAnimator.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            //Height=0, but it set visibility to GONE
                            ChildLayout5.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }

                    });
                    mAnimator.start();
                }
            }
        });
        HeaderLayout6 = (LinearLayout) findViewById(R.id.HeaderLayout6);
        HeaderLayout6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ChildLayout6.getVisibility()== View.GONE){
                    ChildLayout6.setVisibility(View.VISIBLE);
                    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    ChildLayout6.measure(widthSpec, heightSpec);
                    ValueAnimator mAnimator = slideAnimator6(0,ChildLayout6.getMeasuredHeight());
                    mAnimator.start();
                }else{
                    int finalHeight =  ChildLayout6.getHeight();
                    ValueAnimator mAnimator = slideAnimator6(finalHeight,0);
                    mAnimator.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            //Height=0, but it set visibility to GONE
                            ChildLayout6.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }

                    });
                    mAnimator.start();
                }
            }
        });
        HeaderLayout7 = (LinearLayout) findViewById(R.id.HeaderLayout7);
        HeaderLayout7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ChildLayout7.getVisibility()== View.GONE){
                    ChildLayout7.setVisibility(View.VISIBLE);
                    final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
                    ChildLayout7.measure(widthSpec, heightSpec);
                    ValueAnimator mAnimator = slideAnimator7(0,ChildLayout7.getMeasuredHeight());
                    mAnimator.start();                }
                else{
                    int finalHeight =  ChildLayout7.getHeight();
                    ValueAnimator mAnimator = slideAnimator7(finalHeight,0);
                    mAnimator.addListener(new Animator.AnimatorListener() {

                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            //Height=0, but it set visibility to GONE
                            ChildLayout7.setVisibility(View.GONE);
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }

                    });
                    mAnimator.start();
                }
            }
        });

    }

    private ValueAnimator slideAnimator(int start, int end) {

        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =  ChildLayout.getLayoutParams();
                layoutParams.height = value;
                ChildLayout.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }
    private ValueAnimator slideAnimator2(int start, int end) {

        ValueAnimator animator2 = ValueAnimator.ofInt(start, end);

        animator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                //Update Height
                int value = (Integer) valueAnimator2.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =  ChildLayout2.getLayoutParams();
                layoutParams.height = value;
                ChildLayout2.setLayoutParams(layoutParams);
            }
        });
        return animator2;
    }
    private ValueAnimator slideAnimator3(int start, int end) {

        ValueAnimator animator3 = ValueAnimator.ofInt(start, end);

        animator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator3) {
                //Update Height
                int value = (Integer) valueAnimator3.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =  ChildLayout3.getLayoutParams();
                layoutParams.height = value;
                ChildLayout3.setLayoutParams(layoutParams);
            }
        });
        return animator3;
    }
    private ValueAnimator slideAnimator4(int start, int end) {

        ValueAnimator animator4 = ValueAnimator.ofInt(start, end);

        animator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator4) {
                //Update Height
                int value = (Integer) valueAnimator4.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =  ChildLayout4.getLayoutParams();
                layoutParams.height = value;
                ChildLayout4.setLayoutParams(layoutParams);
            }
        });
        return animator4;
    }
    private ValueAnimator slideAnimator5(int start, int end) {

        ValueAnimator animator5 = ValueAnimator.ofInt(start, end);

        animator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator5) {
                //Update Height
                int value = (Integer) valueAnimator5.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =  ChildLayout5.getLayoutParams();
                layoutParams.height = value;
                ChildLayout5.setLayoutParams(layoutParams);
            }
        });
        return animator5;
    }
    private ValueAnimator slideAnimator6(int start, int end) {

        ValueAnimator animator6 = ValueAnimator.ofInt(start, end);

        animator6.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator6) {
                //Update Height
                int value = (Integer) valueAnimator6.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =  ChildLayout6.getLayoutParams();
                layoutParams.height = value;
                ChildLayout6.setLayoutParams(layoutParams);
            }
        });
        return animator6;
    }
    private ValueAnimator slideAnimator7(int start, int end) {

        ValueAnimator animator7 = ValueAnimator.ofInt(start, end);

        animator7.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator7) {
                //Update Height
                int value = (Integer) valueAnimator7.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =  ChildLayout7.getLayoutParams();
                layoutParams.height = value;
                ChildLayout7.setLayoutParams(layoutParams);
            }
        });
        return animator7;
    }

    public void information() {

        INFO2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 1;
                Intent intent =  new Intent(AfterBldT.this,Webview.class);
                intent.putExtra("n",1);
                startActivity(intent);
            }
        });

        INFO3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 2;
                Intent intent =  new Intent(AfterBldT.this,Webview.class);
                intent.putExtra("n",2);
                startActivity(intent);
            }
        });
        INFO4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 3;
                Intent intent =  new Intent(AfterBldT.this,Webview.class);
                intent.putExtra("n",3);
                startActivity(intent);
            }
        });
        INFO5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 4;
                Intent intent =  new Intent(AfterBldT.this,Webview.class);
                intent.putExtra("n",4);
                startActivity(intent);
            }
        });
        INFO6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 5;
                Intent intent =  new Intent(AfterBldT.this,Webview.class);
                intent.putExtra("n",5);
                startActivity(intent);
            }
        });
        INFO7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 6;
                Intent intent =  new Intent(AfterBldT.this,Webview.class);
                intent.putExtra("n",6);
                startActivity(intent);
            }
        });
        INFO8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i = 7;
                Intent intent =  new Intent(AfterBldT.this,Webview.class);
                intent.putExtra("n",7);
                startActivity(intent);
            }
        });

    }
}


