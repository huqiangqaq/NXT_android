package com.nxt.moderagricultrue.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.BuyPage;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;

import java.util.List;

/**
 * Created by xpeng on 2016/9/13.
 */

public class BuyPageAdapter extends ZBaseAdapter<BuyPage> {

    public BuyPageAdapter(Context context, List<BuyPage> dataList) {
        super(context, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if (convertView == null) {
        convertView = mLayoutInflater.inflate(R.layout.item_buypage, parent, false);
        holder = new Holder();
        holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);
        holder.tv_02 = (TextView) convertView.findViewById(R.id.tv_02);
        holder.tv_03 = (TextView) convertView.findViewById(R.id.tv_03);
        holder.tv_04 = (TextView) convertView.findViewById(R.id.tv_04);

        convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        final BuyPage article = dataList.get(position);
        if (!TextUtils.isEmpty(article.getVccultivar()))
            holder.tv_01.setText("购买品种："+article.getVccultivar());
        if (!TextUtils.isEmpty(article.getDtbuy()))
            holder.tv_02.setText("购买时间："+article.getDtbuy().substring(0,10));
        if (!TextUtils.isEmpty(article.getVcbuyman()))
            holder.tv_03.setText("购买人："+article.getVcbuyman());
        if (!TextUtils.isEmpty(article.getVcmadecomp()))
            holder.tv_04.setText("生产单位："+article.getVcmadecomp());
        return convertView;
    }

    class Holder {
        TextView tv_01, tv_02, tv_03,tv_04;

    }
}
