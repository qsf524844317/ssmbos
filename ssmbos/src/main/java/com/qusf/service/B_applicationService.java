package com.qusf.service;

import com.qusf.mapper.B_applicationMapper;
import com.qusf.model.B_application;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/23.
 */
@Service
public class B_applicationService {
    @Resource
    private B_applicationMapper b_applicationMapper;
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void sendB_resume(int a_res_id, int a_rec_id) {
        b_applicationMapper.sendB_resume(a_res_id,a_rec_id);
    }

    public List<B_application> findB_application() {
        return b_applicationMapper.findB_application();
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void inviteinterview(int a_id, String a_invitedetail) {
        b_applicationMapper.updatea_stateBya_id(a_id,a_invitedetail);
    }

    public List<B_application> seeinterview(int u_id) {
        return b_applicationMapper.seeinterview(u_id);
    }
}
