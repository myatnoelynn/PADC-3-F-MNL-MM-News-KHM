package com.padcmyanmar.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.delegates.NewsActionDelegate;

import butterknife.OnClick;

/**
 * Created by NB-MM-HQ-MNL on 1/13/2018.
 */

public class InternationalItemViewHolder extends RecyclerView.ViewHolder {

    private NewsActionDelegate mNewsActionDelegate;

    public InternationalItemViewHolder(View itemView, NewsActionDelegate mNewsActionDelegate) {
        super(itemView);
        mNewsActionDelegate = mNewsActionDelegate;
    }

    @OnClick(R.id.sv_sport_news)
    public void onTapSportItem(View v) {
        mNewsActionDelegate.onTapNewsItem();
    }
}
