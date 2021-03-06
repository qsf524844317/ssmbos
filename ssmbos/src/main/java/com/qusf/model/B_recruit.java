package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class B_recruit implements Serializable{
    private int rec_id;
    private String rec_require;
    private String rec_salary;
    private int rec_empnumber;
    private String rec_contact;
    private int rec_d_id;
    private int rec_p_id;
    private String d_name;
    private String p_name;

    public B_recruit() {
    }

    public B_recruit(int rec_id, String rec_require, String rec_salary, int rec_empnumber, String rec_contact, int rec_d_id, int rec_p_id) {
        this.rec_id = rec_id;
        this.rec_require = rec_require;
        this.rec_salary = rec_salary;
        this.rec_empnumber = rec_empnumber;
        this.rec_contact = rec_contact;
        this.rec_d_id = rec_d_id;
        this.rec_p_id = rec_p_id;
    }

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    public String getRec_require() {
        return rec_require;
    }

    public void setRec_require(String rec_require) {
        this.rec_require = rec_require;
    }

    public String getRec_salary() {
        return rec_salary;
    }

    public void setRec_salary(String rec_salary) {
        this.rec_salary = rec_salary;
    }

    public int getRec_empnumber() {
        return rec_empnumber;
    }

    public void setRec_empnumber(int rec_empnumber) {
        this.rec_empnumber = rec_empnumber;
    }

    public String getRec_contact() {
        return rec_contact;
    }

    public void setRec_contact(String rec_contact) {
        this.rec_contact = rec_contact;
    }

    public int getRec_d_id() {
        return rec_d_id;
    }

    public void setRec_d_id(int rec_d_id) {
        this.rec_d_id = rec_d_id;
    }

    public int getRec_p_id() {
        return rec_p_id;
    }

    public void setRec_p_id(int rec_p_id) {
        this.rec_p_id = rec_p_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }
}
