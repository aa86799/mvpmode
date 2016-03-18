package com.stone.mvp.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.stone.mvp.viewer.IViewer;

import java.util.ArrayList;
import java.util.List;

/**
 * 分离Adapter中的 view的初始化和业务逻辑
 * 使用IViewer 来初始化view，Adapter本身来处理业务逻辑
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/3/17 19 51
 */


public abstract class BasePresenterAdapter<T extends IViewer, D> extends BaseAdapter {

    protected List<D> mData;
    protected Context mContext;
    private LayoutInflater mInflater;

    private T mViewer;

    public BasePresenterAdapter(Context context, List<D> data) {
        this.mContext = context;
        this.mData = data == null ? new ArrayList<D>() : data;
        this.mInflater = LayoutInflater.from(context);
        try {
            mViewer = (T) getViewerClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setList(List<D> data) {
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public D getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            mViewer.init(mInflater, null);
            convertView = mViewer.getView();
        }

        onBindViewData(mViewer, mData, position);

        return convertView;
    }

    protected abstract Class<T> getViewerClass();

    protected abstract void onBindViewData(T viewer, List<D> data, int position);

}

