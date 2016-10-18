package com.nxt.moderagricultrue.list.UserList;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
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
import com.nxt.moderagricultrue.domain.BuyPage;
import com.nxt.moderagricultrue.domain.User;
import com.nxt.moderagricultrue.list.UpdateActivity;
import com.nxt.moderagricultrue.list.WateringList.Add_WateringListActivity;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.nxt.moderagricultrue.R.id.et_filed3;
import static com.nxt.moderagricultrue.R.id.et_itype;
import static com.nxt.moderagricultrue.R.id.et_vccultivar;
import static com.nxt.moderagricultrue.R.id.filed3;

public class Update_UserListActivity extends BaseActivity {
    private EditText et_name, et_filed1, et_filed2, et_filed3;
    private String name, sex, birthday, filed1, filed2, filed3;
    private Button btn_update,btn_birthday;

    private Spinner sp_sex;
    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private User user;
    private int year,month,day;
    private String[] sexs = {"男","女"};

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_name = (EditText) findViewById(R.id.et_name);
        sp_sex = (Spinner) findViewById(R.id.sp_sex);
        btn_birthday = (Button) findViewById(R.id.btn_birthday);
        et_filed1 = (EditText) findViewById(R.id.et_filed1);
        et_filed2 = (EditText) findViewById(R.id.et_filed2);
        et_filed3 = (EditText) findViewById(R.id.et_filed3);

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);
        btn_birthday.setOnClickListener(this);
        initData();
    }

    private void initData() {
        mDataTask = MyApplication.getInstance().getZDataTask();


        //初始化Calendar日历对象
        Calendar mycalendar = Calendar.getInstance(Locale.CHINA);
        Date date = new Date();//获取当前日期Date对象
        mycalendar.setTime(date);////为Calendar对象设置时间为当前日期

        year=mycalendar.get(Calendar.YEAR); //获取Calendar对象中的年
        month=mycalendar.get(Calendar.MONTH);//获取Calendar对象中的月
        day=mycalendar.get(Calendar.DAY_OF_MONTH);//获取这个月的第几天
        sp_sex.setAdapter(new ArrayAdapter<String>(Update_UserListActivity.this, android.R.layout.simple_spinner_dropdown_item, sexs));
        sp_sex.setSelection(0);
        user = (User) getIntent().getSerializableExtra(Constants.VCRECNO);
        et_name.setText(user.getName_());


        et_filed1.setText(user.getFiled1_());
        et_filed2.setText(user.getFiled2_());
        et_filed3.setText(user.getFiled3_());
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_update__user_list;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btn_update:
                name = et_name.getText().toString().trim();
                if ("男".equalsIgnoreCase(sp_sex.getSelectedItem().toString())){
                    sex = "1";
                }else {
                    sex = "0";
                }
                filed1 = et_filed1.getText().toString().trim();
                filed2 = et_filed2.getText().toString().trim();
                filed3 = et_filed3.getText().toString().trim();
                if (Empty(name, sex, birthday, filed1, filed2, filed3)) {
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

                String ss = String.format(Constants.UPDATE_URL_12, user.getId_(), name, sex, birthday, filed1, filed2, filed3);
                Log.d("Update", ss);

                mDataTask.get(String.format(Constants.UPDATE_URL_12, user.getId_(), name, sex, birthday, filed1, filed2, filed3), null, null, this);
                break;
            case R.id.btn_birthday:
                DatePickerDialog dpd1 = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        birthday =year+"-"+(month+1)+"-"+dayOfMonth;
                        btn_birthday.setText(birthday);
                    }
                },year,month,day);
                dpd1.show();
                break;
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
        Log.d("UPDATE", string);
        if (JsonUtil.PareJson(string)) {
            new SweetAlertDialog(Update_UserListActivity.this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Good job!")
                    .setContentText("修改成功")
                    .show();
        } else {
            new SweetAlertDialog(Update_UserListActivity.this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("修改失败")
                    .show();
        }
    }

    @Override
    public void onRequestError(Exception e) {
        pDialog.dismiss();
        new SweetAlertDialog(Update_UserListActivity.this, SweetAlertDialog.ERROR_TYPE)
                .setConfirmText("网络错误")
                .show();
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }

}
