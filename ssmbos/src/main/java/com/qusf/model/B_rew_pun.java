package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class B_rew_pun implements Serializable{
    private int rp_id;
    private double re_money;
    private String re_reason;
    private int re_e_id;

    public B_rew_pun() {
    }

    public B_rew_pun(int rp_id, double re_money, String re_reason, int re_e_id) {
        this.rp_id = rp_id;
        this.re_money = re_money;
        this.re_reason = re_reason;
        this.re_e_id = re_e_id;
    }

    public int getRp_id() {
        return rp_id;
    }

    public void setRp_id(int rp_id) {
        this.rp_id = rp_id;
    }

    public double getRe_money() {
        return re_money;
    }

    public void setRe_money(double re_money) {
        this.re_money = re_money;
    }

    public String getRe_reason() {
        return re_reason;
    }

    public void setRe_reason(String re_reason) {
        this.re_reason = re_reason;
    }

    public int getRe_e_id() {
        return re_e_id;
    }

    public void setRe_e_id(int re_e_id) {
        this.re_e_id = re_e_id;
    }
}
