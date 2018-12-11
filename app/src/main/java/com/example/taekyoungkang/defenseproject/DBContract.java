package com.example.taekyoungkang.defenseproject;

import android.provider.BaseColumns;

public class DBContract {

    public static final String DB_NAME = "defence.db";
    public static final int DB_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA = ",";


    private DBContract() {
    }

    public static class Data implements BaseColumns {
        public static final String TABLE_NAME = "post";
        public static final String KEY_TITLE = "title";
        public static final String KEY_NAME = "name";
        public static final String KEY_LOCATION = "location";
        public static final String KEY_CONTENTS = "contents";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + _ID + INT_TYPE  + " PRIMARY KEY AUTOINCREMENT" + COMMA +
                KEY_TITLE + TEXT_TYPE + COMMA + KEY_NAME + TEXT_TYPE + COMMA +
                KEY_LOCATION + TEXT_TYPE + COMMA + KEY_CONTENTS + TEXT_TYPE +
                ")";
    }
}
