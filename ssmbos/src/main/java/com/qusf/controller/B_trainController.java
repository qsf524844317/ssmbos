package com.qusf.controller;

import com.qusf.model.B_train;
import com.qusf.service.B_trainService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SiFan on 2018/4/26.
 */
@Controller
public class B_trainController {
    @Resource
    private B_trainService b_trainService;
    @RequestMapping(value = "/savetrain")
    public String saveB_train(B_train b_train){
        try{
            b_trainService.saveB_train(b_train);
            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }
    @RequestMapping(value = "/deleteb_train")
    public void deleteb_train(int t_id, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        try {
            b_trainService.deleteb_train(t_id);
            response.getWriter().write("删除成功");
        }catch (Exception e){
            response.getWriter().write("删除失败");
            System.out.println(e);
        }
    }
}
