package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class B_emp implements Serializable{
    private int e_id;
    private String e_pass;
    private String e_name;
    private String   e_email;
    private String e_phone;
    private int e_d_id;
    private int e_p_id;
    private String d_name;
    private String p_name;
    private String e_joindate;
    private int e_dimission;
    private String e_education;

    public B_emp() {
    }

    public B_emp(int e_id, String e_pass, String e_name, String e_email, String e_phone, int e_d_id, int e_p_id, String e_joindate, int e_dimission) {
        this.e_id = e_id;
        this.e_pass = e_pass;
        this.e_name = e_name;
        this.e_email = e_email;
        this.e_phone = e_phone;
        this.e_d_id = e_d_id;
        this.e_p_id = e_p_id;
        this.e_joindate = e_joindate;
        this.e_dimission = e_dimission;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_pass() {
        return e_pass;
    }

    public void setE_pass(String e_pass) {
        this.e_pass = e_pass;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
    }

    public String getE_phone() {
        return e_phone;
    }

    public void setE_phone(String e_phone) {
        this.e_phone = e_phone;
    }

    public int getE_d_id() {
        return e_d_id;
    }

    public void setE_d_id(int e_d_id) {
        this.e_d_id = e_d_id;
    }

    public int getE_p_id() {
        return e_p_id;
    }

    public void setE_p_id(int e_p_id) {
        this.e_p_id = e_p_id;
    }

    public String getE_joindate() {
        return e_joindate;
    }

    public void setE_joindate(String e_joindate) {
        this.e_joindate = e_joindate;
    }

    public int getE_dimission() {
        return e_dimission;
    }

    public void setE_dimission(int e_dimission) {
        this.e_dimission = e_dimission;
    }

    public String getE_education() {
        return e_education;
    }

    public void setE_education(String e_education) {
        this.e_education = e_education;
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

    @Override
    public String toString() {
        return "B_emp{" +
                "e_id=" + e_id +
                ", e_pass='" + e_pass + '\'' +
                ", e_name='" + e_name + '\'' +
                ", e_email='" + e_email + '\'' +
                ", e_phone='" + e_phone + '\'' +
                ", e_d_id=" + e_d_id +
                ", e_p_id=" + e_p_id +
                ", d_name='" + d_name + '\'' +
                ", p_name='" + p_name + '\'' +
                ", e_joindate='" + e_joindate + '\'' +
                ", e_dimission=" + e_dimission +
                ", e_education='" + e_education + '\'' +
                '}';
    }
}
