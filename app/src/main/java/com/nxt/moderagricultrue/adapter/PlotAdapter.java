package com.nxt.moderagricultrue.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.Plot;
import com.nxt.moderagricultrue.findbyid.PlotDetailActivity;
import com.nxt.moderagricultrue.list.plotList.Update_PlotListActivity;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;
import com.nxt.zyl.util.ZToastUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xpeng on 2016/9/17.
 */

public class PlotAdapter extends ZBaseAdapter<Plot> implements View.OnClickListener {
    private Context mContext;
    private int itemPosition = 0;
    private Map<Integer,Boolean> map = new HashMap<>();

    public PlotAdapter(Context context, List<Plot> dataList) {
        super(context, dataList);
        this.mContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_plot, parent, false);
            holder = new Holder();
            holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);
            holder.tv_02 = (TextView) convertView.findViewById(R.id.tv_02);
            holder.tv_03 = (TextView) convertView.findViewById(R.id.tv_03);
            holder.ll_content = (LinearLayout) convertView.findViewById(R.id.ll_content);
            holder.ll_detail = (LinearLayout) convertView.findViewById(R.id.ll_detail);
            holder.ll_update = (LinearLayout) convertView.findViewById(R.id.ll_update);
            holder.iv_more = (ImageView) convertView.findViewById(R.id.iv_more);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        //用map来记录每个item的点击状态,默认一开始都是false
        for (int i=0;i<dataList.size();i++){
            map.put(i,false);
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPosition = position;
                if (map.get(position)){
                    holder.ll_content.setVisibility(View.GONE);
                    holder.iv_more.setImageResource(R.mipmap.icon_btn_01);
                    map.put(position,false);
                }else {
                    holder.ll_content.setVisibility(View.VISIBLE);
                    holder.iv_more.setImageResource(R.mipmap.icon_btn_02);
                    map.put(position,true);

                }

            }
        });

        holder.ll_detail.setOnClickListener(this);
        holder.ll_update.setOnClickListener(this);

        final Plot article = dataList.get(position);
        if (!TextUtils.isEmpty(article.getVcparceldesc()))
            holder.tv_01.setText("地块名称："+article.getVcparceldesc());
        if (!TextUtils.isEmpty(article.getDtreadjust()))
            holder.tv_02.setText("整理时间："+article.getDtreadjust().substring(0,10));
        if (!TextUtils.isEmpty(article.getVcoperateuser()))
            holder.tv_03.setText("记录编辑人："+article.getVcoperateuser());

        return convertView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_detail:
                mContext.startActivity(new Intent(mContext, PlotDetailActivity.class).putExtra(Constants.VCRECNO,dataList.get(itemPosition)));
                ZToastUtils.showShort(mContext,"点击这里进入详情页面");
                break;
            case R.id.ll_update:
                mContext.startActivity(new Intent(mContext, Update_PlotListActivity.class).putExtra(Constants.VCRECNO,dataList.get(itemPosition)));
                ZToastUtils.showShort(mContext,"点击这里进入修改页面");
                break;
        }
    }

    class Holder {
        TextView tv_01, tv_02, tv_03;
        LinearLayout ll_content,ll_detail,ll_update;
        ImageView iv_more;
    }
}
