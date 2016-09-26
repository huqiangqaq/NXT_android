package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Plot implements Serializable {
    private String vcrecno;
    private String vccutsno;
    private String vcparcelno;
    private String vcparceldesc;
    private String dtreadjust;
    private String vcreadjustpattern;
    private String vcdisinfect;
    private String vcoperateuser;
    private String dtoperatedate;

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

    public String getDtreadjust() {
        return dtreadjust;
    }

    public void setDtreadjust(String dtreadjust) {
        this.dtreadjust = dtreadjust;
    }

    public String getVcreadjustpattern() {
        return vcreadjustpattern;
    }

    public void setVcreadjustpattern(String vcreadjustpattern) {
        this.vcreadjustpattern = vcreadjustpattern;
    }

    public String getVcdisinfect() {
        return vcdisinfect;
    }

    public void setVcdisinfect(String vcdisinfect) {
        this.vcdisinfect = vcdisinfect;
    }

    public String getVcoperateuser() {
        return vcoperateuser;
    }

    public void setVcoperateuser(String vcoperateuser) {
        this.vcoperateuser = vcoperateuser;
    }

    public String getDtoperatedate() {
        return dtoperatedate;
    }

    public void setDtoperatedate(String dtoperatedate) {
        this.dtoperatedate = dtoperatedate;
    }
}
