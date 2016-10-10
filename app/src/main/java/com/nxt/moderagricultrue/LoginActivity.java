package com.nxt.moderagricultrue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nxt.moderagricultrue.domain.LoginReturn;
import com.nxt.zyl.data.ZDataTask;

import java.util.ArrayList;

/**
 * Created by xpeng on 2016/9/13.
 */

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";

    private EditText etUnm,etPwd;
    private Button btnLogin;
    private String username,password;
    private ZDataTask mDataTask;
    private MyApplication application;

    @Override
    protected void initView(){
        application = MyApplication.getInstance();
        etUnm=(EditText)findViewById(R.id.login_et_login);
        etPwd=(EditText)findViewById(R.id.login_et_pwd);
        btnLogin=(Button)findViewById(R.id.login_btn_login);

        onBtnLoginClick();
        initData();
    }

    private void initData(){
        mDataTask=MyApplication.getInstance().getZDataTask();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    private void onBtnLoginClick(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               login();
            }
        });
    }

    private void login(){
        username=etUnm.getText().toString().trim();
        password=etPwd.getText().toString().trim();

        if(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)){
            Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!ComUtils.isNetWorkConnected(this)) {
            Toast.makeText(this, "网络不可用", Toast.LENGTH_SHORT).show();
            return;
        }
        showLoadingDialog("正在登录……");
        String ss = String.format(Constants.LOGIN_URL,username,password);
        Log.d(TAG, ss);
        mDataTask.get(String.format(Constants.LOGIN_URL,username,password),null,null,this);
    }

    @Override
    public void onRequestResult(String string) {
        dismissLoadingDialog();
        LoginReturn loginReturn = new Gson().fromJson(string,LoginReturn.class);
        String loginUser = loginReturn.get_default_string_a();
        application.setDefaut_string(loginUser);
        application.setOrgID(loginReturn.get_order());
        if ("2".equalsIgnoreCase(loginUser)){
            //超级用户
            startActivity(new Intent(this,Main2Activity.class).putExtra("loginUser",loginUser));
            this.finish();
        }else if ("1".equalsIgnoreCase(loginUser)){
            //普通用户
            application.setList(loginReturn.get_default_list_a());
            startActivity(new Intent(this,Main2Activity.class).putExtra("loginUser",loginUser));
            this.finish();
        }else {
            Toast.makeText(this,"账号或密码错误",Toast.LENGTH_SHORT).show();
        }
//        Log.e(TAG,string);
//        if(string.contains("1")){
//            startActivity(new Intent(this,Main2Activity.class));
//            this.finish();
//        }else {
//            Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
//        }
    }
}
