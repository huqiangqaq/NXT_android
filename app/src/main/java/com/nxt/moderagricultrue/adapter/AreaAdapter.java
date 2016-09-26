package com.nxt.moderagricultrue.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.Area;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;

import java.util.List;

/**
 * Created by xpeng on 2016/9/17.
 */

public class AreaAdapter extends ZBaseAdapter<Area> {

    public AreaAdapter(Context context, List<Area> dataList) {
        super(context, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_area, parent, false);
            holder = new Holder();
            holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        final Area article = dataList.get(position);
        if (!TextUtils.isEmpty(article.getVcareadesc()))
            holder.tv_01.setText("生产区名称："+article.getVcareadesc());
        return convertView;
    }

    class Holder {
        TextView tv_01;

    }
}
