package com.example.admin.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by admin on 2017/5/2.
 */
public abstract class AbstractAdapter<T> extends BaseAdapter{

    protected Context mContext;
    private LayoutInflater inflater;
    protected List<T> mDatas;
    private int layoutOutResId;

    public AbstractAdapter(Context context, List<T> data,int layoutOutResId){
        this.mContext = context;
        this.inflater = context == null ? null : LayoutInflater.from(context);
        this.mDatas = data;
        this.layoutOutResId = layoutOutResId;
    }

    public void setDatas(List<T> data){
        this.mDatas = data;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas == null ? null : mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder viewHolder = null;
        if(convertView == null){
            convertView = this.inflater.inflate(this.layoutOutResId,null);
            if(convertView == null){
                throw new RuntimeException("convertView inflate can not be null");
            }
            viewHolder = bindViewHolder(convertView);
            if(viewHolder == null){
                throw new RuntimeException("Object viewhodler can not be null");
            }
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (BaseViewHolder) convertView.getTag();
        }

        bindItemData(position,convertView,viewHolder);

        return convertView;
    }

    public abstract void bindItemData(int position, View convertView,BaseViewHolder viewHolder);

    public abstract BaseViewHolder bindViewHolder(View convertView);

    public static class BaseViewHolder{

    }
}
