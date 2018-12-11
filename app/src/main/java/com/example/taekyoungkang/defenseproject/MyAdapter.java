package com.example.taekyoungkang.defenseproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<item> data;
    private DBHelper dbHelper;

    public MyAdapter(Context context, ArrayList<item> data, DBHelper dbHelper) {
        this.context = context;
        this.data = data;
        this.dbHelper = dbHelper;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

}
class item {
    public String title, name, location, contents;

    public item(String title, String name, String location, String contents) {
        this.title = title;
        this.name = name;
        this.location = location;
        this.contents = contents;
    }
}
