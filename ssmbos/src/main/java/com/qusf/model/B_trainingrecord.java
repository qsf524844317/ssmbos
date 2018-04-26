package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/26.
 */
public class B_trainingrecord implements Serializable{
    private int tr_id;
    private int tr_t_id;
    private int tr_e_id;
    private String tr_grand;

    public B_trainingrecord() {
    }

    public B_trainingrecord(int tr_id, int tr_t_id, int tr_e_id, String tr_grand) {
        this.tr_id = tr_id;
        this.tr_t_id = tr_t_id;
        this.tr_e_id = tr_e_id;
        this.tr_grand = tr_grand;
    }

    public int getTr_id() {
        return tr_id;
    }

    public void setTr_id(int tr_id) {
        this.tr_id = tr_id;
    }

    public int getTr_t_id() {
        return tr_t_id;
    }

    public void setTr_t_id(int tr_t_id) {
        this.tr_t_id = tr_t_id;
    }

    public int getTr_e_id() {
        return tr_e_id;
    }

    public void setTr_e_id(int tr_e_id) {
        this.tr_e_id = tr_e_id;
    }

    public String getTr_grand() {
        return tr_grand;
    }

    public void setTr_grand(String tr_grand) {
        this.tr_grand = tr_grand;
    }
}
