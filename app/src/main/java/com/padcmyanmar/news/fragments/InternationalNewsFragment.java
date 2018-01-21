package com.padcmyanmar.news.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.InternationalNewsAdapter;
import com.padcmyanmar.news.delegates.NewsActionDelegate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NB-MM-HQ-MNL on 1/7/2018.
 */

public class InternationalNewsFragment extends Fragment implements NewsActionDelegate {

    private InternationalNewsAdapter mInternationalAdapter;

    @BindView(R.id.rv_international_news)
    RecyclerView rvInternationalNews;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_international_news, container, false);


        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        rvInternationalNews.setLayoutManager(linearLayoutManager);

        mInternationalAdapter = new InternationalNewsAdapter(this);
        rvInternationalNews.setAdapter(mInternationalAdapter);

        return view;
    }


    @Override
    public void onTapNewsItem() {

    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton() {

    }

    @Override
    public void onTapFavoriteButton() {

    }
}
