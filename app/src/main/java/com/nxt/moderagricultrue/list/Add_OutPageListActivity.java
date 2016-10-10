package com.nxt.moderagricultrue.list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.R;

import java.io.UnsupportedEncodingException;

public class Add_OutPageListActivity extends BaseActivity {
    private EditText et_vccultivar,et_itype,et_dtgrant,et_fnum,et_vcreceiver,et_vcgrantman;

    @Override
    protected void initView() throws UnsupportedEncodingException {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_add__out_page_list;
    }
}
