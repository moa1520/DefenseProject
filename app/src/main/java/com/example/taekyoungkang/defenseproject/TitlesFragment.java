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

    int mCurCheckPosition = -1;
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
        ListView lv = (ListView)rootView.findViewById(R.id.title_list);

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

//        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                final long deleteId = id;
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setTitle("글 삭제");
//                builder.setMessage("글을 삭제하시겠습니까?");
//                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        SQLiteDatabase db = DBHelper.getsInstance(getActivity()).getWritableDatabase();
//                        int deletedCount = db.delete(DataContract.Data.TABLE_NAME,
//                                DataContract.Data._ID + " = " + deleteId, null);
//                        if (deletedCount == 0) {
//                            Toast.makeText(getActivity(), "삭제에 문제가 발생했습니다", Toast.LENGTH_SHORT).show();
//                        } else {
//                            mAdapter.swapCursor(getDataCursor());
//                            Toast.makeText(getActivity(), "삭제가 완료되었습니다", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//                builder.setNegativeButton("취소", null);
//                builder.show();
//                return true;
//            }
//        });

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }
}
