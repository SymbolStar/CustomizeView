package com.symbolstar.customizeview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.symbolstar.customizeview.R;

/**
 * Created by fujindong on 29/01/2018.
 */

public class ComposeShaderView extends View {
    private static final String TAG = "ComposeShaderView";

    public ComposeShaderView(Context context) {
        super(context);
    }

    public ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //这里要注意的在Android硬件加速下，ComposeShader（）是不支持两个相同类型的Shader
        //所以这里要关闭硬件加速
        if (canvas.isHardwareAccelerated()) {
            Log.e(TAG, "true");
            this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        } else {
            Log.e(TAG, "true");
        }

        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_1);
        //盖在上方的图片的背景一定要是透明色
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_loyalty_black_48dp);
        Shader shader1 = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Shader shader2 = new BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Shader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.SRC_ATOP);
        paint.setShader(shader);
        canvas.drawRect(0, 0, 700, 800, paint);



    }

}
