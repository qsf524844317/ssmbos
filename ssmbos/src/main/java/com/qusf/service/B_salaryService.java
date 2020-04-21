package com.qusf.service;

import com.qusf.mapper.B_salaryMapper;
import com.qusf.model.B_emp;
import com.qusf.model.B_salary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/5/4.
 */
@Service
public class B_salaryService {
    @Resource
    private B_salaryMapper b_salaryMapper;
    public List<B_salary> selectsalary(B_emp emp){
        return b_salaryMapper.selectsalary(emp.getE_id());
    }

    public List<B_salary> selectcurrentsalary(B_emp emp){
        return b_salaryMapper.selectcurrentsalary(emp.getE_id());
    }
}
