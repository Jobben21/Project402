package com.example.cs.peojec401;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cs.peojec401.FoodCon.*;
import com.example.cs.peojec401.FoodCon.BackgroundTask;

import static com.example.cs.peojec401.Fragment_F4.i;

public class DisplayList1 extends AppCompatActivity {
    Toolbar toolbar;
    public static  Spinner spinner;
    public  String selectedText;
    public Object selectedItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);
       spinner = (Spinner)findViewById ( R.id.spinner2 );
        toolbar = (Toolbar) findViewById(R.id.bloods);



       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){toolbar.setTitle("เมนูอาหารโรคหัวใจ");}
                else if (i==2){toolbar.setTitle("เมนูอาหารโรคไต");}
                else if (i==3){toolbar.setTitle("เมนูอาหารโรคเบาหวาน");}
                else if (i==4){toolbar.setTitle("เมนูอาหารโรคความดันสูง");}
                else if (i==5){}
                else if (i==6){}
             selectedText=spinner.getSelectedItem().toString();
               callBlack();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });






        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_food, menu);
        return true;
    }

    public void callBlack(){

        com.example.cs.peojec401.FoodCon.BackgroundTask backgroundTask = new com.example.cs.peojec401.FoodCon.BackgroundTask(this,selectedText);
        backgroundTask.execute();
    }

}
