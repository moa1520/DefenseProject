package com.example.taekyoungkang.defenseproject;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LookFragment extends Fragment {
    int index = -1;
    String title, name, location, contents;
    TextView tv_title, tv_name, tv_location, tv_contents;

    public LookFragment() {
        // Required empty public constructor
    }

    public void setSelection(int i, String mTitle, String mName, String mLocation, String mContents) {
        index = i;
        title = mTitle;
        name = mName;
        location = mLocation;
        contents = mContents;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = (View) inflater.inflate(R.layout.fragment_look, container, false);
        tv_title = (TextView)view.findViewById(R.id.name);
        tv_name = (TextView)view.findViewById(R.id.who);
        tv_location = (TextView)view.findViewById(R.id.location);
        tv_contents = (TextView)view.findViewById(R.id.lookContents);
        Button btn = (Button)view.findViewById(R.id.modify);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        tv_title.setText(title);
        tv_name.setText(name);
        tv_location.setText(location);
        tv_contents.setText(contents);

        // Inflate the layout for this fragment
//        ArrayList<MyItem> data= new ArrayList<MyItem>();
//
//        image = Defenseinfo.IMAGES[index];
//        title = Defenseinfo.TITLES[index];
//        people = Defenseinfo.PEOPLE[index];
//        address = Defenseinfo.ADRESS[index];
//
//        data.add(new MyItem(image, title, people, address));
//
//        View view = (View)inflater.inflate(R.layout.fragment_look, container, false);
//        ListView lv = (ListView) view.findViewById(R.id.listView);
//
//        MyAdapter adapter = new MyAdapter(getActivity(), R.layout.info, data);
//
//        lv.setAdapter(adapter);
//
//        lv.setDivider(new ColorDrawable(Color.rgb(200,200,200)));
//        lv.setDividerHeight(5);


        return view;
    }
}
