package com.nxt.moderagricultrue.Widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nxt.zyl.ui.adapter.ZBaseAdapter;

import java.util.List;

/**
 * Created by huqiang on 2016/10/13.
 */

public abstract class BaseLmiitAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<T> list;
    protected LayoutInflater inflater;
    protected int page;

    public BaseLmiitAdapter(Context mContext, List<T> list, int page) {
        this.mContext = mContext;
        this.list = list;
        this.page = page;
        inflater = LayoutInflater.from(mContext);
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public int getCount() {
        return page;
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);


}
