package com.padcmyanmar.news.network;

import com.padcmyanmar.news.network.responses.GetNewsResponse;
import com.padcmyanmar.news.network.responses.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by NB-MM-HQ-MNL on 1/7/2018.
 */

public interface NewsApi {

    @FormUrlEncoded // form data
    @POST("getMMNews.php")
    Call<GetNewsResponse> loadNews(@Field("page") int page,
                                   @Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("login.php")
    Call<LoginResponse> loginUser(@Field("phoneNo") String phoneNo,
                                  @Field("password") String password);


}
