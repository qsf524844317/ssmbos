package com.qusf.controller;

import com.qusf.model.B_application;
import com.qusf.model.B_user;
import com.qusf.service.B_applicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by SiFan on 2018/4/25.
 */
@Controller
public class B_applicationController {
    @Resource
    private B_applicationService b_applicationService;

    /**
     * 管理员查看收到的职位申请
     * @param model
     * @return
     */
    @RequestMapping(value = "/receiveb_resume")
    public String findB_application(Model model){
        try{
            List<B_application> b_applications=b_applicationService.findB_application();
            model.addAttribute("applications",b_applications);
            return "apps";
        }catch (Exception e){
            System.out.println(e);
            return "index";
        }
    }
    @RequestMapping(value = "/inviteinterview")
    public String inviteinterview(int a_id,String a_invitedetail){
        b_applicationService.inviteinterview(a_id,a_invitedetail);
        return "success";
    }
    @RequestMapping(value = "/seeinterview")
    public String seeinterview(HttpSession session,Model model){
        B_user user = (B_user) session.getAttribute("user");
        List<B_application> b_applications = b_applicationService.seeinterview(user.getU_id());
        model.addAttribute("apps",b_applications);
        return "interview";
    }
}
