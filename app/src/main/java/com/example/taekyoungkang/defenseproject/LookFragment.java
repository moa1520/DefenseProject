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
    int index = -1;
    int image;
    String title, people, address;

    public LookFragment() {
        // Required empty public constructor
    }

    public void setSelection(int i) { index = i; }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<MyItem> data= new ArrayList<MyItem>();

        image = Defenseinfo.IMAGES[index];
        title = Defenseinfo.TITLES[index];
        people = Defenseinfo.PEOPLE[index];
        address = Defenseinfo.ADRESS[index];

        data.add(new MyItem(image, title, people, address));

        View view = (View)inflater.inflate(R.layout.fragment_look, container, false);
        ListView lv = (ListView) view.findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(getActivity(), R.layout.info, data);

        lv.setAdapter(adapter);

        lv.setDivider(new ColorDrawable(Color.rgb(200,200,200)));
        lv.setDividerHeight(5);


        return view;
    }
}
