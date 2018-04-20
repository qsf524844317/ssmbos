package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class T_user implements Serializable {
    private int u_id;
    private String u_username;
    private String u_passworld;
    private int u_type;

    public T_user() {
    }

    public T_user(String u_username, String u_passworld) {
        this.u_username = u_username;
        this.u_passworld = u_passworld;
    }

    public T_user(int u_id, String u_username, String u_passworld, int u_type) {
        this.u_id = u_id;
        this.u_username = u_username;
        this.u_passworld = u_passworld;
        this.u_type = u_type;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_username() {
        return u_username;
    }

    public void setU_username(String u_username) {
        this.u_username = u_username;
    }

    public String getU_passworld() {
        return u_passworld;
    }

    public void setU_passworld(String u_passworld) {
        this.u_passworld = u_passworld;
    }

    public int getU_type() {
        return u_type;
    }

    public void setU_type(int u_type) {
        this.u_type = u_type;
    }
}
