package com.stone.mvp.viewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 分离View 的接口
 *
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/1/31 18 21
 */
public interface IViewer {
    /**
     * 初始化views
     * @param inflater
     * @param container
     */
    void init(LayoutInflater inflater, ViewGroup container);

    /**
     * 返回整个内容view
     * @return
     */
    View getView();
}
