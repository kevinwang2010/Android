package com.example.admin.fragmentswitch;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.R;

/**
 * Created by admin on 2017/5/13.
 */
public class FragmentA extends BaseSupportFragment {

    @Override
    public View createRootView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.fragment_a,null);
    }

    @Override
    public void initViews(View rootView) {
        TextView tv_tips = (TextView) rootView.findViewById(R.id.tv_tips);
        tv_tips.setText("FragmentA");

        rootView.findViewById(R.id.tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA.this.onFragmentCallback(FragmentCallbackMessage.MessageType.FRAGMENT_A);
            }
        });
    }

    @Override
    public void initDatas() {

    }
}
