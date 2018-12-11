package com.example.taekyoungkang.defenseproject;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteActivity extends AppCompatActivity {

    private EditText mTitleEt;
    private EditText mNameEt;
    private EditText mLocationEt;
    private EditText mCommentEt;
    private Button mWriteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mTitleEt = findViewById(R.id.title);
        mNameEt = findViewById(R.id.name);
        mLocationEt = findViewById(R.id.location);
        mCommentEt = findViewById(R.id.comment);
        mWriteBtn = findViewById(R.id.submit);

        mWriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title, name, location, comment;
                DBHelper dbHelper = new DBHelper(getApplicationContext());

                title = mTitleEt.getText().toString();
                name = mNameEt.getText().toString();
                location = mLocationEt.getText().toString();
                comment = mCommentEt.getText().toString();

                long newRowId = dbHelper.insertUserByMethod(title, name, location, comment);

                if(newRowId == -1) {
                    Toast.makeText(WriteActivity.this, "저장에 문제가 발생했습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(WriteActivity.this, "저장이 완료되었습니다", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
