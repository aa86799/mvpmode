package com.stone.mvp.base;

import android.app.Activity;
import android.os.Bundle;

import com.stone.mvp.viewer.IViewer;

/**
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
