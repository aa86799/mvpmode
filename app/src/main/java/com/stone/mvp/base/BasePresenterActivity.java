package com.stone.mvp.base;

import android.app.Activity;
import android.os.Bundle;

import com.stone.mvp.viewer.IViewer;

/**
 * 分离Activity中的 view的初始化和业务逻辑
 * 使用IViewer 来初始化view，acitvity本身来处理业务逻辑
 *
 * 同理还可以分离fragment的  view
 * listvew-BaseAdapter的  getview
 *
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/1/31 18 13
 */
public abstract class BasePresenterActivity<Viewer extends IViewer> extends Activity {

    protected Viewer mViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mViewer = (Viewer) getViewerClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        mViewer.init(getLayoutInflater(), null);

        setContentView(mViewer.getView());

        onBindView();
    }

    protected abstract Class<? extends  IViewer> getViewerClass();

    protected abstract void onBindView();
}
