package com.padcmyanmar.news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NB-MM-HQ-MNL on 1/21/2018.
 */

public class LoginVO {

    @SerializedName("login_user")
    private String loginUser;

    private int userId;
    private String name;
    private String email;
    private String phoneNo;
    private String profileUrl;
    private String convertUrl;

    public String getLoginUser() {
        return loginUser;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public String getConvertUrl() {
        return convertUrl;
    }
}
