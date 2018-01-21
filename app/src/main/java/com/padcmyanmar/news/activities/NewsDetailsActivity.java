package com.padcmyanmar.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.ImagesInNewsDetailsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by User on 12/9/2017.
 */

public class NewsDetailsActivity extends AppCompatActivity {

    @BindView(R.id.tb_for_news_details)
    Toolbar toolbar_details;

    @BindView(R.id.vp_new_details_images)
    ViewPager vp_new_details_images;

    private ImagesInNewsDetailsAdapter imagesInNewsDetailsAdaper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar_details);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        imagesInNewsDetailsAdaper = new ImagesInNewsDetailsAdapter();

        vp_new_details_images.setAdapter(imagesInNewsDetailsAdaper);


    }
}
