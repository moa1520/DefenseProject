package com.example.taekyoungkang.defenseproject;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {


        private long mld = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setContentView(R.layout.fragment_detail);

     if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
         finish();
         return;
     }

     DetailFragment details = new DetailFragment();
        details.setSelection(getIntent().getIntExtra("id", -1));
     getSupportFragmentManager().beginTransaction().replace(R.id.details,details).commit();
    }
}
