package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class B_position implements Serializable {
    private int p_id;
    private String p_name;
    private int p_d_id;
    private int p_e_id;
    private String p_salary;

    public B_position() {
    }

    public B_position(int p_id, String p_name, int p_d_id, int p_e_id, String p_salary) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_d_id = p_d_id;
        this.p_e_id = p_e_id;
        this.p_salary = p_salary;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public int getP_d_id() {
        return p_d_id;
    }

    public void setP_d_id(int p_d_id) {
        this.p_d_id = p_d_id;
    }

    public int getP_e_id() {
        return p_e_id;
    }

    public void setP_e_id(int p_e_id) {
        this.p_e_id = p_e_id;
    }

    public String getP_salary() {
        return p_salary;
    }

    public void setP_salary(String p_salary) {
        this.p_salary = p_salary;
    }


}
