package com.example.cs.peojec401;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hp on 5/1/2561.
 */

public class MainMenu extends AppCompatActivity{

    private ViewPager viewPager;
    private SlideAdapter myadapter;
    private TextView[] mDots;
    public LinearLayout mDotLayout;
    private Button nNextBtn;
    private Button nBackBtn;
    //private Button mainpage;


    private int mCurrentPage;
    private int position = 0;
    private Context context = this;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcomeactivity);

        // hide ActionBar

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        mDotLayout = (LinearLayout) findViewById(R.id.dotLayout);
        myadapter = new SlideAdapter(context);
        viewPager.setAdapter(myadapter);

        addDotIndicator(position);

        nNextBtn = (Button) findViewById(R.id.nNextBtn);
        nBackBtn = (Button) findViewById(R.id.nBackBtn);
      //  mainpage = (Button) findViewById(R.id.mainpage);

        viewPager.addOnPageChangeListener(viewListener);

        nNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(mCurrentPage +1);

            }
        });

        nBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               Intent intent = new Intent(MainMenu.this,Register_LoginActivity.class);
//                Intent intent =new Intent(MainMenu.this,NavigationActivity.class);
                startActivity(intent);
            }
        });


    }

    public void addDotIndicator(int position) {
        mDots = new TextView[4];

        mDotLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(context);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(40);
            mDots[i].setTextColor(ContextCompat.getColor(context, R.color.backGround));

            mDotLayout.addView(mDots[i]);
        }

        if(mDots.length>0){
            mDots[position].setTextColor(ContextCompat.getColor(context, R.color.cardview_dark_background));;
        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {


        }

        @Override
        public void onPageSelected(int i) {
            addDotIndicator(i);
            mCurrentPage = i;

            if (i == 0)

            {
                nNextBtn.setEnabled(true);
                nBackBtn.setEnabled(true);
                nBackBtn.setVisibility(View.INVISIBLE);
                nNextBtn.setText("ถัดไป");
                nBackBtn.setText("ข้าม");
            } else if (i == mDots.length-1)

            {
                nNextBtn.setEnabled(true);
                nBackBtn.setEnabled(true);
                nBackBtn.setVisibility(View.VISIBLE);
                nNextBtn.setText("เข้าสู่หน้าหลัก");
                nBackBtn.setText("ข้าม");


                nNextBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(MainMenu.this,Register_LoginActivity.class);
                        startActivity(intent);
                    }
                });

            } else

            {
                nNextBtn.setEnabled(true);
                nBackBtn.setEnabled(true);
                nBackBtn.setVisibility(View.VISIBLE);

                nNextBtn.setText("ถัดไป");
                nBackBtn.setText("ข้าม");
            }

        }

        @Override
        public void onPageScrollStateChanged(int i) {


        }

    };






}



