package com.example.taekyoungkang.defenseproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitlesFragment extends Fragment {

    private static final int REQUEST_CODE_INSERT = 1000;
    DataAdapter mAdapter;

    int mCurCheckPosition = -1;
    private ListView lv;
    private DBHelper dbHelper;
    private Cursor cursor;
    private View rootView;

//    public interface OnTitleSelectedListener {
//        public void onTitleSelected(int i);
//    }

    public TitlesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (View)inflater.inflate(R.layout.fragment_titles,container, false);

//        View rootView = (View) inflater.inflate(R.layout.fragment_titles, container, false);
//        ListView lv = (ListView) rootView.findViewById(R.id.listview);
//        lv.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, Defenseinfo.TITLES));
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
//                mCurCheckPosition = i;
//                Activity activity = getActivity();
//                ((OnTitleSelectedListener) activity).onTitleSelected(i);
//
//            }
//        });
//        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        return rootView;
    }

    @Override
    public void onResume() {
        lv = (ListView)rootView.findViewById(R.id.listview);
        dbHelper = DBHelper.getsInstance(getActivity());
        cursor = dbHelper.getReadableDatabase().query(DataContract.Data.TABLE_NAME,
                null, null,null, null, null, null);
        mAdapter = new DataAdapter(getActivity(), cursor);
        lv.setAdapter(mAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), LookActivity.class);

                Cursor cursor = (Cursor)mAdapter.getItem(position);

                String title = cursor.getString(cursor.getColumnIndexOrThrow(DataContract.Data.TITLE));
                String contents = cursor.getString(cursor.getColumnIndexOrThrow(DataContract.Data.CONTENTS));

                intent.putExtra("id", id);
                intent.putExtra("title", title);
                intent.putExtra("contents", contents);

                startActivityForResult(intent, REQUEST_CODE_INSERT);
            }
        });

        super.onResume();
    }

//    @Override
//    public void onViewStateRestored(Bundle savedInstanceState) {
//        super.onViewStateRestored(savedInstanceState);
//        if (savedInstanceState != null) {
//            mCurCheckPosition = savedInstanceState.getInt("curChoice", -1);
//            if (mCurCheckPosition >= 0) {
//                Activity activity = getActivity(); // activity associated with the current fragment
//                ((OnTitleSelectedListener) activity).onTitleSelected(mCurCheckPosition);
//
//                ListView lv = (ListView) getView().findViewById(R.id.listview);
//                lv.setSelection(mCurCheckPosition);
//                lv.smoothScrollToPosition(mCurCheckPosition);
//            }
//        }
//    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }

    private static class DataAdapter extends CursorAdapter {

        public DataAdapter(Context context, Cursor c) {
            super(context,c, false);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            TextView titleText = view.findViewById(android.R.id.text1);
            titleText.setText(cursor.getString(cursor.getColumnIndexOrThrow(DataContract.Data.TITLE)));
        }
    }
}
