package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class User implements Serializable {
//    "id_": "fa04db9dd2f54d61b0c8202a25de2dc6",  记录编号
//    "name_": "超级用户",  姓名
//    "sex_": "1",  性别
//    "birthday_": "",  生日
//    "filed1_": "超级用户",  职称
//    "filed2_": "超级用户"  专业
//    "filed3_": "超级用户"  工种
    private String id_;
    private String name_;
    private String sex_;
    private String birthday_;
    private String filed1_;
    private String filed2_;
    private String filed3_;

    public String getId_() {
        return id_;
    }

    public void setId_(String id_) {
        this.id_ = id_;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    public String getSex_() {
        return sex_;
    }

    public void setSex_(String sex_) {
        this.sex_ = sex_;
    }

    public String getBirthday_() {
        return birthday_;
    }

    public void setBirthday_(String birthday_) {
        this.birthday_ = birthday_;
    }

    public String getFiled1_() {
        return filed1_;
    }

    public void setFiled1_(String filed1_) {
        this.filed1_ = filed1_;
    }

    public String getFiled2_() {
        return filed2_;
    }

    public void setFiled2_(String filed2_) {
        this.filed2_ = filed2_;
    }

    public String getFiled3_() {
        return filed3_;
    }

    public void setFiled3_(String filed3_) {
        this.filed3_ = filed3_;
    }
}
