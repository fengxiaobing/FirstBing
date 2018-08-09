package com.bing.android.mvp.login;

import com.bing.android.mvp.mainback.MainBackModel;


public interface LoginView extends BaseView {

    void getDataSuccess(MainBackModel model);

    void getDataFail(String msg);

}
