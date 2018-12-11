package com.example.taekyoungkang.defenseproject;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
        ListView lv = (ListView) rootView.findViewById(R.id.detail_list);
        DBHelper dbHelper = new DBHelper(getActivity());
        ArrayList<item> data = dbHelper.getListItem();
        MyAdapter adapter = new MyAdapter(getActivity(), data, dbHelper);
        lv.setAdapter(adapter);

        return rootView;

    }

}
