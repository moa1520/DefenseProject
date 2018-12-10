package com.example.taekyoungkang.defenseproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WriteActivity extends AppCompatActivity {

    private EditText mTitleEditText;
    private EditText mContentsEditText;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        mTitleEditText = findViewById(R.id.title_edit);
        mContentsEditText = findViewById(R.id.contents_edit);
        submit = (Button) findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = mTitleEditText.getText().toString();
                String contents = mContentsEditText.getText().toString();

                ContentValues contentValues = new ContentValues();
                contentValues.put(DataContract.Data.TITLE, title);
                contentValues.put(DataContract.Data.CONTENTS, contents);

                SQLiteDatabase db = DBHelper.getsInstance(getApplicationContext()).getWritableDatabase();
                long newRowId = db.insert(DataContract.Data.TABLE_NAME,
                        null,
                        contentValues);

                if (newRowId == -1) {
                    Toast.makeText(getApplicationContext(), "저장에 문제가 발생했습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "저장되었습니다", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                }
            }
        });
    }
}
