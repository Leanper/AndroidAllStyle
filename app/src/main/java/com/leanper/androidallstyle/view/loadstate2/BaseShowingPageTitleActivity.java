package com.leanper.androidallstyle.view.loadstate2;

import android.os.Bundle;
import android.view.View;

import com.leanper.androidallstyle.base.BaseActivity;
import com.leanper.androidallstyle.utils.NetUtils;


/**
 * Created by 芮靖林
 * on 2017/1/12 09:11.
 */

public abstract class BaseShowingPageTitleActivity extends BaseActivity {

    public ShowingPage showingPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        showingPage = new ShowingPage(this) {
            @Override
            public View setSuccessView() {
                return createSuccessView();
            }

            @Override
            public boolean needTitleView() {
                return isNeedTiele();
            }

        };

        setContentView(showingPage);
        createTitleView(showingPage);

        showingPage.setIOnResetShowingPage(new IOnResetShowingPage() {
            @Override
            public void onReset(View v) {
                onLoad();
            }
        });

        //对网络进行判断
        if (NetUtils.isNoNet()) {
            showCurrentPage(ShowingPage.StateType.STATE_LOAD_ERROR);
        } else {
            onLoad();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    //要求加载数据
    protected abstract void onLoad();

    //设置Title
    protected abstract void createTitleView(ShowingPage showingPage);

    //创建我的成功视图
    protected abstract View createSuccessView();

    public void showCurrentPage(ShowingPage.StateType stateType) {
        //调用showingPage的方法
        if (showingPage != null) {
            showingPage.setCurrentState(stateType);
        }
    }

    public  boolean isNeedTiele(){
        return false;
    }
}
