package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class OutPage implements Serializable {
    private String vcrecno;
    private String vccultivar;
    private int itype;
    private String dtgrant;
    private String fnum;
    private String vcreceiver;
    private String vcgrantman;

    public String getVcrecno() {
        return vcrecno;
    }

    public void setVcrecno(String vcrecno) {
        this.vcrecno = vcrecno;
    }

    public String getVccultivar() {
        return vccultivar;
    }

    public void setVccultivar(String vccultivar) {
        this.vccultivar = vccultivar;
    }

    public int getItype() {
        return itype;
    }

    public void setItype(int itype) {
        this.itype = itype;
    }

    public String getDtgrant() {
        return dtgrant;
    }

    public void setDtgrant(String dtgrant) {
        this.dtgrant = dtgrant;
    }

    public String getFnum() {
        return fnum;
    }

    public void setFnum(String fnum) {
        this.fnum = fnum;
    }

    public String getVcreceiver() {
        return vcreceiver;
    }

    public void setVcreceiver(String vcreceiver) {
        this.vcreceiver = vcreceiver;
    }

    public String getVcgrantman() {
        return vcgrantman;
    }

    public void setVcgrantman(String vcgrantman) {
        this.vcgrantman = vcgrantman;
    }
}
