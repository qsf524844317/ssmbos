package com.qusf.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qusf.model.*;
import com.qusf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
    @Resource
    private B_recruitService b_recruitService;
    @Resource
    private B_positionService b_positionService;

    /**
     * 添加员工
     * @param res_id
     * @param a_rec_id
     * @param model
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/gotoaddemployee")
    public String gotoaddB_employee(int res_id,int a_rec_id, Model model, HttpSession session) throws Exception{
        List<B_dept> b_depts=b_deptService.getB_dept();
        session.setAttribute("depts",b_depts);
        B_recruit b_recruit=b_recruitService.findB_recruit(a_rec_id);
        B_dept b_dept=b_deptService.getd_name(b_recruit.getRec_d_id());
        B_position b_position = b_positionService.getp_name(b_recruit.getRec_p_id());
        B_resume b_resume=b_resumeService.receiveB_resume(res_id);
        model.addAttribute("resume",b_resume);
        model.addAttribute("p_name",b_position.getP_name());
        model.addAttribute("d_name",b_dept.getD_name());
        model.addAttribute("recruit",b_recruit);
        return "addemployee";
    }

    /**
     * 保存录入的员工信息
     * @param b_emp
     * @return
     */
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

    @RequestMapping(value = "/getallemp")
    @ResponseBody
    public void getAllEmp(HttpServletResponse response) throws IOException {
        response.setContentType("text/json;charset=UTF-8");
        List<B_emp> b_emps=b_empService.getAllEmp();
        ObjectMapper objectMapper=new ObjectMapper();
        String emp = objectMapper.writeValueAsString(b_emps);
        System.out.println(emp);
        response.getWriter().write(emp);
    }

    @RequestMapping(value = "/empmanage")
    public String empManger(Model model){
        List<B_emp> b_emps = b_empService.getAllEmp();
        model.addAttribute("emps",b_emps);
        return "showemp";
    }
    @RequestMapping(value = "/updateemp")
    public String updateemp(B_emp b_emp){
        System.out.println(b_emp);
        b_empService.updateemp(b_emp);
        return "success";
    }
}
