package com.stone.mvp.hpresenter;

/**
 * Presenter 基类：以泛型绑定相关的view层和model层
 * activity或fragment 等 交互层的业务逻辑层，由Presenter处理
 * <p/>
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/4/19 19 00
 */
public abstract class BasePresenter<V, M> {

    private V mView;
    private M mModel;

    public BasePresenter() {

    }

    public void initViewAndModel(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }

    protected M getModel() {
        return mModel;
    }

    protected V getView() {
        return mView;
    }

}
