package com.stone.mvp.adapter;

import android.content.Context;

import com.stone.mvp.base.BasePresenterAdapter;
import com.stone.mvp.viewer.MainViewer;
import com.stone.mvp.viewer.MyAdapterViewer;

import java.util.List;

public class MyAdapter extends BasePresenterAdapter<MyAdapterViewer, String> {


    public MyAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected Class<MyAdapterViewer> getViewerClass() {
        return MyAdapterViewer.class;
    }

    @Override
    protected void onBindViewData(MyAdapterViewer viewer, List<String> data, int position) {
        viewer.mTvTitle.setText(data.get(position));
    }

}