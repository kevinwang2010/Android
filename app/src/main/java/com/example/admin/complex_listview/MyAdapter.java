package com.example.admin.complex_listview;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnScrollChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.R;

public class MyAdapter extends BaseAdapter {

	private static final String TAG = MyAdapter.class.getSimpleName();

	private Context mContext;
	private LayoutInflater mLayoutInflater;
	private List<Commodity> mDatas = new ArrayList<Commodity>();
	private List<MyOnScrollChangeListener> mMyOnScrollChangeListeners = new ArrayList<MyOnScrollChangeListener>();
	private MyHorizontalScrollView mHeadHorizontalScrollView;
	
	private HorizontalScrollView mTounchScrollview;

	private int mScrollX;

	private long downTime;

	private int mSelectItem = 0;
	
	public MyAdapter(Context context){
		this(context, null);
	}
	public MyAdapter(Context context,List<Commodity> mDatas){
		this(context, mDatas, null);
	}
	public MyAdapter(Context context,List<Commodity> mDatas,MyHorizontalScrollView scrollview){
		this.mContext = context;
		this.mLayoutInflater = LayoutInflater.from(context);
		if(mDatas != null){
			this.mDatas.clear();
			this.mDatas.addAll(mDatas);
		}
		this.mHeadHorizontalScrollView = scrollview;

		mHeadHorizontalScrollView.setScrollViewListener(new MyHorizontalScrollView.ScrollViewListener() {

			@Override
			public void onScrollChanged(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
				for(int i=0;i<mMyOnScrollChangeListeners.size();i++){
					if(mTounchScrollview != mMyOnScrollChangeListeners.get(i).getScrollView()){
						mMyOnScrollChangeListeners.get(i).onScrollChange(v, scrollX, scrollY, oldScrollX, oldScrollY);
					}
				}
			}
		});
	}
	
	public void setDatas(List<Commodity> mDatas){
		this.mDatas.clear();
		this.mDatas.addAll(mDatas);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mDatas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//Log.e("Test","adapter position = " + position);
		ViewHolder holder = null;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = mLayoutInflater.inflate(R.layout.layout_lsitview_item, null);
			holder.tvName = (TextView) convertView.findViewById(R.id.tvName);
			holder.tvTitleOne = (TextView) convertView.findViewById(R.id.tvTitleOne);
			holder.tvTitleTwo = (TextView) convertView.findViewById(R.id.tvTitleTwo);
			holder.tvTitleThree = (TextView) convertView.findViewById(R.id.tvTitleThree);
			holder.tvTitleFour = (TextView) convertView.findViewById(R.id.tvTitleFour);
			holder.btTitleFive = (Button) convertView.findViewById(R.id.btTitleFive);
			holder.scrollview = (MyHorizontalScrollView) convertView.findViewById(R.id.scorllview);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		
		Commodity bean = mDatas.get(position);
		
		holder.tvName.setText(bean.getName());
		holder.tvTitleOne.setText(bean.getTitle1());
		holder.tvTitleTwo.setText(bean.getTitle2());
		holder.tvTitleThree.setText(bean.getTitle3());
		holder.tvTitleFour.setText(bean.getTitle4());
		holder.btTitleFive.setText(bean.getTitle5());

		holder.btTitleFive.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.e(TAG,"tvTitleFive position = " + position + " is click...");
				Toast.makeText(mContext,"position = " + position + " is click...",0).show();
			}
		});
		
		mMyOnScrollChangeListeners.add(new MyOnScrollChangeListener(holder.scrollview));
		final MyHorizontalScrollView view = holder.scrollview;
		view.setScrollViewListener(new MyHorizontalScrollView.ScrollViewListener() {

			@Override
			public void onScrollChanged(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
				mTounchScrollview = view;
			}
		});

		if(mSelectItem == position){
			convertView.setBackgroundColor(Color.parseColor("#33000000"));
		}else{
			convertView.setBackgroundColor(Color.parseColor("#FFFFFF"));
		}
		
		return convertView;
	}

	public void setCurrentClickItem(int position){
		this.mSelectItem = position;
	}
	
	class ViewHolder{
		private TextView tvName;
		private TextView tvTitleOne;
		private TextView tvTitleTwo;
		private TextView tvTitleThree;
		private TextView tvTitleFour;
		private Button btTitleFive;
		private MyHorizontalScrollView scrollview;
	}

	/*class MyOnScrollChangeListener{
		private MyHorizontalScrollView view;
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
	}*/

}
