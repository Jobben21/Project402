package com.example.ben.example.Activity;

import android.provider.BaseColumns;

public class Blood {

    public static final String DATABASE_NAME = "devahoy_blood.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE = "blood";

    public class Column {
        public static final String ID = BaseColumns._ID;
        public static final String SUGAR_BLOOD = "Sugar_blood";
        public static final String SODIUM_BLOOD = "Sodium_blood";
        public static final String POTASSIUM_BLOOD = "Potassium_blood";
        public static final String CHORESTERAL_BLOOD = "Choresteral_blood";
        public static final String LDL_BLOOD = "LDL_blood";
        public static final String HDL_BLOOD = "HDL_blood";
        public static final String TRIGRYCERID_BLOOD = "Trigryceride_blood";

    }
}
