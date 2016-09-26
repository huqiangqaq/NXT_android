package com.nxt.moderagricultrue;

import android.content.Intent;
import android.view.View;

import com.nxt.moderagricultrue.domain.Area;
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

import java.io.UnsupportedEncodingException;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() throws UnsupportedEncodingException {
        findViewById(R.id.tv_01).setOnClickListener(this);
        findViewById(R.id.tv_02).setOnClickListener(this);
        findViewById(R.id.tv_03).setOnClickListener(this);
        findViewById(R.id.tv_04).setOnClickListener(this);
        findViewById(R.id.tv_05).setOnClickListener(this);
        findViewById(R.id.tv_06).setOnClickListener(this);
        findViewById(R.id.tv_07).setOnClickListener(this);
        findViewById(R.id.tv_08).setOnClickListener(this);
        findViewById(R.id.tv_09).setOnClickListener(this);
        findViewById(R.id.tv_10).setOnClickListener(this);
        findViewById(R.id.tv_11).setOnClickListener(this);
        findViewById(R.id.tv_12).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_01:
                startActivity(new Intent(this,SwipeListActivity.class).putExtra(Constants.URL,Constants.URL_01));
                break;
            case R.id.tv_02:
                startActivity(new Intent(this,OutpageListActivity.class).putExtra(Constants.URL,Constants.URL_02));
                break;
            case R.id.tv_03:
                startActivity(new Intent(this,AreaListActivity.class));
                break;
            case R.id.tv_04:
                startActivity(new Intent(this,ParcelListActivity.class));
                break;
            case R.id.tv_05:
                startActivity(new Intent(this,PlotListActivity.class));
                break;
            case R.id.tv_06:
                startActivity(new Intent(this,SeedListActivity.class));
                break;
            case R.id.tv_07:
                startActivity(new Intent(this,FertilizeListActivity.class));
                break;
            case R.id.tv_08:
                startActivity(new Intent(this,WateringListActivity.class));
                break;
            case R.id.tv_09:
                startActivity(new Intent(this,DiseasedListActivity.class));
                break;
            case R.id.tv_10:
                startActivity(new Intent(this,RecoveryListActivity.class));
                break;
            case R.id.tv_11:
                startActivity(new Intent(this,SeedBatchListActivity.class));
                break;
            case R.id.tv_12:
                startActivity(new Intent(this,UserListActivity.class));
                break;
            default:
                break;
        }
    }
}
