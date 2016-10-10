package com.nxt.moderagricultrue.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.MyApplication;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.Widget.MyGridAdapter;
import com.nxt.moderagricultrue.Widget.MyGridView;
import com.nxt.moderagricultrue.domain.LoginReturn;
import com.nxt.moderagricultrue.domain.Test;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huqiang on 2016/10/8.
 */

public class Fragment_two extends Fragment implements AdapterView.OnItemClickListener {
    private MyGridView gridView;
    private MyGridAdapter adapter;
    private boolean isMore = false;
    private boolean isRoot = false;
    private MyApplication application;
    private List<LoginReturn.DefaultListABean> list = new ArrayList<>();
    private List<String> newList = new ArrayList<>();
    private  List<Integer> ids = new ArrayList<>();
    public String[] img_text = {"资料购进","资料发放","生产区管理","地块信息","地块整理","全部"
    };
    public String[] img_text_more = { "资料购进", "资料发放", "生产区管理", "地块信息", "地块整理", "播种记录",
            "施肥记录", "灌溉记录", "病虫害防治","采收记录","茬(批)次记录","人员管理" };
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
        application = MyApplication.getInstance();
        list = application.getList();
        //root用户
        if ("2".equalsIgnoreCase(application.getDefaut_string())){
            isRoot = true;
            adapter = new MyGridAdapter(getActivity(), Arrays.asList(img_text),Arrays.asList(imgs));
            gridView = (MyGridView) view.findViewById(R.id.gridview);
            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener(this);
            //普通用户
        }else if ("1".equalsIgnoreCase(application.getDefaut_string())){
            //获取服务器模块信息
            for (int i=0;i<list.size();i++){
                for (int j=0;j<img_text_more.length;j++){
                    if (list.get(i).getName_().contains(img_text_more[j]) && list.get(i).getIs_auto_expand_().equals("0")){
                        newList.add(img_text_more[j]);
                    }

                }

            }


            Log.d("ss",newList.toString());
            addImgResource(newList);


//管理员权限，增加人员管理模块
            if (newList.size()>6){
                newList.add("人员管理");
                ids.add(R.drawable.icon_12);
                adapter = new MyGridAdapter(getActivity(), newList,ids);
                gridView = (MyGridView) view.findViewById(R.id.gridview);
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(this);
            }else {
                adapter = new MyGridAdapter(getActivity(), newList,ids);
                gridView = (MyGridView) view.findViewById(R.id.gridview);
                gridView.setAdapter(adapter);
                gridView.setOnItemClickListener(this);
            }



        }

        return view;
    }


    private void addImgResource(List<String> newList) {
        //添加全部模块图标资源
        for (int i=0;i<newList.size();i++){
            if ("资料购进".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_01);
            }else if ("资料发放".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_02);
            }else if ("生产区管理".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_03);
            }else if ("地块信息".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_04);
            }else if ("地块整理".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_05);
            }else if ("播种记录".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.idon_06);
            }else if ("施肥记录".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_07);
            }else if ("灌溉记录".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_08);
            }else if ("病虫害防治".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_09);
            }else if ("采收记录".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_10);
            }else if ("茬(批)次记录".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_11);
            }else if ("人员管理".equalsIgnoreCase(newList.get(i))){
                ids.add(R.drawable.icon_12);
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                if (isRoot){
                    startActivity(new Intent(getActivity(),SwipeListActivity.class).putExtra(Constants.URL,Constants.URL_01));
                }else {
                    StartIntent(newList,0);
                }
                break;
            case 1:
                if (isRoot){
                    startActivity(new Intent(getActivity(),OutpageListActivity.class).putExtra(Constants.URL,Constants.URL_02));
                }else {
                    StartIntent(newList,1);
                }
                break;
            case 2:
                if (isRoot){
                    startActivity(new Intent(getActivity(),AreaListActivity.class));
                }else {
                    StartIntent(newList,2);
                }
                break;
            case 3:
                if (isRoot){
                    startActivity(new Intent(getActivity(),ParcelListActivity.class));
                }else {
                    StartIntent(newList,3);
                }
                break;
            case 4:
                if (isRoot){
                    startActivity(new Intent(getActivity(),PlotListActivity.class));
                }else {
                    StartIntent(newList,4);
                }
                break;
            case 5:
                if (isMore){
                    startActivity(new Intent(getActivity(),SeedListActivity.class));
                    break;
                }else if (isRoot){
                    adapter.setList(Arrays.asList(img_text_more));
                    adapter.setImg_list(Arrays.asList(imgs_more));
                    adapter.notifyDataSetChanged();
                    isMore = true;
                }else{
                    StartIntent(newList,5);
                }
                break;
            case 6:
                if (isRoot){
                    startActivity(new Intent(getActivity(),FertilizeListActivity.class));
                }else {
                    StartIntent(newList,6);
                }
                break;
            case 7:
                if (isRoot){
                    startActivity(new Intent(getActivity(),WateringListActivity.class));
                }else {
                    StartIntent(newList,7);
                }
                break;
            case 8:
                if (isRoot){
                    startActivity(new Intent(getActivity(),DiseasedListActivity.class));
                }else {
                    StartIntent(newList,8);
                }
                break;
            case 9:
                if (isRoot){
                    startActivity(new Intent(getActivity(),RecoveryListActivity.class));
                }else {
                    StartIntent(newList,9);
                }
                break;
            case 10:
                if (isRoot){
                    startActivity(new Intent(getActivity(),SeedBatchListActivity.class));
                }else {
                    StartIntent(newList,10);
                }
                break;
            case 11:
                if (isRoot){
                    startActivity(new Intent(getActivity(),UserListActivity.class));
                }else {
                    StartIntent(newList,11);
                }
                break;
            default:
                break;

        }
    }
//根据模块判断跳转
    private void StartIntent(List<String> newList,int position) {

            if ("资料购进".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),SwipeListActivity.class).putExtra(Constants.URL,Constants.URL_01));
            }else if ("资料发放".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),OutpageListActivity.class).putExtra(Constants.URL,Constants.URL_02));
            }else if ("生产区管理".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),AreaListActivity.class));
            }else if ("地块信息".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),ParcelListActivity.class));
            }else if ("地块整理".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),PlotListActivity.class));
            }else if ("播种记录".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),SeedListActivity.class));
            }else if ("施肥记录".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),FertilizeListActivity.class));
            }else if ("灌溉记录".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),WateringListActivity.class));
            }else if ("病虫害防治".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),DiseasedListActivity.class));
            }else if ("采收记录".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),RecoveryListActivity.class));
            }else if ("茬(批)次记录".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),SeedBatchListActivity.class));
            }else if ("人员管理".equalsIgnoreCase(newList.get(position))){
                startActivity(new Intent(getActivity(),UserListActivity.class));
            }
        }

}
