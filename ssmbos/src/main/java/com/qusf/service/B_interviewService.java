package com.qusf.service;

import com.qusf.mapper.B_interviewMapper;
import com.qusf.model.B_interview;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/23.
 */
@Service
public class B_interviewService {
    @Resource
    private B_interviewMapper b_interviewMapper;

    public List<B_interview> seeB_interview(int i_u_id) {
        return b_interviewMapper.findB_interviewByu_id(i_u_id);
    }

    public void acceptinterview(int i_id) {
        b_interviewMapper.updateB_interviewByi_id(i_id);
    }

    public void inviteB_user(B_interview b_interview) {
        b_interviewMapper.inviteB_user(b_interview);
    }
}
