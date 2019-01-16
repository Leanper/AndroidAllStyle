package com.leanper.androidallstyle.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.leanper.androidallstyle.R;
import com.leanper.androidallstyle.utils.TitleBuilder;
import com.leanper.androidallstyle.view.loadstate2.BaseShowingPageTitleActivity;
import com.leanper.androidallstyle.view.loadstate2.ShowingPage;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class LoadState2Activity extends BaseShowingPageTitleActivity {

    @BindView(R.id.loading)
    Button loading;
    @BindView(R.id.error)
    Button error;
    @BindView(R.id.finish)
    Button finish;
    @BindView(R.id.nowifi)
    Button nowifi;
    @BindView(R.id.relative)
    RelativeLayout relative;
    private Unbinder bind;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ButterKnife.bind(this);
        showingPage.setTitleLayoutBackgroudCOlor(Color.GREEN);

    }

    @Override
    public boolean isNeedTiele() {
        return true;
    }


    @Override
    protected void onLoad() {
        showingPage.setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);
    }


    @Override
    protected void createTitleView(ShowingPage showingPage) {
        new TitleBuilder(showingPage).setLeftImageRes(R.mipmap.medium_circle_fill).setLeftImageListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        }).setMiddleText("LoadStatus", 0).build();
    }

    @Override
    protected View createSuccessView() {
        view = View.inflate(this, R.layout.activity_load_state2, null);

        return view ;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }

    @OnClick({R.id.loading, R.id.error, R.id.finish, R.id.nowifi, R.id.relative})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loading:
                showingPage.setCurrentState(ShowingPage.StateType.STATE_LOADING);

                break;
            case R.id.error:
                showingPage.setCurrentState(ShowingPage.StateType.STATE_LOAD_ERROR);

                break;
            case R.id.finish:
                showingPage.setCurrentState(ShowingPage.StateType.STATE_LOAD_SUCCESS);

                break;
            case R.id.nowifi:
                showingPage.setCurrentState(ShowingPage.StateType.STATE_LOAD_UNLOAD);

                break;
            case R.id.relative:
                break;
        }
    }
}
