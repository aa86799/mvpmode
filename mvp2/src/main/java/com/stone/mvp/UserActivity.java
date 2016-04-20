package com.stone.mvp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.stone.mvp.bean.UserBean;
import com.stone.mvp.hpresenter.UserPresenter;
import com.stone.mvp.hview.IUserView;

import java.util.List;

/**
 * 以Activity来充当View层的实现
 * Activity中关联Presenter
 * View和Model分离，它们间的交互通过presenter实现
 * <p/>
 * author : stone
 * email  : aa86799@163.com
 * time   : 16/4/20 09 47
 */
public class UserActivity extends Activity implements IUserView, View.OnClickListener,
        AdapterView.OnItemClickListener {

    private UserPresenter mUserPresenter;

    private View mContentView;
    private ListView mListView;
    private UserAdapter mAdapter;
    private Button mBtnSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bindAndInitView(this);//初始化views
        setContentView(getContentView());

        mUserPresenter = new UserPresenter(this);

        mUserPresenter.showUsers(); //展示users 列表

    }

    @Override
    public void showUsers(List<UserBean> users) {
        mAdapter = new UserAdapter(this, users);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void bindAndInitView(Context context) {
        mContentView = LayoutInflater.from(context).inflate(R.layout.acti_user, null);
        mListView = getViewById(R.id.lv_users);
        mBtnSort = getViewById(R.id.btn_sort);

        mBtnSort.setOnClickListener(this);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public View getContentView() {
        return mContentView;
    }

    @Override
    public <T> T getViewById(View view, int resid) {
        return (T) view.findViewById(resid);
    }

    private <T> T getViewById(int resid) {
        return getViewById(getContentView(), resid);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_sort: {
                mUserPresenter.showSortUsers();
            }
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        UserBean user = mAdapter.getItem(position);
        Toast.makeText(this, user.getName() + "__" + user.getAge(), Toast.LENGTH_SHORT).show();
        /*
        如果要增加一个需求，记录点击了哪些item
         */
        mUserPresenter.record(user);

        /*
        当view的操作，同时需要调用model时，那么就要通过presenter 中继
        当前的activity是IView的实现，关联了presenter
         */
    }


    private static class UserAdapter extends BaseAdapter {

        private Context mContext;
        private List<UserBean> mUsers;

        public UserAdapter(Context context, List<UserBean> users) {
            this.mContext = context;
            this.mUsers = users;
        }

        @Override
        public int getCount() {
            return mUsers.size();
        }

        @Override
        public UserBean getItem(int position) {
            return mUsers.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_user, null);
            TextView tvName = (TextView) view.findViewById(R.id.tv_name);
            TextView tvAge = (TextView) view.findViewById(R.id.tv_age);
            tvName.setText(mUsers.get(position).getName());
            tvAge.setText(mUsers.get(position).getAge() + "");
            return view;
        }
    }
}
