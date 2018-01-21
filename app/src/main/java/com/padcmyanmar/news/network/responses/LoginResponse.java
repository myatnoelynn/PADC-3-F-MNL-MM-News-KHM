package com.padcmyanmar.news.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.news.data.vo.LoginVO;

/**
 * Created by NB-MM-HQ-MNL on 1/21/2018.
 */

public class LoginResponse {

    private int code;

    private String message;

    @SerializedName("login_user")
    private LoginVO loginUser;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public LoginVO getLoginUser() {
        return loginUser;
    }
}
