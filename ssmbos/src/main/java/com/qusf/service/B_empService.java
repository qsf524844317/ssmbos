package com.qusf.service;

import com.qusf.mapper.B_empMapper;
import com.qusf.model.B_emp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/25.
 */
@Service
public class B_empService {
    @Resource
    private B_empMapper b_empMapper;

    /**
     * 录用后保存员工信息
     * @param b_emp
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void saveB_emp(B_emp b_emp) {
        b_empMapper.saveB_emp(b_emp);
    }

    /**
     * 获取所有员工信息
     * @return
     */
    public List<B_emp> getAllEmp() {
        return b_empMapper.findAllB_emp();
    }

    /**
     * 根据员工id查询员工
     * @param tr_e_id
     * @return
     */
    public B_emp findB_empBye_id(int tr_e_id) {
        return b_empMapper.findB_empBye_id(tr_e_id);
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void updateemp(B_emp b_emp) {
        b_empMapper.updateemp(b_emp);
    }
}
