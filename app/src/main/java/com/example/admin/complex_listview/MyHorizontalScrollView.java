package com.example.admin.complex_listview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class MyHorizontalScrollView extends HorizontalScrollView {

	private static final String TAG = MyHorizontalScrollView.class.getSimpleName();

	private float downx,downy;
	
	public MyHorizontalScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public MyHorizontalScrollView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}



	public MyHorizontalScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}



	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			downx = ev.getX();
			downy = ev.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			float movex = ev.getX();
			float movey = ev.getY();

			float x = movex - downx;
			float y = movey - downy;
			if(Math.abs(x) > 0/* && Math.abs(y) < 100*/){
				this.smoothScrollBy(-(int)x, 0);
				downx = movex;
				downy = movey;
			}
			break;
		case MotionEvent.ACTION_UP:
			break;
		}
		//return super.onTouchEvent(ev);
		return false;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.e(TAG,"ACTION_DOWN");
				break;
			case MotionEvent.ACTION_MOVE:
				Log.e(TAG,"ACTION_MOVE");
				break;
			case MotionEvent.ACTION_UP:
				Log.e(TAG,"ACTION_UP");
				break;
		}
		return super.onInterceptTouchEvent(ev);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.e(TAG,"ACTION_DOWN");
				break;
			case MotionEvent.ACTION_MOVE:
				Log.e(TAG,"ACTION_MOVE");
				break;
			case MotionEvent.ACTION_UP:
				Log.e(TAG,"ACTION_UP");
				break;
		}
		return super.dispatchTouchEvent(ev);
	}
}
