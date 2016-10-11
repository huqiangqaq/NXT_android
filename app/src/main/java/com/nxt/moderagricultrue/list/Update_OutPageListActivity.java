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
import com.nxt.moderagricultrue.domain.OutPage;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;

import java.io.UnsupportedEncodingException;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Update_OutPageListActivity extends BaseActivity {
    private EditText  et_vccultivar,et_itype,et_dtgrant,et_fnum,et_vcreceiver,et_vcgrantman;
    private String vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman;
    private Button btn_update;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;
    private OutPage vcrecno;

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vccultivar = (EditText) findViewById(R.id.et_vccultivar);
        et_itype = (EditText) findViewById(R.id.et_itype);
        et_dtgrant = (EditText) findViewById(R.id.et_dtgrant);
        et_fnum = (EditText) findViewById(R.id.et_fnum);
        et_vcreceiver = (EditText) findViewById(R.id.et_vcreceiver);
        et_vcgrantman = (EditText) findViewById(R.id.et_vcgrantman);

        btn_update= (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);

        initData();
    }

    private void initData(){
        application = MyApplication.getInstance();
        mDataTask= MyApplication.getInstance().getZDataTask();
        vcrecno= (OutPage) getIntent().getSerializableExtra(Constants.VCRECNO);
        String ss = vcrecno.getDtgrant();
        //private EditText et_vccultivar,et_itype,et_dtgrant,et_fnum,et_vcreceiver,et_vcgrantman;
        et_vccultivar.setText(vcrecno.getVccultivar());
        et_itype.setText(vcrecno.getItype()+"");
        et_dtgrant.setText(ss);
        et_fnum.setText(vcrecno.getFnum()+"");
        et_vcreceiver.setText(vcrecno.getVcreceiver());
        et_vcgrantman.setText(vcrecno.getVcgrantman());

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_update__out_page_list;
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
            new SweetAlertDialog(Update_OutPageListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(Update_OutPageListActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Update_OutPageListActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update:
                //private EditText et_vccultivar,et_itype,et_dtgrant,et_fnum,et_vcreceiver,et_vcgrantman;
                vccultivar = et_vccultivar.getText().toString().trim();
                itype = et_itype.getText().toString().trim();
                degrant = et_dtgrant.getText().toString().trim();
                fnum = et_fnum.getText().toString().trim();
                vcreceiver = et_vcreceiver.getText().toString().trim();
                vcgrantman = et_vcgrantman.getText().toString().trim();
                if (Empty(vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman)){
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

                String ss = String.format(Constants.UPDATE_URL_02,vcrecno.getVcrecno(),vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman);
                Log.d("Update",ss);

                mDataTask.get(String.format(Constants.UPDATE_URL_02,vcrecno.getVcrecno(),vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman),null,null,this);
        }
    }
}
