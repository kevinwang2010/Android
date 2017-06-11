package com.example.admin.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by admin on 2017/6/10.
 */
public class CustomViewPager extends ViewPager {

    private static final String TAG = CustomViewPager.class.getSimpleName();

    private CustomHorizontalScrollView mCustomHorizontalScrollView;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        if(this.getCurrentItem() == 0 && this.getScrollX() == 0) {
            /**第一页时将事件传递到Scrollview上*/
            if (this.getCurrentItem() == 0 && this.mCustomHorizontalScrollView != null) {
                this.mCustomHorizontalScrollView.onTouchEvent(ev);
            }

            /**当ScrollView没有滑动到最右边时，拦截掉ViewPager的滑动事件*/
            if (!this.mCustomHorizontalScrollView.isScrollright()) {
                return true;
            }
        }

        return super.onTouchEvent(ev);
    }

    public void setScrollView(CustomHorizontalScrollView view){
        this.mCustomHorizontalScrollView = view;
    }
}
