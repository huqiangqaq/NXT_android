package com.nxt.moderagricultrue.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.User;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;

import java.util.List;

/**
 * Created by xpeng on 2016/9/17.
 */

public class UserAdapter extends ZBaseAdapter<User> {
    public UserAdapter(Context context, List<User> dataList) {
        super(context, dataList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_uer, parent, false);
            holder = new Holder();
            holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);
            holder.tv_02 = (TextView) convertView.findViewById(R.id.tv_02);
            holder.tv_03 = (TextView) convertView.findViewById(R.id.tv_03);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        final User article = dataList.get(position);
        if (!TextUtils.isEmpty(article.getName_()))
            holder.tv_01.setText("姓名："+article.getName_());
        if (!TextUtils.isEmpty(article.getSex_()))
            if(article.getSex_()=="3") {
                holder.tv_02.setText("性别：女");
            }else {
                holder.tv_02.setText("性别：男");
            }
        if (!TextUtils.isEmpty(article.getFiled1_()))
            holder.tv_03.setText("职称："+article.getFiled1_());

        return convertView;
    }

    class Holder {
        TextView tv_01, tv_02, tv_03;

    }
}
