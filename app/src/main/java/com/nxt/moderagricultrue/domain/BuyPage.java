package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class BuyPage implements Serializable{

    private String vcrecno;
    private String vccultivar;
    private int itype;
    private String dtbuy;
    private String fnum;
    private String vcbuyman;
    private String vcmadecomp;
    private String vcsalecomp;
    private String dtinstoredate;
    private String vcinstoreman;

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

    public String getDtbuy() {
        return dtbuy;
    }

    public void setDtbuy(String dtbuy) {
        this.dtbuy = dtbuy;
    }

    public String getFnum() {
        return fnum;
    }

    public void setFnum(String fnum) {
        this.fnum = fnum;
    }

    public String getVcbuyman() {
        return vcbuyman;
    }

    public void setVcbuyman(String vcbuyman) {
        this.vcbuyman = vcbuyman;
    }

    public String getVcmadecomp() {
        return vcmadecomp;
    }

    public void setVcmadecomp(String vcmadecomp) {
        this.vcmadecomp = vcmadecomp;
    }

    public String getVcsalecomp() {
        return vcsalecomp;
    }

    public void setVcsalecomp(String vcsalecomp) {
        this.vcsalecomp = vcsalecomp;
    }

    public String getDtinstoredate() {
        return dtinstoredate;
    }

    public void setDtinstoredate(String dtinstoredate) {
        this.dtinstoredate = dtinstoredate;
    }

    public String getVcinstoreman() {
        return vcinstoreman;
    }

    public void setVcinstoreman(String vcinstoreman) {
        this.vcinstoreman = vcinstoreman;
    }
}
