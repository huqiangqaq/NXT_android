package com.nxt.moderagricultrue.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.BuyPage;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;
import com.nxt.zyl.util.ZToastUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by xpeng on 2016/9/13.
 */

public class BuyPageAdapter extends ZBaseAdapter<BuyPage> implements View.OnClickListener {
    private boolean isShow = false;
    private Context mContext;

    public BuyPageAdapter(Context context, List<BuyPage> dataList) {
        super(context, dataList);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Holder holder;
        if (convertView == null) {
        convertView = mLayoutInflater.inflate(R.layout.item_buypage, parent, false);
        holder = new Holder();
        holder.tv_01 = (TextView) convertView.findViewById(R.id.tv_01);
        holder.tv_02 = (TextView) convertView.findViewById(R.id.tv_02);
        holder.tv_03 = (TextView) convertView.findViewById(R.id.tv_03);
        holder.tv_04 = (TextView) convertView.findViewById(R.id.tv_04);
        holder.ll_content = (LinearLayout) convertView.findViewById(R.id.ll_content);
            holder.ll_detail = (LinearLayout) convertView.findViewById(R.id.ll_detail);
            holder.ll_update = (LinearLayout) convertView.findViewById(R.id.ll_update);
            holder.iv_more = (ImageView) convertView.findViewById(R.id.iv_more);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShow){
                    holder.ll_content.setVisibility(View.GONE);
                    holder.iv_more.setImageResource(R.mipmap.icon_btn_01);
                    isShow = false;
                }else {
                    holder.ll_content.setVisibility(View.VISIBLE);
                    holder.iv_more.setImageResource(R.mipmap.icon_btn_02);
                    isShow = true;
                }

            }
        });
        holder.ll_detail.setOnClickListener(this);
        holder.ll_update.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_detail:
                ZToastUtils.showShort(mContext,"点击这里进入详情页面");
                break;
            case R.id.ll_update:
                ZToastUtils.showShort(mContext,"点击这里进入修改页面");
                break;
        }
    }

    class Holder {
        TextView tv_01, tv_02, tv_03,tv_04;
        LinearLayout ll_content,ll_detail,ll_update;
        ImageView iv_more;
    }
}
