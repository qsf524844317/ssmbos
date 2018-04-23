package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class B_train implements Serializable{
    private int t_id;
    private String t_theme;
    private String t_details;
    private int t_e_id;
    private String t_address;
    private String t_start;
    private String t_end;

    public B_train() {
    }

    public B_train(int t_id, String t_theme, String t_details, int t_e_id, String t_address, String t_start, String t_end) {
        this.t_id = t_id;
        this.t_theme = t_theme;
        this.t_details = t_details;
        this.t_e_id = t_e_id;
        this.t_address = t_address;
        this.t_start = t_start;
        this.t_end = t_end;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_theme() {
        return t_theme;
    }

    public void setT_theme(String t_theme) {
        this.t_theme = t_theme;
    }

    public String getT_details() {
        return t_details;
    }

    public void setT_details(String t_details) {
        this.t_details = t_details;
    }

    public int getT_e_id() {
        return t_e_id;
    }

    public void setT_e_id(int t_e_id) {
        this.t_e_id = t_e_id;
    }

    public String getT_address() {
        return t_address;
    }

    public void setT_address(String t_address) {
        this.t_address = t_address;
    }

    public String getT_start() {
        return t_start;
    }

    public void setT_start(String t_start) {
        this.t_start = t_start;
    }

    public String getT_end() {
        return t_end;
    }

    public void setT_end(String t_end) {
        this.t_end = t_end;
    }
}
