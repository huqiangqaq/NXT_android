package com.nxt.moderagricultrue;

import android.app.Application;

import com.nxt.moderagricultrue.domain.LoginReturn;
import com.nxt.zyl.data.ZDataTask;

import java.util.List;

/**
 * Created by xpeng on 2016/9/13.
 */

public class MyApplication extends Application {
    private static MyApplication mMyApplication;
    private List<LoginReturn.DefaultListABean> list;
    private String defaut_string;
    private String OrgID;

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

    public List<LoginReturn.DefaultListABean> getList() {
        return list;
    }

    public void setList(List<LoginReturn.DefaultListABean> list) {
        this.list = list;
    }

    public String getDefaut_string() {
        return defaut_string;
    }

    public void setDefaut_string(String defaut_string) {
        this.defaut_string = defaut_string;
    }

    public String getOrgID() {
        return OrgID;
    }

    public void setOrgID(String orgID) {
        OrgID = orgID;
    }
}
