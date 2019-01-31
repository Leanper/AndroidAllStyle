package com.leanper.androidallstyle.view.hencoder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Title:  PathView 
 
 * @Description:    自定义视图path的描述
 * @author:  Leanper
 * @date:   2019/1/16 14:18   
 
 */  

public class PathView extends View {

    private Path mPath;
    private Paint mPaint;

    public PathView(Context context) {
        this(context,null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        mPath = new Path();
        mPaint = new Paint();
        //设置颜色
        mPaint.setColor(Color.BLACK);
//        mPaint.setShader() //设置着色器,不是直接使用shader，使用子类
        //线性渐变
        // RadialGradient 辐射渐变
        Shader shader = new LinearGradient(100, 100, 500, 500, Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"), Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        mPaint.setAntiAlias(true);


        //bitmap渐变
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
//        Shader shader1 = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        mPaint.setShader(shader);


        //设置线头的形状。线头形状有三种：BUTT 平头、ROUND 圆头、SQUARE 方头。默认为 BUTT。
        mPaint.setStrokeCap(Paint.Cap.ROUND);

//        设置拐角的形状。有三个值可以选择：MITER 尖角、 BEVEL 平角和 ROUND 圆角。默认为 MITER。
        mPaint.setStrokeJoin(Paint.Join.ROUND);


//        这个方法是对于 setStrokeJoin() 的一个补充，它用于设置 MITER 型拐角的延长线的最大值。所谓「延长线的最大值」，是这么一回事：
        mPaint.setStrokeMiter(2);//2就是a/b



//        设置是否使用双线性过滤来绘制 Bitmap 。
//        图像在放大绘制的时候，默认使用的是最近邻插值过滤，这种算法简单，
// 但会出现马赛克现象；而如果开启了双线性过滤，就可以让结果图像显得更加平滑。
        mPaint.setFilterBitmap(true);

        //PathEffect设置轮廓

        //设置阴影
//        setShadowLayer(float radius, float dx, float dy, int shadowColor)

        //setMaskFilter(MaskFilter maskfilter)
        //
        //为之后的绘制设置 MaskFilter。上一个方法 setShadowLayer() 是设置的在绘制层下方的附加效果；
        // 而这个 MaskFilter 和它相反，设置的是在绘制层上方的附加效果。
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(300,300,200,mPaint);

    }
}
