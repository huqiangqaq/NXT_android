package com.nxt.moderagricultrue;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.nxt.moderagricultrue.fragment.Fragment_One;
import com.nxt.moderagricultrue.fragment.Fragment_two;

import java.io.UnsupportedEncodingException;

public class Main2Activity extends BaseActivity{
    private RelativeLayout rl_content;
    private Fragment fragment_one,fragment_two;
    private boolean isRoot = false;
    @Override
    protected void initView() throws UnsupportedEncodingException {
        fragment_one = new Fragment_One();
        fragment_two = new Fragment_two();
        rl_content = (RelativeLayout) findViewById(R.id.rl_content);
        //此处添加判断,从服务器取得账户的权限
        if (true){
            //加载多个权限的碎片
            getSupportFragmentManager().beginTransaction().add(R.id.rl_content,fragment_two).commit();

        }
        getSupportFragmentManager().beginTransaction().add(R.id.rl_content,fragment_one).commit();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }
}
