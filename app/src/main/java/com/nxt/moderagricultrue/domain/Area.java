package com.nxt.moderagricultrue.domain;

import java.io.Serializable;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Area implements Serializable {
    private String vcareano;
    private String vcareadesc;

    public String getVcareano() {
        return vcareano;
    }

    public void setVcareano(String vcareano) {
        this.vcareano = vcareano;
    }

    public String getVcareadesc() {
        return vcareadesc;
    }

    public void setVcareadesc(String vcareadesc) {
        this.vcareadesc = vcareadesc;
    }
}
