package com.leanper.androidallstyle.view.hencoder;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.leanper.androidallstyle.R;

public class StudyView1 extends View {

    private Paint mPaint;

        public StudyView1(Context context) {
            this(context,null);
        }
        public StudyView1(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
        }
        public StudyView1(Context context, AttributeSet attrs) {
            this(context, attrs,0);
            initPaint();
        }

    //初始化操作
    private void initPaint() {

        mPaint = new Paint();
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setDither(true);// 设定是否使用图像抖动处理，会使绘制出来的图片颜色更加平滑和饱满，图像更加清晰
        mPaint.setStyle(Paint.Style.FILL);//Paint.Style.FILL设置只绘制图形内容  填充  Paint.Style.FILL_AND_STROKE 填充且描边  Paint.Style.STROKE 描边         Paint.Style.FILL 填充
        mPaint.setColor(R.color.black);//设置画笔颜色
        mPaint.setAlpha(100);// 设置透明图0~255，要在setColor后面设置才生效
        mPaint.setStrokeWidth(4);

        mPaint.setLinearText(true);// 设置线性文本
        mPaint.setSubpixelText(true);  // 设置该项为true，将有助于文本在LCD屏幕上的显示效果
//        mPaint.setUnderlineText(true);// 设置下划线
//        mPaint.setStrikeThruText(true);// 设置带有删除线的效果
        mPaint.setFakeBoldText(true);//设置伪粗体文本，设置在小字体上效果会非常差
        mPaint.setTextSize(60);
        mPaint.setTextAlign(Paint.Align.LEFT);//设置对齐方式
//        mPaint.setTextScaleX(1);// 设置文本缩放倍数，1.0f为原始
        mPaint.setTextSkewX(-1);// 设置斜体文字，skewX为倾斜弧度 正的往右倾斜 负的往左倾斜

        mPaint.setStrokeCap(Paint.Cap.BUTT);//设置首尾端样式 Round圆形线帽 square方形 butt没有线帽
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);//设置字体样式
        // 如果该项设置为true，则图像在动画进行中会滤掉对Bitmap图像的优化操作
        // 加快显示速度，本设置项依赖于dither和xfermode的设置
        mPaint.setFilterBitmap(true);
        mPaint.setShadowLayer(20, -20, 10, Color.BLACK);//设置阴影


//        设置MaskFilter，可以用不同的MaskFilter实现滤镜的效果，如滤化，立体等
        // 设置光源的方向
        float[] direction = new float[] { 1, 1, 1 };
        //设置环境光亮度
        float light = 0.4f;
        // 选择要应用的反射等级
        float specular = 6;
        // 向mask应用一定级别的模糊
        float blur = 3.5f;
        EmbossMaskFilter emboss = new EmbossMaskFilter(direction, light, specular, blur);
// 应用mask
        mPaint.setMaskFilter(emboss);

        BlurMaskFilter mBlur = new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID);
        mPaint.setMaskFilter(mBlur);

        Shader mShader = new LinearGradient(0, 0, 100, 100, new int[] { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW }, null, Shader.TileMode.REPEAT);
        mPaint.setShader(mShader);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200,100,100,mPaint);
        canvas.drawText("好嗨哟，this is for you",100,100,mPaint);
        //https://blog.csdn.net/qq_35427437/article/details/80045074
//        canvas.drawArc();
//        canvas.drawOval();
//        canvas.drawBitmap();
//        canvas.drawRect();
    }


}
