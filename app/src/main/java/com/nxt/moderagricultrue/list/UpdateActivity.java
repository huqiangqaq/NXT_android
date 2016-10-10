package com.nxt.moderagricultrue.list;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.widget.TextViewCompat;
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
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;

public class UpdateActivity extends BaseActivity {
    private EditText et_vccultivar,et_itype,et_dtbuy,et_fnum,
            et_vcbuyman,et_vcmadecomp,et_vcsalecomp,et_dtinstoredate,et_vcinstoreman;
    private Button btn_update;
    private String vccultivar,itype,dtbuy,fnum,vcbuyman,
                    vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private BuyPage vcrecno;

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vccultivar = (EditText) findViewById(R.id.et_vccultivar);
        et_itype = (EditText) findViewById(R.id.et_itype);
        et_dtbuy = (EditText) findViewById(R.id.et_dtbuy);
        et_fnum = (EditText) findViewById(R.id.et_fnum);
        et_vcbuyman = (EditText) findViewById(R.id.vcbuyman);
        et_vcmadecomp = (EditText) findViewById(R.id.vcmadecomp);
        et_vcsalecomp = (EditText) findViewById(R.id.vcsalecomp);
        et_dtinstoredate = (EditText) findViewById(R.id.dtinstoredate);
        et_vcinstoreman = (EditText) findViewById(R.id.vcinstoreman);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);

        initData();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_update;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_update:
                vccultivar = et_vccultivar.getText().toString().trim();
                itype = et_itype.getText().toString().trim();
                dtbuy = et_dtbuy.getText().toString().trim();
                fnum = et_fnum.getText().toString().trim();
                vcbuyman = et_vcbuyman.getText().toString().trim();
                vcmadecomp = et_vcmadecomp.getText().toString().trim();
                vcsalecomp = et_vcsalecomp.getText().toString().trim();
                dtinstoredate = et_dtinstoredate.getText().toString().trim();
                vcinstoreman = et_vcinstoreman.getText().toString().trim();
                if (Empty(vccultivar,itype,dtbuy,fnum,vcbuyman,vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman)){
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

                String ss = String.format(Constants.UPDATE_URL_01,vcrecno.getVcrecno(),vccultivar,itype,dtbuy,fnum,vcbuyman,vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman);
                Log.d("Update",ss);

                mDataTask.get(String.format(Constants.UPDATE_URL_01,vcrecno.getVcrecno(),vccultivar,itype,dtbuy,fnum,vcbuyman,vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman),null,null,this);
        }
    }

    private void initData(){
        mDataTask= MyApplication.getInstance().getZDataTask();

        vcrecno=(BuyPage) getIntent().getSerializableExtra(Constants.VCRECNO);

        et_vccultivar.setText(vcrecno.getVccultivar());
        et_itype.setText(vcrecno.getItype()+"");
        et_dtbuy.setText(vcrecno.getDtbuy());
        et_fnum.setText(vcrecno.getFnum());
        et_vcbuyman.setText(vcrecno.getVcbuyman());
        et_vcmadecomp.setText(vcrecno.getVcmadecomp());
        et_vcsalecomp.setText(vcrecno.getVcsalecomp());
        et_dtinstoredate.setText(vcrecno.getDtinstoredate());
        et_vcinstoreman.setText(vcrecno.getVcinstoreman());
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
            new SweetAlertDialog(UpdateActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(UpdateActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(UpdateActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }
}
