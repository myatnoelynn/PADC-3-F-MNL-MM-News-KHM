package com.padcmyanmar.news.events;

import com.padcmyanmar.news.data.vo.NewsVO;

import java.util.List;

/**
 * Created by NB-MM-HQ-MNL on 12/24/2017.
 */

public class LoadedNewsEvent {

    private List<NewsVO> newsVOList;

    public LoadedNewsEvent(List<NewsVO> newsVOList) {
        this.newsVOList = newsVOList;
    }

    public List<NewsVO> getNewsVOList() {
        return newsVOList;
    }
}
