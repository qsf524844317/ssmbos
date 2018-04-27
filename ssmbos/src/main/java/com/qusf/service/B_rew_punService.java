package com.qusf.service;

import com.qusf.mapper.B_rew_punMapper;
import com.qusf.model.B_rew_pun;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
