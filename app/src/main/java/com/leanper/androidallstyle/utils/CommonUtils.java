package com.leanper.androidallstyle.utils;

import android.content.Context;
import android.widget.Toast;

public class CommonUtils {

    public static void ToastUtils(Context context,String info){
        Toast.makeText(context,info,Toast.LENGTH_LONG).show();
    }

}
