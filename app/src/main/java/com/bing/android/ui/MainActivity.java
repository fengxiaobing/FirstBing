package com.bing.android.ui;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bing.android.R;
import com.bing.android.adapter.MainPagerAdapter;
import com.bing.android.widget.MyViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {


    @BindView(R.id.viewpager)
    MyViewPager viewpager;

    @BindView(R.id.rl_home)
    RelativeLayout rl_home;
    @BindView(R.id.rl_diary)
    RelativeLayout rl_diary;
    @BindView(R.id.rl_market)
    RelativeLayout rl_market;
    @BindView(R.id.rl_own)
    RelativeLayout rl_own;

    @BindView(R.id.iv_find)
    ImageView iv_find;
    private long mExitTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        init();
    }

    // 监听手机上的BACK键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // 判断两次点击的时间间隔（默认设置为2秒）
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                toastShow("是否退出应用");
                mExitTime = System.currentTimeMillis();
            } else {
                finish();
                super.onBackPressed();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.rl_home, R.id.rl_diary, R.id.rl_market, R.id.rl_own,R.id.iv_find})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_find:

                break;

            case R.id.rl_home:
                setRadioBtnChecked(view.getId());
                viewpager.setCurrentItem(0);
                initToolBarAsHome("首页");
                break;
            case R.id.rl_diary:
                setRadioBtnChecked(view.getId());
                viewpager.setCurrentItem(1);
                initToolBarAsHome("新闻");
                break;
            case R.id.rl_market:
                setRadioBtnChecked(view.getId());
                viewpager.setCurrentItem(2);
                initToolBarAsHome("商城");
                break;
            case R.id.rl_own:
                setRadioBtnChecked(view.getId());
                viewpager.setCurrentItem(3);
                initToolBarAsHome("个人中心");
                break;
        }
    }
    private void init() {

        FragmentManager fm = getSupportFragmentManager();
        MainPagerAdapter mPagerAdapter = new MainPagerAdapter(fm);
        mPagerAdapter.setCount(4);
        viewpager.setAdapter(mPagerAdapter);
        viewpager.setCurrentItem(0); //设置当前页是第一页

        //默认选中首页
        setRadioBtnChecked(R.id.rl_home);
        initToolBarAsHome("首页");

    }

    private void setRadioBtnChecked(int id) {
        ImageView view = findViewById(R.id.iv_home);
        TextView tv = findViewById(R.id.tv_home);
        tv.setTextColor(Color.parseColor("#666666"));
        view.setBackground(getResources().getDrawable(R.drawable.btn_home));

        ImageView view2 = findViewById(R.id.iv_diary);
        TextView tv2 = findViewById(R.id.tv_diary);
        tv2.setTextColor(Color.parseColor("#666666"));
        view2.setBackground(getResources().getDrawable(R.drawable.btn_diary));

        ImageView view3 = findViewById(R.id.iv_market);
        TextView tv3 = findViewById(R.id.tv_market);
        tv3.setTextColor(Color.parseColor("#666666"));
        view3.setBackground(getResources().getDrawable(R.drawable.btn_market));

        ImageView view4 = findViewById(R.id.iv_own);
        TextView tv4 = findViewById(R.id.tv_own);
        tv4.setTextColor(Color.parseColor("#666666"));
        view4.setBackground(getResources().getDrawable(R.drawable.btn_own));

        switch (id) {
            case R.id.rl_home:
                tv.setTextColor(Color.parseColor("#A75ACC"));
                view.setBackground(getResources().getDrawable(R.drawable.btn_homepress));

                break;
            case R.id.rl_diary:
                tv2.setTextColor(Color.parseColor("#A75ACC"));
                view2.setBackground(getResources().getDrawable(R.drawable.btn_diarypress));
                break;
            case R.id.rl_market:
                tv3.setTextColor(Color.parseColor("#A75ACC"));
                view3.setBackground(getResources().getDrawable(R.drawable.btn_marketpress));
                break;
            case R.id.rl_own:
                tv4.setTextColor(Color.parseColor("#A75ACC"));
                view4.setBackground(getResources().getDrawable(R.drawable.btn_ownpress));
                break;
        }
    }

}
