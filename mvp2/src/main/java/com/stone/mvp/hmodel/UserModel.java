package com.stone.mvp.hmodel;

import com.stone.mvp.bean.UserBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/4/19 19 24
 */
public class UserModel implements IUserModel {

    private List<UserBean> mUsers;

    @Override
    public List<UserBean> getAllUsers() {
        /*
        比如从网络、本地DB，获取users
        这里模拟一组user，随机设置年龄值
         */
        UserBean userBean;
        mUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userBean = new UserBean();
            userBean.setName("name" + i);
            userBean.setAge((int) (18 + Math.random() * i));
            mUsers.add(userBean);
        }
        return mUsers;
    }

    @Override
    public List<UserBean> sortByAge() {
        if (mUsers == null) getAllUsers();

        Collections.sort(mUsers, new Comparator<UserBean>() {
            @Override
            public int compare(UserBean lhs, UserBean rhs) {
                int sort = 0;
                if (lhs.getAge() > rhs.getAge()) {
                    sort = 1;
                } else if (lhs.getAge() == rhs.getAge()) {
                    sort = 0;
                } else {
                    sort = -1;
                }
                return sort;
            }
        });
        return mUsers;
    }

    @Override
    public void record(UserBean userBean) {
        /*
        使用database或其他手段，记录
        这里模拟下
         */
        System.out.println("记录到一个被查看的用户：" + userBean.getName());
    }
}
