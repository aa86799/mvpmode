package com.stone.mvp.hview;

import com.stone.mvp.bean.UserBean;

import java.util.List;

/**
 * 更新User相关的视图 接口
 * <p/>
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/4/19 19 01
 */
public interface IUserView extends IBaseView {

    void showUsers(List<UserBean> users);

}
