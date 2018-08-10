package com.bing.android.mvp.news;

import com.bing.android.mvp.mainback.MainBackModel;
import com.bing.android.mvp.mainback.MainBackView;
import com.bing.android.mvp.other.BasePresenter;
import com.bing.android.retrofit.ApiCallback;


public class NewsPresenter extends BasePresenter<MainBackView> {

    public NewsPresenter(MainBackView view) {
        attachView(view);
    }


}
