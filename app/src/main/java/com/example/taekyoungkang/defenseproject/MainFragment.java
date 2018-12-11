package com.example.taekyoungkang.defenseproject;


import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private MyAdapter adapter;
    private DBHelper dbHelper;
    private View rootView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main,container,false);
        dbHelper = new DBHelper(getActivity());

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewAllList();
    }
    private void viewAllList(){
        ArrayList<item> data = dbHelper.getListItem();

        adapter = new MyAdapter(getActivity(), data, dbHelper);

        ListView bunkerList = rootView.findViewById(R.id.mainListView);
        bunkerList.setAdapter(adapter);
        bunkerList.setDivider(new ColorDrawable(Color.BLACK));
        bunkerList.setDividerHeight(5);

        bunkerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intentDetail = new Intent(getActivity(), DetailViewActivity.class);
//                int _id = ((item)bunkerAdapter.getItem(position))._id;
//                intentDetail.putExtra("id", _id);
//                startActivity(intentDetail);
            }
        });
    }
}
