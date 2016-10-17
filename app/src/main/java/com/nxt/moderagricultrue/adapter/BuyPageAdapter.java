package com.nxt.moderagricultrue.adapter;

import android.app.AlertDialog;
import android.content.Context;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.BuyPage;
import com.nxt.moderagricultrue.findbyid.BuyPageDetailActivity;
import com.nxt.moderagricultrue.list.UpdateActivity;
import com.nxt.zyl.ui.adapter.ZBaseAdapter;
import com.nxt.zyl.util.JsonUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;

/**
 * Created by xpeng on 2016/9/13.
 */

public class BuyPageAdapter extends ZBaseAdapter<BuyPage> implements View.OnClickListener {
    private boolean isShow = false;
    private Context mContext;
    private int itemPosition = 0;
    private Map<Integer,Boolean> map = new HashMap<>();

    public BuyPageAdapter(Context context, List<BuyPage> dataList) {
        super(context, dataList);
        this.mContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

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
            holder.ll_delete = (LinearLayout) convertView.findViewById(R.id.ll_delete);
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
        holder.ll_delete.setOnClickListener(this);
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
                mContext.startActivity(new Intent(mContext, BuyPageDetailActivity.class).putExtra(Constants.VCRECNO,dataList.get(itemPosition)));
                break;
            case R.id.ll_update:
                mContext.startActivity(new Intent(mContext, UpdateActivity.class).putExtra(Constants.VCRECNO,dataList.get(itemPosition)));
                break;
            case R.id.ll_delete:
                AlertDialog dialog = new AlertDialog.Builder(mContext)
                        .setTitle("提示")
                        .setMessage("确定删除此条记录吗?")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                OkHttpUtils.get().url(String.format(Constants.DEL_URL_01,dataList.get(itemPosition).getVcrecno()))
                                        .build()
                                        .execute(new StringCallback() {
                                            @Override
                                            public void onError(Call call, Exception e, int id) {

                                            }

                                            @Override
                                            public void onResponse(String response, int id) {
                                                Log.d("DEL",response);

                                                if (JsonUtil.PareJson(response)){
                                                    new SweetAlertDialog(mContext, SweetAlertDialog.SUCCESS_TYPE)
                                                            .setConfirmText("删除成功")
                                                            .show();
                                                    dataList.remove(itemPosition);
                                                    notifyDataSetChanged();
                                                }else {
                                                    new SweetAlertDialog(mContext,SweetAlertDialog.ERROR_TYPE)
                                                            .setConfirmText("删除失败")
                                                            .show();
                                                }
                                            }
                                        });


                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
        }
    }

    class Holder {
        TextView tv_01, tv_02, tv_03,tv_04;
        LinearLayout ll_content,ll_detail,ll_update,ll_delete;
        ImageView iv_more;
    }
}
