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
import com.nxt.moderagricultrue.domain.BuyPage;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;

import java.io.UnsupportedEncodingException;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Add_OutPageListActivity extends BaseActivity {
    private EditText et_vcoperateuser, et_vccultivar,et_itype,et_dtgrant,et_fnum,et_vcreceiver,et_vcgrantman;
    private String vcoperateuser,vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman;
    private Button btn_add;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;
    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vcoperateuser = (EditText) findViewById(R.id.et_vcoperateuser);
        et_vccultivar = (EditText) findViewById(R.id.et_vccultivar);
        et_itype = (EditText) findViewById(R.id.et_itype);
        et_dtgrant = (EditText) findViewById(R.id.et_dtgrant);
        et_fnum = (EditText) findViewById(R.id.et_fnum);
        et_vcreceiver = (EditText) findViewById(R.id.et_vcreceiver);
        et_vcgrantman = (EditText) findViewById(R.id.et_vcgrantman);

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
        return R.layout.activity_add__out_page_list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                vcoperateuser = et_vcoperateuser.getText().toString().trim();
                vccultivar = et_vccultivar.getText().toString().trim();
                itype = et_itype.getText().toString().trim();
                degrant = et_dtgrant.getText().toString().trim();
                fnum = et_fnum.getText().toString().trim();
                vcreceiver = et_vcreceiver.getText().toString().trim();
                vcgrantman = et_vcgrantman.getText().toString().trim();

                if (Empty(vcoperateuser,vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman)){
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


                String ss = String.format(Constants.ADD_URL_02,vcoperateuser,application.getOrgID(),vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman);
                Log.d("Update",ss);

                mDataTask.get(String.format(Constants.ADD_URL_02,vcoperateuser,application.getOrgID(),vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman),null,null,this);
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
            new SweetAlertDialog(Add_OutPageListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(Add_OutPageListActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Add_OutPageListActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }
}
