package com.leanper.androidallstyle.view.hencoder;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Title:  PathView 
 
 * @Description:    自定义视图path的描述
 * @author:  Leanper
 * @date:   2019/1/16 14:18   
 
 */  

public class PathView extends View {
    public PathView(Context context) {
        this(context,null);
    }

    public PathView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
