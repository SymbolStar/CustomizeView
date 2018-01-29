package com.symbolstar.customizeview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.symbolstar.customizeview.R;

/**
 * Created by fujindong on 26/01/2018.
 */

public class TextActivity extends AppCompatActivity {
    private static final String TAG = "TextActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
    }
}
