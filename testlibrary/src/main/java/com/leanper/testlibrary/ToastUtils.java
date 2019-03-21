package com.leanper.testlibrary;

import android.content.Context;
import android.widget.Toast;
public class ToastUtils {

    public static void showToast(Context context, String str) {

        Toast.makeText(context, str, Toast.LENGTH_LONG).show();

    }
}
