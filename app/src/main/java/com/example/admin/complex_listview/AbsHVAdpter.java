package com.example.admin.complex_listview;

import android.content.Context;
import android.view.View;

import com.example.admin.base.AbstractAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/28.
 */
public abstract class AbsHVAdpter<T> extends AbstractAdapter {

    private MyHorizontalScrollView scrollTitleView;
    protected List<MyOnScrollChangeListener> mMyOnScrollChangeListeners = new ArrayList<MyOnScrollChangeListener>();

    public AbsHVAdpter(Context context, List<T> data, int layoutOutResId) {
        super(context, data, layoutOutResId);
        this.scrollTitleView = bindScrollTitleView();
        if(this.scrollTitleView == null)new IllegalStateException("The scrollTitleView can not be null");
        initScrollTitleViewListener();
    }

    private  void initScrollTitleViewListener(){
        scrollTitleView.setScrollViewListener(new MyHorizontalScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                for(int i=0;i<mMyOnScrollChangeListeners.size();i++){
                    mMyOnScrollChangeListeners.get(i).onScrollChange(v, scrollX, scrollY, oldScrollX, oldScrollY);
                }
            }
        });
    }

    public abstract MyHorizontalScrollView bindScrollTitleView();

    @Override
    public abstract void bindItemData(int position, View convertView, BaseViewHolder viewHolder);

    @Override
    public abstract BaseViewHolder bindViewHolder(View convertView);
}
