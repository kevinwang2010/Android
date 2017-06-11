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
public class FragmentB extends BaseSupportFragment {

    @Override
    public int getRootViewLayouResourceId() {
        return R.layout.fragment_b;
    }

    @Override
    public void initViews(View rootView) {
       TextView tv_tips = (TextView) rootView.findViewById(R.id.tv_tips);
        tv_tips.setText("FragmentB");

        rootView.findViewById(R.id.tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentB.this.onFragmentCallback(FragmentCallbackMessage.MessageType.FRAGMENT_B);
            }
        });
    }

    @Override
    public void initDatas() {

    }
}
