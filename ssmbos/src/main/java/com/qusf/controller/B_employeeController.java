package com.qusf.controller;

import com.qusf.model.B_dept;
import com.qusf.model.B_emp;
import com.qusf.model.B_resume;
import com.qusf.service.B_deptService;
import com.qusf.service.B_empService;
import com.qusf.service.B_resumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by SiFan on 2018/4/24.
 */
@Controller
public class B_employeeController {
    @Resource
    private B_deptService b_deptService;
    @Resource
    private B_resumeService b_resumeService;
    @Resource
    private B_empService b_empService;
    @RequestMapping(value = "/gotoaddemployee")
    public String gotoaddB_employee(int i_u_id, Model model, HttpSession session){
        List<B_dept> b_depts=b_deptService.getB_dept();
        session.setAttribute("depts",b_depts);
        B_resume b_resume=b_resumeService.getinterviewresume(i_u_id);
        model.addAttribute("b_resume",b_resume);
        return "addemployee";
    }
    @RequestMapping(value = "/saveemployee")
    public String saveB_emp(B_emp b_emp){
        try {
            b_empService.saveB_emp(b_emp);
            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "addemployee";
        }
    }
}
