package com.example.taekyoungkang.defenseproject;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ListView lv = (ListView)findViewById(R.id.search_listview);
        Cursor cursor = getDataCursor();
        DataAdapter adapter = new DataAdapter(this, cursor);
        lv.setAdapter(adapter);
    }

    private Cursor getDataCursor() {
        dbHelper = DBHelper.getsInstance(this);
        return dbHelper.getReadableDatabase().query(DataContract.Data.TABLE_NAME,
                null, null, null, null, null, null);
    }


    private static class DataAdapter extends CursorAdapter {

        public DataAdapter(Context context, Cursor c) {
            super(context, c, false);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView titleText = view.findViewById(android.R.id.text1);
            titleText.setText(cursor.getString(cursor.getColumnIndexOrThrow(DataContract.Data.TITLE)));
        }
    }

}
