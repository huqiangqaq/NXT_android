package com.nxt.moderagricultrue.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nxt.moderagricultrue.R;
import com.nxt.zyl.util.ZToastUtils;

/**
 * Created by huqiang on 2016/10/8.
 */

public class Fragment_One extends Fragment implements View.OnClickListener {
    private LinearLayout ll_buy,ll_send;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);
        ll_buy = (LinearLayout) view.findViewById(R.id.ll_buy);
        ll_send = (LinearLayout) view.findViewById(R.id.ll_send);
        ll_buy.setOnClickListener(this);
        ll_send.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_buy:
                //生产资料购进
                ZToastUtils.showShort(getActivity(),"生产资料购进");
                break;
            case R.id.ll_send:
                //生产资料发放
                ZToastUtils.showShort(getActivity(),"生产资料发放");
                break;
        }
    }
}
