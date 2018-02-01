package com.symbolstar.customizeview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.symbolstar.customizeview.R;

/**
 * Created by fujindong on 29/01/2018.
 */

public class PaintActivity extends AppCompatActivity {
    private static final String TAG = "PaintActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mask_filter);
    }
}
