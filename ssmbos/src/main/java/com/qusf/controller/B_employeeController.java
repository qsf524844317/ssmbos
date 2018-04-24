package com.qusf.controller;

import com.qusf.model.B_resume;
import com.qusf.service.B_interviewService;
import com.qusf.service.B_resumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by SiFan on 2018/4/24.
 */
@Controller
public class B_employeeController {
    @Resource
    private B_resumeService b_resumeService;
    @RequestMapping(value = "/gotoaddemployee")
    public String gotoaddB_employee(int i_u_id, Model model){
        B_resume b_resume=b_resumeService.getinterviewresume(i_u_id);
        model.addAttribute("b_resume",b_resume);
        return "addemployee";
    }
}
