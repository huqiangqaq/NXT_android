package com.nxt.zyl.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.data.volley.toolbox.HttpCallback;

/**
 * Fragment基类,实现onCreateView方法
 * 使用时须在onAttach()中设置layoutResId,并在initView()中初始化控件
 *
 * @author koneloong koneloong@gmail.com
 *         Created on 2015/8/6 10:53.
 * @version 1.0
 * @since 1.0
 */
public abstract class ZBaseFragment extends Fragment implements View.OnClickListener,HttpCallback{
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        if (mView != null) {
            ViewGroup parent = (ViewGroup) mView.getParent();
            if (parent != null) {
                parent.removeView(mView);
            }
        } else {
            mView = inflater.inflate(getLayoutId(), container, false);
            initView(mView);
        }
        return mView;
    }


    /**
     * 初始化界面
     *
     * @since 1.0
     */
    protected abstract void initView(View view);

    /**
     * @return 布局文件资源ID
     * @since 1.0
     */
    protected abstract int getLayoutId();

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onRequestStart() {
        //Here's nothing
    }

    @Override
    public void onRequestFinish() {
        //Here's nothing
    }

    @Override
    public void onRequestResult(String string) {
        //Here's nothing
    }

    @Override
    public void onRequestError(Exception e) {
        //Here's nothing
    }

    @Override
    public void onRequestCancelled() {
        //Here's nothing
    }

    @Override
    public void onRequestLoading(long count, long current) {
        //Here's nothing
    }
}
