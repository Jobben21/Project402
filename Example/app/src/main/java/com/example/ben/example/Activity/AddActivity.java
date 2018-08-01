package com.example.ben.example.Activity;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.ben.example.R;

import java.util.ArrayList;
import java.util.List;

public class AddActivity extends ListActivity {

    DBHelper mHelper;
    List<String> Blood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        String[] lists = {""};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lists);
        setListAdapter(adapter);
    }


    }


