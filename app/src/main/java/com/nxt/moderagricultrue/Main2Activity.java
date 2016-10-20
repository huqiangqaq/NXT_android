package com.nxt.moderagricultrue;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.nxt.moderagricultrue.Utils.UpdateManager;
import com.nxt.moderagricultrue.domain.LoginReturn;
import com.nxt.moderagricultrue.fragment.Fragment_One;
import com.nxt.moderagricultrue.fragment.Fragment_two;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends BaseActivity{
    private RelativeLayout rl_content;
    private Fragment fragment_one,fragment_two;
    private boolean isRoot = true;
    private List<LoginReturn.DefaultListABean> list = new ArrayList<>();
    private MyApplication application;
    @Override
    protected void initView() throws UnsupportedEncodingException {
        application = MyApplication.getInstance();
        //检测版本更新
        new UpdateManager(this).checkUpdate();
        fragment_one = new Fragment_One();
        fragment_two = new Fragment_two();
        rl_content = (RelativeLayout) findViewById(R.id.rl_content);
        String flag = getIntent().getStringExtra("loginUser");
        if ("2".equalsIgnoreCase(flag)){
            //超级用户
            getSupportFragmentManager().beginTransaction().add(R.id.rl_content,fragment_two).commit();
        }else {
           list = application.getList();
            if (list.size()<2){
                getSupportFragmentManager().beginTransaction().add(R.id.rl_content,fragment_one).commit();
            }
            getSupportFragmentManager().beginTransaction().add(R.id.rl_content,fragment_two).commit();

        }




    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }
}
