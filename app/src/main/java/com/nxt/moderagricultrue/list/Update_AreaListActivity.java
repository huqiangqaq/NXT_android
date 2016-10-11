package com.nxt.moderagricultrue.list;

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
import com.nxt.moderagricultrue.domain.Area;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;

import java.io.UnsupportedEncodingException;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Update_AreaListActivity extends BaseActivity {
    private EditText et_vcareadesc, et_vcoperateuser;
    private String vcareadesc, vcoperatruser;
    private Button btn_update;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;
    private Area vcrecno;

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vcareadesc = (EditText) findViewById(R.id.et_vcareadesc);
        et_vcoperateuser = (EditText) findViewById(R.id.et_vcoperateuser);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);

        initData();
    }
    private void initData() {
        application = MyApplication.getInstance();
        mDataTask = MyApplication.getInstance().getZDataTask();

        vcrecno= (Area) getIntent().getSerializableExtra(Constants.VCRECNO);
        et_vcareadesc.setText(vcrecno.getVcareadesc());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                vcareadesc = et_vcareadesc.getText().toString().trim();
                vcoperatruser = et_vcoperateuser.getText().toString().trim();

                if (Empty(vcareadesc, vcoperatruser)) {
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


                String ss = String.format(Constants.UPDATE_URL_03, vcrecno.getVcareano(), vcoperatruser, vcareadesc);
                Log.d("Update", ss);

                mDataTask.get(String.format(Constants.UPDATE_URL_03, vcrecno.getVcareano(), vcoperatruser, vcareadesc), null, null, this);
        }
    }
    private boolean Empty(String... msgs) {
        for (String s : msgs) {
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
            new SweetAlertDialog(Update_AreaListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(Update_AreaListActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Update_AreaListActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }
    @Override
    protected int getLayout() {
        return R.layout.activity_update__area_list;
    }
}
