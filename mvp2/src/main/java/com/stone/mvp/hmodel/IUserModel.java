package com.stone.mvp.hmodel;

import com.stone.mvp.bean.UserBean;

import java.util.List;

/**
 * 处理UserBean的业务模型接口
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/4/19 18 54
 */
public interface IUserModel {

    /**
     * @return 所有用户
     */
    public List<UserBean> getAllUsers();

    /**
     * 根据年龄排序
     *
     * @return 排序后的用户集合
     */
    public List<UserBean> sortByAge();

    void record(UserBean userBean);
}
