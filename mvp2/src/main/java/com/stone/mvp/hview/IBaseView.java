package com.stone.mvp.hview;

import android.content.Context;
import android.view.View;

/**
 * 视图层的公共方法
 * <p/>
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/4/19 20 13
 */
public interface IBaseView {

    /**
     * 绑定并初始化View
     *
     * @param context
     */
    void bindAndInitView(Context context);

    /**
     * @return 内容View
     */
    View getContentView();

    /**
     * @param view
     * @param resid
     * @param <T>
     * @return 从view中找到resid对应的组件
     */
    <T> T getViewById(View view, int resid);
}
