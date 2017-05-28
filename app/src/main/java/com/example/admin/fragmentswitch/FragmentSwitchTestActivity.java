package com.example.admin.fragmentswitch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.R;

public class FragmentSwitchTestActivity extends AppCompatActivity implements BaseSupportFragment.OnFragmentCallback {
	private BaseSupportFragment fragmentA;
	private BaseSupportFragment fragmentB;
	private FragmentHelper mFragmentHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fragment_switch_test);

		getSupportActionBar().hide();

		fragmentA = new FragmentA();
		fragmentB = new FragmentB();

		mFragmentHelper = new FragmentHelper(this, R.id.rlFragmentContainer);

		mFragmentHelper.changeFragment(fragmentA);
	}

	@Override
	public void onFragmentCallback(BaseSupportFragment.FragmentCallbackMessage msg) {
		if(msg.getType() == BaseSupportFragment.FragmentCallbackMessage.MessageType.FRAGMENT_A){
			mFragmentHelper.changeFragment2Right(fragmentB);
		}else if(msg.getType() == BaseSupportFragment.FragmentCallbackMessage.MessageType.FRAGMENT_B){
			mFragmentHelper.changeFragment2Left(fragmentA);
		}
	}

}
