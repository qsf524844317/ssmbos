package com.qusf.service;

import com.qusf.mapper.B_trainingrecordMapper;
import com.qusf.model.B_trainingrecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/26.
 */
@Service
public class B_trainingrecordService {
    @Resource
    private B_trainingrecordMapper b_trainingrecordMapper;
    public List<B_trainingrecord> selecttrainemp(int t_id) {
        return b_trainingrecordMapper.findB_trainingrecordByt_id(t_id);

    }
}
