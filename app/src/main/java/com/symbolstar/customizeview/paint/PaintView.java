package com.symbolstar.customizeview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.symbolstar.customizeview.R;

/**
 * Created by fujindong on 29/01/2018.
 */

public class PaintView extends View{
    private static final String TAG = "PaintView";


    public PaintView(Context context) {
        super(context);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        //从效果可以看出两点之间渐变
        //x0，y0，x1，y1两个端点的位置，color0，color1 端点颜色，tile端点范围之外的着色规则
        //CLAMP 端点外延伸端点处的颜色，MIRROR 镜像模式 REPEAT 重复模式
        Shader shader = new LinearGradient(100, 100, 300, 100, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.REPEAT);
        paint.setShader(shader);
        canvas.drawRect(0,0,400,300,paint);

        Paint paint1 = new Paint();
        //参数：
        //cx,cy 辐射中心的坐标 radius 辐射半径 centerColor 辐射中心的颜色 edgeColor 辐射边缘的颜色 tileMode 辐射范围之外的着色模式
        Shader shader1 = new RadialGradient(300, 600, 200, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        paint1.setStyle(Paint.Style.FILL);
        paint1.setShader(shader1);
        canvas.drawCircle(300,600,200,paint1);

        Paint paint2 = new Paint();
        //参数 cx，cy 扫描中心，color0 扫描起始颜色，color1 扫描终止颜色
        Shader shader2 = new SweepGradient(800, 600, Color.parseColor("#E91E63"), Color.parseColor("#2196F3"));
        paint2.setStyle(Paint.Style.FILL);
        paint2.setShader(shader2);
        canvas.drawCircle(800,600,200,paint2);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog_1);
        //bitmap 做模版的bitmap tileX 横向的TileMode tileY 纵向的TileMode
        //不可以设置图片的坐标 图像的坐标为原点
        Shader shader3 = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        Paint paint3 = new Paint();
        paint3.setShader(shader3);
//        canvas.drawCircle(300,300,300,paint3);
        canvas.drawRect(0,0,700,800,paint3);


    }
}
