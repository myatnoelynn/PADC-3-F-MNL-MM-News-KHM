package com.padcmyanmar.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.delegates.NewsActionDelegate;
import com.padcmyanmar.news.viewholders.InternationalItemViewHolder;


/**
 * Created by NB-MM-HQ-MNL on 1/13/2018.
 */

public class InternationalNewsAdapter extends RecyclerView.Adapter {

    private NewsActionDelegate mNewActionDelegate;

    public InternationalNewsAdapter(NewsActionDelegate mNewActionDelegate) {
        mNewActionDelegate = mNewActionDelegate;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View newsItemView = inflater.inflate(R.layout.item_international_news, parent, false);
        InternationalItemViewHolder internationalItemViewHolder = new InternationalItemViewHolder(newsItemView, mNewActionDelegate);
        return internationalItemViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
