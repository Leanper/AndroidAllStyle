
package com.leanper.androidallstyle.activity.loadstate;

import android.app.Activity;
import android.os.Bundle;

import com.leanper.androidallstyle.R;

public class LoadStateActivity extends Activity {
    //TODO 加载样式展示
//    private RecyclerView recyclerView;
//    private List<String> lists = new ArrayList<>();
//    private MainAdapter adapter;
//
//    private String TAG="MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_state);
    }
}
//
//    @Override
//    protected void initStatusLayout() {
//        statusLayoutManager = StateLayoutManager.newBuilder(this)
//                .contentView(R.layout.activity_load_state)
//                .emptyDataView(R.layout.activity_emptydata)
//                .errorView(R.layout.activity_error)
//                .loadingView(R.layout.activity_loading)
//                .netWorkErrorView(R.layout.activity_networkerror)
//                .build();
//    }
//
//    @Override
//    protected void initView() {
//        showLoading();
//        initViewContent();
//        initData();
//        initRecycleView();
//
//    }
//
//    private void initViewContent() {
//        Button btn_empty = (Button) findViewById(R.id.btn_empty);
//        Button btn_error = (Button) findViewById(R.id.btn_error);
//        Button btn_network_error = (Button) findViewById(R.id.btn_network_error);
//        Button btn_test = (Button) findViewById(R.id.btn_test);
//        btn_empty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                initEmptyDataView();
//            }
//        });
//        btn_error.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                initErrorDataView();
//            }
//        });
//        btn_network_error.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                initSettingNetwork();
//                Log.i(TAG, "onClick: ");
//            }
//        });
//        btn_test.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LoadStateActivity.this,TestActivity.class));
//            }
//        });
//    }
//
//    private void initRecycleView() {
//        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        adapter = new MainAdapter(lists,this);
//        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(new HhItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                if(lists.size()>position && position>-1){
//                    Toast.makeText(LoadStateActivity.this,"条目"+position+"被点击呢",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
////        showContent();
//    }
//
//    protected void initData() {
//        lists.clear();
//        for(int a=0 ; a<50 ; a++){
//            lists.add("这是第"+a+"条数据");
//        }
//    }
//
//
//    /**
//     * 点击重新刷新数据
//     */
//    private void initEmptyDataView() {
//        statusLayoutManager.showEmptyData();
//        LinearLayout ll_empty_data = (LinearLayout) findViewById(R.id.ll_empty_data);
//        ll_empty_data.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                initData();
//                adapter.notifyDataSetChanged();
////                showContent();
//            }
//        });
//    }
//
//    /**
//     * 点击重新刷新
//     */
//    private void initErrorDataView() {
//        statusLayoutManager.showError();
//        LinearLayout ll_error_data = (LinearLayout) findViewById(R.id.ll_error_data);
//        ll_error_data.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                initData();
//                adapter.notifyDataSetChanged();
//                showContent();
//            }
//        });
//    }
//
//    /**
//     * 点击设置网络
//     */
//    private void initSettingNetwork() {
//        statusLayoutManager.showNetWorkError();
//        LinearLayout ll_set_network = (LinearLayout) findViewById(R.id.ll_set_network);
//        ll_set_network.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent("android.settings.WIRELESS_SETTINGS");
//                startActivity(intent);
//            }
//        });
//    }
//
//}
