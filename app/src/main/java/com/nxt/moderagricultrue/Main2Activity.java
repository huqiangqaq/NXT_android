package com.nxt.moderagricultrue;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.nxt.moderagricultrue.fragment.Fragment_One;

import java.io.UnsupportedEncodingException;

public class Main2Activity extends BaseActivity{
    private RelativeLayout rl_content;
    private Fragment fragment_one;
    @Override
    protected void initView() throws UnsupportedEncodingException {
        fragment_one = new Fragment_One();
        rl_content = (RelativeLayout) findViewById(R.id.rl_content);
        //此处添加判断
        getSupportFragmentManager().beginTransaction().add(R.id.rl_content,fragment_one).commit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }
}
