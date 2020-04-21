package com.qusf.controller;

import com.qusf.model.B_emp;
import com.qusf.model.B_rew_pun;
import com.qusf.service.B_rew_punService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by SiFan on 2018/4/27.
 */
@Controller
public class B_rew_punController{
    @Resource
    private B_rew_punService b_rew_punService;

    /**
     * 保存对员工的奖惩
     * @param b_rew_pun
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/saveb_rew_pun")
    public void saveB_rew_pun(B_rew_pun b_rew_pun, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        try{
            b_rew_punService.saveB_rew_pun(b_rew_pun);
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('操作成功'));" +
                    "window.location.href='empmanage';</script>");
        }catch (Exception e){
            System.out.println(e);
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('操作失败'));" +
                    "window.location.href='empmanage';</script>");
        }
    }

    @RequestMapping(value = "/deleteb_rew_pun")
    public void sdeleteB_rew_pun(int rp_id, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        try{
            b_rew_punService.deleteB_rew_punByrp_id(rp_id);
            response.getWriter().write("删除成功");
        }catch (Exception e){
            System.out.println(e);
            response.getWriter().write("删除失败");
        }
    }
    @RequestMapping(value = "/selectrewpun")
    public String selectrewpun(Model model, HttpSession session){
        B_emp emp = (B_emp) session.getAttribute("emp");
        List<B_rew_pun> rew_puns = b_rew_punService.findB_rew_punByre_e_id(emp.getE_id());
        model.addAttribute("rew_puns",rew_puns);
        return "showrewpun";
    }
}
