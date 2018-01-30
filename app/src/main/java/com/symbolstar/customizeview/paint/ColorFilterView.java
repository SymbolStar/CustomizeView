package com.symbolstar.customizeview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.symbolstar.customizeview.R;

/**
 * Created by fujindong on 29/01/2018.
 */

public class ColorFilterView extends View {
    private static final String TAG = "ColorFilterView";

    public ColorFilterView(Context context) {
        super(context);
    }

    public ColorFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //方法 LightingColorFilter（int mul，int add）
        //参数mul用来更目标色值相乘，add 用来与目标色值相加
        //案例中的0x00ffff 去除了红色色值
        //R' = R * 0x0 / 0xff + 0x0 = 0
        //G' = G * 0xff / 0xff + 0x0 = G
        //B' = B * 0xff / 0xff + 0x0 = B
        ColorFilter colorFilter = new LightingColorFilter(0xffffff, 0x001000);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_1);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        paint.setColorFilter(colorFilter);
//        paint.setShader(shader);
//        canvas.drawRect(0, 0, 700, 800, paint);


        Paint paint1 = new Paint();
        ColorFilter colorFilter1 = new PorterDuffColorFilter(Color.parseColor("#77660000"), PorterDuff.Mode.SRC_OVER);
        paint1.setColorFilter(colorFilter1);
        paint1.setShader(shader);
        canvas.drawRect(0, 0, 700, 800, paint1);

    }
}
