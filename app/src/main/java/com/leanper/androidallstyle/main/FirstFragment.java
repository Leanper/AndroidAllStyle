package com.leanper.androidallstyle.main;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leanper.androidallstyle.R;
import com.leanper.androidallstyle.activity.AddLayoutActivity;
import com.leanper.androidallstyle.activity.ChangeIconActivity;
import com.leanper.androidallstyle.activity.LoadState2Activity;
import com.leanper.androidallstyle.activity.SendShortcutActivity;
import com.leanper.androidallstyle.activity.TestaActivity;
import com.leanper.androidallstyle.adapter.CommonAdapter;
import com.leanper.androidallstyle.adapter.DividerItemDecoration;
import com.leanper.androidallstyle.adapter.MultiItemTypeAdapter;
import com.leanper.androidallstyle.adapter.ViewHolder;
import com.leanper.androidallstyle.utils.StatusBarUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Title: ThridFragment
 * @Description:
 * @author: Leanper
 * @date: 2018/12/25 9:39
 */
public class FirstFragment extends Fragment {

    @BindView(R.id.first_rv)
    RecyclerView firstRecyclerView;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;


    private View mFragmentView;
    private Unbinder bind;
    private List mViewList;
    protected boolean useThemestatusBarColor = false;//是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useStatusBarColor = true;//是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        StatusBarUtils.setStatusTextColor(true,getActivity());
        mFragmentView = inflater.inflate(R.layout.fragment_frist, container, false);
        bind = ButterKnife.bind(this, mFragmentView);
        init();
        return mFragmentView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    //初始化页面
    private void init() {
        tvTitle.setText("牛脑梨汁");
        tvTitle.setTextColor(Color.BLACK);
        addData();

        CommonAdapter myAdapter = new CommonAdapter(getActivity(), R.layout.layout_recycler_view_item, mViewList) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                holder.setText(R.id.tv_item, mViewList.get(position).toString());
            }
        };

        firstRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        firstRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        firstRecyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

                Intent intent = null;

                switch (position) {
                    case 0:
                        intent = new Intent(getActivity(), ChangeIconActivity.class);
                        break;
                    case 1:
                        intent = new Intent(getActivity(), SendShortcutActivity.class);

                        break;
                    case 2:
                        intent = new Intent(getActivity(), LoadState2Activity.class);

                        break;
                    case 3:
                        intent = new Intent(getActivity(), AddLayoutActivity.class);
//                        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//                        Ringtone rt = RingtoneManager.getRingtone(getActivity(), uri);
//                        rt.play();

                        break;
                    case 4:
                        intent = new Intent(getActivity(), TestaActivity.class);
//                        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//                        Ringtone rt = RingtoneManager.getRingtone(getActivity(), uri);
//                        rt.play();

                        break;
                    default:
                }
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }

    public void addData() {
        mViewList = new ArrayList();
        mViewList.add("切换App logo");
        mViewList.add("发送桌面快捷");
        mViewList.add("加载状态");
        mViewList.add("懂动态添加布局");
        mViewList.add("不放音乐");

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
