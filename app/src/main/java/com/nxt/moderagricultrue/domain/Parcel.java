package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Parcel implements Serializable {
    private String vcparcelno;
    private String vcareano;
    private String vcparceldesc;
    private String vcpurpose;
    private String vcmanager;
    private int fparcelarea;
    private int fplantarea;
    private int istatus;
    private String vcareanodesc;

    public String getVcparcelno() {
        return vcparcelno;
    }

    public void setVcparcelno(String vcparcelno) {
        this.vcparcelno = vcparcelno;
    }

    public String getVcareano() {
        return vcareano;
    }

    public void setVcareano(String vcareano) {
        this.vcareano = vcareano;
    }

    public String getVcparceldesc() {
        return vcparceldesc;
    }

    public void setVcparceldesc(String vcparceldesc) {
        this.vcparceldesc = vcparceldesc;
    }

    public String getVcpurpose() {
        return vcpurpose;
    }

    public void setVcpurpose(String vcpurpose) {
        this.vcpurpose = vcpurpose;
    }

    public String getVcmanager() {
        return vcmanager;
    }

    public void setVcmanager(String vcmanager) {
        this.vcmanager = vcmanager;
    }

    public int getFparcelarea() {
        return fparcelarea;
    }

    public void setFparcelarea(int fparcelarea) {
        this.fparcelarea = fparcelarea;
    }

    public int getFplantarea() {
        return fplantarea;
    }

    public void setFplantarea(int fplantarea) {
        this.fplantarea = fplantarea;
    }

    public int getIstatus() {
        return istatus;
    }

    public void setIstatus(int istatus) {
        this.istatus = istatus;
    }

    public String getVcareanodesc() {
        return vcareanodesc;
    }

    public void setVcareanodesc(String vcareanodesc) {
        this.vcareanodesc = vcareanodesc;
    }
}
