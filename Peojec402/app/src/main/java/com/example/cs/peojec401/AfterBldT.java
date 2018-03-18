package com.example.cs.peojec401;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class AfterBldT extends AppCompatActivity {

    ArrayAdapter<String> adapter;
    private ImageButton sugartt,sodiumtt,potasstt,cholett,ldltt,hdltt,tritt;
    private TextView sugar_ab2,sodium_ab2,potass_ab2,chole_ab2,ldl_ab2,hdl_ab2,tri_ab2;
    private TextView description_doc,description_smile,description_sad;
    private Dialog sugar_dd,sodium_dd,potass_dd,chole_dd,ldl_dd,hdl_dd,tri_dd;
    private Button button_dialog;
    final Context context = this;
    private Button next ,home;
    private SeekBar seekBar;
    private TextView seekBarMin;
    LinearLayout HeaderLayout;
    LinearLayout ChildLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_bld_t);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        popUp();

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    public void popUp(){

       /* sugartt = (ImageButton)findViewById(R.id.sugar_bttt);
        sugartt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.content_after_blood_dialog);
              //  dialog.show();

                button_dialog = (Button)dialog.findViewById(R.id.close_dialog);
                button_dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        dialog.dismiss();
                    }
                });

            }
        });*/

        sodiumtt = (ImageButton)findViewById(R.id.sodiun_tt);
        potasstt = (ImageButton)findViewById(R.id.potassi_tt);
        cholett = (ImageButton)findViewById(R.id.cl_tt);
        ldltt = (ImageButton)findViewById(R.id.ldl_tt);
        hdltt = (ImageButton)findViewById(R.id.hdl_tt);
        tritt = (ImageButton)findViewById(R.id.tri_tt);
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

        showImage(message1,message2 ,message3,message4,message5,message6,message7);

        String Resultone = recommendFood(message1);
        String Resulttwo = recommendFood2(message2);
        String Resultthree = recommendFood3(message3);
        String Resultfour =  recommendFood4(message4);
        String Resultfive =  recommendFood5(message5);
        String Resultsix =  recommendFood6(message6);
        String Resultseven =  recommendFood7(message7);

        final ArrayList<String> listResult2 = new ArrayList<>();
        listResult2.add(Resultone);
        listResult2.add(Resulttwo);
        listResult2.add(Resultthree);
        listResult2.add(Resultfour);
        listResult2.add(Resultfive);
        listResult2.add(Resultsix);
        listResult2.add(Resultseven);

        layOutDescription();

        next = (Button)findViewById(R.id.button_bloodAb);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast toast = Toast.makeText (AfterBldT.this, "Selected " +listResult2.toString(), Toast.LENGTH_LONG );
                toast.show ( );

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

    public String recommendFood(String message1){

    String result = "";

     if(message1.equals("sadd")) {

         result = "Suagr_0";

     }
        else{
         result = "Suagar_1";
     }
        return result;
    }

    public String recommendFood2(String message2){

        String result2 = "";

        if(message2.equals("sadd")) {

            result2 = "Sodium_0";

        }
        else{
            result2 = "Sodium_1";
        }
        return result2;
    }
    public String recommendFood3(String message3){

        String result3 = "";

        if(message3.equals("sadd")) {

            result3 = "Potassium_0";

        }
        else{
            result3 = "Potassium_1";
        }
        return result3;
    }
    public String recommendFood4(String message6){

        String result4 = "";

        if(message6.equals("sadd")) {

            result4 = "CH_0";

        }
        else{
            result4 = "CH_1";
        }
        return result4;
    }
    public String recommendFood5(String message4){

        String result5 = "";

        if(message4.equals("sadd")) {

            result5 = "LDL_0";

        }
        else{
            result5 = "LDL_1";
        }
        return result5;
    }
    public String recommendFood6(String message5){

        String result6 = "";

        if(message5.equals("sadd")){

            result6 = "HDL_0";

        }
        else{
            result6 = "HDL_1";
        }
        return result6;
    }
    public String recommendFood7(String message7){

        String result7 = "";

        if(message7.equals("sadd")){

            result7 = "TRI_0";

        }
        else{
            result7 = "TRI_1";
        }
        return result7;
    }

    public void seekBar(float sugar_ab1,float sodium_ab1 ,float potass_ab1,float chole_ab1,float ldl_ab1,float hdl_ab1,float tri_ab1){

        seekBar = (SeekBar)findViewById(R.id.seekBar);

        seekBarMin = (TextView)findViewById(R.id.seekbarmin);


        seekBar.setMax(100);
        seekBar.setProgress((int) sugar_ab1);
        updatePercentValue(seekBar.getProgress());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar,int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
             updatePercentValue(seekBar.getProgress());


            }

        });

        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }
    private void updatePercentValue(int progressValue) {
        seekBarMin.setText("ระดับน้ำตาล "+progressValue);
    }

    public void layOutDescription(){

        ChildLayout = (LinearLayout) findViewById(R.id.Childlayout);
        //set visibility to GONE
        ChildLayout.setVisibility(View.GONE);
        HeaderLayout = (LinearLayout) findViewById(R.id.Headerlayout);
        HeaderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( ChildLayout.getVisibility()== View.GONE){
                    expand();
                }else{
                    collapse();
                }
            }
        });
    }

    private void expand() {
        //set Visible
        ChildLayout.setVisibility(View.VISIBLE);

        final int widthSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        final int heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        ChildLayout.measure(widthSpec, heightSpec);

        ValueAnimator mAnimator = slideAnimator(0,ChildLayout.getMeasuredHeight());
        mAnimator.start();
    }

    private void collapse() {
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

    private ValueAnimator slideAnimator(int start, int end) {

        ValueAnimator animator = ValueAnimator.ofInt(start, end);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //Update Height
                int value = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams =ChildLayout.getLayoutParams();
                layoutParams.height = value;
                ChildLayout.setLayoutParams(layoutParams);
            }
        });
        return animator;
    }
}


