package com.qusf.controller;

import com.qusf.model.B_resume;
import com.qusf.model.B_user;
import com.qusf.service.B_applicationService;
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
  @Resource
  private B_applicationService b_applicationService;

    /**
     * 用户添加简历
     * @param b_resume
     * @param session
     * @return
     */
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

    /**
     * 用户投递简历
     * @param res_id
     * @param response
     * @throws IOException
     */
  @RequestMapping(value = "/sendb_resume")
  public void sendB_resume(String res_id, HttpServletResponse response,String rec_id) throws IOException {
      response.setContentType("text/html;charset=utf-8");
      int a_rec_id = Integer.parseInt(rec_id);
      int a_res_id = Integer.parseInt(res_id);
      try{
          b_applicationService.sendB_resume(a_res_id,a_rec_id);
          response.getWriter().write("投递成功");
      }catch (Exception e){
          response.getWriter().write("投递失败");
          System.out.println(e);
      }
  }

    /**
     * 用户查看自己的简历
     * @param session
     * @return
     */
    @RequestMapping(value = "/seeb_resume")
    public String seeB_resume(HttpSession session){
        try{
            B_user b_user = (B_user) session.getAttribute("user");
            List<B_resume> b_resumes = b_resumeService.seeB_resume(b_user.getU_id());
            session.setAttribute("b_resumes",b_resumes);
            return "myresume";
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }

    /**
     * 选申请职位时选择要投递的简历
     * @param session
     * @param a_rec_id
     * @return
     */
    @RequestMapping(value = "/chooseb_resume")
    public String chooseB_resume(HttpSession session,int a_rec_id,Model model){
        try{
            B_user b_user = (B_user) session.getAttribute("user");
            List<B_resume> b_resumes = b_resumeService.seeB_resume(b_user.getU_id());
            session.setAttribute("b_resumes",b_resumes);
            model.addAttribute("a_rec_id",a_rec_id);
            return "resume";
        }catch (Exception e){
            System.out.println(e);
            return "index";
        }
    }

    /**
     * 根据简历id查询到对应简历
     * @param a_res_id
     * @param model
     * @return
     */
    @RequestMapping(value = "/getresume")
    public String getB_resume(int a_res_id ,Model model){
        B_resume b_resume=b_resumeService.receiveB_resume(a_res_id);
        model.addAttribute("resume",b_resume);
        return "resumeinfo";
    }
    @RequestMapping(value = "/deleteb_resume")
    public void deleteB_resume(int res_id,HttpServletResponse response) throws IOException {
        boolean flag=b_resumeService.deleteB_resumeByres_id(res_id);
        response.setContentType("text/html;charset=utf-8");
        if (flag){
            response.getWriter().write("删除成功");
        }else {
            response.getWriter().write("删除失败");
        }
    }
}
