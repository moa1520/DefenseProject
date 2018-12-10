package com.example.taekyoungkang.defenseproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Toast;

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
        rootView = (View) inflater.inflate(R.layout.fragment_titles, container, false);

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
        lv = (ListView) rootView.findViewById(R.id.listview);
        Cursor cursor = getDataCursor();
        mAdapter = new DataAdapter(getActivity(), cursor);
        lv.setAdapter(mAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), LookActivity.class);

                Cursor cursor = (Cursor) mAdapter.getItem(position);

                String title = cursor.getString(cursor.getColumnIndexOrThrow(DataContract.Data.TITLE));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DataContract.Data.NAME));
                String location = cursor.getString(cursor.getColumnIndexOrThrow(DataContract.Data.LOCATION));
                String contents = cursor.getString(cursor.getColumnIndexOrThrow(DataContract.Data.CONTENTS));

                intent.putExtra("id", id);
                intent.putExtra("title", title);
                intent.putExtra("name", name);
                intent.putExtra("location", location);
                intent.putExtra("contents", contents);

                startActivityForResult(intent, REQUEST_CODE_INSERT);
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final long deleteId = id;

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("글 삭제");
                builder.setMessage("글을 삭제하시겠습니까?");
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SQLiteDatabase db = DBHelper.getsInstance(getActivity()).getWritableDatabase();
                        int deletedCount = db.delete(DataContract.Data.TABLE_NAME,
                                DataContract.Data._ID + " = " + deleteId, null);
                        if (deletedCount == 0) {
                            Toast.makeText(getActivity(), "삭제에 문제가 발생했습니다", Toast.LENGTH_SHORT).show();
                        } else {
                            mAdapter.swapCursor(getDataCursor());
                            Toast.makeText(getActivity(), "삭제가 완료되었습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("취소", null);
                builder.show();
                return true;
            }
        });

        super.onResume();
    }

    private Cursor getDataCursor() {
        dbHelper = DBHelper.getsInstance(getActivity());
        return dbHelper.getReadableDatabase().query(DataContract.Data.TABLE_NAME,
                null, null, null, null, null, null);
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
            super(context, c, false);
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
