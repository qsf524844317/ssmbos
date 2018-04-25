package com.qusf.service;

import com.qusf.mapper.B_empMapper;
import com.qusf.model.B_emp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by SiFan on 2018/4/25.
 */
@Service
public class B_empService {
    @Resource
    private B_empMapper b_empMapper;
    public void saveB_emp(B_emp b_emp) {
        b_empMapper.saveB_emp(b_emp);
    }
}
