package com.example.admin.complex_listview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/**
 * Created by admin on 2017/5/28.
 */
public class MyListView extends ListView {

    private MyHorizontalScrollView hTitlesScorllview;

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(hTitlesScorllview != null)hTitlesScorllview.touchEvent(ev);
        return super.onTouchEvent(ev);
    }

    /***
     * 设置标题的滚动的View
     * @param scrollTitleView
     */
    public void setHeaderView(MyHorizontalScrollView scrollTitleView){
        this.hTitlesScorllview = scrollTitleView;
    }
}
