package com.bing.android.retrofit;

import com.bing.android.mvp.mainback.MainBackModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by WuXiaolong on 2016/3/24.
 * github:https://github.com/WuXiaolong/
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public interface ApiStores {
    //baseUrl
    String API_SERVER_URL = "http://www.weather.com.cn/";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Call<MainBackModel> loadDataByRetrofit(@Path("cityId") String cityId);

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Observable<MainBackModel> loadDataByRetrofitRxJava(@Path("cityId") String cityId);
}
