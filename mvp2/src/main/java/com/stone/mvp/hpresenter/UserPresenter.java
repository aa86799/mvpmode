package com.stone.mvp.hpresenter;

import com.stone.mvp.bean.UserBean;
import com.stone.mvp.hmodel.IUserModel;
import com.stone.mvp.hmodel.UserModel;
import com.stone.mvp.hview.IUserView;

import java.util.List;

/**
 * UserPresenter2 关联User相关的IUserView, IUserModel
 * 依赖
 * Activity不用关心具体的 IUserModel 实现类
 * <p/>
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/4/19 19 08
 */
public class UserPresenter extends BasePresenter<IUserView, IUserModel> {

    public UserPresenter(IUserView userView) {
        initViewAndModel(userView, new UserModel());
    }


    public void showUsers() {
        List<UserBean> users = getModel().getAllUsers();
        super.getView().showUsers(users);
    }

    public void showSortUsers() {
        List<UserBean> users = getModel().sortByAge();
        super.getView().showUsers(users);
    }

    public void record(UserBean userBean) {
        getModel().record(userBean);
    }
}
