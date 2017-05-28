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

    private MyAdapter mMyAdapter;
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
        mMyAdapter = new MyAdapter(mContext,mDatas,hTitlesScorllview);
        lvListview.setAdapter(mMyAdapter);
        mMyAdapter.notifyDataSetChanged();

        lvListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("Test","onItemClick");
                mMyAdapter.setCurrentClickItem(position);
                mMyAdapter.notifyDataSetChanged();
            }
        });
    }

    public void setDatas(List<Commodity> data){
        if(mMyAdapter != null){
            mMyAdapter.setDatas(data);
            mMyAdapter.notifyDataSetChanged();
        }
    }


}
