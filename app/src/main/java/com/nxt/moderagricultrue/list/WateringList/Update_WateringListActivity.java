package com.nxt.moderagricultrue.list.WateringList;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
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
import com.nxt.moderagricultrue.domain.Watering;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;

public class Update_WateringListActivity extends BaseActivity {
    private EditText et_vcoperateuser,et_zha,et_dtirrigatedate,et_fwastewater,et_dtoperatedate;
    private String vcoperatrueser,vcparcelno,vcparceldesc,zha,dtirrigatedate,fwastewater,dtoperatedate;
    private Spinner sp_vcparceldesc;

    private Button btn_update;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;
    private Watering watering;

    //下拉框
    //地块名称
    private List<String> spinner_list = new ArrayList<>();
    //地块编号
    private List<String> spinner_list_num = new ArrayList<>();

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vcoperateuser = (EditText) findViewById(R.id.et_vcoperateuser);
        et_zha = (EditText) findViewById(R.id.et_zha);
        et_dtirrigatedate = (EditText) findViewById(R.id.et_dtirrigatedate);
        et_fwastewater = (EditText) findViewById(R.id.et_fwastewater);
        et_dtoperatedate = (EditText) findViewById(R.id.et_dtoperatedate);
        sp_vcparceldesc = (Spinner) findViewById(R.id.sp_vcparceldesc);


        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);

        initData();
    }

    private void initData() {
        application = MyApplication.getInstance();
        mDataTask = MyApplication.getInstance().getZDataTask();
        watering = (Watering) getIntent().getSerializableExtra(Constants.VCRECNO);

        et_dtirrigatedate.setText(watering.getDtirrigatedate()+"");
        et_fwastewater.setText(watering.getFwastewater());
        et_dtoperatedate.setText(watering.getDtirrigatedate());

        //获取下拉sp生产区编号
        Log.d("ADD", Constants.SPINNER_URL_02 + application.getOrgID());
        //获取地块名称和编号，并填入spinner
        OkHttpUtils.get().url(Constants.SPINNER_URL_02 + application.getOrgID())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        spinner_list = JsonUtil.parseJson_spnner(response, "display");
                        spinner_list_num = JsonUtil.parseJson_spnner(response, "value");
                        sp_vcparceldesc.setAdapter(new ArrayAdapter<String>(Update_WateringListActivity.this, android.R.layout.simple_spinner_dropdown_item, spinner_list));
                        sp_vcparceldesc.setSelection(0);

                    }
                });

        //监听下拉框选择事件，获取茬次号
        sp_vcparceldesc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //根据地块编号异步获取茬次号
                Log.d("URL", Constants.Spinner_URL_ZHA + spinner_list_num.get(position));
                vcparcelno = spinner_list_num.get(position);
                OkHttpUtils.get()
                        .url(Constants.Spinner_URL_ZHA + spinner_list_num.get(position))
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.d("Response", response);
                                zha = JsonUtil.parseJson_zha(response, "appmsg");
                                et_zha.setText(zha);
                            }
                        });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_update:

                vcoperatrueser = et_vcoperateuser.getText().toString().trim();
                vcparceldesc = sp_vcparceldesc.getSelectedItem().toString();
                dtirrigatedate = et_dtirrigatedate.getText().toString().trim();
                fwastewater = et_fwastewater.getText().toString().trim();
                dtoperatedate = et_dtoperatedate.getText().toString().trim();

                if (Empty(vcoperatrueser,vcparceldesc,zha,dtirrigatedate,fwastewater,dtoperatedate)){
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


                String ss = String.format(Constants.UPDATE_URL_08,watering.getVcrecno(),vcparcelno,vcparceldesc,zha,dtirrigatedate,fwastewater,vcoperatrueser,dtoperatedate);
                Log.d("Update",ss);

                mDataTask.get(String.format(Constants.UPDATE_URL_08,application.getOrgID(),vcparcelno,vcparceldesc,zha,dtirrigatedate,fwastewater,vcoperatrueser,dtoperatedate),null,null,this);
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
            new SweetAlertDialog(Update_WateringListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(Update_WateringListActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Update_WateringListActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_update__watering_list;
    }
}
