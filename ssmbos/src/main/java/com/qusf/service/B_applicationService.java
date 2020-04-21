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

    /**
     * 发送职位申请
     * @param a_res_id
     * @param a_rec_id
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void sendB_resume(int a_res_id, int a_rec_id) {
        b_applicationMapper.sendB_resume(a_res_id,a_rec_id);
    }

    /**
     * 管理员查看收到的职位申请
     * @return
     */
    public List<B_application> findB_application() {
        return b_applicationMapper.findB_application();
    }

    /**
     * 发送面试邀请
     * @param a_id
     * @param a_invitedetail
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void inviteinterview(int a_id, String a_invitedetail) {
        b_applicationMapper.updatea_stateBya_id(a_id,a_invitedetail);
    }

    /**
     * 用户查看收到的面试邀请
     * @param u_id
     * @return
     */
    public List<B_application> seeinterview(int u_id) {
        return b_applicationMapper.seeinterview(u_id);
    }

    /**
     * 同意面试邀请
     * @param a_id
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public boolean acceptInvite(int a_id) {
        try {
            b_applicationMapper.Updatea_stateBya_id(a_id);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    /**
     * 管理员查看确定面试的记录
     * @return
     */
    public List<B_application> findInterviewB_application() {
        return b_applicationMapper.findB_applicationBya_state();
    }

    public void acceptemp(int a_id) {
        b_applicationMapper.acceptemp(a_id);
    }
}
