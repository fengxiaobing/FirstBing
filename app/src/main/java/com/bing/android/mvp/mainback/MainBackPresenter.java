package com.bing.android.mvp.mainback;

import android.content.Context;

import com.bing.android.mvp.other.BasePresenter;
import com.bing.android.retrofit.ApiCallback;
import com.bing.android.widget.SimpleLoadDialog;


public class MainBackPresenter extends BasePresenter<MainBackView> {
    SimpleLoadDialog dialogHandler;
    public MainBackPresenter(MainBackView view,Context context) {
        attachView(view);
        dialogHandler = new SimpleLoadDialog(context,true);
    }

    public void loadDataByRetrofitRxjava(String cityId) {
        if (dialogHandler != null) {
            dialogHandler.show();
        }
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
                        if (dialogHandler != null) {
                            dialogHandler.dismiss();
                            dialogHandler=null;
                        }
                    }
                });
    }

}
