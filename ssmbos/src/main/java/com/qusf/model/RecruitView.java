package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/25.
 */
public class RecruitView implements Serializable{
    private String p_name;
    private String rec_require;
    private String d_name;
    private String rec_salary;
    private int rec_empnumber;
    private String rec_contact;
    private int rec_d_id;
    private int rec_p_id;
    private int rec_id;

    public RecruitView() {
    }

    public RecruitView(String p_name, String rec_require, String d_name, String rec_salary, int rec_empnumber, String rec_contact) {
        this.p_name = p_name;
        this.rec_require = rec_require;
        this.d_name = d_name;
        this.rec_salary = rec_salary;
        this.rec_empnumber = rec_empnumber;
        this.rec_contact = rec_contact;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getRec_require() {
        return rec_require;
    }

    public void setRec_require(String rec_require) {
        this.rec_require = rec_require;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
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

    public int getRec_id() {
        return rec_id;
    }

    public void setRec_id(int rec_id) {
        this.rec_id = rec_id;
    }

    @Override
    public String toString() {
        return "RecruitView{" +
                "p_name='" + p_name + '\'' +
                ", rec_require='" + rec_require + '\'' +
                ", d_name='" + d_name + '\'' +
                ", rec_salary='" + rec_salary + '\'' +
                ", rec_empnumber=" + rec_empnumber +
                ", rec_contact='" + rec_contact + '\'' +
                '}';
    }
}
