package com.stone.mvp;

import android.graphics.Color;

import com.stone.mvp.adapter.MyAdapter;
import com.stone.mvp.base.BasePresenterActivity;
import com.stone.mvp.viewer.IViewer;
import com.stone.mvp.viewer.MainViewer;

import java.util.ArrayList;
import java.util.List;

/**
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/1/31 18 13
 */
public class MainActivity extends BasePresenterActivity<MainViewer> {


    @Override
    protected Class<MainViewer> getViewerClass() {
        return MainViewer.class;
    }

    @Override
    protected void onBindViewData() {
        super.mViewer.mTvTitle.setTextColor(Color.RED);
        super.mViewer.mTvTitle.setText("随便说点啥吧");

        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            datas.add("this is item " + i);
        }
        MyAdapter adapter = new MyAdapter(this, datas);
        super.mViewer.mListView.setAdapter(adapter);
    }
}
