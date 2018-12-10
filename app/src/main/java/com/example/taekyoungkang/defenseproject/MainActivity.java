package com.example.taekyoungkang.defenseproject;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
            case R.id.menu_search:
                startActivity(new Intent(this, SearchActivity.class));
                return true;
            case R.id.menu_add:
                startActivity(new Intent(this, WriteActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

//    @Override
//    public void onTitleSelected(int i) {
//        if (getResources().getConfiguration().orientation
//                == Configuration.ORIENTATION_LANDSCAPE) {
//            LookFragment lookFragment = new LookFragment();
//            lookFragment.setSelection(i);
//            getSupportFragmentManager().beginTransaction().replace(R.id.look, lookFragment).commit();
//        } else {
//            Intent intent = new Intent(this, LookActivity.class);
//            intent.putExtra("index", i);
//            startActivity(intent);
//        }
//
//    }

}
