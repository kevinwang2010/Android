package com.example.admin.complex_listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Created by admin on 2017/5/24.
 */
public class CustomListView extends ListView {

    private static final String TAG = CustomListView.class.getSimpleName();

    private float downx,downy;
    private MyHorizontalScrollView hTitlesScorllview;

    public CustomListView(Context context) {
        super(context);
    }

    public CustomListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setHeaderScrollView(MyHorizontalScrollView hTitlesScorllview){
        this.hTitlesScorllview = hTitlesScorllview;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(hTitlesScorllview != null){
            hTitlesScorllview.onTouchEvent(ev);
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG,"onInterceptTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"onInterceptTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"onInterceptTouchEvent ACTION_UP");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(hTitlesScorllview != null){
            hTitlesScorllview.onTouchEvent(ev);
        }
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e(TAG,"onTouchEvent ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e(TAG,"onTouchEvent ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e(TAG,"onTouchEvent ACTION_UP");
                break;
        }
        return super.onTouchEvent(ev);
    }
}
