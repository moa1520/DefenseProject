package com.example.taekyoungkang.defenseproject;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    DBHelper mDbHelper;
    private View rootView;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main,container,false);

        return rootView;
    }

    private void viewAllToListView() {

        Cursor cursor = mDbHelper.getAllUsersByMethod();

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getContext(),
                R.layout.info, cursor, new String[]{
                DbContract.Users._ID,
                DbContract.Users.KEY_NAME,
                DbContract.Users.KEY_USER,
                DbContract.Users.KEY_LOCATION},
                new int[]{R.id._id, R.id.title, R.id.location}, 0);

        ListView lv = (ListView)rootView.findViewById(R.id.mainListView);
        lv.setAdapter(adapter);

    }
}
