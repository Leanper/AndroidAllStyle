package com.leanper.androidallstyle.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.leanper.androidallstyle.R;
import com.leanper.androidallstyle.view.loadstate.StateLayoutManager;



public abstract class BaseActivity extends AppCompatActivity {

    protected StateLayoutManager statusLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
//        initStatusLayout();
////        initBaseView();
////        initToolBar();
//        initView();
    }

//    protected abstract void initStatusLayout();
//
//    protected abstract void initView();
//
//    private void initBaseView() {
//        LinearLayout ll_main = (LinearLayout) findViewById(R.id.ll_main);
//        ll_main.addView(statusLayoutManager.getRootLayout());
//    }
//
//
//    /**
//     * 初始化toolbar
//     */
//    private void initToolBar() {
//        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_bar);
//        toolbar.setTitleTextColor(Color.WHITE);
//        toolbar.setTitle("状态切换");
//        toolbar.inflateMenu(R.menu.base_toolbar_menu);
//        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                if(item.getItemId() == R.id.action_contents) {
//                    showContent();
//                }
//                if(item.getItemId() == R.id.action_emptyData) {
//                    showEmptyData();
//                }
//                if(item.getItemId() == R.id.action_error) {
//                    showError();
//                }
//                if(item.getItemId() == R.id.action_networkError) {
//                    showNetWorkError();
//                }
//                if(item.getItemId() == R.id.action_loading) {
//                    showLoading();
//                }
//                return true;
//            }
//        });
//    }
//
//    protected void showContent() {
//        statusLayoutManager.showContent();
//    }
//
//    protected void showEmptyData() {
//        statusLayoutManager.showEmptyData();
//    }
//
//    protected void showError() {
//        statusLayoutManager.showError();
//    }
//
//    protected void showNetWorkError() {
//        statusLayoutManager.showNetWorkError();
//    }
//
//    protected void showLoading() {
//        statusLayoutManager.showLoading();
//    }
}
