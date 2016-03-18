package com.stone.mvp.viewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stone.mvp.R;

/**
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/3/18 10 22
 */
public class MyAdapterViewer implements IViewer {

    public View mContentView;
    public TextView mTvTitle;

    @Override
    public void init(LayoutInflater inflater, ViewGroup container) {
        mContentView = inflater.inflate(R.layout.myadapter_item, container, container == null ? false : true);
        mTvTitle = getViewById(mContentView, R.id.tv_title);
    }

    @Override
    public View getView() {
        return mContentView;
    }

    private <T> T getViewById(View view, int resid) {
        return (T) view.findViewById(resid);
    }
}
