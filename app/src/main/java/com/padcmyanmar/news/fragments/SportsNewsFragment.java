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
import android.widget.Toast;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.SportAdapter;
import com.padcmyanmar.news.delegates.NewsActionDelegate;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NB-MM-HQ-MNL on 1/7/2018.
 */

public class SportsNewsFragment extends Fragment implements NewsActionDelegate {

    private SportAdapter mSportAdapter;

    @BindView(R.id.rv_sport)
    RecyclerView rvSport;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sports_news, container, false);

        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true);
        rvSport.setLayoutManager(linearLayoutManager);

        mSportAdapter = new SportAdapter(this);
        rvSport.setAdapter(mSportAdapter);

        return view;
    }

    @Override
    public void onTapNewsItem() {
        Toast.makeText(getContext(), "Sport Items is Tap", Toast.LENGTH_SHORT).show();

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
