package com.qusf.model;

/**
 * Created by SiFan on 2018/5/7.
 */
public class TrainView {
    private int t_id;
    private String t_theme;
    private String t_details;
    private String t_address;
    private String t_start;
    private String t_end;
    private int tr_id;
    private int tr_t_id;
    private int tr_e_id;
    private String tr_grand;

    public TrainView() {
    }

    public TrainView(int t_id, String t_theme, String t_details, String t_address, String t_start, String t_end, int tr_id, int tr_t_id, int tr_e_id, String tr_grand) {
        this.t_id = t_id;
        this.t_theme = t_theme;
        this.t_details = t_details;
        this.t_address = t_address;
        this.t_start = t_start;
        this.t_end = t_end;
        this.tr_id = tr_id;
        this.tr_t_id = tr_t_id;
        this.tr_e_id = tr_e_id;
        this.tr_grand = tr_grand;
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
