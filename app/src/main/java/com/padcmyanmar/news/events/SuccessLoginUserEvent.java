package com.padcmyanmar.news.events;

import com.padcmyanmar.news.data.vo.LoginVO;

/**
 * Created by NB-MM-HQ-MNL on 1/20/2018.
 */

public class SuccessLoginUserEvent {

    private LoginVO loginUser;

    public SuccessLoginUserEvent(LoginVO loginUser) {
        this.loginUser = loginUser;
    }

    public LoginVO getLoginUser() {
        return loginUser;
    }
}
