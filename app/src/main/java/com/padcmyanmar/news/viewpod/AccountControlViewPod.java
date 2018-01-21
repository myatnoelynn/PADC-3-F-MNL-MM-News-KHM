package com.padcmyanmar.news.viewpod;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.models.LoginUserModel;
import com.padcmyanmar.news.delegates.BeforeLoginDelegate;
import com.padcmyanmar.news.delegates.LoginUserDelegate;
import com.padcmyanmar.news.events.SuccessLoginUserEvent;
import com.padcmyanmar.news.events.UserLogoutEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by NB-MM-HQ-MNL on 1/21/2018.
 */

public class AccountControlViewPod extends FrameLayout {

    @BindView(R.id.vp_before_login)
    BeforeLoginViewPod vpBeforeLogin;

    @BindView(R.id.vp_login_user)
    LoginUserViewPod vpLoginUser;

    public AccountControlViewPod(@NonNull Context context) {
        super(context);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public AccountControlViewPod(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public  void setDelegate(BeforeLoginDelegate beforeLoginDelegate){
        vpBeforeLogin.setDelegate(beforeLoginDelegate);
    }

    public void setLoginUserDelegate(LoginUserDelegate loginUserDelegate){
        vpLoginUser.setDelegate(loginUserDelegate);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        refreshUserSession();
        EventBus.getDefault().register(this);
    }

    private void refreshUserSession(){
        if (LoginUserModel.getsObjInstance().isUserLogin()) {
            vpBeforeLogin.setVisibility(View.GONE);
            vpLoginUser.setVisibility(View.VISIBLE);
        } else {
            vpBeforeLogin.setVisibility(View.VISIBLE);
            vpLoginUser.setVisibility(View.GONE);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void loginUserSuccess(SuccessLoginUserEvent event){
        vpBeforeLogin.setVisibility(View.GONE);
        vpLoginUser.setVisibility(View.VISIBLE);

        vpLoginUser.bindData(event.getLoginUser());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public  void onLogoutUser(UserLogoutEvent event){
        vpBeforeLogin.setVisibility(View.VISIBLE);
        vpLoginUser.setVisibility(View.GONE);
    }

}
