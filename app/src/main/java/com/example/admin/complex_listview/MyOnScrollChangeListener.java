package com.example.admin.complex_listview;

import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Created by admin on 2017/5/28.
 */
public class MyOnScrollChangeListener {
    private MyHorizontalScrollView view;
    private int mScrollX;
    public MyOnScrollChangeListener(MyHorizontalScrollView view){
        this.view = view;
    }
    public void onScrollChange(View v, int scrollX, int scrollY,
                               int oldScrollX, int oldScrollY){
        mScrollX = scrollX;
        view.smoothScrollTo(scrollX, 0);
    }
    public HorizontalScrollView getScrollView(){
        return view;
    }
}
