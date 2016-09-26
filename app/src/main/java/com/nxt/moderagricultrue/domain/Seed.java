package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Seed implements Serializable {
//    "vcrecno": "36fb61da873c4f69bc478c381ccecad1",  记录编号
//    "vcparcelno": "4cc4ea88ca8f4051b5d9d8147199f1b1", 地块编号
//    "vcparceldesc": "西北高地地块5-1区",  地块名称
//    "vccutsno": "20160906104013192",  茬次号
//    "vcbreed": "黄瓜",  播种品种
//    "dtseeddate": "2015-03-10 00:00:00",  播种时间
//    "vcseedpartten": "直播",  播种方式
//    "vcseeddensity": "10",   播种密度
//    "vcfertilize": "有机肥", 基肥施肥
//    "dtfirstirrigate": "2015-03-10 00:00:00",  首次灌溉时间
    private String vcrecno;
    private String vcparcelno;
    private String vcparceldesc;
    private String vccutsno;
    private String vcbreed;
    private String dtseeddate;
    private String vcseedpartten;
    private String vcseeddensity;
    private String vcfertilize;
    private String dtfirstirrigate;

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

    public String getVccutsno() {
        return vccutsno;
    }

    public void setVccutsno(String vccutsno) {
        this.vccutsno = vccutsno;
    }

    public String getVcbreed() {
        return vcbreed;
    }

    public void setVcbreed(String vcbreed) {
        this.vcbreed = vcbreed;
    }

    public String getDtseeddate() {
        return dtseeddate;
    }

    public void setDtseeddate(String dtseeddate) {
        this.dtseeddate = dtseeddate;
    }

    public String getVcseedpartten() {
        return vcseedpartten;
    }

    public void setVcseedpartten(String vcseedpartten) {
        this.vcseedpartten = vcseedpartten;
    }

    public String getVcseeddensity() {
        return vcseeddensity;
    }

    public void setVcseeddensity(String vcseeddensity) {
        this.vcseeddensity = vcseeddensity;
    }

    public String getVcfertilize() {
        return vcfertilize;
    }

    public void setVcfertilize(String vcfertilize) {
        this.vcfertilize = vcfertilize;
    }

    public String getDtfirstirrigate() {
        return dtfirstirrigate;
    }

    public void setDtfirstirrigate(String dtfirstirrigate) {
        this.dtfirstirrigate = dtfirstirrigate;
    }
}
