package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Diseased implements Serializable{
    private String vcrecno;
    private String vccutsno;
    private String vcparcelno;
    private String vcparceldesc;
    private String vcdrug;
    private String dtpharmacydate;
    private String dtpharmacynum;
    private String dtpharmacypatten;

    public String getVcrecno() {
        return vcrecno;
    }

    public void setVcrecno(String vcrecno) {
        this.vcrecno = vcrecno;
    }

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

    public String getVcdrug() {
        return vcdrug;
    }

    public void setVcdrug(String vcdrug) {
        this.vcdrug = vcdrug;
    }

    public String getDtpharmacydate() {
        return dtpharmacydate;
    }

    public void setDtpharmacydate(String dtpharmacydate) {
        this.dtpharmacydate = dtpharmacydate;
    }

    public String getDtpharmacynum() {
        return dtpharmacynum;
    }

    public void setDtpharmacynum(String dtpharmacynum) {
        this.dtpharmacynum = dtpharmacynum;
    }

    public String getDtpharmacypatten() {
        return dtpharmacypatten;
    }

    public void setDtpharmacypatten(String dtpharmacypatten) {
        this.dtpharmacypatten = dtpharmacypatten;
    }
}
