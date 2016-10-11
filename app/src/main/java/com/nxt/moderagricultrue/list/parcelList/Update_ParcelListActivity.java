package com.nxt.moderagricultrue.list.parcelList;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.ComUtils;
import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.MyApplication;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.OutPage;
import com.nxt.moderagricultrue.domain.Parcel;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;

public class Update_ParcelListActivity extends BaseActivity {
    private EditText  et_vcparceldesc, et_fparcelarea, et_vcpurpose, et_fplantarea,
            et_vcmanager, et_istatus, et_fgisx, et_fgisy;
    private String  vcareano, vcparceldesc, fparcelarea, vcpurpose, fplantarea,
            vcmanager, istauss, fgisx, fgisy;
    private Spinner sp_vcareano;
    private Button btn_update;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;
    private Parcel vcrecno;
    //下拉框
    private List<String> spinner_list = new ArrayList<>();

    @Override
    protected void initView() throws UnsupportedEncodingException {
        sp_vcareano = (Spinner) findViewById(R.id.sp_vcareano);
        et_vcparceldesc = (EditText) findViewById(R.id.et_vcparceldesc);
        et_fparcelarea = (EditText) findViewById(R.id.et_fparcelarea);
        et_vcpurpose = (EditText) findViewById(R.id.et_vcpurpose);
        et_fplantarea = (EditText) findViewById(R.id.et_fplantarea);
        et_vcmanager = (EditText) findViewById(R.id.et_vcmanager);
        et_istatus = (EditText) findViewById(R.id.et_istatus);
        et_fgisx = (EditText) findViewById(R.id.et_fgisx);
        et_fgisy = (EditText) findViewById(R.id.et_fgisy);

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);

        initData();
    }

    private void initData() {
        application = MyApplication.getInstance();
        mDataTask = MyApplication.getInstance().getZDataTask();
        vcrecno= (Parcel) getIntent().getSerializableExtra(Constants.VCRECNO);

        et_vcparceldesc.setText(vcrecno.getVcareanodesc());
        et_fparcelarea.setText(vcrecno.getFparcelarea()+"");
        et_vcpurpose.setText(vcrecno.getVcpurpose());
        et_fplantarea.setText(vcrecno.getFplantarea()+"");
        et_vcmanager.setText(vcrecno.getVcmanager());
        et_istatus.setText(vcrecno.getIstatus()+"");


        //获取下拉sp生产区编号
        Log.d("ADD", Constants.SPINNER_URL_01 + application.getOrgID());
        OkHttpUtils.get().url(Constants.SPINNER_URL_01 + application.getOrgID())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        spinner_list = JsonUtil.parseJson_spnner(response,"vcareano");
                        sp_vcareano.setAdapter(new ArrayAdapter<String>(Update_ParcelListActivity.this, android.R.layout.simple_spinner_dropdown_item, spinner_list));
                        sp_vcareano.setSelection(0);
                    }
                });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_update:
                vcareano = sp_vcareano.getSelectedItem().toString();
                vcparceldesc = et_vcparceldesc.getText().toString().trim();
                fparcelarea = et_fparcelarea.getText().toString().trim();
                vcpurpose = et_vcpurpose.getText().toString().trim();
                fplantarea = et_fplantarea.getText().toString().trim();
                vcmanager = et_vcmanager.getText().toString().trim();
                istauss = et_istatus.getText().toString().trim();
                fgisx = et_fgisx.getText().toString().trim();
                fgisy = et_fgisy.getText().toString().trim();

                if (Empty( vcareano, vcparceldesc, fparcelarea, vcpurpose, fplantarea, vcmanager, istauss, fgisx, fgisy)) {
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


                String ss = String.format(Constants.UPDATE_URL_04, vcrecno.getVcparcelno(),vcareano, vcparceldesc, fparcelarea, vcpurpose, fplantarea, vcmanager, istauss, fgisx, fgisy);
                Log.d("Update", ss);

                mDataTask.get(String.format(Constants.UPDATE_URL_04, vcrecno.getVcparcelno(), vcareano, vcparceldesc, fparcelarea, vcpurpose, fplantarea, vcmanager, istauss, fgisx, fgisy), null, null, this);
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
            new SweetAlertDialog(Update_ParcelListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(Update_ParcelListActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Update_ParcelListActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_update__parcel_list;
    }
}
