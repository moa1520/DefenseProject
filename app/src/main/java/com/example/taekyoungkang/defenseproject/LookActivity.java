package com.example.taekyoungkang.defenseproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);

        LookFragment look = new LookFragment();
        look.setSelection(getIntent().getIntExtra("index", -1));
        getSupportFragmentManager().beginTransaction().replace(R.id.look, look).commit();
    }
}
