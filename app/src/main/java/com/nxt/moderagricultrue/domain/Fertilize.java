package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Fertilize implements Serializable {
    private String vcrecno;
    private String vcparcelno;
    private String vcparceldesc;
    private String vccutsno;
    private String dtfertilizedate;
    private String vcfertilizenum;
    private String vcfertilizerrate;

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

    public String getDtfertilizedate() {
        return dtfertilizedate;
    }

    public void setDtfertilizedate(String dtfertilizedate) {
        this.dtfertilizedate = dtfertilizedate;
    }

    public String getVcfertilizenum() {
        return vcfertilizenum;
    }

    public void setVcfertilizenum(String vcfertilizenum) {
        this.vcfertilizenum = vcfertilizenum;
    }

    public String getVcfertilizerrate() {
        return vcfertilizerrate;
    }

    public void setVcfertilizerrate(String vcfertilizerrate) {
        this.vcfertilizerrate = vcfertilizerrate;
    }
}
