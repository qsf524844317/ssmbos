package com.qusf.model;

import java.io.Serializable;

/**
 * Created by SiFan on 2018/4/20.
 */
public class B_salary implements Serializable{
    private int s_id;
    private int s_e_id;
    private int s_rewards;
    private int s_punishment;

    public B_salary() {
    }

    public B_salary(int s_id, int s_e_id, int s_rewards, int s_punishment) {
        this.s_id = s_id;
        this.s_e_id = s_e_id;
        this.s_rewards = s_rewards;
        this.s_punishment = s_punishment;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getS_e_id() {
        return s_e_id;
    }

    public void setS_e_id(int s_e_id) {
        this.s_e_id = s_e_id;
    }

    public int getS_rewards() {
        return s_rewards;
    }

    public void setS_rewards(int s_rewards) {
        this.s_rewards = s_rewards;
    }

    public int getS_punishment() {
        return s_punishment;
    }

    public void setS_punishment(int s_punishment) {
        this.s_punishment = s_punishment;
    }
}
