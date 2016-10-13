package com.nxt.moderagricultrue.list.SeedList;

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
import com.nxt.moderagricultrue.domain.Seed;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;
import com.nxt.zyl.util.ZToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;

import static com.nxt.moderagricultrue.R.id.btn_add;

public class Update_SeedListActivity extends BaseActivity {
    private EditText et_vccutsno,et_vcbreed,et_dtseeddate,et_vcseedpartten,et_vcseeddensity,
            et_vcfertilize,et_dtfirstirrigate;
    private String vcparceldesc,vcparcelno,vccutsno,vcbreed,dtseeddate,vcseedpartten,vcseeddensity,
            vcfertilize,dtfirstirrigate;

    private Spinner sp_desc;
    private Button btn_update;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;
    private Seed seed;


    //下拉框
    //地块名称
    private List<String> spinner_list = new ArrayList<>();
    //地块编号
    private List<String> spinner_list_num = new ArrayList<>();


    @Override
    protected void initView() throws UnsupportedEncodingException {
        sp_desc = (Spinner) findViewById(R.id.sp_vcparceldesc);
        et_vccutsno = (EditText) findViewById(R.id.et_vccutsno);
        et_vcbreed = (EditText) findViewById(R.id.et_vcbreed);
        et_dtseeddate = (EditText) findViewById(R.id.et_dtseeddate);
        et_vcseedpartten = (EditText) findViewById(R.id.et_vcseedpartten);
        et_vcseeddensity = (EditText) findViewById(R.id.et_vcseeddensity);
        et_vcfertilize = (EditText) findViewById(R.id.et_vcfertilize);
        et_dtfirstirrigate = (EditText) findViewById(R.id.et_dtfirstirrigate);

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);
        initData();
    }

    private void initData(){
        application = MyApplication.getInstance();
        mDataTask= MyApplication.getInstance().getZDataTask();
        seed = (Seed) getIntent().getSerializableExtra(Constants.VCRECNO);
        et_vccutsno.setText(seed.getVccutsno()+"");
        et_vcbreed.setText(seed.getVcbreed());
        et_dtseeddate.setText(seed.getDtseeddate()+"");
        et_vcseedpartten.setText(seed.getVcseedpartten());
        et_vcseeddensity.setText(seed.getVcseeddensity());
        et_vcfertilize.setText(seed.getVcfertilize());
        et_dtfirstirrigate.setText(seed.getDtfirstirrigate()+"");
        //获取下拉sp生产区编号
        Log.d("ADD", Constants.SPINNER_URL_02+application.getOrgID());
        //获取地块名称和编号，并填入spinner
        OkHttpUtils.get().url(Constants.SPINNER_URL_02+application.getOrgID())
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        spinner_list = JsonUtil.parseJson_spnner(response,"display");
                        spinner_list_num = JsonUtil.parseJson_spnner(response,"value");
                        sp_desc.setAdapter(new ArrayAdapter<String>(Update_SeedListActivity.this,android.R.layout.simple_spinner_dropdown_item,spinner_list));
                        sp_desc.setSelection(0);
                    }
                });

        //监听下拉框选择事件，获取茬次号
        sp_desc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //根据地块编号异步获取茬次号
                Log.d("URL",Constants.Spinner_URL_ZHA+spinner_list_num.get(position));
                vcparcelno = spinner_list_num.get(position);
                OkHttpUtils.get()
                        .url(Constants.Spinner_URL_ZHA+spinner_list_num.get(position))
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {
                                Log.d("Response",response);
                                vccutsno = JsonUtil.parseJson_zha(response,"appmsg");
                                et_vccutsno.setText(vccutsno);
                                String appcode = JsonUtil.parseJson_zha(response,"appcode");
                                Log.d("APPCODE",appcode);
                                if ("-1".equalsIgnoreCase(appcode)){
                                    ZToastUtils.showShort(Update_SeedListActivity.this,"该地块有未收割批次,不能添加新的播种记录!");
                                    btn_update.setEnabled(false);
                                }else {
                                    btn_update.setEnabled(true);
                                }

                            }
                        });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Override
    protected int getLayout() {
        return R.layout.activity_update__seed_list;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()){
            case R.id.btn_update:

                vcparceldesc = sp_desc.getSelectedItem().toString();
                vccutsno = et_vccutsno.getText().toString().trim();
                vcbreed = et_vcbreed.getText().toString().trim();
                dtseeddate = et_dtseeddate.getText().toString().trim();
                vcseedpartten = et_vcseedpartten.getText().toString().trim();
                vcseeddensity = et_vcseeddensity.getText().toString().trim();
                vcfertilize = et_vcfertilize.getText().toString().trim();
                dtfirstirrigate = et_dtfirstirrigate.getText().toString().trim();

                if (Empty(vcparceldesc,vccutsno,vcbreed,dtseeddate,vcseedpartten,vcseeddensity,vcfertilize,dtfirstirrigate)){
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

                String ss = String.format(Constants.UPDATE_URL_06,seed.getVcrecno(),vcparceldesc,vcparcelno,vccutsno,vcbreed,dtseeddate,vcseedpartten,vcseeddensity,vcfertilize,dtfirstirrigate);
                Log.d("Update",ss);

                mDataTask.get(String.format(Constants.UPDATE_URL_06,seed.getVcrecno(),vcparceldesc,vcparcelno,vccutsno,vcbreed,dtseeddate,vcseedpartten,vcseeddensity,vcfertilize,dtfirstirrigate),null,null,this);
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
            new SweetAlertDialog(Update_SeedListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(Update_SeedListActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Update_SeedListActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }
}
