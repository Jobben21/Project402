package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;



public class FoodRecod_F4 extends AppCompatActivity {


    private Button but_choice;
    private RadioButton singleplate,threemeals,sevendaysmeal,
                        cholesL1,cholestL2,
                        trigryL1,trigryL2,
                        sugarL1,sugarL2,sugarL3,
                        sodiumL1,sodiumL2,sodiumL3;
    private boolean checking = true;
    private boolean checking2 = true;
    private  boolean checking3 = true;
    private  boolean checking4 = true;
    private  boolean checking5 = true;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_recod__f4);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        singleplate = (RadioButton)findViewById(R.id.singleplate);
        threemeals = (RadioButton)findViewById(R.id.threemeals);
        sevendaysmeal = (RadioButton)findViewById(R.id.sevendaysmeal);
        cholesL1 = (RadioButton)findViewById(R.id.choles_1);
        cholestL2 = (RadioButton)findViewById(R.id.choles_2);
        trigryL1 = (RadioButton)findViewById(R.id.trigry_1);
        trigryL2 = (RadioButton)findViewById(R.id.trigry_2);
        sugarL1   = (RadioButton)findViewById(R.id.sugar_l1);
        sugarL2  = (RadioButton)findViewById(R.id.sugar_l2);
        sugarL3  = (RadioButton)findViewById(R.id.sugar_l3);
        sodiumL1  = (RadioButton)findViewById(R.id.sodium_l1);
        sodiumL2  = (RadioButton)findViewById(R.id.sodium_l2);
         sodiumL3 = (RadioButton)findViewById(R.id.sodium_l3);

        meals(checking);
        String Menuone = meals(checking);
        String Menutwo = cholesteralLevel(checking2);
        String Menuthree = TrigrycerideLevel(checking3);
        String Menufour = sugarLevel(checking4);
        String Menufive = sodiumLevel(checking5);

        final ArrayList<String> listResult = new ArrayList<>();
        listResult.add(Menuone);
        listResult.add(Menutwo);
        listResult.add(Menuthree);
        listResult.add(Menufour);
        listResult.add(Menufive);


        but_choice = (Button)findViewById(R.id.but_choice);
        but_choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast toast = Toast.makeText (FoodRecod_F4.this, "Selected " +listResult.toString(), Toast.LENGTH_LONG );
                toast.show ( );
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public String meals(boolean checking){

     //   boolean checking2 = true;
        String meal = "";

        if(singleplate.isChecked() == checking){

            meal = "1 Meals";
            cholesteralLevel(checking2);
        }

        else if(threemeals.isChecked() == checking){
            meal = "3 Meals";
            cholesteralLevel(checking2);
        }

        else if(sevendaysmeal.isChecked()== checking){
            meal = "7 Days Meals";
            cholesteralLevel(checking2);
        }


        return meal;
    }

    public String cholesteralLevel(boolean checking2){

        String cholesteralLevel = "";
       // boolean checking3  = true;

        if(cholesL1.isChecked() == checking2){

            cholesteralLevel = "CL1";
            TrigrycerideLevel(checking3);

        }
        else if(cholestL2.isChecked() == checking2){
            cholesteralLevel = "CL2";
            TrigrycerideLevel(checking3);
        }

        return  cholesteralLevel;

    }
    public String TrigrycerideLevel(boolean checking3){

        String TrigrycerideLevel = "";
      //  boolean checking4  = true;


        if(trigryL1.isChecked() == checking3){

            TrigrycerideLevel = "TL1";
            sugarLevel(checking4);

        }
        else if(trigryL2.isChecked() == checking3){
            TrigrycerideLevel = "TL2";
            sugarLevel(checking4);
        }

        return TrigrycerideLevel;

    }

    public String sugarLevel(boolean checking4){

        String  sugarLevel = "";
     //   boolean checking5  = true;


        if(sugarL1.isChecked() == checking4){

            sugarLevel = "SL1";
            sodiumLevel(checking5);
        }
        else if(sugarL2.isChecked() == checking4){
            sugarLevel = "SL2";
            sodiumLevel(checking5);
        }
        else if(sugarL3.isChecked() == checking4){
            sugarLevel = "SL3";
            sodiumLevel(checking5);
        }

        return sugarLevel;

    }

    public String sodiumLevel(boolean checking5){

        String  sodiumLevel = "";

        if(sodiumL1.isChecked() == checking5){

            sodiumLevel = "SoL1";

        }
        else if(sodiumL2.isChecked() == checking5){
            sodiumLevel = "SoL2";
        }
        else if(sodiumL3.isChecked() == checking5){
            sodiumLevel = "SoL3";
        }

        return sodiumLevel;

    }

}
