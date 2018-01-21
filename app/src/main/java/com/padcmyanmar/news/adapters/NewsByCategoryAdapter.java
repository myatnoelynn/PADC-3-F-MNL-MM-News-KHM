package com.padcmyanmar.news.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.padcmyanmar.news.data.vo.NewsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NB-MM-HQ-MNL on 1/7/2018.
 */

public class NewsByCategoryAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTabTitles;
    private List<NewsVO> mNewsList;

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    public NewsByCategoryAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mTabTitles = new ArrayList<>();
    }

    public void addTab(String tabTitle, Fragment fragment) {
        mTabTitles.add(tabTitle);
        mFragments.add(fragment);
        notifyDataSetChanged();
    }

    public void setNews(List<NewsVO> newsList) {
        mNewsList = newsList;
        notifyDataSetChanged(); // data changes
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position);
    }
}
