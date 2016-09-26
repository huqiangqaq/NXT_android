package com.nxt.moderagricultrue.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.Fertilize;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;

import java.util.List;

/**
 * Created by xpeng on 2016/9/17.
 */

public class FertilizeAdapter extends ZBaseAdapter<Fertilize> {
    public FertilizeAdapter(Context context, List<Fertilize> dataList) {
        super(context, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_fertilize, parent, false);
            holder = new Holder();
            holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);
            holder.tv_02 = (TextView) convertView.findViewById(R.id.tv_02);
            holder.tv_03 = (TextView) convertView.findViewById(R.id.tv_03);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        final Fertilize article = dataList.get(position);
        if (!TextUtils.isEmpty(article.getVcparceldesc()))
            holder.tv_01.setText("地块名称："+article.getVcparceldesc());
        if (!TextUtils.isEmpty(article.getDtfertilizedate()))
            holder.tv_02.setText("施肥时间："+article.getDtfertilizedate().substring(0,10));
        if (!TextUtils.isEmpty(article.getVcfertilizerrate()))
            holder.tv_03.setText("肥料配比："+article.getVcfertilizerrate());

        return convertView;
    }

    class Holder {
        TextView tv_01, tv_02, tv_03;

    }
}
