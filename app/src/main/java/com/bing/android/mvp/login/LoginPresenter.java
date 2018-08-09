package com.bing.android.mvp.login;

import com.bing.android.mvp.mainback.MainBackModel;
import com.bing.android.mvp.mainback.MainBackView;
import com.bing.android.mvp.other.BasePresenter;
import com.bing.android.retrofit.ApiCallback;


public class LoginPresenter extends BasePresenter<MainBackView> {

    public LoginPresenter(MainBackView view) {
        attachView(view);
    }

    public void loadDataByRetrofitRxjava(String cityId) {
        mvpView.showLoading();
        addSubscription(apiStores.loadDataByRetrofitRxJava(cityId),
                new ApiCallback<MainBackModel>() {
                    @Override
                    public void onSuccess(MainBackModel model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        mvpView.getDataFail(msg);
                    }


                    @Override
                    public void onFinish() {
                        mvpView.hideLoading();
                    }

                });
    }

}
