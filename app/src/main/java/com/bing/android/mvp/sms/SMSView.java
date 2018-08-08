package com.bing.android.mvp.sms;

import com.bing.android.mvp.main.BaseView;
import com.bing.android.mvp.main.MainModel;

/**
 * Created by WuXiaolong on 2015/9/23.
 * 处理业务需要哪些方法
 * github:https://github.com/WuXiaolong/
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public interface SMSView extends BaseView {

    void getDataSuccess(MainModel model);

    void getDataFail(String msg);

}
