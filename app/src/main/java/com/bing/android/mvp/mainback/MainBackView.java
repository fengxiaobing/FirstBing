package com.bing.android.mvp.mainback;


import com.bing.android.mvp.other.BaseView;

public interface MainBackView extends BaseView {

    void getDataSuccess(MainBackModel model);

    void getDataFail(String msg);

}
