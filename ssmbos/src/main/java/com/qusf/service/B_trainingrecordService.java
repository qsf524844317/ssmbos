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

    /**
     * 查看培训员工信息
     * @param t_id
     * @return
     */
    public List<B_trainingrecord> selecttrainemp(int t_id) {
        return b_trainingrecordMapper.findB_trainingrecordByt_id(t_id);

    }

    public void deleteBytr_e_id(int e_id) {
        b_trainingrecordMapper.deleteBytr_e_id(e_id);
    }

    public void saveB_trainingrecord(int tr_e_id, int t_id) {
        b_trainingrecordMapper.saveB_trainingrecord(tr_e_id,t_id);
    }
}
