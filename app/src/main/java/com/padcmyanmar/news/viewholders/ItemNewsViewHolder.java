package com.padcmyanmar.news.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.NewsVO;
import com.padcmyanmar.news.delegates.NewsActionDelegate;

import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by User on 12/3/2017.
 */


public class ItemNewsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_publication_title)
    TextView tvPublicationTitle;

    @BindView(R.id.tv_posted_date)
    TextView tvPostedDate;

    @BindView(R.id.tv_news_brief)
    TextView tvNewsBrief;

    @BindView(R.id.iv_publication_logo)
    ImageView ivPublicationLogo;

    @BindView(R.id.iv_news)
    ImageView ivNews;

    public NewsActionDelegate mNewsActionDelegate;

    public ItemNewsViewHolder(View v, NewsActionDelegate newsActionDelegate) {
        super(v);
        ButterKnife.bind(this, itemView);

        mNewsActionDelegate = newsActionDelegate;
    }

    @OnClick(R.id.cv_news_item_root)
    public void onTapNewItem(View v) {
        mNewsActionDelegate.onTapNewsItem();
    }

    @OnClick(R.id.btn_comment)
    public void onTapCommentButton(View v) {
        mNewsActionDelegate.onTapCommentButton();
    }

    public void setNews(NewsVO newsVO) {
        tvPublicationTitle.setText(newsVO.getPublication().getTitle());
        tvPostedDate.setText(newsVO.getPostedDate());
        tvNewsBrief.setText(newsVO.getBrief());


        Glide.with(ivPublicationLogo.getContext())
                .load(newsVO.getPublication().getLogo())
                .into(ivPublicationLogo);


        if (newsVO.getImages() != null) {
            ivNews.setVisibility(View.VISIBLE);
            Glide.with(ivNews.getContext())
                    .load(newsVO.getImages().get(0))
                    .into(ivNews);
        } else {
            ivNews.setVisibility(View.GONE);
        }

    }


}
