package com.nxt.moderagricultrue.list;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
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

public class AddActivity extends BaseActivity {
    private EditText et_vcoperateuser,et_vccultivar, et_itype, et_fnum,
            et_vcbuyman, et_vcmadecomp, et_vcsalecomp, et_dtinstoredate, et_vcinstoreman;
    private String vcoperateuser,vccultivar,itype,dtbuy,fnum,vcbuyman,
            vcmadecomp,vcsalecomp,dtinstoredate,vcinstoreman;
    private Button btn_add,btn_select_time,btn_select_time_ruku;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private BuyPage vcrecno;
    private MyApplication application;
    private int year,month,day;
    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_vcoperateuser = (EditText) findViewById(R.id.et_vcoperateuser);
        et_vccultivar = (EditText) findViewById(R.id.et_vccultivar);
        et_itype = (EditText) findViewById(R.id.et_itype);
        btn_select_time = (Button) findViewById(R.id.et_dtbuy);
        et_fnum = (EditText) findViewById(R.id.et_fnum);
        et_vcbuyman = (EditText) findViewById(R.id.vcbuyman);
        et_vcmadecomp = (EditText) findViewById(R.id.vcmadecomp);
        et_vcsalecomp = (EditText) findViewById(R.id.vcsalecomp);
        btn_select_time_ruku = (Button) findViewById(R.id.dtinstoredate);
        et_vcinstoreman = (EditText) findViewById(R.id.vcinstoreman);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        initData();
    }

    private void initData(){
        application = MyApplication.getInstance();
        mDataTask= MyApplication.getInstance().getZDataTask();

        vcrecno=(BuyPage) getIntent().getSerializableExtra(Constants.VCRECNO);

        //初始化Calendar日历对象
        Calendar mycalendar = Calendar.getInstance(Locale.CHINA);
        Date date = new Date();//获取当前日期Date对象
        mycalendar.setTime(date);////为Calendar对象设置时间为当前日期

        year=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        month=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        day=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天


        btn_select_time.setOnClickListener(this);
        btn_select_time_ruku.setOnClickListener(this);
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
                fnum = et_fnum.getText().toString().trim();
                vcbuyman = et_vcbuyman.getText().toString().trim();
                vcmadecomp = et_vcmadecomp.getText().toString().trim();
                vcsalecomp = et_vcsalecomp.getText().toString().trim();
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
                break;
            case R.id.et_dtbuy:
                /**
                 * 构造函数原型：
                 * public DatePickerDialog (Context context, DatePickerDialog.OnDateSetListener callBack,
                 * int year, int monthOfYear, int dayOfMonth)
                 * content组件运行Activity，
                 * DatePickerDialog.OnDateSetListener：选择日期事件
                 * year：当前组件上显示的年，monthOfYear：当前组件上显示的月，dayOfMonth：当前组件上显示的第几天
                 *
                 */
                //创建DatePickerDialog对象
                DatePickerDialog dpd=new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dtbuy = year+"-"+(month+1)+"-"+dayOfMonth;
                        btn_select_time.setText(dtbuy);
                    }
                }, year, month, day);
                dpd.show();//显示DatePickerDialog组件
                break;
            case R.id.dtinstoredate:
                //创建DatePickerDialog对象
                DatePickerDialog dpd1=new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dtinstoredate =year+"-"+(month+1)+"-"+dayOfMonth;
                        btn_select_time_ruku.setText(dtinstoredate);
                    }
                }, year, month, day);
                dpd1.show();//显示DatePickerDialog组件
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
