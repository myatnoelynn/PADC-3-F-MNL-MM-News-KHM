package com.padcmyanmar.news.viewitems;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by User on 12/10/2017.
 */

public class ImageInNewsDetailsViewItems extends FrameLayout { //extend framelayout because the root component of layout file is FrameLayout

    public ImageInNewsDetailsViewItems(@NonNull Context context) {
        super(context);
    }

    public ImageInNewsDetailsViewItems(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageInNewsDetailsViewItems(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
