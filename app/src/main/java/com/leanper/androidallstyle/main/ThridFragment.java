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
import com.leanper.androidallstyle.activity.loadstate.LoadStateActivity;
import com.leanper.androidallstyle.adapter.CommonAdapter;
import com.leanper.androidallstyle.adapter.DividerItemDecoration;
import com.leanper.androidallstyle.adapter.MultiItemTypeAdapter;
import com.leanper.androidallstyle.adapter.ViewHolder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Title: ThridFragment
 * @Description:
 * @author: Leanper
 * @date: 2018/12/25 9:48
 */
public class ThridFragment extends Fragment {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar_main)
    Toolbar toolbarMain;
    @BindView(R.id.viewrecyclerview)
    RecyclerView viewrecyclerview;
    private View mFragmentView;
    private Unbinder bind;

    /**
     * 各种视图的名称集合
     */
    ArrayList<String> mViewList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentView = inflater.inflate(R.layout.fragment_three, container, false);
        bind = ButterKnife.bind(this, mFragmentView);
        init();
        return mFragmentView;
    }



    //初始化页面
    private void init() {
        tvTitle.setText("自定义视图");
        tvTitle.setTextColor(Color.BLACK);
        addData();

        CommonAdapter myAdapter = new CommonAdapter(getActivity(), R.layout.layout_recycler_view_item, mViewList) {
            @Override
            protected void convert(ViewHolder holder, Object o, int position) {
                holder.setText(R.id.tv_item, mViewList.get(position));
            }
        };

        viewrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        viewrecyclerview.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));
        viewrecyclerview.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {

                Intent intent=null;

                switch (position){
                    case 0:
                         intent=new Intent(getActivity(),LoadStateActivity.class);

                        break;
                    case 2:
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
        mViewList.add("数据加载状态");
        mViewList.add("sas");
        mViewList.add("sas");
        mViewList.add("ss");
        mViewList.add("sas");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
