package com.leanper.androidallstyle.view.hencoder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
        mPaint.setColor(Color.BLACK);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.FILL);

        canvas.drawPath(mPath,mPaint);

    }
}
