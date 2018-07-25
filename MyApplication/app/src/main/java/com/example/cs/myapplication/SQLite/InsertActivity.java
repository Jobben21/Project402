package com.example.cs.myapplication.SQLite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.cs.myapplication.R;
import com.example.cs.myapplication.SQLite.FragementKnow.KnowFragment;
import com.example.cs.myapplication.SQLite.FragmentBlood.BloodFragment;
import com.example.cs.myapplication.SQLite.FragmentHistory.HistoryFragment;

public class InsertActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottonview);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.blood:
                        fragment = new BloodFragment();
                        Toast.makeText(InsertActivity.this, "1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.knowledge:
                        fragment = new KnowFragment();
                        Toast.makeText(InsertActivity.this, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.history:
                        fragment = new HistoryFragment();
                        Toast.makeText(InsertActivity.this, "3", Toast.LENGTH_SHORT).show();
                        break;
                }
                return loadFragment(fragment);
            }
        });

    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}