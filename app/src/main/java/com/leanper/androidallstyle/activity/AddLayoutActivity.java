package com.leanper.androidallstyle.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.leanper.androidallstyle.R;

import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddLayoutActivity extends AppCompatActivity {

    @BindView(R.id.bt)
    Button bt;
    @BindView(R.id.et1)
    EditText et1;
    @BindView(R.id.et2)
    EditText et2;

    private String TAG = "AddLayoutActivity";
    private Map<String, String> map;
    private Map<String, String> map2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_layout);
        ButterKnife.bind(this);
        map = new LinkedHashMap();
        map2 = new LinkedHashMap();
        et1.addTextChangedListener(new JumpTextWatcher());
        et2.addTextChangedListener(new JumpTextWatcher());

    }

    @OnClick(R.id.bt)
    public void onViewClicked() {
        adadata();
        addLayout();

    }

    private void addLayout() {


    }

    public void adadata() {

        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map2.put("4", "毛4");
        map2.put("3", "map5");


        for (Map.Entry<String, String> entry : map.entrySet()) {
            Log.i(TAG, "Key = " + entry.getKey() + ", Value = " + entry.getValue());
            for (Map.Entry<String, String> entry1 : map2.entrySet()) {
                if (entry.getKey().equals(entry1.getKey())) {
                    map.put(entry1.getKey(), entry1.getValue());
                }
            }
        }
        Log.i(TAG, "Key ========================= ");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            Log.i(TAG, "Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }

    }

    public class JumpTextWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        @Override
        public void afterTextChanged(Editable s) {
            String str=s.toString(); if (str.indexOf("\r")>=0 || str.indexOf("\n")>=0){//发现输入回车符或换行符
                et1.setText(str.replace("\r","").replace("\n",""));//去掉回车符和换行符
                et2.requestFocus();//让editText2获取焦点
                Log.i(TAG,"dddddddddddd");
                et2.setSelection(et2.getText().length());//若editText2有内容就将光标移动到文本末尾
            } } }



}

