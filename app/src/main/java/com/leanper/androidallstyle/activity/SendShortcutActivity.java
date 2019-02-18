package com.leanper.androidallstyle.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.leanper.androidallstyle.R;

public class SendShortcutActivity extends AppCompatActivity {

    private static final int RC_CREATE_SHORTCUT = 11;

    //TODO 创建桌面快捷方式
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_shortcut);
        findViewById(R.id.button3s).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addShortCut();
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteShortCut(SendShortcutActivity.this);
            }
        });
    }

    public void addShortCut(){
        // 安装的Intent
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        // 快捷名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, "mm");
        // 快捷图标是否允许重复
        shortcut.putExtra("duplicate", false);
        Intent shortcutIntent = new Intent(Intent.ACTION_MAIN);
        shortcutIntent.putExtra("参数名", "参数值");
        //可以不传com.leanper.androidallstyle
        shortcutIntent.setClassName(getPackageName(), ".activity.SendShortcutActivity");
        shortcutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        // 快捷图标 TODO 图标处理 将网络图片下载并创建快捷方式图标
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(SendShortcutActivity.this, R.mipmap.icon_three);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
        // 发送广播
        sendBroadcast(shortcut);

    }

    //删除快捷方式
    private void deleteShortCut(Context mContext) {
        Intent intent = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT" );
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "mm");
        // 要删除的应用程序的ComponentName，即应用程序包名+activity的名字
        ComponentName comp = new ComponentName("com.leanper.androidallstyle",
                "com.leanper.androidallstyle.activity.SendShortcutActivity");
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent()
                .setComponent(comp).setAction("android.intent.action.MAIN"));
        sendBroadcast(intent);

    }


}
