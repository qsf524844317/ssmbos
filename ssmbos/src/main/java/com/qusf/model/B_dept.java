package com.qusf.model;

import java.io.Serializable;
/**
 * Created by SiFan on 2018/4/20.
 */
public class B_dept implements Serializable{
    private int d_id;
    private String d_name;
    private String d_address;
    private String d_createdate;

    public B_dept() {
    }

    public B_dept(int d_id, String d_name, String d_address, String d_createdate) {
        this.d_id = d_id;
        this.d_name = d_name;
        this.d_address = d_address;
        this.d_createdate = d_createdate;
    }

    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getD_address() {
        return d_address;
    }

    public void setD_address(String d_address) {
        this.d_address = d_address;
    }

    public String getD_createdate() {
        return d_createdate;
    }

    public void setD_createdate(String d_createdate) {
        this.d_createdate = d_createdate;
    }
}
