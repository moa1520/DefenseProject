package com.example.taekyoungkang.defenseproject;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class LookActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mGoogleMap;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);

        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        num = intent.getIntExtra("index", -1);

        if(getResources().getConfiguration().orientation==
                Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }

        LookFragment look = new LookFragment();
        look.setSelection(num);
        getSupportFragmentManager().beginTransaction().replace(R.id.look, look).commit();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        LatLng location = new LatLng(37.5817891, 127.009854);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
    }
}
