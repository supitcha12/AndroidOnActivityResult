package com.example.navadroid.androidonactivityresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AnotherActivity extends AppCompatActivity {

    private static final int RESULT_OK = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);
    }

    @Override
    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("returnKey1", "This is an apple.");
        intent.putExtra("returnKey2", "This is a pen.");
        setResult(RESULT_OK, intent); //
        super.finish();
    }
}
