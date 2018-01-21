package com.padcmyanmar.news.network;

/**
 * Created by NB-MM-HQ-MNL on 12/23/2017.
 */

public interface NewsDataAgent {

    /**
     * load news from network api.
     */
    void loadNews();


    /**
     * login user.
     * @param phoneNo
     * @param password
     */
    void loginUser(String phoneNo, String password);

}
