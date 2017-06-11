package com.example.admin.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;

public class CustomHorizontalScrollView extends HorizontalScrollView {

	private static final String TAG = CustomHorizontalScrollView.class.getSimpleName();

	private boolean isScrollLeft = false;
	private boolean isScrollright = false;

	private float downx,downy;

	public CustomHorizontalScrollView(Context context) {
		this(context,null);
	}

	public CustomHorizontalScrollView(Context context, AttributeSet attrs) {
		this(context,attrs,0);
	}

	public CustomHorizontalScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		scrollX2SpecfiyPosition();
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		//return super.onInterceptTouchEvent(ev);
		return false;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		//return super.dispatchTouchEvent(ev);
		return false;
	}

	private void scrollX2SpecfiyPosition(){
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(CustomHorizontalScrollView.this.getChildCount() == 0){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					CustomHorizontalScrollView.this.post(new Runnable() {
						@Override
						public void run() {
							int slideMenuViewWidth = getChildAt(0).getMeasuredWidth()-getMeasuredWidth();
							//Log.e(TAG,"scrollX2SpecfiyPosition slideMenuViewWidth= " + slideMenuViewWidth);
							CustomHorizontalScrollView.this.scrollTo(slideMenuViewWidth,0);
						}
					});
				}

			}
		}).start();
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev){
		int slideMenuViewWidth = getChildAt(0).getMeasuredWidth()-getMeasuredWidth();
		//Log.e(TAG,"onTouchEvent slideMenuViewWidth= " + slideMenuViewWidth);

		switch (ev.getAction()) {
			case MotionEvent.ACTION_DOWN:
				downx = ev.getX();
				break;
			case MotionEvent.ACTION_MOVE:
				break;
			case MotionEvent.ACTION_UP:
				float upx = ev.getX();

				if(upx - downx > 0  && !isScrollright()){
					if(upx - downx >= slideMenuViewWidth/2){
						this.smoothScrollBy(-slideMenuViewWidth,0);
					}else{
						this.smoothScrollBy(slideMenuViewWidth,0);
					}
				}

				if(upx - downx < 0  && !isScrollLeft()){
					if(Math.abs(upx - downx) >= slideMenuViewWidth/2){
						this.smoothScrollBy(slideMenuViewWidth,0);
					}else{
						this.smoothScrollBy(-slideMenuViewWidth,0);
					}
				}
				return true;
		}
		return super.onTouchEvent(ev);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		super.onScrollChanged(l, t, oldl, oldt);
		int maxScrollX = getChildAt(0).getMeasuredWidth()-getMeasuredWidth();
		//Log.e(TAG,"maxScrollX= " + maxScrollX + "   getScrollX()=" + getScrollX());

		//滑到最左
		if (getScrollX() == 0 ) {
			isScrollLeft = true;
		}else if (maxScrollX - getScrollX() >= 0 && maxScrollX - getScrollX() < 20) {  //滑到最右
			isScrollright = true;
		}else {  //滑到中间
			isScrollLeft = false;
			isScrollright = false;
		}
		//Log.e(TAG,"isScrollLeft="+isScrollLeft + "   isScrollright="+isScrollright);
	}

	public boolean isScrollLeft(){
		return isScrollLeft;
	}

	public boolean isScrollright(){
		return isScrollright;
	}
}
