package com.bing.android.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bing.android.R;
import com.bing.android.mvp.mainback.MainBackModel;
import com.bing.android.retrofit.RetrofitCallback;
import com.bing.android.mvp.mainback.MainBackPresenter;
import com.bing.android.mvp.mainback.MainBackView;
import com.bing.android.mvp.other.MvpActivity;
import com.bing.android.retrofit.ApiCallback;

import retrofit2.Call;

/**
 * 由Activity/Fragment实现View里方法，包含一个Presenter的引用
 * Created by WuXiaolong on 2015/9/23.
 * github:https://github.com/WuXiaolong/
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public class MainBackActivity extends MvpActivity<MainBackPresenter> implements MainBackView {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_back);
        text = findViewById(R.id.text);
        initToolBarAsHome(getString(R.string.title));
    }

    @Override
    protected MainBackPresenter createPresenter() {
        return new MainBackPresenter(this);
    }


    @Override
    public void getDataSuccess(MainBackModel model) {
        //接口成功回调
        dataSuccess(model);
    }

    @Override
    public void getDataFail(String msg) {
        toastShow(getString(R.string.net_error));

    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button0:
                loadDataByRetrofit();
                break;
            case R.id.button1:
                loadDataByRetrofitRxJava();
                break;
            case R.id.button2:
                //请求接口
                mvpPresenter.loadDataByRetrofitRxjava("101310222");
                break;
        }
    }

    private void loadDataByRetrofit() {
        showProgressDialog();
        Call<MainBackModel> call = apiStores().loadDataByRetrofit("101190201");
        call.enqueue(new RetrofitCallback<MainBackModel>() {
            @Override
            public void onSuccess(MainBackModel model) {
                dataSuccess(model);
            }

            @Override
            public void onFailure(int code, String msg) {
                toastShow(msg);
            }

            @Override
            public void onThrowable(Throwable t) {
                toastShow(t.getMessage());
            }

            @Override
            public void onFinish() {
                dismissProgressDialog();
            }
        });
        addCalls(call);
    }

    //全国+国外主要城市代码http://mobile.weather.com.cn/js/citylist.xml
    private void loadDataByRetrofitRxJava() {
        showProgressDialog();
        addSubscription(
                apiStores().loadDataByRetrofitRxJava("101220602"),
                new ApiCallback<MainBackModel>() {

                    @Override
                    public void onSuccess(MainBackModel model) {
                        dataSuccess(model);
                    }

                    @Override
                    public void onFailure(String msg) {
                        toastShow(msg);
                    }

                    @Override
                    public void onFinish() {
                        dismissProgressDialog();
                    }
                });
    }

    private void dataSuccess(MainBackModel model) {
        MainBackModel.WeatherinfoBean weatherinfo = model.getWeatherinfo();
        String showData = getResources().getString(R.string.city) + weatherinfo.getCity()
                + getResources().getString(R.string.wd) + weatherinfo.getWD()
                + getResources().getString(R.string.ws) + weatherinfo.getWS()
                + getResources().getString(R.string.time) + weatherinfo.getTime();
        text.setText(showData);
    }
}
