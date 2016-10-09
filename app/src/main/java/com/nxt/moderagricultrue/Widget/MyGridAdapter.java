package com.nxt.moderagricultrue.Widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nxt.moderagricultrue.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:gridview的Adapter
 * @author http://blog.csdn.net/finddreams
 */
public class MyGridAdapter extends BaseAdapter {
	private Context mContext;
	private List<String> list = new ArrayList<>();
	private List<Integer> img_list = new ArrayList<>();

	public MyGridAdapter(Context mContext, List<String> list, List<Integer> img_list) {
		this.mContext = mContext;
		this.list = list;
		this.img_list = img_list;
	}

	public List<Integer> getImg_list() {
		return img_list;
	}

	public void setImg_list(List<Integer> img_list) {
		this.img_list = img_list;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.grid_item, parent, false);
		}
		TextView tv = BaseViewHolder.get(convertView, R.id.tv_item);
		ImageView iv = BaseViewHolder.get(convertView, R.id.iv_item);
		iv.setBackgroundResource(img_list.get(position));

		tv.setText(list.get(position));
		return convertView;
	}

}
