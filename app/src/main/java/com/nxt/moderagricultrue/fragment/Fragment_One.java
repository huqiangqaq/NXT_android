package com.nxt.moderagricultrue.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nxt.moderagricultrue.LoginActivity;
import com.nxt.moderagricultrue.R;
import com.nxt.zyl.util.ZToastUtils;

/**
 * Created by huqiang on 2016/10/8.
 */

public class Fragment_One extends Fragment implements View.OnClickListener {
    private LinearLayout ll_buy, ll_send;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x123:
                    ll_buy.setBackgroundResource(R.drawable.bg_update_01);
                    break;
                case 0x124:
                    ll_send.setBackgroundResource(R.drawable.bg_update_02);
                    break;
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        ll_buy = (LinearLayout) view.findViewById(R.id.ll_buy);
        ll_send = (LinearLayout) view.findViewById(R.id.ll_send);
        ll_buy.setOnClickListener(this);
        ll_send.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_buy:
                ll_buy.setBackgroundColor(getResources().getColor(R.color.doctor_main_color));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x123);
                    }
                }, 1000);
                startActivity(new Intent(getActivity(), LoginActivity.class));
                //生产资料购进
                ZToastUtils.showShort(getActivity(), "生产资料购进");
                break;
            case R.id.ll_send:
                ll_send.setBackgroundColor(getResources().getColor(R.color.doctor_main_color));
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x124);
                    }
                }, 1000);
                //生产资料发放
                ZToastUtils.showShort(getActivity(), "生产资料发放");
                break;
        }
    }
}
