package com.symbolstar.customizeview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by fujindong on 24/01/2018.
 */

public class EaseView extends View {
    private static final String TAG = "EaseView";


    public EaseView(Context context) {
        super(context);
    }

    public EaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    Paint paint = new Paint();


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//      按顺序覆盖第二个圆会覆盖在底色的上层

        //TODO 这类颜色设置 一般用于设置view底色，或者在绘制之后为界面设置半透明蒙版
        canvas.drawColor(Color.parseColor("#22002266"));
//        canvas.drawRGB(11,11,11);
//        canvas.drawARGB(11,11,1,1);


//      TODO 画圆 前面三个参数确定了圆的基本信息，paint提供样式风格设置
        paint.setColor(Color.BLUE); //设置圆的颜色
        paint.setStyle(Paint.Style.STROKE);//画线模式
        paint.setStrokeWidth(10);//设置描边的宽度
        paint.setAntiAlias(true);//开启抗锯齿效果，另一种写法在在new Paint(Paint.ANTI_ALIAS_FLAG)
        canvas.drawCircle(300, 300, 200, paint);

        Paint paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(5);
        //TODO 矩形 rectangle 前四个参数是矩形四条边的坐标
        canvas.drawRect(200, 200, 400, 400, paint1);
        //还有两个重载的方法
        Rect rect = new Rect(250, 250, 350, 350);
        canvas.drawRect(rect, paint1);
        RectF rectF = new RectF(275, 275, 325, 325);
        canvas.drawRect(rectF, paint1);


//        TODO drawpoint 画点
        Paint pointPaint = new Paint();
        pointPaint.setStrokeWidth(20);//设置点的大小
        pointPaint.setColor(Color.BLACK);
        //设置点的形状，ROUND圆形，SQUARE或BUTT 方形，这个方法并不是专门用来设置点的形状的，而是一个设置
        //线条端点形状的方法。圆头（ROUND）·平头（BUTT）·方头（SQUARE）
        pointPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(50, 150, pointPaint);
        Paint pointPaint1 = new Paint();
        pointPaint1.setStrokeWidth(20);
        pointPaint1.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(50, 100, pointPaint1);
        //绘制多个点
        float[] points = {50,500,100,500,150,500,50,600,100,600,150,600};
//        canvas.drawPoints(points,pointPaint1);//这个就是绘制数组中的所有的点一个为一组
        //offset 跳过前面两个数，画后面的两个数
        canvas.drawPoints(points,2,2,pointPaint);

        //TODO 椭圆 drawoval要求的android API等级为21
        Paint ovalPaint = new Paint();
        ovalPaint.setColor(Color.GREEN);
        ovalPaint.setStrokeWidth(8);
        ovalPaint.setStyle(Paint.Style.STROKE);
       //或者canvas.drawOval(RectF,paint);
        canvas.drawOval(30,700,200,800,ovalPaint);


        //TODO 画线
        Paint linePaint = new Paint();
        linePaint.setColor(Color.YELLOW);
        linePaint.setStrokeWidth(10);
        canvas.drawLine(10,10,10,100,linePaint);
        //画线段的方法
        //float[] points= {......}
       // canvas.drawLines(points,paint);

        //TODO 画圆角矩形
        Paint roundRectPaint = new Paint();
        roundRectPaint.setColor(Color.BLACK);
        roundRectPaint.setStyle(Paint.Style.FILL);
        roundRectPaint.setAntiAlias(true);
        //前四个为坐标位置，RX,RY 横向和纵向半径
        canvas.drawRoundRect(200,10,300,80,20,20,roundRectPaint);


//        TODO 绘制扇形
        Paint arcPaint = new Paint();
        arcPaint.setColor(Color.BLUE);
        arcPaint.setStyle(Paint.Style.FILL);
        //STARTANGLE 起始角度正右方向，顺时针为正方向，sweepAngle为需要的角度，userCenter为是否连接到圆心，
        //如果不连接到圆心就是弧形，连接到圆心就是扇形
        canvas.drawArc(600,100,800,300,0,-30,true,arcPaint);

    }
}
