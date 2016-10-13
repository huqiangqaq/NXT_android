package com.nxt.moderagricultrue.Widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;

import java.util.List;

/**
 * Created by huqiang on 2016/10/13.
 */

public class MyAdapter extends BaseLmiitAdapter<String> {

    private Context mContext;
    public MyAdapter(Context mContext, List<String> list, int page) {
        super(mContext, list, page);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            holder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_content.setText(list.get(position));
        return convertView;
    }

    public class ViewHolder{
        TextView tv_content;
    }
}
