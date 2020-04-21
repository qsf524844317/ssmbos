package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/25.
 */
public class B_application implements Serializable{
    private int a_id;
    private int a_res_id;
    private int a_rec_id;
    private int a_state;
    private int a_invitestate;
    private String a_invitedetail;
    private String res_name;

    public B_application() {
    }

    public B_application(int a_id, int a_res_id, int a_rec_id, int a_state, int a_invitestate, String a_invitedetail) {
        this.a_id = a_id;
        this.a_res_id = a_res_id;
        this.a_rec_id = a_rec_id;
        this.a_state = a_state;
        this.a_invitestate = a_invitestate;
        this.a_invitedetail = a_invitedetail;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public int getA_res_id() {
        return a_res_id;
    }

    public void setA_res_id(int a_res_id) {
        this.a_res_id = a_res_id;
    }

    public int getA_rec_id() {
        return a_rec_id;
    }

    public void setA_rec_id(int a_rec_id) {
        this.a_rec_id = a_rec_id;
    }

    public int getA_state() {
        return a_state;
    }

    public void setA_state(int a_state) {
        this.a_state = a_state;
    }

    public int getA_invitestate() {
        return a_invitestate;
    }

    public void setA_invitestate(int a_invitestate) {
        this.a_invitestate = a_invitestate;
    }

    public String getA_invitedetail() {
        return a_invitedetail;
    }

    public void setA_invitedetail(String a_invitedetail) {
        this.a_invitedetail = a_invitedetail;
    }

    public String getRes_name() {
        return res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }
}
