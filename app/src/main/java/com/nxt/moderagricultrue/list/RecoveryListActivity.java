package com.nxt.moderagricultrue.list;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.ComUtils;
import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.MyApplication;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.adapter.FertilizeAdapter;
import com.nxt.moderagricultrue.adapter.RecoveryAdapter;
import com.nxt.moderagricultrue.domain.Recovery;
import com.nxt.moderagricultrue.findbyid.FertilizeDetailActivity;
import com.nxt.moderagricultrue.findbyid.RecoveryDetailActivity;
import com.nxt.moderagricultrue.list.RecoveryList.Add_RecoveryListActivity;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.ZToastUtils;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by xpeng on 2016/9/17.
 */

public class RecoveryListActivity extends BaseActivity implements AdapterView.OnItemClickListener{
    private static final String TAG = "ParcelListActivity";
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView mlistview;
    private View footerview;
    private LinearLayout lineShaiXuan;
    private EditText et_01,et_02,et_03,et_04,et_05;
    private TextView tv_reset,tv_confirm;
    private FloatingActionButton fab;

    private RecoveryAdapter mBuyPageAdapter;
    private List<Recovery> buyPageList=new ArrayList<>();
    private ZDataTask zDataTask;
    private int lastItem;
    private int page=1;
    //每页显示的数目
    private int count = 10;

    @Override
    protected int getLayout() {
        return R.layout.activity_recovery_list;
    }

    @Override
    protected void initView() throws UnsupportedEncodingException {
        initSearch();

        zDataTask= MyApplication.getInstance().getZDataTask();
        mlistview= (ListView) findViewById(R.id.listview_common);
        footerview= LayoutInflater.from(this).inflate(R.layout.layout_foot,null);
        swipeRefreshLayout= (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.white);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
//        swipeRefreshLayout.setProgressViewOffset(false, 0, (int) TypedValue
//                .applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources()
//                        .getDisplayMetrics()));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                zDataTask.get(String.format(Constants.URL_08,count,page),null,null,RecoveryListActivity.this);

            }
        });
        mlistview.setOnItemClickListener(this);
        mlistview.setOnScrollListener(new AbsListView.OnScrollListener() {
            //AbsListView view 这个view对象就是listview
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        mlistview.addFooterView(footerview);
                        load();
//                        dismiss();
                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                lastItem = firstVisibleItem + visibleItemCount - 1;
            }
        });
        refresh();
//        Log.e(TAG,encodeResult("姹熻タ鍐滀笟鍐滆嵂闆嗗洟"));
    }

    private void initSearch(){
        lineShaiXuan = (LinearLayout) findViewById(R.id.line_shaixuan);
        et_01=(EditText)findViewById(R.id.et_prc);
        et_02=(EditText)findViewById(R.id.et_prs);
        et_03=(EditText)findViewById(R.id.buy_start);
        et_04=(EditText)findViewById(R.id.buy_end);
//        et_05=(EditText)findViewById(R.id.in_end);
        tv_reset=(TextView)findViewById(R.id.reset);
        tv_confirm=(TextView)findViewById(R.id.confirm);

        tv_reset.setOnClickListener(this);
        tv_confirm.setOnClickListener(this);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reset:
                et_01.setText(null);
                et_02.setText(null);
                et_03.setText(null);
                et_04.setText(null);
//                et_05.setText(null);
                break;
            case R.id.confirm:
                String prc=et_01.getText().toString().trim();
                String s="1&vcparceldesc="+prc;
                Log.e(TAG,s);
                if(prc !=null){
                    zDataTask.get(String.format(Constants.URL_08,count,s),null,null,this);
                    Log.e(TAG,String.format(Constants.URL_08,count,s));
                }
                String prs=et_02.getText().toString().trim();
                String ps="1&vccutsno="+prs;
                Log.e(TAG,s);
                if(prc !=null){
                    zDataTask.get(String.format(Constants.URL_08,count,ps),null,null,this);
                    Log.e(TAG,String.format(Constants.URL_08,ps));
                }
                String buy_start=et_03.getText().toString().trim();
                String buy_end=et_04.getText().toString().trim();
                String buy="1&startDate="+buy_start+"endDate="+buy_end;
                if(!TextUtils.isEmpty(buy_start)&&!TextUtils.isEmpty(buy_end))
                {
                    zDataTask.get(String.format(Constants.URL_08,count,buy),null,null,this);
                    Log.e(TAG,String.format(Constants.URL_08,buy));
                }
                lineShaiXuan.setVisibility(View.GONE);
                break;
            case R.id.fab:
            startActivity(new Intent(this,Add_RecoveryListActivity.class));
            break;
        }
    }

    private void dismiss(){
        TimerTask task = new TimerTask(){
            public void run(){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mlistview.removeFooterView(footerview);
                        Toast.makeText(RecoveryListActivity.this, "数据已加载完毕", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 500);
    }

    public void load() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessageDelayed(1, 1500);
            }
        });
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                page = 1;
            } else {
                count+=5;
                page++;
            }
            getData();
            super.handleMessage(msg);
        }
    };

    private void getData(){
        if (!ComUtils.isNetWorkConnected(this)) {
            Toast.makeText(this, "网络不可用", Toast.LENGTH_SHORT).show();
            return;
        }else {
            zDataTask.get(String.format(Constants.URL_08,count,page),null,null,this);
        }
    }

    public void refresh() {
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                handler.sendEmptyMessageDelayed(0, 500);
            }
        });
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }

    public void onRightClick(View view) {
        lineShaiXuan.setVisibility(lineShaiXuan.getVisibility() == View.VISIBLE
                ? View.GONE : View.VISIBLE);
    }

    @Override
    public void onRequestResult(String string) {
        if (swipeRefreshLayout.isRefreshing()) swipeRefreshLayout.setRefreshing(false);
        mlistview.removeFooterView(footerview);
        //Here's nothing
        Log.e(TAG,string);
        if(!TextUtils.isEmpty(string)){
            if(page==1) {
//                buyPageList.clear();
                try {
                    String s = new JSONObject(string).getString("_rows");
                    buyPageList = new Gson().fromJson(s, new TypeToken<List<Recovery>>() {
                    }.getType());
                    Log.e(TAG,buyPageList.size()+"");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mBuyPageAdapter=new RecoveryAdapter(this, buyPageList);
                mlistview.setAdapter(mBuyPageAdapter);
            }else {
                try {
                    String s = new JSONObject(string).getString("_rows");
                    List<Recovery>  addList = new Gson().fromJson(s, new TypeToken<List<Recovery>>() {
                    }.getType());
                    if(addList.size()>0) {
                        buyPageList.clear();
                        buyPageList.addAll(addList);
                        mBuyPageAdapter.notifyDataSetChanged();
                    }else{
                        Toast.makeText(this, "数据已加载完毕", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String encodeResult(String s) {
        String str= null;
        try {
            str=new String(s.getBytes("gbk"),"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public void onItemClick(AdapterView<?> view, View view1, int i, long l) {
        Recovery mBuypage=buyPageList.get(i);
        Log.e(TAG,i+"");
        startActivity(new Intent(this, RecoveryDetailActivity.class).putExtra(Constants.VCRECNO,mBuypage));
    }

}
