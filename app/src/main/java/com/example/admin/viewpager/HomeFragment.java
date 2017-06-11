package com.example.admin.viewpager;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.R;
import com.example.admin.fragmentswitch.BaseSupportFragment;

/**
 * Created by admin on 2017/6/10.
 */
public class HomeFragment extends BaseSupportFragment {
    private static final String TAG = HomeFragment.class.getSimpleName();
    private CustomHorizontalScrollView chzScrollView;

    @Override
    public int getRootViewLayouResourceId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews(View rootView) {
        chzScrollView = (CustomHorizontalScrollView) rootView.findViewById(R.id.chzScrollView);
        Activity activity = getActivity();
        if(activity instanceof ViewPagerTestActivity){
            ((ViewPagerTestActivity) activity).setScrollView(chzScrollView);
        }
    }

    @Override
    public void initDatas() {

    }

}
