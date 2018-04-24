package com.qusf.service;

import com.qusf.mapper.B_interviewMapper;
import com.qusf.model.B_interview;
import com.qusf.model.B_resume;
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
public class B_interviewService {
    @Resource
    private B_interviewMapper b_interviewMapper;
    /**
     * 用户查看收到的面试邀请
     * @param i_u_id
     * @return
     */
    public List<B_interview> seeB_interview(int i_u_id) {
        return b_interviewMapper.findB_interviewByu_id(i_u_id);
    }

    /**
     * 同一面试邀请
     * @param i_id
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void acceptinterview(int i_id) {
        b_interviewMapper.updateB_interviewByi_id(i_id);
    }

    /**
     * 管理员发送面试邀请
     * @param b_interview
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void inviteB_user(B_interview b_interview) {
        b_interviewMapper.inviteB_user(b_interview);
    }

    /**
     * 查询面试的人
     * @return
     */
    public List<B_interview> disposeB_interview() {
       return b_interviewMapper.findB_interviewByi_state();
    }

}
