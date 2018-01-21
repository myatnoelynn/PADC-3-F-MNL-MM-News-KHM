package com.padcmyanmar.news.viewpod;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.delegates.BeforeLoginDelegate;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by NB-MM-HQ-MNL on 1/20/2018.
 */

public class BeforeLoginViewPod extends RelativeLayout {

    private BeforeLoginDelegate mDelegate;

    public BeforeLoginViewPod(Context context) {
        super(context);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
    }


    public void setDelegate(BeforeLoginDelegate mDelegate) {
        this.mDelegate = mDelegate;
    }

    @OnClick(R.id.btn_login)
    public void onTapLogin(View view) {
        mDelegate.onTapToLogin();

    }

    @OnClick(R.id.btn_register)
    public void onTapRegister(View view) {
        mDelegate.onTapToRegister();
    }

}
