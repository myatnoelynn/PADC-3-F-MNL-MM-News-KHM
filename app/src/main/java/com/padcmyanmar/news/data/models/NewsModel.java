package com.padcmyanmar.news.data.models;

import com.padcmyanmar.news.network.HttpUrlConnectionDataAgent;
import com.padcmyanmar.news.network.NewsDataAgent;
import com.padcmyanmar.news.network.RetrofitDataAgent;
import com.padcmyanmar.news.network.responses.OKHttpDataAgent;

/**
 * Created by NB-MM-HQ-MNL on 12/23/2017.
 */

public class NewsModel {

    private NewsDataAgent mDataAgent;

    private static NewsModel sObjInstance;

    private NewsModel() {
        //mDataAgent= HttpUrlConnectionDataAgent.getsDataAgent();
        //mDataAgent= OKHttpDataAgent.getsObjInstance();
        mDataAgent = RetrofitDataAgent.getsObjectInstance();
    }

    public static NewsModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new NewsModel();
        }
        return sObjInstance;
    }

    /**
     * Load news from network api.
     */
    public void loadNews() {
        mDataAgent.loadNews();
    }
}
