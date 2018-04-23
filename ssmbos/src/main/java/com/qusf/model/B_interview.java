package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class B_interview implements Serializable {
    private int i_id;
    private String i_interviewtime;
    private String i_interviewaddress;
    private int i_u_id;

    public B_interview() {
    }

    public B_interview(int i_id, String i_interviewtime, String i_interviewaddress, int i_u_id) {
        this.i_id = i_id;
        this.i_interviewtime = i_interviewtime;
        this.i_interviewaddress = i_interviewaddress;
        this.i_u_id = i_u_id;
    }

    public int getI_id() {
        return i_id;
    }

    public void setI_id(int i_id) {
        this.i_id = i_id;
    }

    public String getI_interviewtime() {
        return i_interviewtime;
    }

    public void setI_interviewtime(String i_interviewtime) {
        this.i_interviewtime = i_interviewtime;
    }

    public String getI_interviewaddress() {
        return i_interviewaddress;
    }

    public void setI_interviewaddress(String i_interviewaddress) {
        this.i_interviewaddress = i_interviewaddress;
    }

    public int getI_u_id() {
        return i_u_id;
    }

    public void setI_u_id(int i_u_id) {
        this.i_u_id = i_u_id;
    }
}
