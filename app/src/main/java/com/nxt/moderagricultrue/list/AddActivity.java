package com.nxt.moderagricultrue.list;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
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

public class AddActivity extends BaseActivity {
    private EditText et_vcoperateuser,et_vccultivar, et_itype, et_dtbuy, et_fnum,
            et_vcbuyman, et_vcmadecomp, et_vcsalecomp, et_dtinstoredate, et_vcinstoreman;
    private String vcoperateuser,vccultivar,itype,dtbuy,fnum,vcbuyman,
            vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman;
    private Button btn_add;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private BuyPage vcrecno;
    private MyApplication application;
    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vcoperateuser = (EditText) findViewById(R.id.et_vcoperateuser);
        et_vccultivar = (EditText) findViewById(R.id.et_vccultivar);
        et_itype = (EditText) findViewById(R.id.et_itype);
        et_dtbuy = (EditText) findViewById(R.id.et_dtbuy);
        et_fnum = (EditText) findViewById(R.id.et_fnum);
        et_vcbuyman = (EditText) findViewById(R.id.vcbuyman);
        et_vcmadecomp = (EditText) findViewById(R.id.vcmadecomp);
        et_vcsalecomp = (EditText) findViewById(R.id.vcsalecomp);
        et_dtinstoredate = (EditText) findViewById(R.id.dtinstoredate);
        et_vcinstoreman = (EditText) findViewById(R.id.vcinstoreman);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        initData();
    }

    private void initData(){
        application = MyApplication.getInstance();
        mDataTask= MyApplication.getInstance().getZDataTask();

        vcrecno=(BuyPage) getIntent().getSerializableExtra(Constants.VCRECNO);
    }


    @Override
    protected int getLayout() {
        return R.layout.activity_add;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_add:
                vcoperateuser = et_vcoperateuser.getText().toString().trim();
                vccultivar = et_vccultivar.getText().toString().trim();
                itype = et_itype.getText().toString().trim();
                dtbuy = et_dtbuy.getText().toString().trim();
                fnum = et_fnum.getText().toString().trim();
                vcbuyman = et_vcbuyman.getText().toString().trim();
                vcmadecomp = et_vcmadecomp.getText().toString().trim();
                vcsalecomp = et_vcsalecomp.getText().toString().trim();
                dtinstoredate = et_dtinstoredate.getText().toString().trim();
                vcinstoreman = et_vcinstoreman.getText().toString().trim();

                if (Empty(vcoperateuser,vccultivar,itype,dtbuy,fnum,vcbuyman,vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman)){
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

                String ss = String.format(Constants.ADD_URL_01,vcoperateuser,application.getOrgID(),vccultivar,itype,dtbuy,fnum,vcbuyman,vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman);
                Log.d("Update",ss);

                mDataTask.get(String.format(Constants.ADD_URL_01,vcoperateuser,application.getOrgID(),vccultivar,itype,dtbuy,fnum,vcbuyman,vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman),null,null,this);
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
            new SweetAlertDialog(AddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setConfirmText("添加成功")
                    .show();
        }else {
            new SweetAlertDialog(AddActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setConfirmText("添加失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(AddActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }
}
