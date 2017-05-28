package com.example.admin.complex_listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.admin.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/5/20.
 */
public class HorizontalVerticalListView extends LinearLayout{

    private Context mContext;
    private MyListView lvListview;
    private MyHorizontalScrollView hTitlesScorllview;

    private HVAdapter mHVAdapter;

    private List<Commodity> mDatas = new ArrayList<Commodity>();

    public HorizontalVerticalListView(Context context) {
        this(context,null);
    }

    public HorizontalVerticalListView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public HorizontalVerticalListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater mLayoutInflater = LayoutInflater.from(mContext);
        mLayoutInflater.inflate(R.layout.layout_horizontal_vertical_listview,this);
        findViews();
        initDatas();
    }

    private void findViews() {
        lvListview = (MyListView) findViewById(R.id.lvListview);
        hTitlesScorllview = (MyHorizontalScrollView) findViewById(R.id.hTitlesScorllview);
        lvListview.setHeaderView(hTitlesScorllview);
    }

    private void initDatas() {
        mHVAdapter = new HVAdapter(mContext, mDatas, R.layout.layout_lsitview_item) {
            @Override
            public MyHorizontalScrollView bindScrollTitleView() {
                return hTitlesScorllview;
            }
        };
        lvListview.setAdapter(mHVAdapter);
        mHVAdapter.notifyDataSetChanged();

        lvListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("Test","onItemClick");
                mHVAdapter.setCurrentClickItem(position);
                mHVAdapter.notifyDataSetChanged();
            }
        });
    }

    public void setDatas(List<Commodity> data){
        if(mHVAdapter != null){
            mHVAdapter.setDatas(data);
            mHVAdapter.notifyDataSetChanged();
        }
    }


}
