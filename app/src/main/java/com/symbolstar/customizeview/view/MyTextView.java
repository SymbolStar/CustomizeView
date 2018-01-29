package com.symbolstar.customizeview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fujindong on 26/01/2018.
 */

public class MyTextView extends View {
    private static final String TAG = "MyTextView";
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#119922"));
        paint.setTextSize(90);
        canvas.drawText("symbolStar",100,100,paint);
    }
}
