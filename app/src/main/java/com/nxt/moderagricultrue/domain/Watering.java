package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Watering implements Serializable {
//    "vcrecno": "0f5a8360d13a489fb1443328fe88c4e5",  记录编号
//    "vcparcelno": "8f9cd5595ef54c599d928c00fc0f29c5",  地块编号
//    "vcparceldesc": "小白菜大棚1号", 地块名称
//    "dtirrigatedate": "2016-08-10 00:00:00",  灌溉时间
//    "fwastewater": "600",  用水量
    private String vcrecno;
    private String vcparcelno;
    private String vcparceldesc;
    private String dtirrigatedate;
    private String fwastewater;

    public String getVcrecno() {
        return vcrecno;
    }

    public void setVcrecno(String vcrecno) {
        this.vcrecno = vcrecno;
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

    public String getDtirrigatedate() {
        return dtirrigatedate;
    }

    public void setDtirrigatedate(String dtirrigatedate) {
        this.dtirrigatedate = dtirrigatedate;
    }

    public String getFwastewater() {
        return fwastewater;
    }

    public void setFwastewater(String fwastewater) {
        this.fwastewater = fwastewater;
    }
}
