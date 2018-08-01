package com.example.ben.example.Activity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ben.example.Data.BloodTest;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DBHelper extends SQLiteOpenHelper {


    private final String TAG = getClass().getSimpleName();

    private SQLiteDatabase sqLiteDatabase;

    public DBHelper(Context context) {
        super(context, Blood.DATABASE_NAME, null, Blood.DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_BLOODTEST_TABLE = String.format("CREATE TABLE %s " +
                        "(%s INTEGER PRIMARY KEY  AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)",
                Blood.TABLE,
                Blood.Column.ID,
                Blood.Column.SUGAR_BLOOD,
                Blood.Column.SODIUM_BLOOD,
                Blood.Column.POTASSIUM_BLOOD,
                Blood.Column.CHORESTERAL_BLOOD,
                Blood.Column.LDL_BLOOD,
                Blood.Column.HDL_BLOOD,
                Blood.Column.TRIGRYCERID_BLOOD);

        Log.i(TAG, CREATE_BLOODTEST_TABLE);

        // create friend table
        db.execSQL(CREATE_BLOODTEST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_BLOODTEST_TABLE = "DROP TABLE IF EXISTS blood";

        db.execSQL(DROP_BLOODTEST_TABLE);

        onCreate(db);
    }

    public List<String> getBloodList() {
        List<String> Blood = new ArrayList<String>();

        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query
                (com.example.ben.example.Activity.Blood.TABLE, null, null, null, null, null, null,null);


        if (cursor != null) {
            cursor.moveToFirst();
        }

        while(!cursor.isAfterLast()) {

            Blood.add(cursor.getLong(0) + " " +
                    cursor.getString(1) + " " +
                    cursor.getString(2));

            cursor.moveToNext();
        }

        sqLiteDatabase.close();

        return Blood;
    }

}
