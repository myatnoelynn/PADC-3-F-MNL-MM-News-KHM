package com.padcmyanmar.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;


import com.padcmyanmar.news.MMNewsApp;
import com.padcmyanmar.news.R;
import com.padcmyanmar.news.adapters.NewsByCategoryAdapter;
import com.padcmyanmar.news.data.models.NewsModel;
import com.padcmyanmar.news.events.LoadedNewsEvent;
import com.padcmyanmar.news.fragments.InternationalNewsFragment;
import com.padcmyanmar.news.fragments.NewsByCategoryFragment;
import com.padcmyanmar.news.fragments.SportsNewsFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NB-MM-HQ-MNL on 1/7/2018.
 */

public class NewsByCategoryActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_by_category)
    ViewPager vpNewsByCategory;

    @BindView(R.id.tb_news_by_category)
    TabLayout tbNewsByCategory;

    private NewsByCategoryAdapter mNewsByCategoryAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_by_category);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar); //Support Lib component

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_news_by_category);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        mNewsByCategoryAdapter = new NewsByCategoryAdapter(getSupportFragmentManager());

        vpNewsByCategory.setAdapter(mNewsByCategoryAdapter);

        mNewsByCategoryAdapter.addTab("Local News", new NewsByCategoryFragment());
        mNewsByCategoryAdapter.addTab("International News", new InternationalNewsFragment());
        mNewsByCategoryAdapter.addTab("Sport News", new SportsNewsFragment());

        tbNewsByCategory.setupWithViewPager(vpNewsByCategory);

        vpNewsByCategory.setOffscreenPageLimit(mNewsByCategoryAdapter.getCount());

    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, NewsByCategoryActivity.class);
        return intent;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }


}
