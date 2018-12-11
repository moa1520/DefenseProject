package com.example.taekyoungkang.defenseproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.info, parent, false);
        }

        TextView id = (TextView)convertView.findViewById(R.id._id);
        TextView title = (TextView)convertView.findViewById(R.id.title);
        TextView name = (TextView)convertView.findViewById(R.id.name);
        TextView location = (TextView)convertView.findViewById(R.id.location);

        item mitem = (item) getItem(position);
        
        id.setText(dbHelper.getAllUsersByMethod().getString(0));
        title.setText(mitem.title);
        name.setText(mitem.name);
        location.setText(mitem.location);

        return convertView;
    }
}

class item {
    public String title;
    public String name;
    public String location;
    public String comment;

    public item(String title, String name, String location, String comment) {
        this.title = title;
        this.name = name;
        this.location = location;
        this.comment = comment;
    }
}
