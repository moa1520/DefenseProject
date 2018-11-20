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


    public LookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<MyItem> data= new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.s1,"설악산 수렴동대피소","주상현","강원 인제군 북면 백담로 1220"));
        data.add(new MyItem(R.drawable.s2,"지리산 세석동대피소","강태경","경남 산청군 시천면 내대리"));
        data.add(new MyItem(R.drawable.s3,"덕유산 향적봉대피소","배장근","전북 무주군 설천면 삼공리 산109"));
        data.add(new MyItem(R.drawable.s4,"지리산 노고단대피소","박종범","전남 구례군 산동면 노고단로 1068"));

        View rootView = (View)inflater.inflate(R.layout.fragment_titles, container, false);
        ListView lv = (ListView) rootView.findViewById(R.id.listview);

        adapter = new MyAdapter(getActivity(), R.layout.info, data);

        lv.setAdapter(adapter);

        lv.setDivider(new ColorDrawable(Color.rgb(200,200,200)));
        lv.setDividerHeight(5);

        return rootView;
    }

}
