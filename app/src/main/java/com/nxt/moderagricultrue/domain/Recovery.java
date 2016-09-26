package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Recovery implements Serializable {
    private String vcrecno;
    private String vcparcelno;
    private String vcparceldesc;
    private String vccutsno;
    private String dtrecoverydate;
    private String vcrecoveryman;
    private String vcmaturity;
    private String frecovery;

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

    public String getDtrecoverydate() {
        return dtrecoverydate;
    }

    public void setDtrecoverydate(String dtrecoverydate) {
        this.dtrecoverydate = dtrecoverydate;
    }

    public String getVcrecoveryman() {
        return vcrecoveryman;
    }

    public void setVcrecoveryman(String vcrecoveryman) {
        this.vcrecoveryman = vcrecoveryman;
    }

    public String getVcmaturity() {
        return vcmaturity;
    }

    public void setVcmaturity(String vcmaturity) {
        this.vcmaturity = vcmaturity;
    }

    public String getFrecovery() {
        return frecovery;
    }

    public void setFrecovery(String frecovery) {
        this.frecovery = frecovery;
    }
}
