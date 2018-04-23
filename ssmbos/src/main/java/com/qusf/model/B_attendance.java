package com.qusf.model;

import java.io.Serializable;
/**
 * Created by SiFan on 2018/4/20.
 */
public class B_attendance implements Serializable {
    private int a_id;
    private String a_working;
    private String a_gohome;
    private int a_late;
    private int a_early;

    public B_attendance() {
    }

    public B_attendance(int a_id, String a_working, String a_gohome, int a_late, int a_early) {
        this.a_id = a_id;
        this.a_working = a_working;
        this.a_gohome = a_gohome;
        this.a_late = a_late;
        this.a_early = a_early;
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getA_working() {
        return a_working;
    }

    public void setA_working(String a_working) {
        this.a_working = a_working;
    }

    public String getA_gohome() {
        return a_gohome;
    }

    public void setA_gohome(String a_gohome) {
        this.a_gohome = a_gohome;
    }

    public int getA_late() {
        return a_late;
    }

    public void setA_late(int a_late) {
        this.a_late = a_late;
    }

    public int getA_early() {
        return a_early;
    }

    public void setA_early(int a_early) {
        this.a_early = a_early;
    }
}
