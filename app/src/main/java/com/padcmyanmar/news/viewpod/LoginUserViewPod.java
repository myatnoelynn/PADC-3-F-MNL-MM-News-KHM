package com.padcmyanmar.news.viewpod;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.data.vo.LoginVO;
import com.padcmyanmar.news.delegates.LoginUserDelegate;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by NB-MM-HQ-MNL on 1/14/2018.
 */

public class LoginUserViewPod extends RelativeLayout {

    private LoginUserDelegate mDelegate;

    public void setDelegate(LoginUserDelegate loginUserDelegate){
        mDelegate=loginUserDelegate;
    }

    public LoginUserViewPod(Context context) {
        super(context);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ButterKnife.bind(this,this);
    }

    public void bindData(LoginVO loginUser){
        String email=loginUser.getEmail().toString();
        String name=loginUser.getName().toString();
        String phoneNo=loginUser.getPhoneNo().toString();
        int userId=loginUser.getUserId();
    }

    @OnClick(R.id.btn_logout)
    public void onTapLogout(View view){
        mDelegate.onTapLogout();
    }
}
