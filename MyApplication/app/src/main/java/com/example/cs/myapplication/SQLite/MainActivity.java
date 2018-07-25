package com.example.cs.myapplication.SQLite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.cs.myapplication.R;

import java.util.ArrayList;

public class MainActivity extends Activity {

    SQLiteDatabase mDb;
    MyDBclass mHelper;
    Cursor mCursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView1 = (ListView)findViewById(R.id.listView1);

        mHelper = new MyDBclass(this);
        mDb = mHelper.getWritableDatabase();

        mCursor = mDb.rawQuery("SELECT " + MyDBclass.COL_NAME + ", "  + MyDBclass.COL_PIECE_PRICE
                + ", " + MyDBclass.COL_CAKE_PRICE + " FROM " +MyDBclass.TABLE_NAME, null);

        ArrayList<String> dirArray = new ArrayList<String>();
        mCursor.moveToFirst();

        while ( !mCursor.isAfterLast() ){
            dirArray.add(mCursor.getString(mCursor.getColumnIndex(MyDBclass.COL_NAME)) + "\n"
                    + "Piece : " + mCursor.getString(mCursor.getColumnIndex(MyDBclass.COL_PIECE_PRICE)) + "\t\t"
                    + "Cake : " + mCursor.getString(mCursor.getColumnIndex(MyDBclass.COL_CAKE_PRICE)));
            mCursor.moveToNext();
        }

        ArrayAdapter<String> adapterDir = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dirArray);
        listView1.setAdapter(adapterDir);

    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public void onPause() {
        super.onPause();
        mHelper.close();
        mDb.close();
    }
}
