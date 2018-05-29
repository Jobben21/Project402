package com.example.cs.peojec401;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;



public class FoodRecod_F4 extends AppCompatActivity {


    private Button but_choice;
    private RadioButton singleplate,threemeals,sevendaysmeal,
                        cholesL1,cholestL2,
                        trigryL1,trigryL2,
                        sugarL1,sugarL2,sugarL3,
                        sodiumL1,sodiumL2,sodiumL3;
    public static String checkedLabelcholes="";
    public static String checkedLabeltrigly="";
    public static String checkedLabelsugar="";
    public static String checkedLabelsodium="";
    public static  int se=0;
    private RadioGroup choles,trigly,sugar,sodium;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_recod__f4);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        choles = (RadioGroup) findViewById(R.id.radio_choles);
        trigly = (RadioGroup) findViewById(R.id.radio_trigly);
        sugar = (RadioGroup) findViewById(R.id.radio_sugar);
        sodium = (RadioGroup) findViewById(R.id.radio_sodium);







        but_choice = (Button)findViewById(R.id.but_choice);
        but_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int checkedRadioButtoncholes = choles.getCheckedRadioButtonId ( );
                RadioButton checkedRadioButton = ( RadioButton )findViewById ( checkedRadioButtoncholes );
                checkedLabelcholes = checkedRadioButton.getText ( ).toString ( );


                int checkedRadioButtontrigly = trigly.getCheckedRadioButtonId ( );
                RadioButton checkedRadioButton1 = ( RadioButton )findViewById ( checkedRadioButtontrigly );
                checkedLabeltrigly = checkedRadioButton1.getText ( ).toString ( );

                int checkedRadioButtonsugar = sugar.getCheckedRadioButtonId ( );
                RadioButton checkedRadioButton2 = ( RadioButton )findViewById ( checkedRadioButtonsugar );
                 checkedLabelsugar = checkedRadioButton2.getText ( ).toString ( );

                int checkedRadioButtonsodium = sodium.getCheckedRadioButtonId ( );
                RadioButton checkedRadioButton3 = ( RadioButton )findViewById ( checkedRadioButtonsodium );
                checkedLabelsodium = checkedRadioButton3.getText ( ).toString ( );

            if(checkedLabelcholes.equals("ควบคุม")){

                checkedLabelcholes="0";
            }
            if(checkedLabelcholes.equals("ไม่ควบคุม")){
                checkedLabelcholes="1";
            }
            if(checkedLabeltrigly.equals("ควบคุม")){

                    checkedLabeltrigly="0";
            }
            if(checkedLabeltrigly.equals("ไม่ควบคุม")){
                    checkedLabeltrigly="1";
            }
            if(checkedLabelsugar.equals("ควบคุม")){

                    checkedLabelsugar="0";
            }
            if(checkedLabelsugar.equals("ไม่ควบคุม")){
                    checkedLabelsugar="1";
            }
            if(checkedLabelsodium.equals("ควบคุม")){

                    checkedLabelsodium="0";
            }
            if(checkedLabelsodium.equals("ไม่ควบคุม")){
                    checkedLabelsodium="1";
            }
                se =5;
                //Toast.makeText(getApplicationContext(),checkedLabelcholes+":"+checkedLabeltrigly+":"+checkedLabelsugar+":"+checkedLabelsodium,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(),DisplayList1.class);

                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

//    public String meals(boolean checking){
//
//     //   boolean checking2 = true;
//        String meal = "";
//
//        if(singleplate.isChecked() == checking){
//
//            meal = "1 Meals";
//            cholesteralLevel(checking2);
//        }
//
//        else if(threemeals.isChecked() == checking){
//            meal = "3 Meals";
//            cholesteralLevel(checking2);
//        }
//
//        else if(sevendaysmeal.isChecked()== checking){
//            meal = "7 Days Meals";
//            cholesteralLevel(checking2);
//        }
//
//
//        return meal;
//    }
//
//    public String cholesteralLevel(boolean checking2){
//
//        String cholesteralLevel = "";
//       // boolean checking3  = true;
//
//        if(cholesL1.isChecked() == checking2){
//
//            cholesteralLevel = "CL1";
//            TrigrycerideLevel(checking3);
//
//        }
//        else if(cholestL2.isChecked() == checking2){
//            cholesteralLevel = "CL2";
//            TrigrycerideLevel(checking3);
//        }
//
//        return  cholesteralLevel;
//
//    }
//    public String TrigrycerideLevel(boolean checking3){
//
//        String TrigrycerideLevel = "";
//      //  boolean checking4  = true;
//
//
//        if(trigryL1.isChecked() == checking3){
//
//            TrigrycerideLevel = "TL1";
//            sugarLevel(checking4);
//
//        }
//        else if(trigryL2.isChecked() == checking3){
//            TrigrycerideLevel = "TL2";
//            sugarLevel(checking4);
//        }
//
//        return TrigrycerideLevel;
//
//    }
//
//    public String sugarLevel(boolean checking4){
//
//        String  sugarLevel = "";
//     //   boolean checking5  = true;
//
//
//        if(sugarL1.isChecked() == checking4){
//
//            sugarLevel = "SL1";
//            sodiumLevel(checking5);
//        }
//        else if(sugarL2.isChecked() == checking4){
//            sugarLevel = "SL2";
//            sodiumLevel(checking5);
//        }
//        else if(sugarL3.isChecked() == checking4){
//            sugarLevel = "SL3";
//            sodiumLevel(checking5);
//        }
//
//        return sugarLevel;
//
//    }
//
//    public String sodiumLevel(boolean checking5){
//
//        String  sodiumLevel = "";
//
//        if(sodiumL1.isChecked() == checking5){
//
//            sodiumLevel = "SoL1";
//
//        }
//        else if(sodiumL2.isChecked() == checking5){
//            sodiumLevel = "SoL2";
//        }
//        else if(sodiumL3.isChecked() == checking5){
//            sodiumLevel = "SoL3";
//        }
//
//        return sodiumLevel;
//
//    }

}
