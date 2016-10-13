package com.nxt.moderagricultrue.list.UserList;

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
import com.nxt.moderagricultrue.domain.User;
import com.nxt.moderagricultrue.list.UpdateActivity;
import com.nxt.zyl.data.ZDataTask;
import com.nxt.zyl.util.JsonUtil;

import java.io.UnsupportedEncodingException;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.nxt.moderagricultrue.R.id.et_filed3;
import static com.nxt.moderagricultrue.R.id.et_itype;
import static com.nxt.moderagricultrue.R.id.et_vccultivar;
import static com.nxt.moderagricultrue.R.id.filed3;

public class Update_UserListActivity extends BaseActivity {
    private EditText et_name, et_sex, et_birthday, et_filed1, et_filed2, et_filed3;
    private String name, sex, birthday, filed1, filed2, filed3;
    private Button btn_update;

    private ZDataTask mDataTask;
    private SweetAlertDialog pDialog;
    private User user;

    @Override
    protected void initView() throws UnsupportedEncodingException {
        et_name = (EditText) findViewById(R.id.et_name);
        et_sex = (EditText) findViewById(R.id.et_sex);
        et_birthday = (EditText) findViewById(R.id.et_birthday);
        et_filed1 = (EditText) findViewById(R.id.et_filed1);
        et_filed2 = (EditText) findViewById(R.id.et_filed2);
        et_filed3 = (EditText) findViewById(R.id.et_filed3);

        btn_update = (Button) findViewById(R.id.btn_update);
        btn_update.setOnClickListener(this);
        initData();
    }

    private void initData() {
        mDataTask = MyApplication.getInstance().getZDataTask();

        user = (User) getIntent().getSerializableExtra(Constants.VCRECNO);
        et_name.setText(user.getName_());
        if ("1".equalsIgnoreCase(user.getSex_())) {
            et_sex.setText("男");
        } else {
            et_sex.setText("女");
        }

        et_birthday.setText(user.getBirthday_());
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
                sex = et_sex.getText().toString().trim();
                birthday = et_birthday.getText().toString().trim();
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
