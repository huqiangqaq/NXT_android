package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class SeedBatch implements Serializable {
//    "vccutsno": "1",  茬次号
//    "vcparcelno": "0783889a65a74443bc47f48daa4bf34c",  地块编号
//    "vcparceldesc": "黄豆大棚1号", 地块名称
//    "breap": 1, 是否收割
//    0：未收割
//    1：已收割',
//            "dtbreeddate": "2016-09-04 14:43:29", 播种时间
    private String vccutsno;
    private String vcparcelno;
    private String vcparceldesc;
    private int breap;
    private String dtbreeddate;

    public String getVccutsno() {
        return vccutsno;
    }

    public void setVccutsno(String vccutsno) {
        this.vccutsno = vccutsno;
    }

    public String getVcparcelno() {
        return vcparcelno;
    }

    public void setVcparcelno(String vcparcelno) {
        this.vcparcelno = vcparcelno;
    }

    public String getVcparceldesc() {
        return vcparceldesc;
    }

    public void setVcparceldesc(String vcparceldesc) {
        this.vcparceldesc = vcparceldesc;
    }

    public int getBreap() {
        return breap;
    }

    public void setBreap(int breap) {
        this.breap = breap;
    }

    public String getDtbreeddate() {
        return dtbreeddate;
    }

    public void setDtbreeddate(String dtbreeddate) {
        this.dtbreeddate = dtbreeddate;
    }
}
