package com.example.taekyoungkang.defenseproject;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<MyItem> data= new ArrayList<MyItem>();
        data.add(new MyItem(R.drawable.s1,"설악산 수렴동대피소","주상현","강원 인제군 북면 백담로 1220"));
        data.add(new MyItem(R.drawable.s2,"지리산 세석동대피소","강태경","경남 산청군 시천면 내대리"));
        data.add(new MyItem(R.drawable.s3,"덕유산 향적봉대피소","배장근","전북 무주군 설천면 삼공리 산109"));


        adapter = new MyAdapter(this, R.layout.info,data);

        ListView listView=(ListView) findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setDivider(new ColorDrawable(Color.rgb(200,200,200)));
        listView.setDividerHeight(5);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search :
                Toast.makeText(MainActivity.this, item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_add :
                Toast.makeText(MainActivity.this, item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_next :
                startActivity(new Intent(this, EditActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
