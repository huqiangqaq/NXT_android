package com.nxt.moderagricultrue;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nxt.moderagricultrue.Widget.MyAdapter;
import com.nxt.moderagricultrue.domain.Item;
import com.nxt.moderagricultrue.domain.Test;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;

public class TestActivity extends AppCompatActivity {
    private List<Item> items = new ArrayList<>();
    private List<List<Item>> all_items = new ArrayList<>();
    private List<Test.RowsBean> rowsBeen = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        OkHttpUtils.get().url("http://jx.12316.zq.yn15.com/Data1/DispestMap.ashx?Action=typegrid&rnd=0.9937502318269488")
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        Test test = new Gson().fromJson(response,Test.class);
                        rowsBeen = test.getRows();
                        for (int i =0;i<rowsBeen.size();i++){
                            all_items.add(rowsBeen.get(i).getArr());
                        }
                        Log.d("Test", all_items.toString());
                    }
                });


    }

}
