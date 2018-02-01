package com.symbolstar.customizeview.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fujindong on 30/01/2018.
 */

public class PathEffectView extends View {
    private static final String TAG = "PathEffectView";

    public PathEffectView(Context context) {
        super(context);
    }

    public PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        if (canvas.isHardwareAccelerated()) {
//            this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
//        }


        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        Path path = new Path();
        path.addCircle(200, 200, 150, Path.Direction.CW);
        PathEffect pathEffect = new DashPathEffect(new float[]{10, 5}, 10);
        paint.setPathEffect(pathEffect);
        canvas.drawPath(path, paint);


        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(3);
        Path path1 = new Path();
        path1.moveTo(200, 200);
        float[] point = {250,100,300,250,350,200,400,300,450,100};
        path1.lineTo(250,100);
        path1.lineTo(300,250);
        path1.lineTo(350,200);
        path1.lineTo(400,300);
        path1.lineTo(450,100);
        //CornerPathEffect(radius) radius 拐角圆角半径
        PathEffect pathEffect1 = new CornerPathEffect(20);
        //segmentLength 指定拼接的线段长度，deviation 偏移量
        PathEffect pathEffect2 = new DiscretePathEffect(20, 5);
        //第一个参数是一个数组，它指定虚线格式：数组中元素个数必须为偶数按照 画线长度、空白长度的顺序排列
        //第二个参数是虚线的偏移量
        PathEffect pathEffect3 = new DashPathEffect(new float[]{20, 10, 5, 10}, 0);
        paint1.setPathEffect(pathEffect3);
//        canvas.drawPath(path1,paint1);


        Path path3 = new Path();
//        path3.addCircle(400,800,300, Path.Direction.CW);
        path3.addRoundRect(100,600,600,800,30,30, Path.Direction.CW);
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        Path path2 = new Path();
        path2.moveTo(0, 20);
        path2.lineTo(10, 0);
        path2.lineTo(20, 20);
        path2.close();
        //用绘制的path来作为轨迹元素，advance 相邻元素的间隔，这个个间隔的距离为相邻元素的起点间隔，phase 偏移量
        //Style 用来指定拐角的时候元素的转换方向 分为三类 TRANSLATE 位移，ROTATE 旋转，MORPH 变体
        PathEffect pathEffect4 = new PathDashPathEffect(path2, 25, 0, PathDashPathEffect.Style.TRANSLATE);
        PathEffect pathEffect5 = new SumPathEffect(pathEffect3, pathEffect2);
        PathEffect pathEffect6 = new ComposePathEffect(pathEffect3, pathEffect2);
        paint2.setPathEffect(pathEffect4);
        canvas.drawPath(path3,paint2);

        Paint paint3 = new Paint();
        paint3.setTextSize(150);
        //radius 模糊范围 值越大越模糊 dx，dy x/y方向的偏移量
        paint3.setShadowLayer(5,20,20, Color.BLUE);
        canvas.drawText("SymbolStar",200,1000,paint3);

    }
}
