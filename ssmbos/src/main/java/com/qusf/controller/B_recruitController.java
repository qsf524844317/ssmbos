package com.qusf.controller;

import com.qusf.model.B_recruit;
import com.qusf.model.RecruitView;
import com.qusf.service.B_recruitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * Created by SiFan on 2018/4/23.
 */
@Controller
public class B_recruitController {
    @Resource
    private B_recruitService b_recruitService;
    /**
     * 管理员发布招聘信息
     * @param b_recruit
     * @return
     */
    @RequestMapping(value = "/sendb_recruit")
    public String sendB_recruit(B_recruit b_recruit){
        try{
            b_recruitService.sendB_recruit(b_recruit);
            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "sendrecruit";
        }
    }
    @RequestMapping(value = "/recruitmanage")
    public String recruitmanage(Model model){
        List<RecruitView> recruits=b_recruitService.findAllB_recruit();
        model.addAttribute("recruits",recruits);
        return "editrecruit";
    }
    @RequestMapping(value = "/deleteb_recruit")
    public void deleteB_recruit(int rec_id, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        try {
            b_recruitService.deleteByrec_id(rec_id);
            response.getWriter().write("删除成功");
        }catch (Exception e){
            System.out.println(e);
            response.getWriter().write("删除失败");
        }
    }
}
