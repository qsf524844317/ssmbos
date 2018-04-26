package com.qusf.controller;

import com.qusf.model.B_emp;
import com.qusf.model.B_trainingrecord;
import com.qusf.service.B_empService;
import com.qusf.service.B_trainingrecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SiFan on 2018/4/26.
 */
@Controller
public class B_trainingrecordController{
    @Resource
    private B_trainingrecordService b_trainingrecordService;
    private B_empService b_empService;
    @RequestMapping(value = "/selecttrainemp")
    public String selecttrainemp(int t_id, Model model){
        List<B_trainingrecord> b_trainingrecords=b_trainingrecordService.selecttrainemp(t_id);
        List<B_emp> b_emps=new ArrayList<>();
        for (int i=0;i<b_trainingrecords.size();i++){
            B_emp b_emp=b_empService.findB_empBye_id(b_trainingrecords.get(i).getTr_e_id());
            b_emps.add(b_emp);
        }
        model.addAttribute("emps",b_emps);
        return "showtrainemp";
    }

}
