package com.bing.android.mvp.sms;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.bing.android.mvp.other.BasePresenter;

import org.json.JSONException;
import org.json.JSONObject;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


public class SMSPresenter extends BasePresenter<SMSView> {

    public SMSPresenter(SMSView view) {
        attachView(view);
        SMSSDK.registerEventHandler(handler);
    }

    EventHandler handler = new EventHandler(){
        @Override
        public void afterEvent(int event, int result, Object data) {

            if (result == SMSSDK.RESULT_COMPLETE){
                //回调完成
                switch (event) {
                    case SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE:
                        //提交验证码成功（异步）
                        Log.e("SMS","提交验证码成功");
                        break;
                    case SMSSDK.EVENT_GET_VOICE_VERIFICATION_CODE:
                        //语音验证发送（异步）
                        Log.e("SMS","语音验证发送");
                        break;
                    case SMSSDK.EVENT_GET_VERIFICATION_CODE:
                        //获取验证码成功（异步）
                        Log.e("SMS","获取验证码成功");
                        break;
                    case SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES:
                        Log.i("test", "test");

                        break;
                        default:
                            break;
                }
            }else{
                ((Throwable)data).printStackTrace();
                Throwable throwable = (Throwable) data;
                throwable.printStackTrace();
                Log.i("1234",throwable.toString());
                try {
                    JSONObject obj = new JSONObject(throwable.getMessage());
                    final String des = obj.optString("detail");
                    if (!TextUtils.isEmpty(des)){
                      // 异步
                        Log.e("SMS","内容"+des);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }
    };

}
