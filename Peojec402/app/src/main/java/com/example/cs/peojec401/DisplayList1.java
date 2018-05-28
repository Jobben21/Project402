package com.example.cs.peojec401;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Spinner;

import com.example.cs.peojec401.FoodCon.*;
import com.example.cs.peojec401.FoodCon.BackgroundTask;

import static com.example.cs.peojec401.Fragment_F4.i;

public class DisplayList1 extends AppCompatActivity {
    Toolbar toolbar;
    public   String selectedText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        toolbar = (Toolbar) findViewById(R.id.bloods);
        Spinner spinner = ( Spinner ) findViewById ( R.id.spinner2 );
        Object selectedItem = spinner.getSelectedItem ( );
        selectedText = selectedItem.toString ( );
        if(i==1){toolbar.setTitle("เมนูอาหารโรคหัวใจ");}
        else if (i==2){toolbar.setTitle("เมนูอาหารโรคไต");}
        else if (i==3){toolbar.setTitle("เมนูอาหารโรคเบาหวาน");}
        else if (i==4){toolbar.setTitle("เมนูอาหารโรคความดันสูง");}
        else if (i==5){}
        else if (i==6){}


        Intent i = new Intent(this,RecyclerAdapter.class);
        i.putExtra("ww",selectedText);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        com.example.cs.peojec401.FoodCon.BackgroundTask backgroundTask = new com.example.cs.peojec401.FoodCon.BackgroundTask(this);
        backgroundTask.execute();

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
}
