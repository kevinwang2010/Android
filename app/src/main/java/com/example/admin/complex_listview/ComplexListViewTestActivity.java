package com.example.admin.complex_listview;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HorizontalScrollView;
import android.widget.ListView;

import com.example.admin.R;

public class ComplexListViewTestActivity extends Activity {
	
	private List<Commodity> mDatas = new ArrayList<Commodity>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_complex_test);

		HorizontalVerticalListView hvListView = (HorizontalVerticalListView) findViewById(R.id.hvListView);
		createDatas();
		hvListView.setDatas(mDatas);

	}

	private void createDatas(){
		for(int i=0;i<100;i++){
			Commodity bean = new Commodity();
			bean.setName("name"+i);
			bean.setTitle1("title 1 "+i);
			bean.setTitle2("title 2 "+i);
			bean.setTitle3("title 3 "+i);
			bean.setTitle4("title 4 "+i);
			bean.setTitle5("title 5 "+i);
			mDatas.add(bean);
		}
	}

}
