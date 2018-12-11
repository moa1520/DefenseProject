package com.example.taekyoungkang.defenseproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, DbContract.DB_NAME, null, DbContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbContract.Users.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DbContract.Users.DELETE_TABLE);
        onCreate(db);
    }

    public void insertUserBySQL(String name, String user, String location, String comment) {
        try {
            String sql = String.format(
                    "INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (NULL,'%s', '%s', '%s', '%s')",
                    DbContract.Users.TABLE_NAME,
                    DbContract.Users._ID,
                    DbContract.Users.KEY_NAME,
                    DbContract.Users.KEY_USER,
                    DbContract.Users.KEY_LOCATION,
                    DbContract.Users.KEY_COMMENT,
                    name, user, location, comment);

            getWritableDatabase().execSQL(sql);
        } catch (SQLException e) {

        }
    }

    public Cursor getAllUsersBySQL() {
        String sql = "Select * FROM " + DbContract.Users.TABLE_NAME;
        return getReadableDatabase().rawQuery(sql, null);
    }

    public void deleteUserBySQL(String _id) {
        try {
            String sql = String.format(
                    "DELETE FROM %s WHERE %s = %s",
                    DbContract.Users.TABLE_NAME,
                    DbContract.Users._ID,
                    _id);
            getWritableDatabase().execSQL(sql);
        } catch (SQLException e) {
        }
    }

    public void updateUserBySQL(String _id, String name, String user, String location, String comment) {
        try {
            String sql = String.format(
                    "UPDATE  %s SET %s = '%s', %s = '%s' WHERE %s = %s",
                    DbContract.Users.TABLE_NAME,
                    DbContract.Users.KEY_NAME, name,
                    DbContract.Users.KEY_USER, user,
                    DbContract.Users.KEY_LOCATION, location,
                    DbContract.Users.KEY_COMMENT, comment,
                    DbContract.Users._ID, _id);
            getWritableDatabase().execSQL(sql);
        } catch (SQLException e) {
        }
    }

    public long insertUserByMethod(String name, String user, String location, String comment) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DbContract.Users.KEY_NAME, name);
        values.put(DbContract.Users.KEY_USER, user);
        values.put(DbContract.Users.KEY_LOCATION, location);
        values.put(DbContract.Users.KEY_COMMENT, comment);

        return db.insert(DbContract.Users.TABLE_NAME, null, values);
    }

    public Cursor getAllUsersByMethod() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(DbContract.Users.TABLE_NAME, null, null, null, null, null, null);
    }

    public int deleteUserByMethod(long _id) {
        SQLiteDatabase db = getWritableDatabase();

        return db.delete(DbContract.Users.TABLE_NAME, DbContract.Users._ID + " = " + _id, null);
    }

//    public long updateUserByMethod(String _id, String name, String phone) {
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(DbContract.Users.KEY_NAME, name);
//        values.put(DbContract.Users.KEY_PHONE,phone);
//
//        String whereClause = DbContract.Users._ID +" = ?";
//        String[] whereArgs ={_id};
//
//        return db.update(DbContract.Users.TABLE_NAME, values, whereClause, whereArgs);
//    }

    public ArrayList<item> getListItem() {
        String sql;
        sql = String.format("SELECT * FROM %s",
                DbContract.Users.TABLE_NAME);

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        ArrayList<item> data = new ArrayList<item>();
        while (cursor.moveToNext()) {
            int _id = cursor.getInt(0);
            String title = cursor.getString(1);
            String name = cursor.getString(2);
            String location = cursor.getString(3);
            String comment = cursor.getString(4);

            data.add(new item(_id, title, name, location, comment));
        }

        return data;
    }

    public ArrayList<item> getDetailItem(int i) {
        String sql;
        sql = String.format("SELECT * FROM %s",
                DbContract.Users.TABLE_NAME);

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);
        for(int j = 0; j<i; j++) {
            cursor.moveToNext();
        }
        ArrayList<item> data = new ArrayList<item>();
        int _id = cursor.getInt(0);
        String title = cursor.getString(1);
        String name = cursor.getString(2);
        String location = cursor.getString(3);
        String comment = cursor.getString(4);

        data.add(new item(_id, title, name, location, comment));

        return data;
    }
}
