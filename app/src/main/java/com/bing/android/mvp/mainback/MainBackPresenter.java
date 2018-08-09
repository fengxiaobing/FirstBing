package com.bing.android.mvp.mainback;

import com.bing.android.mvp.other.BasePresenter;
import com.bing.android.retrofit.ApiCallback;


public class MainBackPresenter extends BasePresenter<MainBackView> {

    public MainBackPresenter(MainBackView view) {
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
