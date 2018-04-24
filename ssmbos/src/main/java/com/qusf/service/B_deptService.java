package com.qusf.service;

import com.qusf.mapper.B_deptMapper;
import com.qusf.model.B_dept;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/24.
 */
@Service
public class B_deptService {
    @Resource
    private B_deptMapper b_deptMapper;
    /**
     * 管理员添加部门
     * @param b_dept
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addB_dept(B_dept b_dept) {
        b_deptMapper.addB_dept(b_dept);
    }

    public boolean checkd_name(String d_name) {
        List<B_dept> b_depts=b_deptMapper.findB_deptByd_name(d_name);
        if (b_depts.size()==0){
            return true;
        }
        return false;
    }

    public List<B_dept> getB_dept() {
        return b_deptMapper.findAllB_dept();
    }
}
