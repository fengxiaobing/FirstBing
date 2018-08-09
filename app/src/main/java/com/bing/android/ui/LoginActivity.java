package com.bing.android.ui;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.bing.android.R;
import com.bing.android.mvp.login.LoginPresenter;
import com.bing.android.mvp.login.LoginView;
import com.bing.android.mvp.mainback.MainBackModel;
import com.bing.android.mvp.other.MvpActivity;
import com.bing.android.widget.CustomVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.videoview)
    CustomVideoView videoview;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.tv_find_pwd)
    TextView tvFindPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initToolBarAsHome("登录");
        initView();

    }

    private void initView() {
        videoview.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.aaa));

        //播放
        videoview.start();
        //循环播放
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
    }

    @Override
    protected LoginPresenter createPresenter() {
        return null;
    }

    @Override
    public void getDataSuccess(MainBackModel model) {

    }

    @Override
    public void getDataFail(String msg) {

    }
}
