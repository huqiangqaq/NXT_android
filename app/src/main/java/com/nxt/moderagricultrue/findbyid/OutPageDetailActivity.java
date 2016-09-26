package com.nxt.moderagricultrue.findbyid;

import android.view.View;
import android.widget.TextView;

import com.nxt.moderagricultrue.BaseActivity;
import com.nxt.moderagricultrue.Constants;
import com.nxt.moderagricultrue.R;
import com.nxt.moderagricultrue.domain.OutPage;

import java.io.UnsupportedEncodingException;

/**
 * Created by xpeng on 2016/9/17.
 */

public class OutPageDetailActivity extends BaseActivity {
    private TextView tv_01,tv_02,tv_03,tv_04,tv_05,tv_06,tv_07,tv_08,tv_09,tv_10,tv_11;
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

        OutPage vcrecno=(OutPage) getIntent().getSerializableExtra(Constants.VCRECNO);
        if(vcrecno != null){
            tv_01.setText("发放品种："+vcrecno.getVccultivar());
            if(vcrecno.getItype()==1){
                tv_02.setText("类别：种子");
            }else if (vcrecno.getItype()==2){
                tv_02.setText("类别：农药");
            }else if (vcrecno.getItype()==3){
                tv_02.setText("类别：化肥");
            }else if (vcrecno.getItype()==4){
                tv_02.setText("类别：农膜");
            }
            tv_03.setText("发放时间："+vcrecno.getDtgrant().substring(0,10));
            tv_04.setText("发放数量："+vcrecno.getFnum());
            tv_05.setText("购买人："+vcrecno.getFnum());
            tv_06.setText("领取人："+vcrecno.getVcreceiver());
            tv_07.setText("发放人："+vcrecno.getVcgrantman());
//            tv_08.setText("入库时间："+vcrecno.getDtinstoredate().substring(0,10));
//            tv_09.setText("入库人："+vcrecno.getVcinstoreman());
//            tv_10.setText("记录编辑人："+vcrecno.getVccultivar());
//            tv_11.setText("记录产生时间："+vcrecno.getVccultivar());
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
