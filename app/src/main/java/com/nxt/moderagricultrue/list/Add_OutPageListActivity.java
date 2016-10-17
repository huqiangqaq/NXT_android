package com.nxt.moderagricultrue.list;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Add_OutPageListActivity extends BaseActivity {
    private EditText et_vcoperateuser, et_vccultivar,et_itype,et_fnum,et_vcreceiver,et_vcgrantman;
    private String vcoperateuser,vccultivar,itype,degrant,fnum,vcreceiver,vcgrantman;
    private Button btn_add,btn_time;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private MyApplication application;
    private int year,month,day;
    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vcoperateuser = (EditText) findViewById(R.id.et_vcoperateuser);
        et_vccultivar = (EditText) findViewById(R.id.et_vccultivar);
        et_itype = (EditText) findViewById(R.id.et_itype);
        btn_time = (Button) findViewById(R.id.btn_time);
        et_fnum = (EditText) findViewById(R.id.et_fnum);
        et_vcreceiver = (EditText) findViewById(R.id.et_vcreceiver);
        et_vcgrantman = (EditText) findViewById(R.id.et_vcgrantman);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        btn_time.setOnClickListener(this);

        initData();
    }

    private void initData(){
        application = MyApplication.getInstance();
        mDataTask= MyApplication.getInstance().getZDataTask();

        //初始化Calendar日历对象
        Calendar mycalendar = Calendar.getInstance(Locale.CHINA);
        Date date = new Date();//获取当前日期Date对象
        mycalendar.setTime(date);////为Calendar对象设置时间为当前日期

        year=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        month=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        day=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天

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
                break;
            case R.id.btn_time:
                DatePickerDialog dpd=new DatePickerDialog(Add_OutPageListActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        degrant = year+"-"+(month+1)+"-"+dayOfMonth;
                        btn_time.setText(degrant);
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
