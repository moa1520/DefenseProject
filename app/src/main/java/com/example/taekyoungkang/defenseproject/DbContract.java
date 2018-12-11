package com.example.taekyoungkang.defenseproject;

import android.provider.BaseColumns;

public class DbContract {
    public static final String DB_NAME="defence.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private DbContract() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME="post";
        public static final String KEY_NAME = "title";
        public static final String KEY_USER = "user";
        public static final String KEY_LOCATION = "location";
        public static final String KEY_COMMENT = "comment";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                KEY_NAME + TEXT_TYPE + COMMA_SEP +
                KEY_USER + TEXT_TYPE + COMMA_SEP +
                KEY_LOCATION + TEXT_TYPE + COMMA_SEP +
                KEY_COMMENT + TEXT_TYPE +
                " )";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
