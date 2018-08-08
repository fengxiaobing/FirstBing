package com.bing.android;

import android.app.Application;

import com.mob.MobSDK;

/**
 * Created by RF on 2018/8/8.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this);
    }
}
