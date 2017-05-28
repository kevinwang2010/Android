package com.example.admin.complex_listview;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.R;
import com.example.admin.base.AbstractAdapter;

import java.util.List;

/**
 * Created by admin on 2017/5/28.
 */
public abstract class HVAdapter extends AbsHVAdpter<Commodity> {

    private static final String TAG = HVAdapter.class.getSimpleName();

    private int mSelectItem = 0;

    public HVAdapter(Context context, List<Commodity> data, int layoutOutResId) {
        super(context, data, layoutOutResId);
    }

    @Override
    public abstract MyHorizontalScrollView bindScrollTitleView();

    @Override
    public void bindItemData(final int position, View convertView, BaseViewHolder viewHolder) {
        ViewHolder holder = (ViewHolder) viewHolder;

        Commodity bean = (Commodity) mDatas.get(position);

        holder.tvName.setText(bean.getName());
        holder.tvTitleOne.setText(bean.getTitle1());
        holder.tvTitleTwo.setText(bean.getTitle2());
        holder.tvTitleThree.setText(bean.getTitle3());
        holder.tvTitleFour.setText(bean.getTitle4());
        holder.btTitleFive.setText(bean.getTitle5());

        holder.btTitleFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"tvTitleFive position = " + position + " is click...");
                Toast.makeText(mContext,"position = " + position + " is click...",0).show();
            }
        });

        mMyOnScrollChangeListeners.add(new MyOnScrollChangeListener(holder.scrollview));

        if(mSelectItem == position){
            convertView.setBackgroundColor(Color.parseColor("#33000000"));
        }else{
            convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }

    @Override
    public BaseViewHolder bindViewHolder(View convertView) {
        ViewHolder holder = new ViewHolder();
        holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
        holder.tvTitleOne = (TextView) convertView.findViewById(R.id.tvTitleOne);
        holder.tvTitleTwo = (TextView) convertView.findViewById(R.id.tvTitleTwo);
        holder.tvTitleThree = (TextView) convertView.findViewById(R.id.tvTitleThree);
        holder.tvTitleFour = (TextView) convertView.findViewById(R.id.tvTitleFour);
        holder.btTitleFive = (Button) convertView.findViewById(R.id.btTitleFive);
        holder.scrollview = (MyHorizontalScrollView) convertView.findViewById(R.id.scorllview);
        return holder;
    }

    public void setCurrentClickItem(int position){
        this.mSelectItem = position;
    }

    public class ViewHolder extends BaseViewHolder{
        private TextView tvName;
        private TextView tvTitleOne;
        private TextView tvTitleTwo;
        private TextView tvTitleThree;
        private TextView tvTitleFour;
        private Button btTitleFive;
        private MyHorizontalScrollView scrollview;
    }
}
