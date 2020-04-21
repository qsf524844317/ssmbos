package com.qusf.service;

import com.qusf.mapper.B_rew_punMapper;
import com.qusf.model.B_rew_pun;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/27.
 */
@Service
public class B_rew_punService{
    @Resource
    private B_rew_punMapper b_rew_punMapper;

    public void saveB_rew_pun(B_rew_pun b_rew_pun) {
        b_rew_punMapper.saveB_rew_pun(b_rew_pun);
    }

    public List<B_rew_pun> getAllrewpun() {
        return b_rew_punMapper.getAllrewpun();
    }

    public void deleteB_rew_punByrp_id(int rp_id){
        b_rew_punMapper.deleteB_rew_punByrp_id(rp_id);
    }

    public B_rew_pun getcurrentrewpun(int re_e_id){
        return b_rew_punMapper.getcurrentrewpun(re_e_id);
    }

    public void updaterewpun(B_rew_pun b_rew_pun){
        b_rew_punMapper.updaterewpun(b_rew_pun);
    }

    public List<B_rew_pun> findB_rew_punByre_e_id(int re_e_id){
        return b_rew_punMapper.findB_rew_punByre_e_id(re_e_id);
    }
}
