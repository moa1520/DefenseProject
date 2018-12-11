package com.example.taekyoungkang.defenseproject;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.widget.Toast;

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

    public interface onTitleSelectedListener {
        public void onTitleSelected(int i);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        dbHelper = new DBHelper(getActivity());

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ArrayList<item> data = dbHelper.getListItem();

        adapter = new MyAdapter(getActivity(), data, dbHelper);

        ListView bunkerList = rootView.findViewById(R.id.mainListView);
        bunkerList.setAdapter(adapter);
        bunkerList.setDivider(new ColorDrawable(Color.BLACK));
        bunkerList.setDividerHeight(5);

        bunkerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Activity activity = getActivity();
                ((onTitleSelectedListener) activity).onTitleSelected(position);
//                Intent intentDetail = new Intent(getActivity(), DetailActivity.class);
//                Cursor cursor = (Cursor) adapter.getItem(position);
            }
        });
        bunkerList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        bunkerList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final Cursor cursor = (Cursor) adapter.getItem(position);
                final long deleteId = id+1;
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("글 삭제");
                builder.setMessage("글을 삭제하시겠습니까?");
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int count = dbHelper.deleteUserByMethod(deleteId);
                        if (count == 0) {
                            Toast.makeText(getActivity(), "삭제에 문제가 발생했습니다", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "글이 삭제 되었습니다", Toast.LENGTH_SHORT).show();
                            onResume();
                        }
                    }
                });
                builder.setNegativeButton("취소", null);
                builder.show();

                return true;
            }
        });
    }
}
