package com.stone.mvp;

import android.graphics.Color;

import com.stone.mvp.base.BasePresenterActivity;
import com.stone.mvp.viewer.IViewer;
import com.stone.mvp.viewer.MainViewer;

/**
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/1/31 18 13
 */
public class MainActivity extends BasePresenterActivity<MainViewer> {


    @Override
    protected Class<? extends IViewer> getViewerClass() {
        return MainViewer.class;
    }

    @Override
    protected void onBindView() {
        mViewer.mTvTitle.setTextColor(Color.RED);
        mViewer.mTvTitle.setText("中华人民共和国");
    }
}
