package com.nxt.moderagricultrue.findbyid;

import android.view.View;
import android.widget.TextView;

import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.Fertilize;

import java.io.UnsupportedEncodingException;

/**
 * Created by xpeng on 2016/9/17.
 */

public class FertilizeDetailActivity extends BaseActivity {
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

        tv_06.setVisibility(View.GONE);
        tv_07.setVisibility(View.GONE);
        tv_08.setVisibility(View.GONE);
        tv_09.setVisibility(View.GONE);

        Fertilize vcrecno=(Fertilize) getIntent().getSerializableExtra(Constants.VCRECNO);
        if(vcrecno != null){
            tv_01.setText("地块名称："+vcrecno.getVcparceldesc());
            tv_02.setText("茬次号："+vcrecno.getVccutsno());
            tv_03.setText("施肥时间："+vcrecno.getDtfertilizedate().substring(0,10));
            tv_04.setText("施肥数量："+vcrecno.getVcfertilizenum());
            tv_05.setText("肥料配比："+vcrecno.getVcfertilizerrate());
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
