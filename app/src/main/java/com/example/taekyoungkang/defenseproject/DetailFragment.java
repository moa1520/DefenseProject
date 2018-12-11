package com.example.taekyoungkang.defenseproject;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    int index = -1;

    public void setSelection(int i) {
        index = i;
    }


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        DBHelper dbHelper = new DBHelper(getActivity());
        TextView tv = (TextView)rootView.findViewById(R.id.detail_commnet);
        Cursor cursor = dbHelper.getAllUsersByMethod();
        if(cursor == null) {
            Toast.makeText(getActivity(), "가져오는데 실패함", Toast.LENGTH_SHORT).show();
        }
        cursor.moveToFirst();
        String comment = cursor.getString(4);
        tv.setText(comment);

        return rootView;

    }

}
