package com.bing.android.mvp.news;


import com.bing.android.mvp.mainback.MainBackModel;
import com.bing.android.mvp.other.BaseView;

public interface NewsView extends BaseView {

    void getDataSuccess(MainBackModel model);

    void getDataFail(String msg);

}
