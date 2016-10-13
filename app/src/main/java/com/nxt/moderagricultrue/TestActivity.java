package com.nxt.moderagricultrue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.nxt.moderagricultrue.Widget.MyAdapter;
import com.nxt.moderagricultrue.list.DiseasedList.Add_DiseasedListActivity;
import com.nxt.moderagricultrue.list.ParcelListActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class TestActivity extends AppCompatActivity {
    private ListView lv_content;
    private List<String> list = new ArrayList<>();
    private MyAdapter adapter;
    private int page = 20;
    private View footview;
    private int maxpage = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        lv_content = (ListView) findViewById(R.id.lv_content);
        for (int i=0;i<50;i++){
            list.add("item"+i);
        }
        adapter = new MyAdapter(this,list,page);
        lv_content.setAdapter(adapter);
        footview = LayoutInflater.from(this).inflate(R.layout.layout_foot,null);
        lv_content.setOnScrollListener(new AbsListView.OnScrollListener() {
            //AbsListView view 这个view对象就是listview
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
                    if (view.getLastVisiblePosition() == view.getCount() - 1) {
                        lv_content.addFooterView(footview);
                        if (page<maxpage) {
                            page += 10;
                        }

                            adapter.setPage(page);
                        dismiss();
                        adapter.notifyDataSetChanged();


                    }
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {

            }
        });

    }
    private void dismiss(){
        TimerTask task = new TimerTask(){
            public void run(){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        lv_content.removeFooterView(footview);
                    }
                });
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000);
    }
}
