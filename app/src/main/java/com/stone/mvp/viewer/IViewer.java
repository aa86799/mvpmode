package com.stone.mvp.viewer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/1/31 18 21
 */
public interface IViewer {

    void init(LayoutInflater inflater, ViewGroup container);

    View getView();
}
