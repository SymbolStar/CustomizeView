package com.symbolstar.customizeview.view;

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
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
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
//        canvas.drawPath(path, paint);
        /**
         *
         * TODO Path方法第一类：路径描述
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
        path1.addCircle(40, 40, 30, Path.Direction.CW);
        canvas.drawPath(path1, paint1);


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
        path2.quadTo(80, 50, 100, 100);
        canvas.drawPath(path2, quadPaint);

        /**
         * 移动到目标位置
         * moveTo(float x,float y)
         * rMoveTo(float x,float y)
         */

        /**
         * 画弧线
         * 相比较Canvas.draw.drawArc（）不需要useCenter这个参数不需要过中心，这里只是画线
         * forceMoveTo 的意思是 在绘制弧线的时候是从当前位置直接画线到弧度的开始位置还是直接跳到弧线的开始位置画弧线
         * arcTo(RectF oval, float startAngle, float sweepAngle, boolean forceMoveTo)
         * arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo)
         * arcTo(RectF oval, float startAngle, float sweepAngle)
         * 也是画弧度的方法与arcTo的区别就是少了forceMoveTo这个参数 该方法默认 forceMoveTo 为true 即直接跳到起始位置
         * addArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle)
         * addArc(RectF oval, float startAngle, float sweepAngle)
         */

        /**
         * 封闭当前子视图
         * 直接从当前位置画一条直线到视图的起始位置
         * close()
         */

        /**
         * contour 轮廓的定义  即path中的addXXX（）方法每绘制一个图形即表示一个contour的结束
         * 其他的xxxTo（）方法 每一次断线或抬笔即表示一个contour
         *
         * 不是所有的contour都需要用close（）封闭，当需要填充图形时（即Paint.Style为FILL、FILL_AND_STROKE）path会自动封闭
         */


//        TODO path方法第二类：辅助的设置或计算 （详细讲解）
        /**
         * Path.setFillType(Path.FillType ft) 设置图形相交时的填充方式
         * FillType类型如下：
         * EVEN_ODD
         * WINDING
         * INVERSE_EVEN_ODD
         * INVERSE_WINDING
         * 效果如下
         */
        Path typePath = new Path();
        Paint typePaint = new Paint();
        typePaint.setColor(Color.BLACK);
        typePaint.setStyle(Paint.Style.FILL);
        typePath.setFillType(Path.FillType.EVEN_ODD);
        typePath.addCircle(400,400,200, Path.Direction.CW);
        typePath.addCircle(700,400,200, Path.Direction.CW);
        canvas.drawPath(typePath,typePaint);

        /**
         * EVEN_ODD 效果跟机械画图中的布尔运算差不多是求差的运算 两个封闭图形的相交的部分没有填充颜色
         * 具体的实现方法是以这个图形中的任意一点为起点然后画一条射线如果这个射线在这个视图中有偶数个交点
         * 就说明这个点在图形的外部，如果有基数个就说明在图形的内部
         */
        /**
         * WINDING 这个视图的效果跟视图的绘制方向有关判断方法跟EVEN_ODD差不多，在任意一点画一条射线
         * 所过交点处如果视图的轮廓是顺时针穿过射线结果就+1，反之则-1，最后结果是0，则这个点在图形的外部，
         * 不是0，则在图形的内部
         *
         * 对去addXXX（）方法可以通过设置Direction来设置图形的方向，对去XXXTo（）绘制的方向就是图形的方向
         *
         *
         * 在WINDING 模式下巧用图形的绘制方向就可以实现EVEN_ODD的效果。FillType的默认值也是WINDING
         */





    }
}
