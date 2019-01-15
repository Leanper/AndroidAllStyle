package com.leanper.androidallstyle.utils;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;

import com.leanper.androidallstyle.main.MyApp;

public class CommonUtils {

    public static Context getContext() {
        return MyApp.getContext();
    }


    public static void ToastUtils(Context context,String info){
        Toast.makeText(context,info,Toast.LENGTH_LONG).show();
    }

    // 获取资源文件夹操作
    public static Resources getResources() {
        return getContext().getResources();
    }

    public static void runOnUIThread(Runnable runable) {
        //先判断当前属于子线程主线程
        if (android.os.Process.myTid() == MyApp.getMainThreadId()) {
            runable.run();
        } else {
            //子线程
            MyApp.getHandler().post(runable);
        }
    }

}
