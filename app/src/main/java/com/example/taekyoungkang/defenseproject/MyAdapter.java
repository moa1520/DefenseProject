package com.example.taekyoungkang.defenseproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class MyItem{
    int mIcon;
    String nName;
    String nWho;
    String nLocation;

    MyItem(int aIcon, String aName, String aWho, String aLocation){
        mIcon = aIcon;
        nWho = aWho;
        nLocation = aLocation;
        nName = aName;
    }
}

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private int mResource;
    private ArrayList<MyItem> mItems = new ArrayList<MyItem>();

    public MyAdapter(Context context, int resource, ArrayList<MyItem> items){
        mContext = context;
        mResource = resource;
        mItems = items;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent, false);
        }

        ImageView icon = (ImageView) convertView.findViewById(R.id.image);
        icon.setImageResource(mItems.get(position).mIcon);

        TextView name = (TextView) convertView.findViewById(R.id.name);
        name.setText(mItems.get(position).nName);

        TextView who = (TextView) convertView.findViewById(R.id.who);
        who.setText(mItems.get(position).nWho);

        TextView location = (TextView) convertView.findViewById(R.id.location);
        location.setText(mItems.get(position).nLocation);
        return convertView;
    }
}