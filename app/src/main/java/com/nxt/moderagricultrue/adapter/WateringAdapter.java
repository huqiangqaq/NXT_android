package com.nxt.moderagricultrue.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.Watering;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;

import java.util.List;

/**
 * Created by xpeng on 2016/9/17.
 */

public class WateringAdapter extends ZBaseAdapter<Watering> {
    public WateringAdapter(Context context, List<Watering> dataList) {
        super(context, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_watering, parent, false);
            holder = new Holder();
            holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);
            holder.tv_02 = (TextView) convertView.findViewById(R.id.tv_02);
            holder.tv_03 = (TextView) convertView.findViewById(R.id.tv_03);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        final Watering article = dataList.get(position);
        if (!TextUtils.isEmpty(article.getVcparceldesc()))
            holder.tv_01.setText("地块名称："+article.getVcparceldesc());
        if (!TextUtils.isEmpty(article.getDtirrigatedate()))
            holder.tv_02.setText("灌溉时间："+article.getDtirrigatedate().substring(0,10));
        if (!TextUtils.isEmpty(article.getFwastewater()))
            holder.tv_03.setText("用水量："+article.getFwastewater());

        return convertView;
    }

    class Holder {
        TextView tv_01, tv_02, tv_03;

    }
}
