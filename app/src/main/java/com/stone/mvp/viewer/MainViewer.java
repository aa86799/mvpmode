package com.stone.mvp.viewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stone.mvp.R;

/**
 * main-acti 用于
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/1/31 18 31
 */
public class MainViewer implements IViewer {

    public View mContentView;
    public TextView mTvTitle;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        mContentView = inflater.inflate(R.layout.acit_main, container, container == null ? false : true);
    }

    @Override
    public View getView() {
        mTvTitle = getViewById(mContentView, R.id.tv_title);
        return mContentView;
    }

    private <T> T getViewById(View view, int resid) {
        return (T) view.findViewById(resid);
    }
}
