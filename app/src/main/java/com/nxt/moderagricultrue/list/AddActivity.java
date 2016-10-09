package com.nxt.moderagricultrue.list;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.R;

import java.io.UnsupportedEncodingException;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class AddActivity extends BaseActivity {
    private EditText et_vccultivar, et_itype, et_dtbuy, et_fnum,
            vcbuyman, vcmadecomp, vcsalecomp, dtinstoredate, vcinstoreman;
    private Button btn_add;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x123:
                    new SweetAlertDialog(AddActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Good job!")
                            .setContentText("添加成功")
                            .show();
                    break;
            }
        }

    };

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vccultivar = (EditText) findViewById(R.id.et_vccultivar);
        et_itype = (EditText) findViewById(R.id.et_itype);
        et_dtbuy = (EditText) findViewById(R.id.et_dtbuy);
        et_fnum = (EditText) findViewById(R.id.et_fnum);
        vcbuyman = (EditText) findViewById(R.id.vcbuyman);
        vcmadecomp = (EditText) findViewById(R.id.vcmadecomp);
        vcsalecomp = (EditText) findViewById(R.id.vcsalecomp);
        dtinstoredate = (EditText) findViewById(R.id.dtinstoredate);
        vcinstoreman = (EditText) findViewById(R.id.vcinstoreman);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
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
                final SweetAlertDialog pDialog = new SweetAlertDialog(this, SweetAlertDialog.PROGRESS_TYPE);
                pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
                pDialog.setTitleText("正在添加...");
                pDialog.setCancelable(false);
                pDialog.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0x123);
                        pDialog.dismiss();
                    }
                },2000);
                break;
        }
    }
}
