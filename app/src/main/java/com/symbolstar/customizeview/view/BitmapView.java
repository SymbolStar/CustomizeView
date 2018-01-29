package com.symbolstar.customizeview.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.symbolstar.customizeview.R;

/**
 * Created by fujindong on 26/01/2018.
 */

/**
 * 着重分析一下 虽然用得比较少
 */
public class BitmapView extends View {
    private static final String TAG = "BitmapView";
    private Bitmap mBitmap;
    Paint paint = new Paint();

    public BitmapView(Context context) {
        super(context);
    }

    public BitmapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.dog)).getBitmap();
        canvas.drawBitmap(mBitmap,0,0,null);

    }
}
