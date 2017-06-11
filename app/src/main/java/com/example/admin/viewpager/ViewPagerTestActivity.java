package com.example.admin.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerTestActivity extends AppCompatActivity {

	private List<Fragment> fragments = new ArrayList<>();
	private CustomViewPager vp;
	private MyViewPagerAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager_test);

		getSupportActionBar().hide();

		initViews();
	}

	private void initViews() {
		vp = (CustomViewPager) findViewById(R.id.vp);
		HomeFragment homeFragment = new HomeFragment();
		SecondFragment secondFragment = new SecondFragment();
		ThirdFragment thirdFragment = new ThirdFragment();
		fragments.add(homeFragment);
		fragments.add(secondFragment);
		fragments.add(thirdFragment);
		adapter = new MyViewPagerAdapter(getSupportFragmentManager(),fragments);
		vp.setAdapter(adapter);
	}

	public void setScrollView(CustomHorizontalScrollView view){
		if(vp != null){
			vp.setScrollView(view);
		}
	}


}
