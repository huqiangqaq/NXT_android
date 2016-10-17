package com.nxt.moderagricultrue.domain;

import java.util.List;

/**
 * Created by huqiang on 2016/10/14.
 */

public class Test {


    /**
     * type : 苦瓜病虫害
     * arr : []
     */

    private List<RowsBean> Rows;

    public List<RowsBean> getRows() {
        return Rows;
    }

    public void setRows(List<RowsBean> Rows) {
        this.Rows = Rows;
    }

    public static class RowsBean {
        private String type;
        private List<Item> arr;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Item> getArr() {
            return arr;
        }

        public void setArr(List<Item> arr) {
            this.arr = arr;
        }
    }
}
