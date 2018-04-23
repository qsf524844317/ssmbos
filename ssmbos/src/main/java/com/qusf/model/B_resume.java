package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class B_resume implements Serializable {
    private int res_id;
    private String res_name;
    private String res_phone;
    private String res_email;
    private int res_u_id;
    private String res_education;
    private String res_p_name;
    private int res_state;

    public B_resume() {
    }

    public B_resume(int res_id, String res_name, String res_phone, String res_email, int res_u_id, String res_education, String res_p_name, int res_state) {
        this.res_id = res_id;
        this.res_name = res_name;
        this.res_phone = res_phone;
        this.res_email = res_email;
        this.res_u_id = res_u_id;
        this.res_education = res_education;
        this.res_p_name = res_p_name;
        this.res_state = res_state;
    }

    public int getRes_id() {
        return res_id;
    }

    public void setRes_id(int res_id) {
        this.res_id = res_id;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getRes_phone() {
        return res_phone;
    }

    public void setRes_phone(String res_phone) {
        this.res_phone = res_phone;
    }

    public String getRes_email() {
        return res_email;
    }

    public void setRes_email(String res_email) {
        this.res_email = res_email;
    }

    public int getRes_u_id() {
        return res_u_id;
    }

    public void setRes_u_id(int res_u_id) {
        this.res_u_id = res_u_id;
    }

    public String getRes_education() {
        return res_education;
    }

    public void setRes_education(String res_education) {
        this.res_education = res_education;
    }

    public String getRes_p_name() {
        return res_p_name;
    }

    public void setRes_p_name(String res_p_name) {
        this.res_p_name = res_p_name;
    }

    public int getRes_state() {
        return res_state;
    }

    public void setRes_state(int res_state) {
        this.res_state = res_state;
    }
}
