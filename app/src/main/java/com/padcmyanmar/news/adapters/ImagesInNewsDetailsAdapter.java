package com.padcmyanmar.news.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.padcmyanmar.news.R;
import com.padcmyanmar.news.viewitems.ImageInNewsDetailsViewItems;

/**
 * Created by User on 12/10/2017.
 */

public class ImagesInNewsDetailsAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 6;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
       /* if (object instanceof View)
            return true;
        else
            return false;*/

        //return (object instanceof View);

        return (view == (View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ImageInNewsDetailsViewItems view = (ImageInNewsDetailsViewItems)
                layoutInflater.inflate(R.layout.item_new_details_images, container, false);
        container.addView(view); //to show
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
