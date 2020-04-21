package com.qusf.controller;

import com.qusf.model.*;
import com.qusf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by SiFan on 2018/4/19.
 */
@Controller
public class MyController{
    @Resource
    private B_recruitService b_recruitService;
    @Resource
    private B_deptService b_deptService;
    @Resource
    private B_empService b_empService;
    @Resource
    private B_trainService b_trainService;
    @Resource
    private B_userService b_userService;
    @Resource
    private B_rew_punService b_rew_punService;
    /**
     * 访问直接查询所有招聘记录返回首页显示给游客
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model){
        List<RecruitView> recruits=b_recruitService.findAllB_recruit();
        model.addAttribute("recruits",recruits);
        return "index";
    }
    @RequestMapping(value = "/gotoaddresume")
    public String gotoaddresume(HttpSession session){
        B_user user = (B_user) session.getAttribute("user");
        if (user==null){
            return "login";
        }
        return "addresume";
    }
    @RequestMapping(value = "/sendbrecruit")
    public String sendB_recruit(HttpSession session){
        List<B_dept> b_depts=b_deptService.getB_dept();
        session.setAttribute("depts",b_depts);
        return "sendrecruit";
    }
    @RequestMapping(value = "/gotoadddept")
    public String gotoadddept(){
        return "adddept";
    }
    @RequestMapping(value = "/gotoinvite")
    public String gotoInvite(int a_id,Model model){
        model.addAttribute("a_id",a_id);
        return "addressandtime";
    }
    @RequestMapping(value = "/deptmanage")
    public String deptmanage(HttpSession session){
        List<B_dept> b_depts=b_deptService.getB_dept();
        session.setAttribute("depts",b_depts);
        return "editdept";
    }
    @RequestMapping(value = "/addhtml")
    public String addhtml(String name){
        return name;
    }

    @RequestMapping(value = "/gototrainemp")
    public String trainB_emp(Model model){
       List<B_train> b_trains= b_trainService.getAllB_train();
       model.addAttribute("trains",b_trains);
        return "trainemp";
    }
    @RequestMapping(value = "/gotoaddtrain")
    public String addtrain(Model model){
        return "addtrain";
    }

    @RequestMapping(value = "/addtrainemp")
    public String addTrainemp(Model model,int t_id){
        List<B_emp> allEmp = b_empService.getAllEmp();
        model.addAttribute("emps",allEmp);
        model.addAttribute("t_id",t_id);
        return "addtrainemp";
    }
    @RequestMapping(value = "/gotorewandpun")
    public String gotoB_rew_pun(int e_id,Model model){
        model.addAttribute("e_id",e_id);
        return "rewpun";
    }
    @RequestMapping(value = "/transfer")
    public String transfer(int e_id,Model model,HttpSession session){
        List<B_dept> b_depts=b_deptService.getB_dept();
        session.setAttribute("depts",b_depts);
        System.out.println(e_id);
        model.addAttribute("e_id",e_id);
        return "transferemp";
    }
    @RequestMapping(value = "/gotodeleteemp")
    public String gotodeleteemp(int e_id,Model model){
        model.addAttribute("e_id",e_id);
        return "deleteempreason";
    }
    @RequestMapping(value = "/gotologin")
    public String gotologin(){
        return "login";
    }
    @RequestMapping(value = "/login")
    public String login(String username,String password,int type,HttpSession session,Model model){
        if (type==1){
            B_emp b_emp=new B_emp();
            int e_id = Integer.parseInt(username);
            b_emp.setE_id(e_id);
            b_emp.setE_pass(password);
            B_emp emp = b_empService.getempByp_idAndp_pass(b_emp);
            if (emp!=null){
                session.setAttribute("emp",emp);
                return "empview";
            }else {
                return "login";
            }
        }else {
            System.out.println(type);
            B_user b_user=new B_user();
            b_user.setU_username(username);
            b_user.setU_passworld(password);
            B_user user = b_userService.login(b_user);
            if (user!=null&&user.getU_type()==0){
                List<RecruitView> recruits=b_recruitService.findAllB_recruit();
                model.addAttribute("recruits",recruits);
                session.setAttribute("user",user);
                return "index";
            }else if (user!=null&&user.getU_type()==2){
                session.setAttribute("admin",user);
                return  "success";
            }else {
                return "login";
            }
        }
    }
    @RequestMapping("backempview")
    public String empview(){
        return "empview";
    }
    @RequestMapping(value = "/rewpunmanage")
    public String rewpunmanage(Model model){
        List<B_rew_pun> b_rew_puns=b_rew_punService.getAllrewpun();
        model.addAttribute("rew_puns",b_rew_puns);
        return "showrewpuns";
    }
    @RequestMapping(value = "/salarymanage")
    public String salarymanage(){
        return "editsalary";
    }

    @RequestMapping(value = "/gotoregist")
    public String gotoregist(){
        return "regist";
    }
}
