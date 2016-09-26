package com.nxt.moderagricultrue.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.OutPage;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;

import java.util.List;

/**
 * Created by xpeng on 2016/9/17.
 */

public class OutPageAdapter extends ZBaseAdapter<OutPage> {
    public OutPageAdapter(Context context, List<OutPage> dataList) {
        super(context, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_outpage, parent, false);
            holder = new Holder();
            holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);
            holder.tv_02 = (TextView) convertView.findViewById(R.id.tv_02);
            holder.tv_03 = (TextView) convertView.findViewById(R.id.tv_03);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        final OutPage article = dataList.get(position);
        if (!TextUtils.isEmpty(article.getVccultivar()))
            holder.tv_01.setText("发放品种："+article.getVccultivar());
        if (!TextUtils.isEmpty(article.getDtgrant()))
            holder.tv_02.setText("发放时间："+article.getDtgrant().substring(0,10));
        if (!TextUtils.isEmpty(article.getVcreceiver()))
            holder.tv_03.setText("领取人："+article.getVcreceiver());

        return convertView;
    }

    class Holder {
        TextView tv_01, tv_02, tv_03;

    }
}
