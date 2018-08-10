package com.bing.android.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bing.android.R;
import com.bing.android.mvp.mainback.MainBackModel;
import com.bing.android.mvp.news.NewsPresenter;
import com.bing.android.mvp.news.NewsView;
import com.bing.android.mvp.other.MvpFragment;
import com.bing.android.ui.BaseFragment;


/**
 * @author RF
 */
public class NewsFragment extends MvpFragment<NewsPresenter> implements NewsView {


    public static NewsFragment newInstance() {
        Bundle args = new Bundle();
        NewsFragment fragment = new NewsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void getDataSuccess(MainBackModel model) {

    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    protected NewsPresenter createPresenter() {
        return null;
    }

}
