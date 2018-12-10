package com.example.taekyoungkang.defenseproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper sInstance;

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "defence.db";
    private static final String CREATE_TABLE =
            String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY AUTOINCREMENT, %s TEXT, %s TEXT, %s TEXT, %s TEXT)"
                    , DataContract.Data.TABLE_NAME,
                    DataContract.Data._ID,
                    DataContract.Data.TITLE,
                    DataContract.Data.LOCATION,
                    DataContract.Data.NAME,
                    DataContract.Data.CONTENTS);
    private static final String DELETE_TABLE =
            "DROP TABLE IF EXISTS " + DataContract.Data.TABLE_NAME;

    public static DBHelper getsInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DBHelper(context);
        }
        return sInstance;
    }

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }
}
