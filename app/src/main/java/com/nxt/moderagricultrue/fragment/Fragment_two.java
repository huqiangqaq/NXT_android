package com.nxt.moderagricultrue.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.Widget.MyGridAdapter;
import com.nxt.moderagricultrue.Widget.MyGridView;
import com.nxt.moderagricultrue.list.AreaListActivity;
import com.nxt.moderagricultrue.list.DiseasedListActivity;
import com.nxt.moderagricultrue.list.FertilizeListActivity;
import com.nxt.moderagricultrue.list.OutpageListActivity;
import com.nxt.moderagricultrue.list.ParcelListActivity;
import com.nxt.moderagricultrue.list.PlotListActivity;
import com.nxt.moderagricultrue.list.RecoveryListActivity;
import com.nxt.moderagricultrue.list.SeedBatchListActivity;
import com.nxt.moderagricultrue.list.SeedListActivity;
import com.nxt.moderagricultrue.list.SwipeListActivity;
import com.nxt.moderagricultrue.list.UserListActivity;
import com.nxt.moderagricultrue.list.WateringListActivity;

import java.util.Arrays;

/**
 * Created by huqiang on 2016/10/8.
 */

public class Fragment_two extends Fragment implements AdapterView.OnItemClickListener {
    private MyGridView gridView;
    private MyGridAdapter adapter;
    private boolean isMore = false;
    public String[] img_text = {"资料购进","资料发放","生产区管理","地块信息","地块整理","全部"
    };
    public String[] img_text_more = { "资料购进", "资料发放", "生产区管理", "地块信息", "地块整理", "播种信息",
            "地块信息", "灌溉信息", "病虫害防治","采收记录","倒茬记录","人员管理" };
    public Integer[] imgs = { R.drawable.icon_01, R.drawable.icon_02,
            R.drawable.icon_03, R.drawable.icon_04,
            R.drawable.icon_05, R.drawable.icon_more,};

    public Integer[] imgs_more = { R.drawable.icon_01, R.drawable.icon_02,
            R.drawable.icon_03, R.drawable.icon_04,
            R.drawable.icon_05, R.drawable.idon_06,
            R.drawable.icon_07, R.drawable.icon_08, R.drawable.icon_09,R.drawable.icon_10,
            R.drawable.icon_11,R.drawable.icon_12};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        adapter = new MyGridAdapter(getActivity(), Arrays.asList(img_text),Arrays.asList(imgs));
        gridView = (MyGridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                startActivity(new Intent(getActivity(),SwipeListActivity.class).putExtra(Constants.URL,Constants.URL_01));
                break;
            case 1:
                startActivity(new Intent(getActivity(),OutpageListActivity.class).putExtra(Constants.URL,Constants.URL_02));
                break;
            case 2:
                startActivity(new Intent(getActivity(),AreaListActivity.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(),ParcelListActivity.class));
                break;
            case 4:
                startActivity(new Intent(getActivity(),PlotListActivity.class));
                break;
            case 5:
                if (isMore){
                    startActivity(new Intent(getActivity(),SeedListActivity.class));
                    break;
                }else {
                    adapter.setList(Arrays.asList(img_text_more));
                    adapter.setImg_list(Arrays.asList(imgs_more));
                    adapter.notifyDataSetChanged();
                    isMore = true;
                }
                break;
            case 6:
                startActivity(new Intent(getActivity(),FertilizeListActivity.class));
                break;
            case 7:
                startActivity(new Intent(getActivity(),WateringListActivity.class));
                break;
            case 8:
                startActivity(new Intent(getActivity(),DiseasedListActivity.class));
                break;
            case 9:
                startActivity(new Intent(getActivity(),RecoveryListActivity.class));
                break;
            case 10:
                startActivity(new Intent(getActivity(),SeedBatchListActivity.class));
                break;
            case 11:
                startActivity(new Intent(getActivity(),UserListActivity.class));
                break;
            default:
                break;

        }
    }
}
