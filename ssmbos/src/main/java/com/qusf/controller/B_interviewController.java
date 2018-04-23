package com.qusf.controller;

import com.qusf.model.B_interview;
import com.qusf.model.B_user;
import com.qusf.service.B_interviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by SiFan on 2018/4/23.
 */
@Controller
public class B_interviewController{
    @Resource
    private B_interviewService b_interviewService;
    @RequestMapping(value = "/seeb_interview")
    public String seeB_interview(HttpSession session, Model model){
        B_user user = (B_user) session.getAttribute("user");
        List<B_interview> b_interviews=b_interviewService.seeB_interview(user.getU_id());
        model.addAttribute("b_interviews",b_interviews);
        return "interviews";
    }
    @RequestMapping(value = "/acceptInterview")
    public void AcceptInterview(int i_id, HttpServletResponse response){
        response.setContentType("text/html;charset=utf-8");
        try {
            b_interviewService.acceptinterview(i_id);
            response.getWriter().write("接受面试邀请,请准时参加面试");
        }catch (Exception e){
            try {
                response.getWriter().write("发生错误");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    @RequestMapping(value = "/inviteuser")
    public void inviteB_user(B_interview b_interview){
        System.out.println(b_interview);
        b_interviewService.inviteB_user(b_interview);
    }
}
