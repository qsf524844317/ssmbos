package com.qusf.controller;

import com.qusf.model.B_resume;
import com.qusf.model.B_user;
import com.qusf.service.B_resumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *Created by SiFan on 2018/4/21.
 */
 @Controller
public class B_resumeController {
  @Resource
  private B_resumeService b_resumeService;
  @RequestMapping(value = "/addb_resume")
  public String addB_resume(B_resume b_resume, HttpSession session){
      try {
          B_user b_user = (B_user) session.getAttribute("user");
          b_resume.setRes_u_id(b_user.getU_id());
          b_resumeService.addB_resume(b_resume);
          return "index";
      }catch (Exception e){
          System.out.println(e);
          return "login";
      }
  }
  @RequestMapping(value = "/sendb_resume")
  public void sendB_resume(int res_id, HttpServletResponse response) throws IOException {
      response.setContentType("text/html;charset=utf-8");
      try{
          response.getWriter().write("投递成功");
          b_resumeService.sendB_resume(res_id);
      }catch (Exception e){
          response.getWriter().write("投递失败");
          System.out.println(e);
      }
  }

    @RequestMapping(value = "/seeb_resume")
    public String seeB_resume(Model model,HttpSession session){
        try{
            B_user b_user = (B_user) session.getAttribute("user");
            List<B_resume> b_resumes = b_resumeService.seeB_resume(b_user.getU_id());
            model.addAttribute("b_resumes",b_resumes);
            return "resume";
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }
    @RequestMapping(value = "/receiveb_resume")
    public String receiveB_resume(Model model,HttpSession session){
        try{
            B_user b_user = (B_user) session.getAttribute("user");
            List<B_resume> b_resumes = b_resumeService.receiveB_resume(b_user.getU_id());
            model.addAttribute("b_resumes",b_resumes);
            return "interviewuser";
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }
}
