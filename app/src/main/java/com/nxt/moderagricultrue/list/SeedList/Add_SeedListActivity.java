package com.nxt.moderagricultrue.list.SeedList;

import android.drm.DrmStore;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.ComUtils;
import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.MyApplication;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.BuyPage;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;

import java.io.UnsupportedEncodingException;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Add_SeedListActivity extends BaseActivity {
    private EditText et_vcoperateuser,et_vcparceldesc,et_vccutsno,et_vcbreed,et_dtseeddate,et_vcseedpartten,et_vcseeddensity,
            et_vcfertilize,et_dtfirstirrigate;
    private String vcoperateuser,vcparceldesc,vccutsno,vcbreed,dtseeddate,vcseedpartten,vcseeddensity,
            vcfertilize,dtfirstirrigate;

    private Button btn_add;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vcoperateuser = (EditText) findViewById(R.id.et_vcoperateuser);
        et_vcparceldesc = (EditText) findViewById(R.id.et_vcparceldesc);
        et_vccutsno = (EditText) findViewById(R.id.et_vccutsno);
        et_vcbreed = (EditText) findViewById(R.id.et_vcbreed);
        et_dtseeddate = (EditText) findViewById(R.id.et_dtseeddate);
        et_vcseedpartten = (EditText) findViewById(R.id.et_vcseedpartten);
        et_vcseeddensity = (EditText) findViewById(R.id.et_vcseeddensity);
        et_vcfertilize = (EditText) findViewById(R.id.et_vcfertilize);
        et_dtfirstirrigate = (EditText) findViewById(R.id.et_dtfirstirrigate);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        initData();
    }

    private void initData(){
        application = MyApplication.getInstance();
        mDataTask= MyApplication.getInstance().getZDataTask();

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_add__seed_list;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_add:

                vcoperateuser = et_vcoperateuser.getText().toString().trim();
                vcparceldesc = et_vcparceldesc.getText().toString().trim();
                vccutsno = et_vccutsno.getText().toString().trim();
                vcbreed = et_vcbreed.getText().toString().trim();
                dtseeddate = et_dtseeddate.getText().toString().trim();
                vcseedpartten = et_vcseedpartten.getText().toString().trim();
                vcseeddensity = et_vcseeddensity.getText().toString().trim();
                vcfertilize = et_vcfertilize.getText().toString().trim();
                dtfirstirrigate = et_dtfirstirrigate.getText().toString().trim();

                if (Empty(vcoperateuser,vcparceldesc,vccutsno,vcbreed,dtseeddate,vcseedpartten,vcseeddensity,vcfertilize,dtfirstirrigate)){
                    Toast.makeText(this, "该信息不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!ComUtils.isNetWorkConnected(this)) {
                    Toast.makeText(this, "网络不可用", Toast.LENGTH_SHORT).show();
                    return;
                }

                pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("正在修改...");
                pDialog.setCancelable(false);
                pDialog.show();

                String ss = String.format(Constants.ADD_URL_06,vcoperateuser,application.getOrgID(),vcparceldesc,vccutsno,vcbreed,dtseeddate,vcseedpartten,vcseeddensity,vcfertilize,dtfirstirrigate);
                Log.d("Update",ss);

                mDataTask.get(String.format(Constants.ADD_URL_06,vcoperateuser,application.getOrgID(),vcparceldesc,vccutsno,vcbreed,dtseeddate,vcseedpartten,vcseeddensity,vcfertilize,dtfirstirrigate),null,null,this);
        }
    }
    private boolean Empty(String... msgs) {
        for (String s:msgs){
            if (TextUtils.isEmpty(s))
                return true;
        }
        return false;
    }

    @Override
    public void onRequestResult(String string) {
        pDialog.dismiss();
        Log.d("UPDATE",string);
        if (JsonUtil.PareJson(string)){
            new SweetAlertDialog(Add_SeedListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(Add_SeedListActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Add_SeedListActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }
}
