package com.example.taekyoungkang.defenseproject;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
public class LookFragment extends Fragment {
    MyAdapter adapter;
    int index = -1;

    public void setSelection(int i) { index = i; }

    public LookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = (View)inflater.inflate(R.layout.fragment_look, container, false);
        ListView lv = (ListView) rootView.findViewById(R.id.listview);

        return  inflater.inflate(R.layout.fragment_look, container, false);
    }

}
