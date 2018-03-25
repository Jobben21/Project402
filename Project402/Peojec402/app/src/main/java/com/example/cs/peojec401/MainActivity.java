package com.example.cs.peojec401;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> mainfood_name = new ArrayList<>();
    private ArrayList<String> mainfood_image = new ArrayList<>();



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_food_dialog);

        MainDishFood();

    }

    public void MainDishFood(){

        mainfood_name.add("ผัดช่า");
        mainfood_image.add("https://drive.google.com/open?id=1eQ1NzwGO87dlJNLeTO21BXnN75cBt1Ul");

        mainfood_name.add("หมูตุ๋น");
        mainfood_image.add("https://drive.google.com/open?id=1dW_KDWf5Rt9BzR6T3xpqa1Jbu1HkzA-6\n");
    }


}