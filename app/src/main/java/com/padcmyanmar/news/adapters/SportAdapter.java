package com.padcmyanmar.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.delegates.NewsActionDelegate;
import com.padcmyanmar.news.viewholders.SportItemViewHolder;

/**
 * Created by NB-MM-HQ-MNL on 1/12/2018.
 */

public class SportAdapter extends RecyclerView.Adapter {

    private NewsActionDelegate mNewActionDelegate;

    public SportAdapter(NewsActionDelegate mNewActionDelegate) {
        mNewActionDelegate = mNewActionDelegate;
    }

    @Override
    public SportItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItemView = inflater.inflate(R.layout.item_sports_news, parent, false);
        SportItemViewHolder sportItemViewHolder = new SportItemViewHolder(newsItemView, mNewActionDelegate);
        return sportItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }


}
