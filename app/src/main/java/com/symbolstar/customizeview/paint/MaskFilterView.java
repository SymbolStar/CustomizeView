package com.symbolstar.customizeview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.symbolstar.customizeview.R;

/**
 * Created by fujindong on 30/01/2018.
 */

public class MaskFilterView extends View {
    private static final String TAG = "MaskFilterView";
    public MaskFilterView(Context context) {
        super(context);
    }

    public MaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (canvas.isHardwareAccelerated()) {
            this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }

        Paint paint = new Paint();
        //radius 模糊范围 模糊类型
        //NORMAL 内外模糊/SOLID 内部正常外部模糊／INNER 内部模糊，外部不绘制／OUTER 内部不绘制，外部模糊
//        paint.setMaskFilter(new BlurMaskFilter(300, BlurMaskFilter.Blur.NORMAL));
        paint.setMaskFilter(new EmbossMaskFilter(new float[]{0, 1, 1}, 0.2f, 8, 10));
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_1);
        canvas.drawBitmap(bitmap,100,100,paint);

        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setColor(Color.parseColor("#008866"));
        //第一个参数是一个有三个元素的数组代表三个方向xyz 为1 表示光从负方向往正方向，坐标的方向为右手笛卡尔坐标
        //ambient 光的强度 范围 0～1，specular 炫光系数，blurRadius 应用光线的范围
        paint1.setMaskFilter(new EmbossMaskFilter(new float[]{1, 0, 1}, 0.5f, 8, 10));
        canvas.drawRoundRect(200,1000,600,1200,30,30,paint1);



    }
}
