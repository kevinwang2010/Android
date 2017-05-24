package com.example.admin.fragmentswitch;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.admin.R;

/**
 * Created by admin on 2017/5/13.
 */
public class FragmentHelper {

    private FragmentActivity mContext;
    private int mContainerLayoutId;
    private FragmentManager fragmentManager;

    public FragmentHelper(FragmentActivity context, int layoutId){
        this.mContext = context;
        this.mContainerLayoutId = layoutId;
        this.fragmentManager = mContext.getSupportFragmentManager();
    }

    /**
     * 加载fragment 无切换动画
     * @param fragment
     */
    public void changeFragment(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(mContainerLayoutId, fragment);
        transaction.commit();
    }

    /**
     * 加载fragment 右进左出
     * @param fragment
     */
    public void changeFragment2Right(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_left_out);
        transaction.replace(mContainerLayoutId, fragment);
        transaction.commit();
    }

    /**
     * 加载fragment 左进右出
     * @param fragment
     */
    public void changeFragment2Left(Fragment fragment){
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_left_in,R.anim.slide_right_out);
        transaction.replace(mContainerLayoutId, fragment);
        transaction.commit();
    }
}
