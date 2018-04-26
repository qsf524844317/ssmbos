package com.qusf.controller;

import com.qusf.model.B_dept;;
import com.qusf.model.B_train;
import com.qusf.model.RecruitView;
import com.qusf.service.B_deptService;
import com.qusf.service.B_empService;
import com.qusf.service.B_recruitService;
import com.qusf.service.B_trainService;
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
    /**
     * 访问直接查询所有招聘记录返回首页显示给游客
     * @param session
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(HttpSession session){
        List<RecruitView> recruits=b_recruitService.findAllB_recruit();
        session.setAttribute("recruits",recruits);
        return "index";
    }
    @RequestMapping(value = "/gotoaddresume")
    public String gotoaddresume(){
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
}
