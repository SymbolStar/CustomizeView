package com.symbolstar.customizeview.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;

import com.symbolstar.customizeview.R;

/**
 * Created by fujindong on 25/01/2018.
 */

public class PathViewActivity extends AppCompatActivity {
    private static final String TAG = "PathViewActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path);
    }
}
