package com.leanper.androidallstyle.main;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Process;

import org.xutils.x;

public class MyApp extends Application {
    private static  Context mContext;
    private static Handler handler;
    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false); //输出debug日志，开启会影响性能

        mContext = getApplicationContext();

        mContext = getApplicationContext();
        handler = new Handler();//创建Handle
        mainThreadId = Process.myTid();//得到主线程id
    }

    public static Context getContext() {
        return mContext;
    }
    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static Handler getHandler() {
        return handler;
    }

}
