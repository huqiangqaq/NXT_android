package com.nxt.moderagricultrue.list.FertilizeLiset;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.ComUtils;
import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.MyApplication;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.list.SeedList.Add_SeedListActivity;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.Call;

public class Add_FertilizeListActivity extends BaseActivity {
    private EditText et_vcoperateuser,et_zha,et_vcfertilizenum,et_vcfertilizerrate;
    private String vcoperatrueser,vcparcelno,vcparceldesc,zha,dtfertilizedate,vcfertilizenum,vcfertilizerrate;
    private Spinner sp_vcparceldesc,sp_vcparcelno;

    private Button btn_add,btn_time;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;
    private int year,month,day;
    //下拉框
    //地块名称
    private List<String> spinner_list = new ArrayList<>();
    //地块编号
    private List<String> spinner_list_num = new ArrayList<>();

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vcoperateuser = (EditText) findViewById(R.id.et_vcoperateuser);
        et_zha = (EditText) findViewById(R.id.et_zha);
        sp_vcparceldesc = (Spinner) findViewById(R.id.sp_vcparceldesc);
//        sp_vcparcelno = (Spinner) findViewById(R.id.sp_vcparcelno);
        btn_time = (Button) findViewById(R.id.btn_time);
        et_vcfertilizenum = (EditText) findViewById(R.id.et_vcfertilizenum);
        et_vcfertilizerrate = (EditText) findViewById(R.id.et_vcfertilizerrate);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_time.setOnClickListener(this);

        initData();
    }

    private void initData() {
        application = MyApplication.getInstance();
        mDataTask = MyApplication.getInstance().getZDataTask();

        //初始化Calendar日历对象
        Calendar mycalendar = Calendar.getInstance(Locale.CHINA);
        Date date = new Date();//获取当前日期Date对象
        mycalendar.setTime(date);////为Calendar对象设置时间为当前日期

        year=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        month=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        day=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天

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
                        sp_vcparceldesc.setAdapter(new ArrayAdapter<String>(Add_FertilizeListActivity.this, android.R.layout.simple_spinner_dropdown_item, spinner_list));
                        sp_vcparceldesc.setSelection(0);
//                        sp_vcparcelno.setAdapter(new ArrayAdapter<String>(Add_FertilizeListActivity.this, android.R.layout.simple_spinner_dropdown_item, spinner_list_num));
//                        sp_vcparcelno.setSelection(0);
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
    protected int getLayout() {
        return R.layout.activity_add__fertilize_list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:

                vcoperatrueser = et_vcoperateuser.getText().toString().trim();
//                vcparcelno = sp_vcparcelno.getSelectedItem().toString();
                vcparceldesc = sp_vcparceldesc.getSelectedItem().toString();
                vcfertilizenum = et_vcfertilizenum.getText().toString().trim();
                vcfertilizerrate = et_vcfertilizerrate.getText().toString().trim();

                if (Empty(vcoperatrueser,vcparcelno,vcparceldesc,zha,dtfertilizedate,vcfertilizenum,vcfertilizerrate)){
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


                String ss = String.format(Constants.ADD_URL_07,vcoperatrueser,application.getOrgID(),vcparcelno,vcparceldesc,zha,dtfertilizedate,vcfertilizenum,vcfertilizerrate);
                Log.d("Update",ss);

                mDataTask.get(String.format(Constants.ADD_URL_07,vcoperatrueser,application.getOrgID(),vcparcelno,vcparceldesc,zha,dtfertilizedate,vcfertilizenum,vcfertilizerrate),null,null,this);
                break;
            case R.id.btn_time:
                //创建DatePickerDialog对象
                DatePickerDialog dpd=new DatePickerDialog(Add_FertilizeListActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dtfertilizedate = year+"-"+(month+1)+"-"+dayOfMonth;
                        btn_time.setText(dtfertilizedate);
                    }
                }, year, month, day);
                dpd.show();//显示DatePickerDialog组件
                break;
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
            new SweetAlertDialog(Add_FertilizeListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        }else {
            new SweetAlertDialog(Add_FertilizeListActivity.this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Add_FertilizeListActivity.this,SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }
}
