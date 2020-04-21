package com.qusf.controller;

import com.qusf.model.B_emp;
import com.qusf.model.B_salary;
import com.qusf.service.B_salaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by SiFan on 2018/5/4.
 */
@Controller
public class B_salaryController {
    @Resource
    private B_salaryService b_salaryService;
    @RequestMapping(value = "/selectsalary")
    public String selectsalary(HttpSession session, Model model){
        B_emp emp = (B_emp) session.getAttribute("emp");
        List<B_salary> b_salaries = b_salaryService. selectsalary(emp);
        model.addAttribute("salaries",b_salaries);
        return "showsalary";
    }
}
