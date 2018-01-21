package com.padcmyanmar.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.delegates.NewsActionDelegate;

import butterknife.OnClick;

/**
 * Created by NB-MM-HQ-MNL on 1/12/2018.
 */

public class SportItemViewHolder extends RecyclerView.ViewHolder {


    private NewsActionDelegate mNewsActionDelegate;


    public SportItemViewHolder(View itemView, NewsActionDelegate mNewActionDelegate) {
        super(itemView);
        mNewsActionDelegate = mNewActionDelegate;

    }

  /*  @OnClick(R.id.sv_sport_news)
    public void onTapSportItem(View v){
        mNewsActionDelegate.onTapNewsItem();
    }
*/


}
