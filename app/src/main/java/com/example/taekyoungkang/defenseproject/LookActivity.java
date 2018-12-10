package com.example.taekyoungkang.defenseproject;

import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LookActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private int mPostId = -1;
    private String title;
    private String contents;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        if(intent != null) {
            mPostId = intent.getIntExtra("id", -1);
            title = intent.getStringExtra("title");
            contents = intent.getStringExtra("contents");
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        LookFragment look = new LookFragment();
        //look.setSelection(num);
        look.setSelection(mPostId, title, contents);
        getSupportFragmentManager().beginTransaction().replace(R.id.look, look).commit();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

//        LatLng location = new LatLng(Defenseinfo.LOCATIONS[mPostId][0], Defenseinfo.LOCATIONS[mPostId][1]);
//        mGoogleMap.addMarker(new MarkerOptions().position(location).title(Defenseinfo.TITLES[mPostId]));
//        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
    }
}
