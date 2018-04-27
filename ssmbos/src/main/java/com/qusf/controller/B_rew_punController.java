package com.qusf.controller;

import com.qusf.model.B_rew_pun;
import com.qusf.service.B_rew_punService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('操作成功'));" +
                    "window.location.href='empmanage';</script>");
        }
    }
}
