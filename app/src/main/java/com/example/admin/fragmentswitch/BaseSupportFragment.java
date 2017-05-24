package com.example.admin.fragmentswitch;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2017/5/13.
 */
public abstract class BaseSupportFragment extends Fragment{
    private static final String TAG = BaseSupportFragment.class.getSimpleName();

    private View mRootView;
    protected OnFragmentCallback mOnFragmentCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG,"onAttach");
        if(context instanceof OnFragmentCallback){
            this.mOnFragmentCallback = (OnFragmentCallback) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        if(mRootView == null){
            mRootView = createRootView(inflater,container);
            initViews(mRootView);
            initDatas();
        }
        ViewGroup parent = (ViewGroup) mRootView.getParent();
        if(parent != null){
            parent.removeView(mRootView);
        }
        return mRootView;
    }

    public abstract View createRootView(LayoutInflater inflater, @Nullable ViewGroup container);
    public abstract void initViews(View rootView);
    public abstract void initDatas();

    /**
     * fragment 回调 activity
     * @param type
     */
    protected void onFragmentCallback(FragmentCallbackMessage.MessageType type){
        if(mOnFragmentCallback == null){
            Log.e(TAG,"Call method onFragmentCallback,but the object mOnFragmentCallback is null ");
            return;
        }
        mOnFragmentCallback.onFragmentCallback(new FragmentCallbackMessage(type));
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG,"onDetach");
    }

    public interface OnFragmentCallback{
       void onFragmentCallback(FragmentCallbackMessage msg);
    }

    public static class FragmentCallbackMessage{

        public enum MessageType{
            FRAGMENT_A,FRAGMENT_B;
        }

        public FragmentCallbackMessage(MessageType type){
            this.setType(type);
        }

        private MessageType type;

        public MessageType getType() {
            return type;
        }

        public void setType(MessageType type) {
            this.type = type;
        }
    }
}
