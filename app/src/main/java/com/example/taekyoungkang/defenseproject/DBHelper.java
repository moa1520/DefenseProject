package com.example.taekyoungkang.defenseproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;

    public DBHelper(Context context) {
        super(context, "defencedb", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String defenceSql = "CREATE TABLE post (_id integer primary key autoincrement," +
                "title not null, " +
                "name, " +
                "location, " +
                "contents)";

        String memberSql = "CREATE TABLE member (_id integer primary key autoincrement," +
                "member_id not null, " +
                "member_pw)";

        db.execSQL(defenceSql);
        db.execSQL(memberSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table post");
        db.execSQL("drop table member");
        onCreate(db);
    }
}
