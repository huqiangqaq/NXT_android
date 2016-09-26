package com.nxt.moderagricultrue;

import android.app.Application;

import com.nxt.zyl.data.ZDataTask;

/**
 * Created by xpeng on 2016/9/13.
 */

public class MyApplication extends Application {
    private static MyApplication mMyApplication;

    @Override
    public void onCreate() {

        mMyApplication=this;
        super.onCreate();
    }

    public static synchronized MyApplication getInstance() {
        return mMyApplication;
    }
    public ZDataTask getZDataTask() {
        return ZDataTask.getInstance(mMyApplication);
    }
}
