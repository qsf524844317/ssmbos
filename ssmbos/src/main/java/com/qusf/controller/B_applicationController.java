package com.qusf.controller;

import com.qusf.model.B_application;
import com.qusf.model.B_user;
import com.qusf.service.B_applicationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    /**
     * 管理员发送面试邀请
     * @param a_id
     * @param a_invitedetail
     * @return
     */
    @RequestMapping(value = "/inviteinterview")
    public String inviteinterview(int a_id,String a_invitedetail){
        b_applicationService.inviteinterview(a_id,a_invitedetail);
        return "success";
    }

    /**
     * 用户查询收到的面试邀请
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/seeinterview")
    public String seeinterview(HttpSession session,Model model){
        B_user user = (B_user) session.getAttribute("user");
        List<B_application> b_applications = b_applicationService.seeinterview(user.getU_id());
        System.out.println(b_applications.size());
        model.addAttribute("apps",b_applications);
        return "interview";
    }
    @RequestMapping(value = "/acceptInvite",method = RequestMethod.POST)
    public void acceptInvite(int a_id, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        boolean flag= b_applicationService.acceptInvite(a_id);
        System.out.println(flag);
        if (flag){
           response.getWriter().write("同意面试邀请,请按时参加面试");
        }else {
            response.getWriter().write("发生错误");
        }
    }

    /**
     * 管理员处理已经面试的申请
     * @return
     */
    @RequestMapping(value = "/disposeb_application")
    public String disposeB_application(Model model){
        List<B_application> b_application = b_applicationService.findInterviewB_application();
        model.addAttribute("b_application",b_application);
        return "dispose.html";
    }
}
