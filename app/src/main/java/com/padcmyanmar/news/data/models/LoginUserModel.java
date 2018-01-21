package com.padcmyanmar.news.data.models;

import com.padcmyanmar.news.data.vo.LoginVO;
import com.padcmyanmar.news.events.SuccessLoginUserEvent;
import com.padcmyanmar.news.events.UserLogoutEvent;
import com.padcmyanmar.news.network.NewsDataAgent;
import com.padcmyanmar.news.network.RetrofitDataAgent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by NB-MM-HQ-MNL on 1/20/2018.
 */

public class LoginUserModel {

    private NewsDataAgent mDataAgent;

    private LoginVO mLoginUser;

    /**
     * Singleton Pattern
     */
    private static LoginUserModel sObjInstance;


    private LoginUserModel() {
        mDataAgent = RetrofitDataAgent.getsObjectInstance();
        EventBus.getDefault().register(this);
    }

    public static LoginUserModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new LoginUserModel();
        }
        return sObjInstance;
    }


    /**
     * login user from network api.
     */
    public void loginUser(String phoneNo, String password) {
        mDataAgent.loginUser(phoneNo, password);
    }

    public boolean isUserLogin() {
        return mLoginUser != null;
    /*    if(mLoginUser==null){
            return false;
        }
        else return true;*/
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onLoginUserEvent(SuccessLoginUserEvent event) {
        mLoginUser = event.getLoginUser();
    }


    public void logout(){
        mLoginUser=null;
        UserLogoutEvent event=new UserLogoutEvent();
        EventBus.getDefault().post(event);
    }

}
