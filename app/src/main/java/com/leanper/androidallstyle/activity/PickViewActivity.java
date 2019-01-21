package com.leanper.androidallstyle.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.leanper.androidallstyle.R;
import com.leanper.androidallstyle.view.PickValueView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PickViewActivity extends AppCompatActivity {

    @BindView(R.id.pick)
    PickValueView pick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_view);
        ButterKnife.bind(this);
        ArrayList<String> data=new ArrayList<>();
        String [] array=new String[10];
        for (int i=0;i<10;i++){
            data.add(i+"个");
            array[i]=data.get(i);
        }
        pick.setValueData(array,3);
    }
}
