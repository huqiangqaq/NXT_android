package com.nxt.moderagricultrue.findbyid;

import android.view.View;
import android.widget.TextView;

import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.Parcel;

import java.io.UnsupportedEncodingException;

/**
 * Created by xpeng on 2016/9/17.
 */

public class ParcelDetailActivity extends BaseActivity {
    private TextView tv_01,tv_02,tv_03,tv_04,tv_05,tv_06,tv_07,tv_08,tv_09;
    @Override
    protected void initView() throws UnsupportedEncodingException {
        tv_01=(TextView) findViewById(R.id.buypage_01);
        tv_02=(TextView)findViewById(R.id.buypage_02);
        tv_03=(TextView) findViewById(R.id.buypage_03);
        tv_04=(TextView)findViewById(R.id.buypage_04);
        tv_05=(TextView) findViewById(R.id.buypage_05);
        tv_06=(TextView)findViewById(R.id.buypage_06);
        tv_07=(TextView) findViewById(R.id.buypage_07);
        tv_08=(TextView)findViewById(R.id.buypage_08);
        tv_09=(TextView) findViewById(R.id.buypage_09);
        tv_08.setVisibility(View.GONE);
        tv_09.setVisibility(View.GONE);

        Parcel vcrecno=(Parcel) getIntent().getSerializableExtra(Constants.VCRECNO);
        if(vcrecno != null){
            tv_01.setText("生产区名称："+vcrecno.getVcareanodesc());
            tv_02.setText("地块名称："+vcrecno.getVcparceldesc());
            tv_03.setText("地块面积（亩）："+vcrecno.getFparcelarea());
            tv_04.setText("地块用途："+vcrecno.getVcpurpose());
            tv_05.setText("种植面积："+vcrecno.getFplantarea());
            tv_06.setText("负责人："+vcrecno.getVcmanager());
            tv_07.setText("状态："+vcrecno.getIstatus());
//            tv_08.setText("记录产生时间："+vcrecno.getDtinstoredate().substring(0,10));
//            tv_09.setText("记录编辑人："+vcrecno.getVcinstoreman());
        }
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_detail_buypage;
    }

    public void onLeftClick(View view) {
        onBackPressed();
        finish();
    }
}
