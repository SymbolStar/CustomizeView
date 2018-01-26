package com.symbolstar.customizeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fujindong on 25/01/2018.
 */



public class PathView extends View {
    private static final String TAG = "PathView";

    Paint paint = new Paint();
    Path path = new Path();
    {
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400,200,600,400,-180,225,false);
        path.lineTo(400,542);
    }


    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //TODO 自定义绘制图形   通过描述图形路径的方式来绘制图形
        //Path 可以描述可以描述直线、二次曲线、圆、椭圆、弧形、矩形、圆角矩形。
        //Path 有两种方法，一类是直接描述路径，另一类辅助的设计与计算
        canvas.drawPath(path,paint);
        /**
         *
         * Path方法第一类：路径描述
         * addXXX（）添加子图形
         * addCircle（float x，float y，float radius，Direction dir）添加圆
         * Direction 的参数有两种：顺时针CW 、逆时针 CCW 具体的区别后面看
         *
         * addOval（float left，float top，float right，float bottom，Direction dir）添加椭圆
         * addRect（float left，float top，float right，float bottom，Direction dir）添加矩形
         * addRoundRect（RectF rect，float rx，float ry，Direction dir）添加圆角矩形
         *
         *
         * xxxTo（） 画线（直线或曲线）
         * 从当前位置向目标位置画线
         * lineTo（float x，float y）这个方法的目标位置的坐标是绝对坐标
         * rLineTo（float x，float y）这个方法的目标位置的坐标是相对与当前位置的相对坐标
         */
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.FILL);
        paint1.setColor(Color.RED);
        Path path1 = new Path();
        path1.addCircle(40,40,30, Path.Direction.CW);
        canvas.drawPath(path1,paint1);


        /**
         * 二次贝塞尔曲线
         * quadTo(float x1,float y1,float x2,float y2)
         * rquadTo(float dx1,float dy1,float dx2,float dy2)
         * 三次贝塞尔曲线
         * cubicTo（float x1,float y1,float x2,float y2，float x3，float y3）
         * rCubicTo（float x1,float y1,float x2,float y2，float x3，float y3）
         */
        Paint quadPaint = new Paint();
        quadPaint.setColor(Color.BLACK);
        quadPaint.setStyle(Paint.Style.STROKE);
        quadPaint.setStrokeWidth(3);
        Path path2 = new Path();
        path2.quadTo(80,50,100,100);
        canvas.drawPath(path2,quadPaint);

        /**
         * 移动到目标位置
         * moveTo(float x,float y)
         * rMoveTo(float x,float y)
         */


    }
}
