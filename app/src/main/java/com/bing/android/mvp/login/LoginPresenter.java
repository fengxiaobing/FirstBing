package com.bing.android.mvp.login;

import com.bing.android.mvp.mainback.MainBackModel;
import com.bing.android.mvp.mainback.MainBackView;
import com.bing.android.mvp.other.BasePresenter;
import com.bing.android.retrofit.ApiCallback;


public class LoginPresenter extends BasePresenter<MainBackView> {

    public LoginPresenter(MainBackView view) {
        attachView(view);
    }



}
