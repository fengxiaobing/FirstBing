package com.bing.android.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bing.android.R;
import com.bing.android.mvp.main.MainModel;
import com.bing.android.mvp.other.MvpActivity;
import com.bing.android.mvp.sms.SMSPresenter;
import com.bing.android.mvp.sms.SMSView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.SMSSDK;

public class SMSActivity extends MvpActivity<SMSPresenter> implements SMSView {

    @BindView(R.id.et_phoneNum)
    EditText etPhoneNum;
    @BindView(R.id.tv_send_code)
    Button tvSendCode;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_test_code)
    Button tvTestCode;
   private String phone;
   private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);
        initToolBar("验证码");

    }

    @Override
    protected SMSPresenter createPresenter() {
        return new SMSPresenter(this);
    }

    @Override
    public void getDataSuccess(MainModel model) {

    }

    @Override
    public void getDataFail(String msg) {

    }

    @OnClick({R.id.tv_send_code, R.id.tv_test_code})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_send_code:
                //获取验证码
                phone = etPhoneNum.getText().toString().toString();
                SMSSDK.getVerificationCode("86",phone);
                break;
            case R.id.tv_test_code:
                //提交验证码验证
                SMSSDK.submitVerificationCode("86",phone,number);
                break;
        }
    }
}
