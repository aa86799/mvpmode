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
public abstract class BasePresenterActivity<T extends IViewer> extends Activity {

    protected T mViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mViewer = (T) getViewerClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        mViewer.init(getLayoutInflater(), null);

        setContentView(mViewer.getView());

        onBindViewData();
    }

    /**
     * 抽象方法：由子Activity 决定要使用的IViewer实现类
     * @return 实际的Viewer实现类的Class
     */
    protected abstract Class<T> getViewerClass();


    protected abstract void onBindViewData();
}
