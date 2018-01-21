package com.padcmyanmar.news.data.vo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NB-MM-HQ-MNL on 1/21/2018.
 */

public class RegisterVO {

    @SerializedName("login_user")
    private String loginUser;

    private int userId;
    private String name;
    private String email;
    private String phoneNo;
    private String profileUrl;
    private String convertUrl;
}
